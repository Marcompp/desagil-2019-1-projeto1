package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PresetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);
        Button m1 = findViewById(R.id.m1);
        Button m2 = findViewById(R.id.m2);
        Button m3 = findViewById(R.id.m3);
        Button m4 = findViewById(R.id.m4);

       /* m1.setOnClickListener(view -> {
            Intent intent = new Intent(this, InputActivity.class);
            setContentView(R.layout.activity_input);
            TextView text = findViewById(R.id.edit);
            text.setText("Pré Definida 1");


        });
        m2.setOnClickListener(view -> {
            Intent intent = new Intent(this, InputActivity.class);
            setContentView(R.layout.activity_input);
            TextView text = findViewById(R.id.edit);
            text.setText("Pré Definida 2");
    });
        m3.setOnClickListener(view -> {
            Intent intent = new Intent(this, InputActivity.class);
            setContentView(R.layout.activity_input);
            TextView text = findViewById(R.id.edit);
            text.setText("Pré Definida 3");
        });
        m4.setOnClickListener(view -> {
            Intent intent = new Intent(this, InputActivity.class);
            setContentView(R.layout.activity_input);
            TextView text = findViewById(R.id.edit);
            text.setText("Pré Definida 4");
        });

*/
    }
}
