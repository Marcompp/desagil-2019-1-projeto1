package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PresetActivity extends AppCompatActivity {
    String msgpd[]= new String[] {"Estou com fome", "Estou com sede", "Preciso ir ao banheiro", "Quero uma breja"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,android.R.layout.simple_expandable_list_item_1,msgpd);
        listView.setAdapter(adapter);

    }
}