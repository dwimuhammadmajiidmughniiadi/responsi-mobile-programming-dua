package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Mahasiswa> ArrMhs;
    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Register;
    private int counter = 5;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText) findViewById(R.id.IdUsername);
        Password = (EditText) findViewById(R.id.IdPasswd);
        Info = (TextView) findViewById(R.id.IdInfo);
        Register = (Button) findViewById(R.id.idRegister);
        Login = (Button) findViewById(R.id.idLogin);

        Intent intent =getIntent();
        ArrMhs = intent.getParcelableArrayListExtra("myData");

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        private void validate(String Username, String Password) {
            for (int idx = 0; idx < ArrMhs.size();idx++){
                String UserPassword = ArrMhs.get(idx).getPassword();
                String UserName = ArrMhs.get(idx).getUsername();
                if (Username.equals(UserName) && Password.equals(UserPassword)) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    counter--;
                    Info.setText("Toleransi Jumlah Kesalahan :" + String.valueOf(counter));

                    if (counter == 0) {
                        Login.setEnabled(false);

                    }
                }
            }
        }
        
        if(v.getId() == R.id.idLogin){
            validate(Username.getText().toString(), Password.getText().toString());
        }

        if (v.getId() == R.id.idRegister){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }

    private void validate(String toString, String toString1) {
    }

}

