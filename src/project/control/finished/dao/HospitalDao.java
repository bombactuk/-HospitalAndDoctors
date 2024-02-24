package project.control.finished.dao;

import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;

import java.util.List;

public interface HospitalDao {

    void add(Hospital hospital) throws DaoException;

    void add(Doctor doctor) throws DaoException;

    List<Hospital> findHospital(String field, String meaning) throws DaoException;

    List<Doctor> findDoctor(String field, String meaning) throws DaoException;

    void update(int id, Hospital hospital) throws DaoException;

    void update(int id, Doctor doctor) throws DaoException;

    void delete(String field, int id) throws DaoException;

}
