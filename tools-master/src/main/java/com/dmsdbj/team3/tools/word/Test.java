package com.dmsdbj.team3.tools.word;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Test
 * @Auther sunshinezhang
 * @Date 2019/10/3 21:23
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("username", "张三");
        dataMap.put("sex", "男");
        String templateFile = "/Users/sunshinezhang/Documents/Team3/DesignPatterns/code/tools/template.ftl";
        String exportFile = "/Users/sunshinezhang/Documents/Team3/DesignPatterns/code/tools/src/test/test.word";
        WordUtil.getInstance().createDocFile(templateFile, dataMap, exportFile, 1);
    }

}
