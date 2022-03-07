package com.example.mytextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "lyd";
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv_one = findViewById(R.id.tv_one);
//        tv_one.setText(R.string.my_name1);
//        tv_one.setBackgroundColor(ContextCompat.getColor(this,R.color.background_color));
        //Color.parseColor("#7fb80e")

        Button btn = findViewById(R.id.btn);

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
}