package project.control.finished.dao.impl.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConfigFilesDataBase {

    private ConfigFilesDataBase() {
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();

        InputStream in = Files.newInputStream(Paths.get("database.properties"));
        props.load(in);


        return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
                props.getProperty("password"));

    }

}
