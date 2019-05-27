package com.lijingtest.studymaven.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * 读入配置文件的地方
 */
public class PropertiesConfig {

    public static List<String> redisPropertisConfig() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertiesConfig.class.getClassLoader();
        System.out.println(classLoader.getResource(""));
        //System.out.println(classLoader.getResource("/"));
        InputStream inputStream = classLoader.getResourceAsStream("redis.properties");
        properties.load(inputStream);
        Iterator<String> it = properties.stringPropertyNames().iterator();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            if (it.next().equals("redis.port")) {
                String redisPort = properties.getProperty("redis.port");
                result.add(redisPort);
                String redisServer = properties.getProperty("redis.server");
                result.add(redisServer);
            }
        }
        return result;
    }

    public static List<String> databasePropertisConfig() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertiesConfig.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("config/database.properties");
        properties.load(inputStream);
        Iterator<String> it = properties.stringPropertyNames().iterator();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            if (it.next().equals("databasename")) {
                String databaseName = properties.getProperty("databasename");
                result.add(databaseName);
                String databasePassword = properties.getProperty("databasepassword");
                result.add(databasePassword);
            }
        }
        return result;
    }

    //从外面读取文件
    public static List<String> redisOutsize() throws Exception{
        InputStream inputStream = new FileInputStream("config/resources/config/database.properties");
        Properties propertie = new Properties();
        propertie.load(inputStream);
        List<String> result = new ArrayList<>();
        result.add(propertie.getProperty("databasename"));
        result.add(propertie.getProperty("databasepassword"));
        return result;
    }

    public static List<String> kafkaPropertisConfig() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertiesConfig.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("kafka.properties");
        properties.load(inputStream);
        Iterator<String> it = properties.stringPropertyNames().iterator();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            if (it.next().equals("kafkaname")) {
                String databaseName = properties.getProperty("kafkaname");
                result.add(databaseName);
                String databasePassword = properties.getProperty("kafkapassword");
                result.add(databasePassword);
            }
        }
        return result;
    }

}
