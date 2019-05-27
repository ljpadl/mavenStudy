package com.lijingtest.studymaven;
//import org.junit.Test;

import com.lijingtest.studymaven.config.PropertiesConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {

        System.out.println( "Hello World!" );
        System.out.println(StringUtils.isNotBlank("hellohusd"));
        System.out.println(StringUtils.isNotEmpty("lijiang"));
        //设计一个读入参数的类
        List<String> result = PropertiesConfig.redisPropertisConfig();
        System.out.println(result.size());
        System.out.println(result.get(0) + result.get(1));
        List<String> result1 = PropertiesConfig.databasePropertisConfig();
        System.out.println(result1.size());
        System.out.println(result1.get(0) + result1.get(1));
        if (args != null && args.length > 0){
            List<String> result2 = PropertiesConfig.redisOutsize();
            System.out.println(result2.size());
            System.out.println(result2.get(0) + result2.get(1));
        }
        List<String> result3 = PropertiesConfig.kafkaPropertisConfig();
        System.out.println(result3.get(0) + result3.get(1));
    }
}
