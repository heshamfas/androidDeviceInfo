package com.heshamfas.device;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.Locale;

;
/**
 * Created by Hesham Fas on 6/12/15.
 */

public class DeviceInfoApplication extends Application{


    private static DeviceInfoApplication INSTANCE ;
    public static int screenSmallestWidthDp;
    public static int screenWidthDp ;
    public static int screenHeightDp;
    public static int screenOrientation;
    public static int screenSize;
    public static int densityDpi;
    public static int displayWidth ;
    public static int displayHeight;
    public static float displayDensityX ;
    public static float displayDensityY;
    public static int   mobileCountryCode ;
    public static int   mobileNetworkCode ;
    public static Locale deviceLocale ;

    public static String screenLayoutSize;
    public static String screenOrientationString = "";
    public static String displayDensityXString ="" ;
    public static String displayDensityYString="" ;
    public static String   mobileCountryCodeString ="" ;
    public static String   mobileNetworkCodeString ="" ;
    public static String deviceLocaleString  ="" ;
    public static String  screenDensityDpi;
    public static String exactDeviceDensity= "";


    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = DeviceInfoApplication.this;
/*          *//* configuration *//*
        Configuration configuration = getResources().getConfiguration();
        screenSmallestWidthDp = configuration.smallestScreenWidthDp;
        screenWidthDp = configuration.screenWidthDp;
        screenHeightDp = configuration.screenHeightDp;
        screenOrientation = configuration.orientation;
        screenSize = configuration.screenLayout & configuration.SCREENLAYOUT_SIZE_MASK;



        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_UNDEFINED:
                screenLayoutSize = "undefined";
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                screenLayoutSize=" small";
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                screenLayoutSize=" normal";
                break;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                screenLayoutSize=" larg";
                break;
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                screenLayoutSize=  " xlarg";
                break;
            default:
                screenLayoutSize = (" layoutSize=" + screenSize);
                break;
        }
        //String screenCofinString = getResources().getConfiguration().toString();

        switch (screenOrientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                screenOrientationString = "Landscape";
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                screenOrientationString = "Portrait";
                break;
            case Configuration.ORIENTATION_UNDEFINED:
                screenOrientationString = "Undefined";
                break;
        }
        String screenOrientationLongString = String.format("screen orientation = %s \n\n" , screenOrientationString);

        *//* display metrics *//*
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float diplayDensity= displayMetrics.density;

        String exactDeviceDensity= String.format("Logical display density = %s \n\n", diplayDensity);
        int densityDpi = displayMetrics.densityDpi;
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight= displayMetrics.heightPixels;
        float displayDensityX = displayMetrics.xdpi;
        float displayDensityY= displayMetrics.ydpi;
        int   mobileCountryCode = configuration.mcc;
        int   mobileNetworkCode = configuration.mnc;
        Locale deviceLocale = configuration.locale;


        *//* building configuration strings *//*
        String displayDensityXString = String.format("display dinsity x = %s \n\n",displayDensityX );
        String displayDensityYString= String.format("display Density y = %s \n\n",displayDensityY);
        String   mobileCountryCodeString = String.format("mobile Country code = %s \n\n",mobileCountryCode);
        String   mobileNetworkCodeString = String.format("mobile network code = %s \n\n",mobileNetworkCode);
        String deviceLocaleString  = String.format("Locale = %s \n\n ",deviceLocale.toString());


        switch (displayMetrics.densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_LOW ,"low density");
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_MEDIUM ,"medium density");
                break;
            case DisplayMetrics.DENSITY_TV:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_TV ,"between medium and high density");
                break;
            case DisplayMetrics.DENSITY_HIGH:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_HIGH ,"high density");
                break;
            case DisplayMetrics.DENSITY_280:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_280 ," between high and xhigh density");
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_XHIGH ,"xhigh density");
                break;
            case DisplayMetrics.DENSITY_400:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_400 ,"between xhigh and xxhigh density");
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_XXHIGH ,"xxhigh density");
                break;
            case DisplayMetrics.DENSITY_560:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_560 ,"between xxhigh and xxxhigh density");
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                screenDensityDpi = String.format("screenDensityDpi = %s %s\n\n",DisplayMetrics.DENSITY_XXXHIGH ,"xxxhigh density");
                break;
            default:
                screenDensityDpi= displayMetrics.densityDpi +"unDefined \n\n";
                break;
        }*/
    }

    public static DeviceInfoApplication getInstance(){
            if (INSTANCE == null) {
                throw new AndroidRuntimeException("com.heshamfas.device.DeviceInfoApplication was not initialized");
            }
            return INSTANCE;
        }
    }

