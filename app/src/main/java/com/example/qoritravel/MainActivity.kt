package com.example.qoritravel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private lateinit var miVisorWeb: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        miVisorWeb = findViewById(R.id.visorWeb)
        miVisorWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
                    view?.loadUrl(url)
                    return true
                } else {
                    return super.shouldOverrideUrlLoading(view, url)
                }
            }
        }
        val ajustesVisorWeb: WebSettings = miVisorWeb.settings
        ajustesVisorWeb.javaScriptEnabled = true
        ajustesVisorWeb.javaScriptEnabled = true
        miVisorWeb.loadUrl("https://travelqori.com/")
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val miVisorWeb: WebView = findViewById(R.id.visorWeb)
        if (event?.action == KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (miVisorWeb.canGoBack()) {
                        miVisorWeb.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}