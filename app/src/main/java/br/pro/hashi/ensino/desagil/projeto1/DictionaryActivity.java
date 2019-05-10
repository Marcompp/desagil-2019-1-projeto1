package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DictionaryActivity extends AppCompatActivity {

    private ListView dict;

    LinkedList<String> Mtl = new LinkedList<String>();
    LinkedList<String> Ltm = new LinkedList<String>();
    char Alfabeto[] = {'a','b','c','d','e','f','g','h','i',
            'j','k','l','m','n','o','p','q','r','s','t','j',
            'v','w','x','y','z','0','1','2','3','4','5','6',
            '7','8','9','/','+','='};
    LinkedList<String> Letras = new LinkedList<String>();
    LinkedList<String> Letra1 = new LinkedList<String>();
    LinkedList<String> Letra2 = new LinkedList<String>();
    LinkedList<String> Letra3 = new LinkedList<String>();
    LinkedList<String> Letra4 = new LinkedList<String>();
    LinkedList<String> Letra5 = new LinkedList<String>();


    private boolean ismtv;

    private Translator translator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dict = findViewById(R.id.listView);
        translator = new Translator();

        Letra1.add(".");
        Letra1.add("/");
        Letras.add(".");
        Letras.add("/");
        for (String letra:Letra1) {
            Letra2.add(letra+".");
            Letra2.add(letra+"-");
            Letras.add(letra+".");
            Letras.add(letra+"-");
        }
        for (String letra:Letra2) {
            Letra3.add(letra+".");
            Letra3.add(letra+"-");
            Letras.add(letra+".");
            Letras.add(letra+"-");
        }
        for (String letra:Letra3) {
            Letra4.add(letra+".");
            Letra4.add(letra+"-");
            Letras.add(letra+".");
            Letras.add(letra+"-");
        }
        for (String letra:Letra4) {
            Letra5.add(letra+".");
            Letra5.add(letra+"-");
            Letras.add(letra+".");
            Letras.add(letra+"-");
        }

        //for (char alpha:Alfabeto) {
        //     String string = translator.charToMorse(alpha);
        //     Ltm.add(alpha+" => "+string);

        //}

        for (String string:Letras) {
            char alpha = translator.morseToChar(string);
            if (alpha != ' ') {
                Mtl.add(string+" => "+alpha);
                Ltm.add(alpha+" => "+string);
            }
        }

        Arrays.sort(Ltm);



        ArrayAdapter<String> mtlAdapter = new ArrayAdapter<String>(this, R.layout.activity_dictionary, R.id.textView, Mtl);
        ArrayAdapter<String> ltmAdapter = new ArrayAdapter<String>(this, R.layout.activity_dictionary, R.id.textView, Ltm);
        if (ismtv) {
            dict.setAdapter(mtlAdapter);
        } else {
            dict.setAdapter(mtlAdapter);
        }





    }

}
