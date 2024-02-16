package dao.impl;

import dao.DaoException;
import dao.DaoProvider;
import dao.HospitalDao;
import entity.Doctor;
import entity.Hospital;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalDaoBase implements HospitalDao {

    @Override
    public void add(Hospital n) throws DaoException {

        try {

            String insert = "INSERT INTO " + DatabaseConstants.TABLE_HOSPITALS +
                    "(" + DatabaseConstants.NAME_HOSPITALS + "," +
                    DatabaseConstants.ADDRESS_HOSPITALS + "," +
                    DatabaseConstants.CITY_HOSPITALS + ")" + "VALUES(?,?,?)";

            PreparedStatement prSt = DaoProvider.getDbConnection().prepareCall(insert);

            prSt.setString(1, n.getName());
            prSt.setString(2, n.getAddress());
            prSt.setString(3, n.getCity());

            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void add(Doctor n) throws DaoException {

        try {

            String insert = "INSERT INTO " + DatabaseConstants.TABLE_DOCTORS +
                    "(" + DatabaseConstants.ID_HOSPITALS_DOCTORS + "," +
                    DatabaseConstants.FIO_DOCTORS + "," +
                    DatabaseConstants.JOB_TITLE_DOCTORS + ")" + "VALUES(?,?,?)";

            PreparedStatement prSt = DaoProvider.getDbConnection().prepareCall(insert);

            prSt.setInt(1, n.getIdHospital());
            prSt.setString(2, n.getFio());
            prSt.setString(3, n.getJobTitle());

            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public ResultSet find(String field, String meaning) throws DaoException {

        ResultSet resSet = null;
        String select = "";

        try {

            switch (field) {

                case "name" -> {
                    select = "SELECT * FROM " + DatabaseConstants.TABLE_HOSPITALS +
                            " WHERE " + DatabaseConstants.NAME_HOSPITALS + "=?";
                }

                case "address" -> {
                    select = "SELECT * FROM " + DatabaseConstants.TABLE_HOSPITALS +
                            " WHERE " + DatabaseConstants.ADDRESS_HOSPITALS + "=?";
                }

                case "city" -> {
                    select = "SELECT * FROM " + DatabaseConstants.TABLE_HOSPITALS +
                            " WHERE " + DatabaseConstants.CITY_HOSPITALS + "=?";
                }

            }

            PreparedStatement prSt = DaoProvider.getDbConnection().prepareStatement(select);
            prSt.setString(1, meaning);

            resSet = prSt.executeQuery();

            return resSet;

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

}
