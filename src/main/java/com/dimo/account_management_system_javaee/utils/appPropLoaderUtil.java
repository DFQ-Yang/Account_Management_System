package com.dimo.account_management_system_javaee.utils;

import java.io.InputStream;
import java.util.Properties;

public class appPropLoaderUtil {
    private static Properties prop = new Properties();

    static{
        try(InputStream is = appPropLoaderUtil.class.getClassLoader().getResourceAsStream("application.properties")){
            prop.load(is);
        }
        catch (Exception e){
            throw new RuntimeException("Load application.properties failed", e);
        }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }
}
