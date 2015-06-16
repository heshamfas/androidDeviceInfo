package com.heshamfas.device.file_utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.heshamfas.device.DeviceInfoApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

/**
 * Created by Hesham Fas on 6/15/15.
 */
public class FileManager {

    private static final String TAG = FileManager.class.getSimpleName();
    Context context = DeviceInfoApplication.getInstance().getApplicationContext();
    public static boolean createExternalFile(String fileName, String contents) {
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, fileName);
       // file.createNewFile();
/*        if (!file.mkdirs()) {
            Log.d("FileManager", "Directory Not Created");
        }*/
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(contents.getBytes());
       /*     OutputStreamWriter outputStreamWriter =
            fileOutputStream.close();*/
            Log.d("FileManager", "file seems to be created ok");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("FileManager", "FileNotFoundException " + e.getCause().toString());
        } catch (IOException e) {
            Log.e("FileManager", "IOException " + e.getCause().toString());
            e.printStackTrace();
        }

        return true;
    }

    public static boolean writeToExternalStorage(String content){
        // write on SD card file data in the text box
        tyringOneMoreTime();
        try {
            File path = Environment.getExternalStorageDirectory();
            File dir = new File(path.getAbsolutePath()+ "/newDir");

            File myFile = new File(dir, "newFile.txt");
            myFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(myFile);
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(content);
            outputStreamWriter.close();
            fileOutputStream.close();
            Log.d(TAG, "file seems to be created successfully");
            Toast.makeText(DeviceInfoApplication.getInstance(),
                    "Done writing SD 'mysdfile.txt'",
                    Toast.LENGTH_LONG).show();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void tyringOneMoreTime(){
        Log.d(TAG, "What the heck is going on?????????");
        String filename = "filename.txt";
        File file = new File(Environment.getExternalStorageDirectory(), filename);
        FileOutputStream fos;
        byte[] data = new String("data to write to file").getBytes();
        try {
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // handle exception
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
