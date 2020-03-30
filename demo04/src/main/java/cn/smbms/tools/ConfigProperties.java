package cn.smbms.tools;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 懒汉单例模式
 */
public class ConfigProperties {
    private static ConfigProperties configProperties;
    private static Properties params;

    private ConfigProperties() {
        params = new Properties();
        String configFile = "database.properties";
        InputStream is =
                ConfigProperties.class.getClassLoader().getResourceAsStream(configFile);
        try {
            params.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用同步锁解决懒汉模式线程安全的问题
     *
     * @return
     */
    public static ConfigProperties getInstance() {
        if (configProperties == null) {
            synchronized (ConfigProperties.class) {
                if (configProperties == null)
                    configProperties = new ConfigProperties();
            }
        }
        return configProperties;
    }


    public String getValue(String key) {
        return params.getProperty(key);
    }
}
