package com.dmsdbj.team3.tools.pdf;

import java.io.File;

/**
 * @Classname Test
 * @Auther sunshinezhang
 * @Date 2019/10/3 19:52
 */
public class Test {
    public static void main(String args[]) throws Exception {
        String path = "/Users/Betty/Desktop/test.pdf";
        File file = new File(path);
        file.createNewFile();
        new PdfUtil(file).generatePDF();
    }
}
