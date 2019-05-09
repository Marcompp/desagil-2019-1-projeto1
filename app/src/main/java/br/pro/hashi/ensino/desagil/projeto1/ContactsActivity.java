package br.pro.hashi.ensino.desagil.projeto1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
        String nome[] = new String[] {"André", "Marco", "Pedro", "Leonardo"};
        String num[] = new String[] {"11999078090","11","",""}

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preset);

            ListView listView = findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,msgpd);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(PresetActivity.this,InputActivity.class);
                    intent.putExtra("position",msgpd[position]);
                    startActivity(intent);
                }
            });
        }
    }
}