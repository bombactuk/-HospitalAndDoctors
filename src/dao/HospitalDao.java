package dao;

import entity.Doctor;
import entity.Hospital;

import java.sql.ResultSet;

public interface HospitalDao {

    void add(Hospital n) throws DaoException;

    void add(Doctor n) throws DaoException;

    ResultSet find(String field, String meaning) throws DaoException;

}
