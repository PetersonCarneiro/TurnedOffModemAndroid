package com.turnedoffmodem;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button btnReboot;
    String loginUrl = "http://192.168.1.254/";
    String rebootUrl = "http://192.168.1.254/reboot.cgi";
    boolean isLogged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btnReboot = findViewById(R.id.btnTurnOff);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                if (url.equals(loginUrl) && !isLogged) {
                    // Faz login
                    webView.evaluateJavascript(
                            "document.getElementById('username').value = 'userAdmin';" +
                                    "document.getElementById('password').value = '3f68SPTDKp';" +
                                    "document.getElementById('loginBT').click();", null
                    );

                    isLogged = true;

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    webView.loadUrl(rebootUrl);
                } else if (url.equals(rebootUrl)) {
                    // Clica no botão de reboot
                    webView.evaluateJavascript(
                            "document.getElementById('do_reboot').click();", null
                    );
                } else {
                    Toast.makeText(getApplicationContext(),"Entered the reboot url",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReboot.setOnClickListener(v -> {
            isLogged = false;
            webView.loadUrl(loginUrl);// Inicia processo
        });
    }
}
