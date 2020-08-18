package com.example.applicationjumpactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mHuya;
    private Button mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }
    private void initView(){
        mHuya = findViewById(R.id.JumpToHuya);
        mUrl = findViewById(R.id.JumpTpUrl);
    }
    private void initEvent(){
        mHuya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PackageUtils.isAppInstalled(getApplicationContext(),PackageUtils.TAO_BAO)){
                    Intent intent = new Intent();
                    intent.setAction("Android.intent.action.VIEW");
                    intent.setClassName(PackageUtils.HU_YA_ZHI_BO,"com.duowan.kiwi");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"请先安装斗鱼客户端",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
//                Intent action = new Intent(Intent.ACTION_VIEW);
//                action.setData(Uri.parse("https://www.douyu.com/1237105"));
//                startActivity(action);
            }


        });
    }
}