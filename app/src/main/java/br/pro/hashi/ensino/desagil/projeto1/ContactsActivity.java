package br.pro.hashi.ensino.desagil.projeto1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.pro.hashi.ensino.desagil.projeto1.R;

public class ContactsActivity extends AppCompatActivity {
    private ListView lvContatos;
    private ListaContatosAdapter adapter;
    private List<Contatos> mListaContatos;
    private int selIndex = 0;
    private TextView msg;
    private TextView content;
    private Button up_btn;
    private Button down_btn;
    private Button send_btn;
    private  String savedExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        msg = findViewById(R.id.msg);
        up_btn = findViewById(R.id.up);
        down_btn = findViewById(R.id.down);
        send_btn = findViewById(R.id.send);
        savedExtra = getIntent().getStringExtra("position");
        content = findViewById(R.id.content);

        lvContatos = (ListView) findViewById(R.id.listview_contatos);

        mListaContatos = new ArrayList<>();

        mListaContatos.add(new Contatos(1, "André", "11999078090"));
        mListaContatos.add(new Contatos(2, "Leonardo", "11966357075"));
        mListaContatos.add(new Contatos(3, "Pedro", "6281240350"));
        mListaContatos.add(new Contatos(4, "Marco", "11949774919"));


        adapter = new ListaContatosAdapter(getApplicationContext(), mListaContatos);
        lvContatos.setAdapter(adapter);

        /*lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Clicked Contatos id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });*/

        up_btn.setOnClickListener(view -> {
            selIndex--;
            if (selIndex < 0) {
                selIndex = 0;
            }
            msg.setText(String.valueOf(mListaContatos.get(selIndex).getNumber()));
        });

        if (savedExtra != null){
            content.setText(savedExtra);
        }

        send_btn.setOnClickListener(view -> {
            SmsManager manager = SmsManager.getDefault();
            if (savedExtra != null) {
                manager.sendTextMessage(msg.getText().toString(), null, savedExtra, null, null);
            }});

        down_btn.setOnClickListener(view -> {
            selIndex++;
            if (selIndex >= adapter.getCount()) {
                selIndex = adapter.getCount() - 1;
            }
            //msg.setText(adapter.getItem(selIndex).toString());
            //tvnumero.setText(String.valueOf(mListaContatos.get(position).getNumber()));
            msg.setText(String.valueOf(mListaContatos.get(selIndex).getNumber()));

        });
        if (selIndex >= adapter.getCount()){
            selIndex -= 1;
        }
    }



















    public class Contatos {
        private int id;
        private String name;
        private String numero;

        public Contatos(int id, String name, String numero) {
            this.id = id;
            this.name = name;
            this.numero = numero;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return numero;
        }

        public void setNumber(String numero) {
            this.numero = numero;
        }
    }

    public class ListaContatosAdapter extends BaseAdapter {
        private Context mContext;
        private List<Contatos> mListaContatos;


        public ListaContatosAdapter(Context mContext, List<Contatos> mListaContatos) {
            this.mContext = mContext;
            this.mListaContatos = mListaContatos;
        }

        @Override
        public int getCount() {
            return mListaContatos.size();
        }

        @Override
        public Object getItem(int position) {
            return mListaContatos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = View.inflate(mContext, R.layout.item_product_list, null);
            TextView tvName = (TextView) v.findViewById(R.id.tv_name);
            TextView tvnumero = (TextView) v.findViewById(R.id.tv_numero);

            tvName.setText(mListaContatos.get(position).getName());
            tvnumero.setText(String.valueOf(mListaContatos.get(position).getNumber()));

            v.setTag(mListaContatos.get(position).getId());

            return v;
        }
    }
}
