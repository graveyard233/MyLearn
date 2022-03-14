package com.example.mytextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThirdActivity extends BaseActivity {

    private Button btn_third;
    private Button btn_getMessage;
    private TextView textView_changed;
    public List<Fruit> fruitList = new ArrayList<>();
    public List<Fruit> fruitList2 = new ArrayList<>();

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

        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter_Recycler adapter_recycler = new FruitAdapter_Recycler(fruitList);
        recyclerView.setAdapter(adapter_recycler);

        initFruits2();
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView_PuBu);
        StaggeredGridLayoutManager layoutManager2 = new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager2);
        FruitAdapter_PuBu adapter_puBu = new FruitAdapter_PuBu(fruitList2);
        recyclerView2.setAdapter(adapter_puBu);

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

    private void initFruits() {
        for (int i = 0; i < 3; i++) {
            Fruit a1 = new Fruit("apple",R.drawable.ic_baseline_ac_unit_24);
            fruitList.add(a1);
            Fruit a2 = new Fruit("banana",R.drawable.ic_baseline_access_time_24);
            fruitList.add(a2);
            Fruit a3 = new Fruit("orange",R.drawable.glass_change_544x383);
            fruitList.add(a3);
            Fruit a4 = new Fruit("Water",R.drawable.ic_launcher_foreground);
            fruitList.add(a4);
        }
    }

    private void initFruits2() {
        for (int i = 0; i < 3; i++) {
            Fruit a1 = new Fruit(
                    getRandomLengthString("apple"),R.drawable.ic_baseline_ac_unit_24);
            fruitList2.add(a1);
            Fruit a2 = new Fruit("banana",R.drawable.ic_baseline_access_time_24);
            fruitList2.add(a2);
            Fruit a3 = new Fruit(getRandomLengthString("orange"),R.drawable.glass_change_544x383);
            fruitList2.add(a3);
            Fruit a4 = new Fruit("Water",R.drawable.ic_launcher_foreground);
            fruitList2.add(a4);
        }
    }

    private String getRandomLengthString(String name) {
        Random random = new Random();
        int length = random.nextInt(15) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}