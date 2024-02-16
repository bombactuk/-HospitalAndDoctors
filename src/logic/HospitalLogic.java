package logic;

import entity.Doctor;
import entity.Hospital;

import java.sql.ResultSet;

public interface HospitalLogic {

    void add(Hospital n) throws LogicException;

    ResultSet find(String field, String meaning) throws LogicException;

    void add(Doctor n) throws LogicException;

}
