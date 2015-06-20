package com.heshamfas.device.file_utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heshamfas.device.device_info.R;

public class StorageActivity extends ActionBarActivity {

    private static EditText fileNameET;
    private Button newFileBtn;
    private Button openFileBtn;
    private Button saveFileBtn;

    private static final int CREATE_REQUEST_CODE = 40;
    private static final int OPEN_REQUEST_CODE= 41;
    private static final int SAVE_REQUEST_CODE=42;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        fileNameET=(EditText) findViewById(R.id.fileText);
        newFileBtn = (Button)findViewById(R.id.btn_storage_new);
        openFileBtn = (Button)findViewById(R.id.btn_storage_open);
        saveFileBtn = (Button) findViewById(R.id.btn_storage_save);
        newFileBtn.setOnClickListener(onClickListener);
        openFileBtn.setOnClickListener(onClickListener);
        saveFileBtn.setOnClickListener(onClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_storage, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case CREATE_REQUEST_CODE:
                    if(data!=null){
                         fileNameET.setText("file created");
                    }
                    break;
                case OPEN_REQUEST_CODE:
                    break;
                case SAVE_REQUEST_CODE:
                    Uri fileUri = null;
                    if(resultCode == Activity.RESULT_OK){
                        if(data != null){
                            fileUri = data.getData();
                            FileManager.writeFileCotnent(this, fileUri, "this  is sample text");
                            Toast.makeText(StorageActivity.this, "Storage Created Successfully ", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(StorageActivity.this, "An Error has occurred ", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_storage_new:

                    //Intent intent = new Intent()
                    Intent newIntent= new Intent(Intent.ACTION_CREATE_DOCUMENT);
                    newIntent.setType("text/plain");
                    newIntent.putExtra(Intent.EXTRA_TITLE, "newfile.txt");
                    startActivityForResult(newIntent,CREATE_REQUEST_CODE);
                    break;
                case R.id.btn_storage_open:
                    break;
                case R.id.btn_storage_save:
                    Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                    //Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("text/plain");
                    startActivityForResult(intent,SAVE_REQUEST_CODE);
                    break;
            }
        }
    };
}
