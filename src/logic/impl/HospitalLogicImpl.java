package logic.impl;

import dao.DaoException;
import dao.DaoProvider;
import dao.HospitalDao;
import entity.Doctor;
import entity.Hospital;
import logic.HospitalLogic;
import logic.LogicException;

import java.sql.ResultSet;

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
    public ResultSet find(String field, String meaning) throws LogicException {
        try {
            return dao.find(field, meaning);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

}
