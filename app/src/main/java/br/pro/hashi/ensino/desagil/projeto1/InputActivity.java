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
        EditText edit = findViewById(R.id.edit);
        Button setButton = findViewById(R.id.set);
        setButton.setOnClickListener((view) -> {
            String content = edit.getText().toString();
            String word = "";
            
            word += translator.morseToChar(content);
            text.setText(word);
        });
    }



}
}
