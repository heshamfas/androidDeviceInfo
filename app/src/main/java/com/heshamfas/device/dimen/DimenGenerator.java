package com.heshamfas.device.dimen;

import com.heshamfas.device.DeviceInfoApplication;

/**
 * Created by Hesham Fas on 6/12/15.
 */
public class DimenGenerator {

    private int widthDp, heightDp, widthPixils, heightPixils;
    private String dimenFile;
    static int deviceWidth = DeviceInfoApplication.screenWidthDp;
    static int deviceHeight = DeviceInfoApplication.screenHeightDp;


    public static String generateDimenFile(){

        StringBuilder builder = new StringBuilder("");
        builder.append(generateFileHead());
        builder.append(getWidthDimens());
        builder.append(getHeightDimens());
        builder.append(generateFileEnd());

        return builder.toString();
    }

    private static String getWidthDimens(){
        StringBuilder builder = new StringBuilder("<!-- Width Percentages --> \n\n");
        for(int i = 1; i<= 100; i++){
            int dimen = (int) ((i*deviceWidth)/100);
            builder.append(String.format("<dimen name=\"width_percent_%s\">%s</dimen> \n\n",i, dimen));
        }
        return builder.toString();
    }
    private static String getHeightDimens(){
        StringBuilder builder = new StringBuilder("\n\n <!-- Height Percentages --> \n\n");
        for(int i = 1; i<= 100; i++){
            int dimen = (int) ((i*deviceHeight)/100);
            builder.append(String.format("<dimen name=\"height_percent_%s\">%s</dimen> \n\n",i, dimen));
        }
        return builder.toString();
    }

    private static String generateFileHead(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<resources> \n\n\n";
    }

    private static String generateFileEnd(){
        return "</resources> \n\n\n";
    }
}
