package com.example.mytextview.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytextview.IFragmentCallBack;
import com.example.mytextview.R;


public class BlankFragment1 extends Fragment {

    private View root;
    private TextView textView;
    private Button button;

    private IFragmentCallBack fragmentCallBack;
    public void setFragmentCallBack(IFragmentCallBack iFragmentCallBack){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        String message = bundle.getString("message");
        Log.d("message", "fragment传递数据： " + message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null){
            root = inflater.inflate(R.layout.fragment_blank1,container,false);
        }
        textView = root.findViewById(R.id.text_frag_1);
        button = root.findViewById(R.id.btn_frag_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("message");
            }
        });
        return root;
    }
}