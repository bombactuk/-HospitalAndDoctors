package dao;

import dao.impl.HospitalDaoBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DaoProvider extends ConfigDataBase {

    private static final DaoProvider INSTANCE;
    private static Connection dbConnection;

    static {

        try {
            INSTANCE = new DaoProvider();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private DaoProvider() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

    }

    private HospitalDao hospitalDao = new HospitalDaoBase();

    public HospitalDao getHospitalDao() {
        return hospitalDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }

    public static Connection getDbConnection() {
        return dbConnection;
    }

}
