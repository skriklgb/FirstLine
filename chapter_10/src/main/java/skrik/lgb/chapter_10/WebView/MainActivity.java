package skrik.lgb.chapter_10.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import skrik.lgb.chapter_10.R;

public class MainActivity extends AppCompatActivity {

    private WebView mWeb_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeb_view = (WebView) findViewById(R.id.web_view);
        mWeb_view.getSettings().setJavaScriptEnabled(true);
        mWeb_view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);// 根据传入的参数再去加载新的网页
                return true; // 表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器

            }
        });
        mWeb_view.loadUrl("http://www.baidu.com");
    }
}
