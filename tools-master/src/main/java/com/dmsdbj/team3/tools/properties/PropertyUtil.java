package com.dmsdbj.team3.tools.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Classname PropertyUtil
 * @Auther sunshinezhang
 * @Date 2019/10/3 14:48
 */
public class PropertyUtil {
    private static Properties props;

    synchronized static private void loadProps(String path) {
        System.out.println("开始加载properties文件内容.......");
        props = new Properties();
        InputStream inputStream =null;
        try {
            //inputStream = PropertyUtil.class.getResourceAsStream("/test.properties");
            inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream(path);
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("properties文件未找到");
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.printf("jdbc.properties文件流关闭出现异常");
                }
            }
        }

        System.out.println("加载properties文件内容完成");
        System.out.println("properties文件内容："+props);
    }


    public static String getProperty(String path,String key){
        if (props == null) {
            loadProps(path);
        }
        return props.getProperty(key);
    }

    public static String getProperty(String path,String key,String defaultValue){
        if (props == null) {
            loadProps(path);
        }
        return props.getProperty(key, defaultValue);
    }

}
