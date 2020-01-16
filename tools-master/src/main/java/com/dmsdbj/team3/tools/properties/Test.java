package com.dmsdbj.team3.tools.properties;

/**
 * @Classname PropertyTest
 * @Auther sunshinezhang
 * @Date 2019/10/3 15:10
 */
public class Test {
    public static void main(String[] args) {
        String path = "test.properties";
        String key = "username";
        String defaultValue = "password";
        String result=PropertyUtil.getProperty(path,key,defaultValue);
        String result1=PropertyUtil.getProperty(path,key);
        System.out.println(result);
        System.out.println(result1);

    }
}
