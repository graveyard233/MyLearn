package com.example.mytextview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    private Button btn_secondpage;
    private Button btn_alertDialog;
    private ProgressBar progressBar2;
    private NotificationManager manager;
    private Notification notification;

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
            case R.id.page3_item:
                Intent intent3 = new Intent(getApplicationContext(),ThirdActivity.class);

                startActivity(intent3);

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

        progressBar2 = findViewById(R.id.pb2);

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

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("lyd",
                    "测试通知",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        Intent intent4 = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent4, 0);
        notification = new NotificationCompat.Builder(this,"lyd")
                .setContentTitle("回到第一页")
                .setContentText("文本内容显示区域")
                .setSmallIcon(R.drawable.ic_baseline_ac_unit_24)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.glass))
                .setColor(Color.parseColor("#3a89b0"))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        btn_alertDialog = findViewById(R.id.btn_alertDialog);
        btn_alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setIcon(R.drawable.ic_baseline_ac_unit_24)
                      .setTitle("this is dialog")
                      .setMessage("something important")
                      .setCancelable(false)
                      .setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                      .setNegativeButton("Cancel!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                      .setNeutralButton("好吧", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                      .show();
            }
        });

//        Toolbar toolbar = findViewById(R.id.tb);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e(TAG, "onClick: toolbar被点击了");
//            }
//        });
    }


    public void load(View view) {
        int progress = progressBar2.getProgress();
        progress += 10;
        progressBar2.setProgress(progress);
    }

    public void sendNotification(View view) {
        manager.notify(1,notification);
    }

    public void cancelNotification(View view) {
        manager.cancel(1);
    }

    public void popupClick(View view) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_view, null);
        Button btn1 = popupView.findViewById(R.id.btn_first);
        Button btn2 = popupView.findViewById(R.id.btn_second);

        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setBackgroundDrawable(getResources().
                getDrawable(R.drawable.ic_launcher_background));

        popupWindow.showAsDropDown(view,view.getWidth(), - view.getHeight());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: 第一个");
                popupWindow.dismiss();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: 第二个");
                popupWindow.dismiss();
            }
        });

    }

    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

    public void sendMessagetoThird(View view) {
        SecondActivity.actionStart(this,"haha","HAHA");
    }
}