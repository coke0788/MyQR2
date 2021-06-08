package com.example.myqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        new IntentIntegrator(this).initiateScan(); //QR Scan라이브러리
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) { //결과가 null이 아닌 경우만
            if(result.getContents() == null) { //콘텐츠가 널이면 취소
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else { //콘텐츠가 널이 아닌 경우 읽어오기. (토스트 팝업을 띄운다.)
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}