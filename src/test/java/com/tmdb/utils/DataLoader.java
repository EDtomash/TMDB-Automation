package com.tmdb.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataloader;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance() {
        if(dataloader == null) {
            dataloader = new DataLoader();
        }
        return dataloader;
    }

    public String getUserLogin() {
        String prop = properties.getProperty("user_login");
        if(prop != null) return prop;
        else throw new RuntimeException("property user_login is not specified in the data.properties file");
    }

    public String getUserPassword() {
        String prop = properties.getProperty("user_password");
        if (prop != null) return prop;
        else throw new RuntimeException("property user_password is not specified in the data.properties file");
    }

    public String getUserId() {
        String prop = properties.getProperty("account_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property account_id is not specified in the data.properties file");
    }
}
