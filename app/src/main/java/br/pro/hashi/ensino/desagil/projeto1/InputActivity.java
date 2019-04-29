package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class InputActivity extends AppCompatActivity{

    Button btnMorse;
    TextView morseView;
    EditText editText;


    private String oldMorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        btnMorse = (Button)findViewById(R.id.btnMorse);
        morseView = (TextView)findViewById(R.id.morseView);


        //final EditText editText = (EditText)findViewById(R.id.editText);


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
