package com.dmsdbj.team3.tools.xml;

/**
 * @Classname Test
 * @Auther sunshinezhang
 * @Date 2019/10/3 18:59
 */
public class Test {
    public static void main(String[] args) {
        String path = "/Users/sunshinezhang/Documents/Team3/DesignPatterns/code/tools/src/main/resources/test.xml";
        String tagName = "className";
        Object bean = XMLUtil.getBean(path, tagName);
        System.out.println(bean.getClass().getPackage());

    }
}
