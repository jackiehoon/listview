package com.oz.edu.listview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText edt;
    Button btn;
    String id="";
    static ArrayList<String> chatData = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);

        listView = (ListView)findViewById(R.id.listView);

        Intent intent = getIntent();


        chatData.add(intent.getStringExtra("id"));

        final ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(), R.layout.simplist, chatData);

        listView.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatData.add(edt.getText().toString());
                adapter.notifyDataSetChanged();
                edt.setText("");
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("삭제");
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        chatData.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("취소",null);

                builder.show();

                return false;
            }
        });



    }
}
