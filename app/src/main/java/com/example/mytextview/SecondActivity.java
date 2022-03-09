package com.example.mytextview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button btn_secondpage;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.page1_item:
                Toast.makeText(this,"click page1",Toast.LENGTH_SHORT).show();
//                Intent intent1 = new Intent(this,MainActivity.class);
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent1);
                break;
            case R.id.page2_item:
                Toast.makeText(this,"click page2",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent("com.example.activitytest.ACTION_START");
                intent2.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent2);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("SecondActivity", "onActivityResult: " + returnedData);
                }
                break;
            default:
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity", " THE DATA I SAND IS:" + data);

        btn_secondpage = findViewById(R.id.btn_secondpage);
        btn_secondpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivityForResult(intent3,1);
            }
        });


    }


}