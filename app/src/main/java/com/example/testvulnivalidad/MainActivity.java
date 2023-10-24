package com.example.testvulnivalidad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.webView);
        WebSettings webSettings = view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        view.addJavascriptInterface(new JavaScriptInterface(), "appInterface");
    }

    public void loadURL(View v){
        EditText urlText = findViewById(R.id.editText);
        String url = urlText.getText().toString();
        if (url.isEmpty()){
            Toast.makeText(this, "Ingrese una URL valida", Toast.LENGTH_SHORT).show();
        }
        else {
            view.loadUrl(url);
        }
    }

    private class JavaScriptInterface{
        @android.webkit.JavascriptInterface
        public void showToast(String message){

        }
    }
}