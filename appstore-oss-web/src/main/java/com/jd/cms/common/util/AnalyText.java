package com.jd.cms.common.util;

import java.io.*;

/**
 * YYF on 2015-07-08.
 */
public class AnalyText {

    public static void main(String args[]) {
        try {
            File file = new File("F://2015-2014.txt");
            String lines = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while ((lines = br.readLine()) != null) {
                System.out.print(lines);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
