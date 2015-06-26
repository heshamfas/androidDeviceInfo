package com.heshamfas.device.device_info;

import android.os.Build;
import android.os.Build.VERSION_CODES;

/**
 * Created by root on 6/22/15.
 */
public class BuildInfoGenerator {

    public String getBuildInfo(){
        int SDK = Build.VERSION.SDK_INT;
        /*The current development codename, or the string "REL" if this is a release build.*/
        String codeName = Build.VERSION.CODENAME;
        /*The internal value used by the underlying source control
         to represent this build. E.g., a perforce changelist number or a git hash.*/
        String incremental = Build.VERSION.INCREMENTAL;
        /*The user-visible version string. E.g., "1.0" or "3.4b5".*/
        String release = Build.VERSION.RELEASE;
        String versionCode =  getVersinCode();
        String brandName = Build.BRAND;
        String model = Build.MODEL;
        String manufacturer = Build.MANUFACTURER;
        String serialNumber = Build.SERIAL;
        String display = Build.DISPLAY;
        String board = Build.BOARD;
        String bootLoader = Build.BOOTLOADER;
        String device = Build.DEVICE;
        String cpu_abi = Build.CPU_ABI;
        String hardware = Build.HARDWARE;
        String host = Build.HOST;
        String id= Build.ID;
        String product = Build.PRODUCT;
        String tags = Build.TAGS;
        String time = "" +Build.TIME;
        String type= Build.TYPE;
        String user = Build.USER;







        return "";
    }
private String getVersinCode(){
    String versionName=null;
   switch (Build.VERSION.SDK_INT){

       case VERSION_CODES.BASE:
           versionName = "BASE";
           break;
       case VERSION_CODES.BASE_1_1:
           break;
       case VERSION_CODES.CUPCAKE:
           versionName = "CUPCAKE";
           break;
       case VERSION_CODES.CUR_DEVELOPMENT:
           versionName = "CUR_DEVELOPMENT";
           break;
       case VERSION_CODES.DONUT:
           versionName = "DONUT";
           break;
       case VERSION_CODES.ECLAIR:
           versionName = "ECLAIR";
           break;
       case VERSION_CODES.ECLAIR_0_1:
           versionName = "ECLAIR_0_1";
           break;
       case VERSION_CODES.ECLAIR_MR1:
           versionName = "ECLAIR_MR1";
           break;
       case VERSION_CODES.FROYO:
           versionName = "FROYO";
           break;
       case VERSION_CODES.GINGERBREAD:
           versionName = "GINGERBREAD";
           break;
       case VERSION_CODES.GINGERBREAD_MR1:
           versionName = "GINGERBREAD_MR1";
           break;
       case VERSION_CODES.HONEYCOMB:
           versionName = "HONEYCOMB";
           break;
       case VERSION_CODES.HONEYCOMB_MR1:
           versionName = "HONEYCOMB_MR1";
           break;
       case VERSION_CODES.HONEYCOMB_MR2:
           versionName = "HONEYCOMB_MR2";
           break;
       case VERSION_CODES.ICE_CREAM_SANDWICH:
           versionName = "ICE_CREAM_SANDWICH";
           break;
       case VERSION_CODES.ICE_CREAM_SANDWICH_MR1:
           versionName = "ICE_CREAM_SANDWICH_MR1";
           break;
       case VERSION_CODES.JELLY_BEAN:
           versionName = "JELLY_BEAN";
           break;
       case VERSION_CODES.JELLY_BEAN_MR1:
           versionName = "JELLY_BEAN_MR1";
           break;
       case VERSION_CODES.JELLY_BEAN_MR2:
           versionName = "JELLY_BEAN_MR2";
           break;
       case VERSION_CODES.KITKAT:
           versionName = "KITKAT";
           break;
       case VERSION_CODES.KITKAT_WATCH:
           versionName = "KITKAT_WATCH";
           break;
       case VERSION_CODES.LOLLIPOP:
           versionName = "LOLLIPOP";
           break;
       case VERSION_CODES.LOLLIPOP_MR1:
           versionName = "LOLLIPOP_MR1";
           break;
       default:
           versionName="";
   }

    return versionName ;
}

}

