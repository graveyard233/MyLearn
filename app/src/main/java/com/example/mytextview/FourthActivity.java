package com.example.mytextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytextview.Fragment.BlankFragment1;
import com.example.mytextview.Fragment.BlankFragment2;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_change;
    private Button button_replace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        button_change = findViewById(R.id.btn_four_change);
        button_change.setOnClickListener(this);
        button_replace = findViewById(R.id.btn_four_replace);
        button_replace.setOnClickListener(this);
        replaceFragment(new BlankFragment2());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_four_change:
                Bundle bundle = new Bundle();
                bundle.putString("message","HaHa,i like it");
                BlankFragment1 bf = new BlankFragment1();
                bf.setArguments(bundle);
//                IFragmentCallBack Icall = new IFragmentCallBack() {
//                }

                replaceFragment(bf);
                break;
            case R.id.btn_four_replace:
                replaceFragment(new BlankFragment2());
                break;
            default:break;
        }
    }

    private void replaceFragment(Fragment fragment) {//动态切换fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
//        transaction.addToBackStack(null);  用于将其碎片加入栈
        transaction.commit();
    }
}