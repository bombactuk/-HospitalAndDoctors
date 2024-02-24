package project.control.finished.dao.impl;

import project.control.finished.dao.DaoException;
import project.control.finished.dao.HospitalDao;
import project.control.finished.dao.impl.configuration.ConfigDataBase;
import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class HospitalDaoBase implements HospitalDao {

    private static final String insertHospitalIntoDataBase = "INSERT INTO hospital" +
            " ( name , address, city ) VALUES(?,?,?)";

    @Override
    public void add(Hospital hospital) throws DaoException {

        try (Connection dbConnection = ConfigDataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareCall(insertHospitalIntoDataBase);

            prSt.setString(1, hospital.getName());
            prSt.setString(2, hospital.getAddress());
            prSt.setString(3, hospital.getCity());

            prSt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }

    private static final String insertDoctorIntoDataBase = "INSERT INTO doctors" +
            " ( idhospitals, fio , jobTitle ) VALUES(?,?,?)";

    @Override
    public void add(Doctor doctor) throws DaoException {

        try (Connection dbConnection = ConfigDataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareCall(insertDoctorIntoDataBase);

            prSt.setInt(1, doctor.getIdHospital());
            prSt.setString(2, doctor.getFio());
            prSt.setString(3, doctor.getJobTitle());

            prSt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }

    private final Map<String, String> hospitalFindByField = new HashMap<>() {
        {
            put("name", "SELECT * FROM hospital WHERE name = ?");
            put("address", "SELECT * FROM hospital WHERE address = ?");
            put("city", "SELECT * FROM hospital WHERE city = ?");
            put("doctor", "SELECT * FROM hospital, doctors WHERE hospital.idhospitals = doctors.iddoctors AND " +
                    "doctors.iddoctors = ?");
        }
    };

    @Override
    public List<Hospital> findHospital(String field, String meaning) throws DaoException {

        ResultSet resSet = null;
        List<Hospital> hospitalsList = new ArrayList<>();
        Hospital hospitals;

        try (Connection dbConnection = ConfigDataBase.getConnection()) {

            PreparedStatement prSt = null;

            for (String key : hospitalFindByField.keySet()) {

                if (key.equals(field)) {
                    prSt = dbConnection.prepareStatement(hospitalFindByField.get(key));
                }

            }

            prSt.setString(1, meaning);

            resSet = prSt.executeQuery();

            while (resSet.next()) {

                hospitals = new Hospital();

                hospitals.setName(resSet.getString(2));
                hospitals.setAddress(resSet.getString(3));
                hospitals.setCity(resSet.getString(4));

                hospitalsList.add(hospitals);

            }

            return hospitalsList;

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }

    private final Map<String, String> DoctorFindByField = new HashMap<>() {
        {
            put("fio", "SELECT * FROM doctors WHERE fio = ?");
            put("jobTitle", "SELECT * FROM doctors WHERE jobTitle = ?");
            put("hospital", "SELECT * FROM doctors, hospital WHERE doctors.idhospitals = hospital.idhospitals " +
                    "AND doctors.idhospitals = ?");
        }
    };

    @Override
    public List<Doctor> findDoctor(String field, String meaning) throws DaoException {

        ResultSet resSet = null;
        Doctor doctors;
        List<Doctor> doctorsList = new ArrayList<>();

        try (Connection dbConnection = ConfigDataBase.getConnection()) {

            PreparedStatement prSt = null;

            for (String key : DoctorFindByField.keySet()) {

                if (key.equals(field)) {
                    prSt = dbConnection.prepareStatement(DoctorFindByField.get(key));
                }

            }

            prSt.setString(1, meaning);

            resSet = prSt.executeQuery();

            while (resSet.next()) {

                doctors = new Doctor();

                doctors.setIdHospital(Integer.parseInt(resSet.getString(2)));
                doctors.setFio(resSet.getString(3));
                doctors.setJobTitle(resSet.getString(4));

                doctorsList.add(doctors);

            }

            return doctorsList;

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }

    private static final String updateHospitalIntoDataBase = "UPDATE hospital SET name" +
            " = ?, address = ?, city = ? WHERE idhospitals = ?";

    @Override
    public void update(int id, Hospital hospital) throws DaoException {

        try (Connection dbConnection = ConfigDataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareCall(updateHospitalIntoDataBase);

            prSt.setString(1, hospital.getName());
            prSt.setString(2, hospital.getAddress());
            prSt.setString(3, hospital.getCity());
            prSt.setInt(4, id);

            prSt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }

    private static final String updateDoctorIntoDataBase = "UPDATE doctors SET idhospitals" +
            " = ?, fio = ?, jobTitle = ? WHERE iddoctors = ?";


    @Override
    public void update(int id, Doctor doctor) throws DaoException {

        try (Connection dbConnection = ConfigDataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareCall(updateDoctorIntoDataBase);

            prSt.setInt(1, doctor.getIdHospital());
            prSt.setString(2, doctor.getFio());
            prSt.setString(3, doctor.getJobTitle());
            prSt.setInt(4, id);

            prSt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }

    private final Map<String, String> hospitalAndDoctorDeleteByField = new HashMap<>() {
        {
            put("hospitalAndDoctor", "DELETE hospital, doctors" +
                    " FROM hospital" +
                    " JOIN doctors ON hospital.idhospitals = doctors.idhospitals" +
                    " WHERE hospital.idhospitals = ?");
            put("doctor", "DELETE FROM doctors WHERE iddoctors=?");
            put("hospital", "DELETE FROM hospital WHERE idhospitals=?");
        }
    };

    @Override
    public void delete(String field, int id) throws DaoException {

        try (Connection dbConnection = ConfigDataBase.getConnection()) {
            PreparedStatement prSt = null;

            for (String key : hospitalAndDoctorDeleteByField.keySet()) {

                if (key.equals(field)) {
                    prSt = dbConnection.prepareStatement(hospitalAndDoctorDeleteByField.get(key));
                }

            }

            prSt.setInt(1, id);

            prSt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new DaoException(e);
        }

    }


}
