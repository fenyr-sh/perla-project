package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Fenyr Shell
 */
public class Configuration extends Properties {

    private final File configFile = new File("db_config.properties");

    public Configuration() {
        setProperty("DB_PROTOCOL", "jdbc:mysql:");
        setProperty("DB_HOST", "localhost");
        setProperty("DB_PORT", "3306");
        setProperty("DB_DATABASE", "test");
        setProperty("DB_USERNAME", "root");
        setProperty("DB_PASSWORD", "secret");
    }

    /**
     * Carga la configuración de la base de datos desde un archivo de
     * propiedades.
     *
     * @throws IOException
     */
    public void loadProperties() throws IOException {
        InputStream inputStream = new FileInputStream(configFile);
        load(inputStream);
        inputStream.close();
    }

    /**
     * Guarda la configuracion de la base de datos en un archivo de propiedades.
     *
     * @param protocol protocolo de conexión.
     * @param host host de la base de datos.
     * @param port puerto de la base de datos.
     * @param database nombre de la base de datos.
     * @param username usuario de la base de datos.
     * @param password contraseña de la base de datos.
     * @throws IOException
     */
    public void saveProperties(String protocol, String host, String port,
            String database, String username, String password) throws IOException {

        setProperty("DB_PROTOCOL", protocol);
        setProperty("DB_HOST", host);
        setProperty("DB_PORT", port);
        setProperty("DB_DATABASE", database);
        setProperty("DB_USERNAME", username);
        setProperty("DB_PASSWORD", password);

        OutputStream outputStream = new FileOutputStream(configFile);
        store(outputStream, "Database setttings");
        outputStream.close();
    }
}
