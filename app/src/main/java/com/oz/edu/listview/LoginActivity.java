package com.oz.edu.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {
    String et_id;
    String et_pw;

    final String id="user"+new Random().nextInt(1000);
    final String pw="1214";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_id = ((EditText)findViewById(R.id.et_id)).getText().toString();
                et_pw = ((EditText)findViewById(R.id.et_pw)).getText().toString();
                if(et_id.equals(id)&& et_pw.equals(pw)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id",et_id);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplication(), "일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.btn_customlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_id = ((EditText)findViewById(R.id.et_id)).getText().toString();
                et_pw = ((EditText)findViewById(R.id.et_pw)).getText().toString();


                    Intent intent = new Intent(LoginActivity.this, CustomListActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);




            }
        });
    }
}
