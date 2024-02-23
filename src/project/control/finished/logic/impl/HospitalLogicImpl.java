package project.control.finished.logic.impl;

import project.control.finished.dao.DaoException;
import project.control.finished.dao.DaoProvider;
import project.control.finished.dao.HospitalDao;
import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;

import java.util.List;

public class HospitalLogicImpl implements HospitalLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final HospitalDao dao = provider.getHospitalDao();

    @Override
    public void add(Hospital n) throws LogicException {
        try {
            dao.add(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void add(Doctor n) throws LogicException {
        try {
            dao.add(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public List<Hospital> findHospital(String field, String meaning) throws LogicException {
        try {
            return dao.findHospital(field, meaning);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public List<Doctor> findDoctor(String field, String meaning) throws LogicException {
        try {
            return dao.findDoctor(field, meaning);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void update(int id, Doctor n) throws LogicException {
        try {
            dao.update(id, n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void update(int id, Hospital n) throws LogicException {
        try {
            dao.update(id, n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void delete(String field, int id) throws LogicException {
        try {
            dao.delete(field, id);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

}
