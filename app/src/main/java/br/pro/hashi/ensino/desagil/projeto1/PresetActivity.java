package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class PresetActivity extends AppCompatActivity {

    private  DatabaseReference database;
    private int selIndex = 0;
    private TextView msg;
    private Button add_btn;
    private Button up_btn;
    private Button down_btn;
    private Button send_btn;
    private  ListView listView;

    private  ArrayList<String> arrayList = new ArrayList<>();
    private  ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);

        database = FirebaseDatabase.getInstance().getReference();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        msg = findViewById(R.id.msg);
        add_btn = findViewById(R.id.add);
        up_btn = findViewById(R.id.up);
        down_btn = findViewById(R.id.down);
        send_btn = findViewById(R.id.send);
        listView = findViewById(R.id.listView);

        listView.setAdapter(adapter);

        add_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddPresetActivity.class);
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

        send_btn.setOnClickListener(view -> {
            Intent intent = new Intent(PresetActivity.this, InputActivity.class);
            intent.putExtra("position",arrayList.get(selIndex));
            startActivity(intent);
        });

        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String content = dataSnapshot.getValue(String.class);

                arrayList.add(content);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}