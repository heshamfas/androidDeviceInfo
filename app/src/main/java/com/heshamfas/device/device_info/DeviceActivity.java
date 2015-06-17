package com.heshamfas.device.device_info;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.heshamfas.device.dimen.DimenGenerator;
import com.heshamfas.device.file_utils.FileManager;
import java.util.Locale;


public class DeviceActivity extends ActionBarActivity {
    TextView deviceInfoTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        deviceInfoTV = (TextView)findViewById(R.id.infoTV);

        /* configuration */
        Configuration configuration = getResources().getConfiguration();
        int screenSmallestWidthDp = configuration.smallestScreenWidthDp;
        int screenWidthDp = configuration.screenWidthDp;
        int screenHeightDp = configuration.screenHeightDp;
        int screenOrientation = configuration.orientation;
        int screenSize = configuration.screenLayout & configuration.SCREENLAYOUT_SIZE_MASK;
        String screenLayoutSize;
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
        String screenOrientationString = "";
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
        screenOrientationString = String.format("screen orientation = %s \n\n" , screenOrientationString);

        /* display metrics */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
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

        /* building configuration strings */
        String displayDensityXString = String.format("display dinsity x = %s \n\n",displayDensityX );
        String displayDensityYString= String.format("display Density y = %s \n\n",displayDensityY);
        String   mobileCountryCodeString = String.format("mobile Country code = %s \n\n",mobileCountryCode);
        String   mobileNetworkCodeString = String.format("mobile network code = %s \n\n",mobileNetworkCode);
        String deviceLocaleString  = String.format("Locale = %s \n\n ",deviceLocale.toString());

        String  screenDensityDpi;
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
        }
        /* displaying info */
        StringBuilder builder = new StringBuilder("");
        String dimenFileContents = DimenGenerator.generateDimenFile();
        builder.append(dimenFileContents);
        FileManager.saveFile("dimens.xml",dimenFileContents );
        builder.append(String.format("display density DPI     = %s \n\n",densityDpi));
        builder.append(String.format("display Width Px  = %s \n\n",displayWidth));
        builder.append(String.format("display Height Px = %s \n\n",displayHeight));
        builder.append(String.format("screen Width in DP  = %s \n\n", screenWidthDp));
        builder.append(String.format("screen Height in DP = %s \n\n", screenHeightDp));
        builder.append(String.format("smallest Screen Width Dp = %s \n\n",screenSmallestWidthDp));
        builder.append(String.format("screen Layout Size = %s \n\n", screenLayoutSize));
        builder.append(screenDensityDpi);
        builder.append(exactDeviceDensity);
        builder.append(screenOrientationString);
        builder.append(displayDensityXString) ;
        builder.append(displayDensityYString) ;
        builder.append(mobileCountryCodeString);
        builder.append(mobileNetworkCodeString) ;
        builder.append(deviceLocaleString);
        /*builder.append(String.format("screenCofinString = %s \n",screenCofinString));*/
        deviceInfoTV.setText(builder.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_device, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
