package project.control.finished.logic;

import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;

import java.util.List;

public interface HospitalLogic {

    void add(Hospital hospital) throws LogicException;

    void add(Doctor doctor) throws LogicException;

    List<Hospital> findHospital(String field, String meaning) throws LogicException;

    List<Doctor> findDoctor(String field, String meaning) throws LogicException;

    void update(int id, Doctor doctor) throws LogicException;

    void update(int id, Hospital hospital) throws LogicException;

    void delete(String field, int id) throws LogicException;

}
