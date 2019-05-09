package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {


    String msgpd[]= new String[] {"11966357075", "11999078090", "6281240350", "11949774919"};
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
        setContentView(R.layout.activity_contact);
        msg = findViewById(R.id.msg);
        up_btn = findViewById(R.id.up);
        down_btn = findViewById(R.id.down);
        send_btn = findViewById(R.id.send);
        savedExtra = getIntent().getStringExtra("position");
        content = findViewById(R.id.content);


        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,msgpd);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ContactActivity.this,InputActivity.class);
            intent.putExtra("position",msgpd[position]);
            startActivity(intent);
        });


        up_btn.setOnClickListener(view -> {
            selIndex--;
            if (selIndex < 0) {
                selIndex = 0;
            }
            msg.setText(listView.getItemAtPosition(selIndex).toString());
        });


        down_btn.setOnClickListener(view -> {
            selIndex++;
            if (selIndex >= listView.getCount()) {
                selIndex = listView.getCount() - 1;
            }
            msg.setText(listView.getItemAtPosition(selIndex).toString());
        });
        if (savedExtra != null){
            content.setText(savedExtra);
        }

        send_btn.setOnClickListener(view -> {
            SmsManager manager = SmsManager.getDefault();
            if (savedExtra != null) {
                manager.sendTextMessage(msg.getText().toString(), null, savedExtra, null, null);
            }});


    }
}