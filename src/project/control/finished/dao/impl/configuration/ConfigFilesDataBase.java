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

    private static final ConfigFilesDataBase instance;

    static {
        try {
            instance = new ConfigFilesDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final String url;
    private final String username;
    private final String password;

    private ConfigFilesDataBase() throws IOException {

        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {

            props.load(in);

            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");

        } catch (IOException e) {
            throw new IOException(e);
        }

    }

    public Connection getConnection() throws SQLException, IOException {
        return DriverManager.getConnection(url, username, password);
    }

    public static ConfigFilesDataBase getInstance() {
        return instance;
    }

}
