package skrik.lgb.chapter_10.HTTP;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParserFactory;

import skrik.lgb.chapter_10.R;
import skrik.lgb.chapter_10.xml.ContentHandler;

public class HttpActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int SHOW_RESPONSE = 0;
    private Button mSend_request;
    private TextView mResponse;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                 case SHOW_RESPONSE:
                     String response = (String) msg.obj;
//                     parseXMLWithPull(response);
//                     parseXMLWithSAX(response );
                     parseJSONWithJSONObject(response);
                     // 在这里进行UI操作，将结果显示到界面上
                     mResponse.setText(response);
                     break;
                 default:
                     break;
                 }
        }
    };

    private void parseJSONWithJSONObject(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i =0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("JSON解析","id is"+id);
                Log.d("JSON解析","name is"+name);
                Log.d("JSON解析","version is"+version);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            // 将ContentHandler的实例设置到XMLReader中
            xmlReader.setContentHandler(handler);
            // 开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithPull(String response) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(response));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    // 开始解析某个结点
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }// 完成解析某个结点
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.d("MainActivity", "id is " + id);
                            Log.d("MainActivity", "name is " + name);
                            Log.d("MainActivity", "version is " + version);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        mSend_request = (Button) findViewById(R.id.send_request);
        mResponse = (TextView) findViewById(R.id.response);
        mSend_request.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request){
            sendRequestWithHttpURLConnection();
//            sendRequestWithHttpClient();
        }
    }

//    private void sendRequestWithHttpClient() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    HttpClient httpClient = new DefaultHttpClient();
//                    HttpGet httpGet = new HttpGet("http://www.baidu.com");
//                    HttpResponse httpResponse = httpClient.execute(httpGet);
//                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                        // 请求和响应都成功了
//                        HttpEntity entity = httpResponse.getEntity();
//                        String response = EntityUtils.toString(entity,
//                                "utf-8");
//                        Message message = new Message();
//                        message.what = SHOW_RESPONSE;
//                        // 将服务器返回的结果存放到Message中
//                        message.obj = response.toString();
//                        handler.sendMessage(message);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL("http://192.168.1.200/get_data.json");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    InputStream in = connection.getInputStream();
                    // 下面对获取到的输入流进行读取
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }


                    Message message = new Message();
                    message.what = SHOW_RESPONSE;
                    // 将服务器返回的结果存放到Message中
                    message.obj = response.toString();
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }
}
