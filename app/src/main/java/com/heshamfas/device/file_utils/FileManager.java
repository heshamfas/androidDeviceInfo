package com.heshamfas.device.file_utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;

import com.heshamfas.device.DeviceInfoApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

/**
 * Created by Hesham Fas on 6/15/15.
 */
public class FileManager {
//nexus 9 is 1024 x 768 dp check when Ricardo comes back
    private static final String TAG = FileManager.class.getSimpleName();
    Context context = DeviceInfoApplication.getInstance().getApplicationContext();

    // an attempt for template for loading files
    public static String loadFile(String fileName){
        int data_block = 100;
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath()+ "/MyDirectory");
            File file = new File(directory,fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data="";
            int size;
            try {
                while((size = isr.read(data))>0)
                {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data+= read_data;
                    data = new char[data_block];
                }
                //Toast.makeText(getBaseContext(), "Message :"+final_data, Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";
    }



    public static void saveFile(String fileName, String contents){
        try {
            //FileOutputStream fou = openFileOutput("text.txt", MODE_WORLD_READABLE);
            //File sdcard = Environment.getExternalStorageDirectory();
            File sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File directory = new File(sdcard.getAbsolutePath()+ "/DimenDirectory");
            directory.mkdirs();
            File file = new File(directory,fileName);
            FileOutputStream fou = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fou);
            try {
                osw.write(contents);
                osw.flush();
                osw.close();
                //Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();}
    }

    public static void writeFileCotnent(Context context,Uri uri, String content){
        try{
            ParcelFileDescriptor parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /* public static void tyringOneMoreTime() throws IOException {
        Log.d(TAG, "What the heck is going on?????????");
        String filename = "filename.txt";
        File file = new File(Environment.getExternalStorageDirectory(), filename);
        file.createNewFile();
        FileOutputStream fos;
        byte[] data = new String("data to write to file").getBytes();
        try {
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // handle exception
            Log.d(TAG, " FileNotFoundException What the heck is going on?????????");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d(TAG, " IOException What the heck is going on?????????");
            e.printStackTrace();
        }
    }*/
}
