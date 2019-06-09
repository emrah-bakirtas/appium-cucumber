package util;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Configuration instance = new Configuration();

    private Properties configProps = new Properties();

    private String app;
    private String device;
    private String browserstackDebug;
    private String userEmail;
    private String userPassword;

    public static Configuration getInstance() {
        return instance;
    }

    private Configuration() {

        try (InputStream is = ClassLoader.getSystemResourceAsStream("config.properties")) {
            configProps.load(is);

            this.app = configProps.getProperty("app");
            this.device = configProps.getProperty("device");
            this.browserstackDebug = configProps.getProperty("browserstack.debug");
            this.userEmail = configProps.getProperty("user.email");
            this.userPassword = configProps.getProperty("user.password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getApp() {
        return app;
    }

    public String getDevice() {
        return device;
    }

    public String getBrowserstackDebug() {
        return browserstackDebug;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
