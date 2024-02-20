package project.control.finished.dao;

import project.control.finished.dao.impl.HospitalDaoBase;

public final class DaoProvider {

    private static final DaoProvider INSTANCE;

    static {
        INSTANCE = new DaoProvider();
    }

    private DaoProvider() {
    }

    private HospitalDao hospitalDao = new HospitalDaoBase();

    public HospitalDao getHospitalDao() {
        return hospitalDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }

}
