package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPreset extends AppCompatActivity {

    private EditText edit;
    private Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_preset);
        edit = findViewById(R.id.edit);
        add_button = findViewById(R.id.add);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference message = database.getReference();


        add_button.setOnClickListener(view -> {
            String msg = edit.getText().toString();
            message.push().setValue(msg);

        } );


    }

    }

