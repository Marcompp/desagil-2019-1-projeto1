package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class InputActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        TextView text = findViewById(R.id.text);
        EditText edit = findViewById(R.id.edit);
        Button setButton = findViewById(R.id.set);
        setButton.setOnClickListener((view) -> {
            String content = edit.getText().toString();
            text.setText(content);
        });
    }
}
