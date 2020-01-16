package com.dmsdbj.team3.tools.word;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

/**
 * @Classname WordUtil
 * @Auther sunshinezhang
 * @Date 2019/10/4 08:14
 */
public class WordUtil {

    private static WordUtil wordUtil = null;

    private WordUtil() {
    }

    public static WordUtil getInstance() {
        if (wordUtil == null) {
            synchronized (WordUtil.class) {
                if (wordUtil == null) {
                    wordUtil = new WordUtil();
                }
            }
        }
        return wordUtil;
    }



    /**
     *
     * @param templateFilePath  eg: 模板的位置
     * @param dataMap  文档的内容
     * @param exportFilePath  eg: 导出文件的位置
     * @param loadType  设置路径加载方式。1-绝对路径，2-项目相对路径
     * @return
     * @throws Exception
     */
    public File createDocFile(String templateFilePath, Map<String, Object> dataMap, String exportFilePath, int loadType) {
        Template t = null;
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("UTF-8");
        try {
            templateFilePath = pathReplace(templateFilePath);
            String ftlPath = templateFilePath.substring(0, templateFilePath.lastIndexOf("/"));
            if (loadType == 1) {
                // FTL文件所存在的位置
                configuration.setDirectoryForTemplateLoading(new File(ftlPath));
            } else {
                //以类加载的方式查找模版文件路径
                configuration.setClassForTemplateLoading(this.getClass(), ftlPath);
            }

            String ftlFile = templateFilePath.substring(templateFilePath.lastIndexOf("/") + 1);
            // 模板文件名
            t = configuration.getTemplate(ftlFile);

            File outFile = new File(exportFilePath);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            t.process(dataMap,out);
        } catch (Exception e) {
            System.out.println("导出word文档出错");
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  把路径的\替换成/
     * @param path
     * @return
     */
    private String pathReplace(String path) {
        while (path != null && path.contains("\\")) {
            path = path.replace("\\", "/");
        }
        return path;
    }
}
