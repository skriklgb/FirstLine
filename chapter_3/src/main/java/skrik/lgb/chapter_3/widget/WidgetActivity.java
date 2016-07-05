package skrik.lgb.chapter_3.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import skrik.lgb.chapter_3.R;

public class WidgetActivity extends Activity implements View.OnClickListener {

    private Button mBt_button;
    private EditText mEt_edittext;
    private ImageView mIv_image;
    private Button mBt_button2;
    private Button mBt_button3;
    private ProgressBar mPb_pro;
    private Button mBt_button4;
    private Button mBt_button5;
    private Button mBt_button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        mBt_button = (Button) findViewById(R.id.bt_button);
        mEt_edittext = (EditText) findViewById(R.id.et_edittext);
        mIv_image = (ImageView) findViewById(R.id.iv_image);
         mBt_button2 = (Button) findViewById(R.id.bt_button2);
        mPb_pro = (ProgressBar) findViewById(R.id.pb_pro);
        mBt_button3 = (Button) findViewById(R.id.bt_button3);
        mBt_button4 = (Button) findViewById(R.id.bt_button4);
        mBt_button5 = (Button) findViewById(R.id.bt_button5);
        mBt_button6 = (Button) findViewById(R.id.bt_button6);

        mBt_button.setOnClickListener(this);
        mBt_button2.setOnClickListener(this);
        mBt_button3.setOnClickListener(this);
        mBt_button4.setOnClickListener(this);
        mBt_button5.setOnClickListener(this);
        mBt_button6.setOnClickListener(this);

        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.bt_button:
                 String inputdata = mEt_edittext.getText().toString();
                 Toast.makeText(WidgetActivity.this,inputdata,Toast.LENGTH_SHORT).show();
        
                 break;
            case R.id.bt_button2:
                mIv_image.setImageResource(R.mipmap.jelly_bean);
                break;

            case R.id.bt_button3:
                if (mPb_pro.getVisibility() == View.GONE){
                    mPb_pro.setVisibility(View.VISIBLE);
                } else {
                    mPb_pro.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_button4:
                int progress = mPb_pro.getProgress();
                progress = progress+10;
                mPb_pro.setProgress(progress);
                break;
            case R.id.bt_button5:
                AlertDialog.Builder dialog = new AlertDialog.Builder(WidgetActivity.this);
                dialog.setTitle("this is dialog");
                dialog.setMessage("it is very important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialog","点击了OK");
                    }
                });
                dialog.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialog","点击了cancle");
                    }
                });
                dialog.show();
                break;
            case R.id.bt_button6:
                ProgressDialog progressDialog = new ProgressDialog(WidgetActivity.this);
                progressDialog.setTitle("this is progressDialog");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();


            default:
                 break;
             }

    }
}
