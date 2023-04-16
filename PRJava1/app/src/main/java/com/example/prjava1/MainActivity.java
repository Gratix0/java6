package com.example.prjava1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText logininp, passinp;
    private Button singInButton;

    private String valid_pass = "!@#$%^&*?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singInButton = findViewById(R.id.SignInButton);
        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("name", logininp.getText().toString());
                startActivity(intent);
            }

            public boolean isEmailValid(String email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(logininp.getText()).matches();
            }
        });
        logininp = findViewById(R.id.login);
        logininp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logininp.getText().length() == 0) {
                    logininp.setError("Пусто тута");
                }
                if (logininp.getText().charAt(-7) != "@".charAt(1)){
                    logininp.setError("Забыл собаку");
                }
            }
        });
        passinp = findViewById(R.id.password);
        passinp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passinp.getText().length() < 6) {
                    passinp.setError("Введите больше 6 символов");
                }
                for (int i = 0; i < passinp.length(); i++) {
                    if (passinp.getText().charAt(i) != valid_pass.charAt(i)) {
                        passinp.setError("Пароль должен содержать спецсимволы");
                        }
                    if (passinp.getText().charAt(i) != passinp.getText().charAt(i))//.ToUpperCase
                    {
                        passinp.setError("Нет символов в ерхнем регистре");
                    }
                    ;
                }
            }
        })
    ;}
}