package skrik.lgb.chapter_5.practice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import skrik.lgb.chapter_5.R;

public class LoginActivity extends BaseActivity {

    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private CheckBox mRemember_pass;
    private SharedPreferences.Editor mConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mConfig = getSharedPreferences("config", MODE_PRIVATE).edit();
        SharedPreferences pre = getSharedPreferences("config", MODE_PRIVATE);

        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mRemember_pass = (CheckBox) findViewById(R.id.remember_pass);

        boolean isremember = pre.getBoolean("remember_password", false);
        if (isremember){
            mAccount.setText(pre.getString("account",""));
            mPassword.setText(pre.getString("password",""));
            mRemember_pass.setChecked(true);
        }

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mAccount.getText().toString();
                String password = mPassword.getText().toString();

                // 如果账号是admin且密码是123456，就认为登录成功
                if (account.equals("admin") && password.equals("123456")) {

                    if (mRemember_pass.isChecked()){  //// 检查复选框是否被选中
                        mConfig.putBoolean("remember_password",true);
                        mConfig.putString("account",account);
                        mConfig.putString("password",password);
                    }else {
                        mConfig.clear();
                    }
                    mConfig.commit();
                    Intent intent =new Intent(LoginActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
