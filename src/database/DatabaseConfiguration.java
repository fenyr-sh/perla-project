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
public class DatabaseConfiguration extends Properties {

    private final File configurationFile;

    /**
     * Establece un nombre de archivo de configuración.
     * 
     * @param configurationFile archivo de configuración.
     */
    public DatabaseConfiguration(File configurationFile) {
        this.configurationFile = configurationFile;
    }
    
    /**
     * Retorna el archivo de configuración.
     * @return archivo de configuracion.
     */
    public File getConfigurationFile() {
        return configurationFile;
    }

    /**
     * Establece la configuración.
     * 
     * @param protocol protocolo de conexión.
     * @param host host de la base de datos.
     * @param port puerto de la base de datos.
     * @param database nombre de la base de datos.
     * @param username usuario de la base de datos.
     * @param password contraseña de la base de datos.
     * @param timezone zona horaria de la base de datos.
     */
    public void setConfiguration(String protocol, String host, String port,
            String database, String username, String password, String timezone) {
        
        setProperty("DB_PROTOCOL", protocol);
        setProperty("DB_HOST", host);
        setProperty("DB_PORT", port);
        setProperty("DB_DATABASE", database);
        setProperty("DB_USERNAME", username);
        setProperty("DB_PASSWORD", password);
        setProperty("DB_TIMEZONE", timezone);
    }

    /**
     * Carga la configuración desde un archivo.
     *
     * @throws IOException
     */
    public void loadConfiguration() throws IOException {
        InputStream inputStream = new FileInputStream(configurationFile);
        load(inputStream);
        inputStream.close();
    }
    
    /**
     * Guarda la configuracion en un archivo.
     *
     * @param msg mensaje.
     * @throws IOException
     */
    public void storeConfiguration(String msg) throws IOException {
        OutputStream outputStream = new FileOutputStream(configurationFile);
        store(outputStream, msg);
        outputStream.close();
    }
}