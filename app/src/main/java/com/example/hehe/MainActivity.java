package com.example.hehe;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kết nối WebView từ giao diện
        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        // Bật JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Tải nội dung HTML từ thư mục assets
        webView.loadUrl("file:///android_asset/index.html");
    }
    // Lớp để giao tiếp giữa Java và JavaScript
    public class WebAppInterface {
        @JavascriptInterface
        public void showToast(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
