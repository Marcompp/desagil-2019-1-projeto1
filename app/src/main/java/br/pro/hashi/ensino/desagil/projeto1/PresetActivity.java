package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PresetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);
        Button m1 = findViewById(R.id.m1);
        Button m2 = findViewById(R.id.m2);
        Button m3 = findViewById(R.id.m3);
        Button m4 = findViewById(R.id.m4);
    }

}
