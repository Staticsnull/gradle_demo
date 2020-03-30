package cn.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 演示饿汉单例模式 不具备懒加载的特性
 */
public class ConfigManager {
//    private static ConfigManager configManager = new ConfigManager();
    private static Properties params;
    private ConfigManager(){
        params = new Properties();
        String configFile = "database.properties";
        InputStream is =
                ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            params.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用静态内部类解决饿汉模式不能具备懒加载的特性
    private static class ConfigManagerHelper{
        private static final ConfigManager CONFIG_MANAGER = new ConfigManager();
    }
    public static ConfigManager getInstance(){
//        return configManager;
        return ConfigManagerHelper.CONFIG_MANAGER;
    }

    public String getValue(String key){
        return params.getProperty(key);
    }
}
