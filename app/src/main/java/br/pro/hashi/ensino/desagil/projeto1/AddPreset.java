package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;

public class AddPreset extends AppCompatActivity{




    private String oldMorse;
    private FirebaseDatabase database;
    private DatabaseReference message;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_preset);


        Button btnMorse = findViewById(R.id.btnMorse);
        TextView morseView = findViewById(R.id.morseView);
        add = findViewById(R.id.add);

        database = FirebaseDatabase.getInstance();
        message = database.getReference();


        btnMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                morseView.append(".");
            }
        });

        btnMorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                morseView.append("-");
                return true;
            }
        });


        Translator translator = new Translator();
        TextView text = findViewById(R.id.text);
        String savedExtra = getIntent().getStringExtra("position");
        if (savedExtra != null)
            text.setText(savedExtra);
        Button setButton = findViewById(R.id.set);
        Button spaceButton = findViewById(R.id.space);
        Button wordButton = findViewById(R.id.word);
        Button deleteButton = findViewById(R.id.delete);

        deleteButton.setOnLongClickListener((view) -> {
            morseView.setText("");
            return  true;
        });
        deleteButton.setOnClickListener((view) -> {
            String content = morseView.getText().toString();
            content = content.substring(0,content.length()-1);
            morseView.setText(content);

        });


        spaceButton.setOnClickListener((view) -> {
            String content = morseView.getText().toString();
            content += " ";
            morseView.setText(content);
        });

        wordButton.setOnClickListener((view) ->{
            String content =  morseView.getText().toString();
            content += "/";
            morseView.setText(content);
        } );

        add.setOnClickListener(view -> {
            message.push().setValue(text.getText());
        });

        setButton.setOnClickListener((view) -> {
            String content = morseView.getText().toString();
            String word = "";
            String [] split_slash = content.split("/");
            boolean space = false;
            boolean slash = false;
            for (int i =0;i < content.length();i++){
                if (content.charAt(i) == ' ') {
                    space = true;
                }
                if (content.charAt(i)== '/'){
                    slash = true;
                }
            }
            if (slash) {
                for (String s: split_slash){
                    if (space){
                        String [] space_slash =  s.split(" ");
                        for (String a: space_slash){
                            word += translator.morseToChar(a);
                        }
                    } else { word+= translator.morseToChar(s);}
                    word += " ";
                }


            }
            else if (space){String [] space_slash =  content.split(" ");
                for (String a: space_slash){
                    word += translator.morseToChar(a);
                }

            }
            else {word+= translator.morseToChar(content);}




            text.setText(word);
        });
    }



}
