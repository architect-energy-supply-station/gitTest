package com.dmsdbj.team3.tools.yaml;

import java.util.Map;
import java.util.Properties;

/**
 * @Classname Test
 * @Auther sunshinezhang
 * @Date 2019/10/3 18:35
 */
public class Test {
    public static void main(String[] args) {
        String path = "test.yaml";
        Map<String, Object> stringObjectMap = YamlUtil.yaml2Map(path);
        System.out.println(stringObjectMap);

        Properties properties = YamlUtil.yaml2Properties(path);
        System.out.println(properties);
    }
}
