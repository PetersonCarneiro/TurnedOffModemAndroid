package com.turnedoffmodem;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnTurnOff;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnTurnOff = findViewById(R.id.btnTurnOff);

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

    }


    public void login(View view) throws IOException {
        String name = "userAdmin";
        String password = "3f68SPTDKp";

        // Carrega a página de login do modem
        webView.loadUrl("http://192.168.1.254/");

        webView.evaluateJavascript(
                "document.getElementById('WanIp') !== null",
                value -> {
                    if ("true".equals(value)) {
                        Toast.makeText(MainActivity.this, "Login OK!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Login FALHOU!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }



}