package br.pro.hashi.ensino.desagil.projeto1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
        String nome[] = new String[] {"André", "Marco", "Pedro", "Leonardo"};
        String num[] = new String[] {"11999078090","11949774919","6281240350","11966357075"};
        ListView list;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            list= findViewById(R.id.listView);

            MyAdapter adapter = new MyAdapter(this, nome, num);
            list.setAdapter(adapter);

            /*list.setOnClickListener(new AdapterView.OnClickListener(){
                @Override
                public void onItemClick()

            });*/
        }

        class MyAdapter extends ArrayAdapter<String>{
            Context context;
            String nomes[];
            String numeros[];

            MyAdapter(Context c, String[] nome, String[] num){
                super(c,R.layout.row,R.id.contato, nome);
                this.context=c;
                this.nomes=nome;
                this.numeros=num;
            }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView nomes = row.findViewById(R.id.contato);
            TextView numeros = row.findViewById(R.id.numero);
            nomes.setText(nome[position]);
            numeros.setText(num[position]);
            return row;
        }

        }

}
