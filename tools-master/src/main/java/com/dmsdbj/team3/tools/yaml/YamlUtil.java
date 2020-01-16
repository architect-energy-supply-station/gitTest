package com.dmsdbj.team3.tools.yaml;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;
import java.util.Properties;

/**
 * @Classname YamlUtil
 * @Auther sunshinezhang
 * @Date 2019/10/3 18:31
 */
public class YamlUtil {
    public static Map<String,Object> yaml2Map(String yamlSource){
        YamlMapFactoryBean bean = new YamlMapFactoryBean();
        bean.setResources(new ClassPathResource(yamlSource));
        return bean.getObject();
    }

    public static Properties yaml2Properties(String yamlSource){
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(yamlSource));
        return yaml.getObject();
    }
}
