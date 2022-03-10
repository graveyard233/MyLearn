package com.example.mytextview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends BaseActivity {

    private Button btn_third;
    private Button btn_getMessage;
    private TextView textView_changed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn_third = findViewById(R.id.btn_thirdpage);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        btn_getMessage = findViewById(R.id.btn_getMessage);
        btn_getMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return",
                        "hello,this message is from thirdActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        textView_changed = findViewById(R.id.text_changed);
        String data = getIntent().getStringExtra("param2");
        if (data != null)
            textView_changed.setText(data);
    }

    @Override
    public void onBackPressed(){//重写方法，用户在按下back建后也能将数据传回上个activity
        Intent intent = new Intent();
        intent.putExtra("data_return","hello,this message is from thirdActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void clearAll(View view) {
        ActivityCollector.finishAll();
//        android.os.Process.killProcess(android.os.Process.myPid()); //这能杀光当前程序后台
    }
}