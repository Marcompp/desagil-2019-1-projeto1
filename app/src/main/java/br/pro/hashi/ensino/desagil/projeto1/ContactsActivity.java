package br.pro.hashi.ensino.desagil.projeto1;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.pro.hashi.ensino.desagil.projeto1.R;

public class ContactsActivity extends AppCompatActivity {
    String nome[]= new String[] {"André"};
    String numero[] = new String[] {"11999078090"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,nome);
        ArrayAdapter<String> adpter2 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_2,numero);
        listView.setAdapter(adapter);
        listView.setAdapter(adpter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContactsActivity.this,InputActivity.class);
                intent.putExtra("position",numero[position]);
                startActivity(intent);
            }
        });
    }
}