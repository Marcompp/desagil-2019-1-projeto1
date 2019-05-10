package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;

public class DictionaryActivity extends AppCompatActivity {

    private ListView dict;

    private LinkedList<String> Mtl;
    private LinkedList<String> Ltm;

    private LinkedList<String> Letras;
    private Button buttonLtoM;
    private Button buttonMtoL;


    private Translator translator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dict = findViewById(R.id.listView);
        translator = new Translator();

        Mtl = new LinkedList<>();
        Ltm = new LinkedList<>();


        Letras = new LinkedList<>();
        Letras = translator.getCodes();
        buttonLtoM = findViewById(R.id.ltoMButton);
        buttonMtoL = findViewById(R.id.mToLButton);



        for (String string:Letras) {

            char alpha;

            alpha = translator.morseToChar(string);
            if (alpha != ' ') {
                Mtl.add(string + " ==> " + alpha);
                Ltm.add(alpha + " ==> " + string);
            }

        }


        Collections.sort(Ltm);

        ArrayAdapter<String> mtladapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,Mtl);
        ArrayAdapter<String> ltmadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,Ltm);



        buttonMtoL.setOnClickListener(view -> {


            dict.setAdapter(mtladapter);
        });


        buttonLtoM.setOnClickListener(view -> {
            dict.setAdapter(ltmadapter);
        });

        dict.setAdapter(ltmadapter);







    }

}
