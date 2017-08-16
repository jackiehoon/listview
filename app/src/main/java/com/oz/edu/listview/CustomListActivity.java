package com.oz.edu.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomListActivity extends AppCompatActivity {
    private ArrayList<ChatVO> chatList=new ArrayList<>();
    EditText et;
    Button btn;
    String msg="";
    ChatAdapter adapter;
    String id="";

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference ref = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        id=getIntent().getStringExtra("id");

        ChatVO chat1 = new ChatVO(R.drawable.one, "김창식", "날도,,,,,더운데,,,, 수고~많으십니다~~~","07:08");
        ChatVO chat2 = new ChatVO(R.drawable.four, "박동석", "아이고ㅓ.......조만간에 찾아뵙겠씁니다 형님","07:11");
        ChatVO chat3 = new ChatVO(R.drawable.two, "이영수", "좋은 하루덜,,,,보내십시오,,,,,,,","07:11");
        ChatVO chat4 = new ChatVO(R.drawable.one, "김창식", "^^~~~","07:12");
        chatList.add(chat1);
        chatList.add(chat2);
        chatList.add(chat3);
        chatList.add(chat4);

        adapter = new ChatAdapter(getApplicationContext(), R.layout.customlist, chatList,id);


        ListView lv = (ListView) findViewById(R.id.customListView);
        lv.setAdapter(adapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long time = System.currentTimeMillis();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                String nowTime = format.format(new Date(time));

                msg  = ((EditText)findViewById(R.id.editText)).getText().toString();

                ChatVO chat = new ChatVO(R.drawable.three, id, msg,nowTime);

                ref.child("message").push().setValue(chat);

                ((EditText)findViewById(R.id.editText)).setText("");


            }
        });

        ref.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                ChatVO chatVO = dataSnapshot.getValue(ChatVO.class);
                chatList.add(chatVO);
                adapter.notifyDataSetChanged();



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}
