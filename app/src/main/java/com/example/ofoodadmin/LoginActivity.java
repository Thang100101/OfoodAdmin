package com.example.ofoodadmin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

public class LoginActivity extends AppCompatActivity {

    private Button btnScan;
    private ActivityResultLauncher<ScanOptions> launcher =registerForActivityResult(new ScanContract(),
            new ActivityResultCallback<ScanIntentResult>() {
                @Override
                public void onActivityResult(ScanIntentResult result) {
                    if(result.getContents() != null){
                        // Xử lí đăng nhập
                    }else{
                        Toast.makeText(LoginActivity.this, "Mã QR không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnScan = findViewById(R.id.btn_scan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanOptions options = new ScanOptions();
                options.setBeepEnabled(true);
                options.setOrientationLocked(true);
                options.setPrompt("Quét mã đăng nhập");
                options.setCaptureActivity(CaptureA.class);
                GrantPermission.scanQRCode(launcher, options, LoginActivity.this);
            }
        });
    }
}