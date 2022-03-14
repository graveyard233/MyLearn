package com.example.mytextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "lyd";
    private EditText et;
    private  ProgressBar progressBar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.page1_item:
                Toast.makeText(this,"click page1",Toast.LENGTH_SHORT).show();
//              Intent intent1 = new Intent(this,MainActivity.class);
                Intent intent1 = new Intent("lyd.aaa");
//              startActivity(intent1);
                PackageManager packageManager = getPackageManager();
                if (intent1.resolveActivity(packageManager) != null){
                    Toast.makeText(this,"找到了activity",Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                } else {
                    Toast.makeText(this,"没找到activity",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.page2_item:
                Toast.makeText(this,"click page2",Toast.LENGTH_SHORT).show();
//                Intent intent2 = new Intent(this,SecondActivity.class);
                Intent intent2 = new Intent("com.example.activitytest.ACTION_START");
                PackageManager packageManager2 = getPackageManager();
                if (intent2.resolveActivity(packageManager2) != null){
                    Toast.makeText(this,"找到了activity",Toast.LENGTH_SHORT).show();
                    String data = "hello secondActivity";
                    intent2.putExtra("extra_data",data);
                    startActivity(intent2);
                } else {
                    Toast.makeText(this,"没找到activity",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.page4_item:
                Intent intent4 = new Intent(this,FourthActivity.class);
                startActivity(intent4);
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv_one = findViewById(R.id.tv_one);
//        tv_one.setText(R.string.my_name1);
//        tv_one.setBackgroundColor(ContextCompat.getColor(this,R.color.background_color));
        //Color.parseColor("#7fb80e")

        Button btn = findViewById(R.id.btn);

        progressBar = findViewById(R.id.pb);

        //点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
            }
        });
        //长按事件
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.e(TAG,"On Long Click");
                return false;
            }
        });
        //触摸事件
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e(TAG, "onTouch: "+ motionEvent.getAction());
                return false;
            }
        });

        Button btn_getPassword = findViewById(R.id.btn_getpassword);
        et = findViewById(R.id.et);
        btn_getPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();
                Log.e(TAG, "my password :" + text);
            }
        });



    }


    public void myclick(View view)
    {

        if (progressBar.getVisibility() == View.GONE)
        {
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(this,"显示进度条! short",Toast.LENGTH_SHORT).show();
        }
        else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this,"隐藏! long",Toast.LENGTH_LONG).show();
        }

    }
}