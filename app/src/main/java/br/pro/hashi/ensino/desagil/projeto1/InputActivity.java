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
        Translator translator = new Translator();
        TextView text = findViewById(R.id.text);
        EditText edit = findViewById(R.id.edit);
        Button setButton = findViewById(R.id.set);
        setButton.setOnClickListener((view) -> {
            String content = edit.getText().toString();
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
