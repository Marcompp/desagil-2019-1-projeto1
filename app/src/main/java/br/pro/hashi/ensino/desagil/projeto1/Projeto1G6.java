package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Projeto1G6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeto1g6);
        Button input= findViewById(R.id.input);
        Button dict = findViewById(R.id.dict);
        Button atalho = findViewById(R.id.atalho);
        Button message = findViewById(R.id.msg);

        input.setOnClickListener(view -> openInput());
        dict.setOnClickListener(view -> openDict());
        atalho.setOnClickListener(view -> openAtalho());
        message.setOnClickListener(view -> openMessage());
}

    private void openMessage() {
        Intent intent = new Intent(this, SMSActivity.class);
        startActivity(intent);
    }

    private void openInput() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }
    private void openDict() {
        Intent intent = new Intent(this, DictionaryActivity.class);
        startActivity(intent);
    }
    private void openAtalho() {
        Intent intent = new Intent(this, PresetActivity.class);
        startActivity(intent);
    }
}
