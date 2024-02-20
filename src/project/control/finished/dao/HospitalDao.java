package project.control.finished.dao;

import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;

import java.util.List;

public interface HospitalDao {

    void add(Hospital n) throws DaoException;

    void add(Doctor n) throws DaoException;

    List<Hospital> findHospital(String field, String meaning) throws DaoException;

    List<Doctor> findDoctor(String field, String meaning) throws DaoException;

}
