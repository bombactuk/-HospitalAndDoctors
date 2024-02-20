package project.control.finished.logic;

import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;

import java.util.List;

public interface HospitalLogic {

    void add(Hospital n) throws LogicException;

    List<Hospital> findHospital(String field, String meaning) throws LogicException;

    List<Doctor> findDoctor(String field, String meaning) throws LogicException;

    void add(Doctor n) throws LogicException;

}
