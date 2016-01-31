package com.example.yash.shop_stop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Yash on 1/23/2016.
 */
public class webview extends AppCompatActivity {

    WebView webview;
    String category,item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        Intent i=getIntent();
        category=i.getStringExtra("Category");
       // category="products";
        item=i.getStringExtra("Item");
      //  item="books";

        Log.e("WebView","category : "+category);
        Log.e("Webview","item : "+item);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebView myWebView1 = (WebView) findViewById(R.id.webview1);

        myWebView.loadUrl("http://www.amazon.in/gp/aw/s/ref=is_s_?ie=UTF8&rh=i%3Aaps&search-alias=aps&k="+item);
        myWebView1.loadUrl("http://m.snapdeal.com/search?keyword="+item+"&categoryId=0&categoryXPath=ALL");


        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        myWebView1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });


    }



}
