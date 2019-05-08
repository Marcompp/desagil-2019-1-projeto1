package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class InputActivity extends AppCompatActivity{

    //Definindo componentes da página
    private Button morseButton;
    private TextView morseView;
    private TextView text;
    private  Button spaceButton;
    private Button deleteButton;
    private Button sendButton;

    //Criando um objeto da classe Translator para traduzir o texto em Morse
    private Translator translator;

    private String savedExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        //Iniciando componentes
        morseButton = findViewById(R.id.btnMorse);
        morseView = findViewById(R.id.morseView);
        text = findViewById(R.id.text);
        spaceButton = findViewById(R.id.space);
        deleteButton = findViewById(R.id.delete);
        sendButton = findViewById(R.id.button_send);

        translator = new Translator();

        //String que pega o texto da mensagens rápidas e adiciona em Text
        savedExtra = getIntent().getStringExtra("position");

        //Função que quando o botão morseButton é clickado, adiciona um . em morseView
        morseButton.setOnClickListener(view ->{
                morseView.append(".");
                translate();});


        //Função que quando o botão morseButton é clickado por um longo período de tempo, adiciona um - em morseView
        morseButton.setOnLongClickListener(view -> {
            morseView.append("-");
            translate();
            return true;
        });

        //Função que deleta todo o conteúdo de morseView se o deleteButton for clickado por um longo período
        deleteButton.setOnLongClickListener((view) -> {
            morseView.setText("");
            return  true;
        });

        //deleta apenas o ultimo Char de morseView
        deleteButton.setOnClickListener((view) -> {
            if (morseView.getText().toString().length() != 0){
            String content = morseView.getText().toString();
            content = content.substring(0,content.length()-1);
            morseView.setText(content);}
        });

        //Se clickado, pula um espaço
        spaceButton.setOnClickListener(view -> {
            String content = morseView.getText().toString();
            content += " ";
            morseView.setText(content);
        });

        //Se clickado por um longo período, adiciona uma barra, que significa inicio de uma nova palavra em Morse
        spaceButton.setOnLongClickListener(v -> {
            String content =  morseView.getText().toString();
            content += "/";
            morseView.setText(content);
            return true;
        });

        sendButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, PermissionActivity.class);
            startActivity(intent);
        });

        if (savedExtra != null)
            text.setText(savedExtra);

    }

    private void translate() {

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
    }
}
