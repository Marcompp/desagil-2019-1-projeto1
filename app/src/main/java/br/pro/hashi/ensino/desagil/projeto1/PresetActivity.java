package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
/*import android.widget.Toast; */


public class PresetActivity extends AppCompatActivity {
    String msgpd[]= new String[] {"Estou com fome", "Estou com sede", "Preciso ir ao banheiro", "Quero uma breja"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preset);

            ListView listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,msgpd);
            listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PresetActivity.this,InputActivity.class);
                intent.putExtra("position",msgpd[position]);
                startActivity(intent);

                /*setContentView(R.layout.activity_input);
                TextView text = findViewById(R.id.text);
                text.setText(msgpd[position]);*/

                /*Toast.makeText(PresetActivity.this, msgpd[position], Toast.LENGTH_SHORT).show();*/
            }
        });
    }
}
