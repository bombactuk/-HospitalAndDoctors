package project.control.finished.dao.impl;

import project.control.finished.dao.DaoException;
import project.control.finished.dao.HospitalDao;
import project.control.finished.dao.impl.Configuration.ConfigDataBase;
import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoBase implements HospitalDao {

    private StringBuilder connectionDataBase = new StringBuilder();

    private static final String insertDoctorIntoDataBase = "INSERT INTO doctors" +
            " ( idhospitals, fio , jobTitle ) VALUES(?,?,?)";
    private static final String insertHospitalIntoDataBase = "INSERT INTO hospital" +
            " ( name , address, city ) VALUES(?,?,?)";
    private static final String updateHospitalIntoDataBase = "UPDATE hospital SET name" +
            " = ?, address = ?, city = ? WHERE idhospitals = ?";
    private static final String updateDoctorIntoDataBase = "UPDATE doctors SET idhospitals" +
            " = ?, fio = ?, jobTitle = ? WHERE iddoctors = ?";

    @Override
    public synchronized void add(Hospital n) throws DaoException {

        connectionDataBase = new StringBuilder();

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = dbConnection.prepareCall(insertHospitalIntoDataBase);

            prSt.setString(1, n.getName());
            prSt.setString(2, n.getAddress());
            prSt.setString(3, n.getCity());

            prSt.executeUpdate();

            prSt.close();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public synchronized void add(Doctor n) throws DaoException {

        connectionDataBase = new StringBuilder();

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = dbConnection.prepareCall(insertDoctorIntoDataBase);

            prSt.setInt(1, n.getIdHospital());
            prSt.setString(2, n.getFio());
            prSt.setString(3, n.getJobTitle());

            prSt.executeUpdate();

            prSt.close();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public synchronized List<Hospital> findHospital(String field, String meaning) throws DaoException {

        ResultSet resSet = null;
        List<Hospital> hospitalsList = new ArrayList<>();
        Hospital hospitals;

        connectionDataBase = new StringBuilder();
        Map<String, String> hospitalSelectionByField = new HashMap<>() {
            {
                put("name", "SELECT * FROM hospital WHERE name = ?");
                put("address", "SELECT * FROM hospital WHERE address = ?");
                put("city", "SELECT * FROM hospital WHERE city = ?");
                put("doctor", "SELECT * FROM hospital, doctors WHERE hospital.idhospitals = doctors.iddoctors AND " +
                        "doctors.iddoctors = ?");
            }
        };

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = null;

            for (String key : hospitalSelectionByField.keySet()) {

                if (key.equals(field)) {
                    prSt = dbConnection.prepareStatement(hospitalSelectionByField.get(key));
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

            prSt.close();

            return hospitalsList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public synchronized List<Doctor> findDoctor(String field, String meaning) throws DaoException {

        ResultSet resSet = null;
        Doctor doctors;
        List<Doctor> doctorsList = new ArrayList<>();
        connectionDataBase = new StringBuilder();

        Map<String, String> hospitalSelectionByField = new HashMap<>() {
            {
                put("fio", "SELECT * FROM doctors WHERE fio = ?");
                put("jobTitle", "SELECT * FROM doctors WHERE jobTitle = ?");
                put("hospital", "SELECT * FROM doctors, hospital WHERE doctors.idhospitals = hospital.idhospitals " +
                        "AND doctors.idhospitals = ?");
            }
        };

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = null;

            for (String key : hospitalSelectionByField.keySet()) {

                if (key.equals(field)) {
                    prSt = dbConnection.prepareStatement(hospitalSelectionByField.get(key));
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

            prSt.close();

            return doctorsList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void update(int id, Hospital n) throws DaoException {

        connectionDataBase = new StringBuilder();

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = dbConnection.prepareCall(updateHospitalIntoDataBase);

            prSt.setString(1, n.getName());
            prSt.setString(2, n.getAddress());
            prSt.setString(3, n.getCity());
            prSt.setInt(4, id);

            prSt.executeUpdate();

            prSt.close();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void update(int id, Doctor n) throws DaoException {

        connectionDataBase = new StringBuilder();

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = dbConnection.prepareCall(updateDoctorIntoDataBase);

            prSt.setInt(1, n.getIdHospital());
            prSt.setString(2, n.getFio());
            prSt.setString(3, n.getJobTitle());
            prSt.setInt(4, id);

            prSt.executeUpdate();

            prSt.close();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(String field, int id) throws DaoException {

        connectionDataBase = new StringBuilder();
        Map<String, String> hospitalSelectionByField = new HashMap<>() {
            {
                put("hospital", "DELETE hospital, doctors" +
                        " FROM hospital" +
                        " JOIN doctors ON hospital.idhospitals = doctors.idhospitals" +
                        " WHERE hospital.idhospitals = ?");
                put("doctor", "DELETE FROM doctors WHERE iddoctors=?");
            }
        };

        connectionDataBase.append("jdbc:mysql://" + ConfigDataBase.DB_HOST + ":" +
                ConfigDataBase.DB_PORT + "/" + ConfigDataBase.DB_NAME);

        try (Connection dbConnection = DriverManager.getConnection(connectionDataBase.toString(),
                ConfigDataBase.DB_USER, ConfigDataBase.DB_PASS)) {

            PreparedStatement prSt = null;

            for (String key : hospitalSelectionByField.keySet()) {

                if (key.equals(field)) {
                    prSt = dbConnection.prepareStatement(hospitalSelectionByField.get(key));
                }

            }

            prSt.setInt(1, id);

            prSt.executeUpdate();

            prSt.close();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

}