package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMSInputActivity extends AppCompatActivity {



    private String oldMorse;

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);


        Button btnMorse = findViewById(R.id.btnMorse);
        TextView morseView = findViewById(R.id.morseView);


        EditText textMessage = findViewById(R.id.text_message);
        Button buttonSend = findViewById(R.id.btnSend);


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
        //Button wordButton = findViewById(R.id.word);*/
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

        spaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = morseView.getText().toString();
                content += " ";
                morseView.setText(content);
            }
        });
        /*spaceButton.setOnLongClickListener((view) -> {
            String content = morseView.getText().toString();
            content += " ";
            morseView.setText(content);
        });*/

        spaceButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String content =  morseView.getText().toString();
                content += "/";
                morseView.setText(content);
                return true;
            }
        });
        /*spaceButton.setOnClickListener((view) ->{
            String content =  morseView.getText().toString();
            content += "/";
            morseView.setText(content);
        } );*/


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


        buttonSend.setOnClickListener((view) -> {
            String message = textMessage.getText().toString();

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            String phone = text.getText().toString();

            // Esta verificação do número de telefone é bem
            // rígida, pois exige até mesmo o código do país.
            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            }

            // Enviar uma mensagem de SMS. Por simplicidade,
            // não estou verificando se foi mesmo enviada,
            // mas é possível fazer uma versão que verifica.
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            // Limpar o campo para nenhum engraçadinho
            // ficar apertando o botão várias vezes.
            text.setText("");
        });
    }



}
