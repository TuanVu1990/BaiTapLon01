package tutorial.freelancertraning.tuanvu.baitaplon01.LoginActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tutorial.freelancertraning.tuanvu.baitaplon01.Menuactivity.MenuActivity;
import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername;

    EditText edtPassword;

    Button btnLogin;

    TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "User name or password is empty",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void initView() {
        edtUsername= (EditText)findViewById(R.id.edt_username);
        edtPassword = (EditText)findViewById(R.id.edt_password);
        btnLogin = (Button)findViewById(R.id.btn_login);
        tvForgotPassword = (TextView)findViewById(R.id.tv_forgot_password);
    }
}
