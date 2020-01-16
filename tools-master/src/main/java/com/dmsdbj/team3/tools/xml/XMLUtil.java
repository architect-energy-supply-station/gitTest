package com.dmsdbj.team3.tools.xml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @Classname XMLUtil
 * @Auther sunshinezhang
 * @Date 2019/10/3 10:38
 */
public class XMLUtil {
    public static Object getBean(String path, String tagName) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(path));

            String firstChild = document.getElementsByTagName(tagName).item(0).getFirstChild().getNodeValue();

            Class aClass = Class.forName(firstChild);
            Object o = aClass.newInstance();
            return o;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
