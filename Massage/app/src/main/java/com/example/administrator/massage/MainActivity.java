package com.example.administrator.massage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();
    private List<Msg> msgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        final RecyclerView recyclerView = findViewById(R.id.msg_recycler_view);
        Button sentBtn = findViewById(R.id.send);
        final EditText input = findViewById(R.id.input);
        final MsgAdapter adapter = new MsgAdapter(msgs);
        sentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgs.add(msg);
                    adapter.notifyItemInserted(msgs.size()-1);
                    recyclerView.scrollToPosition(msgs.size()-1);
                    input.setText("");
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//        FruitAdapter fruitAdapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);

    }
    private void initFruits(){
        for(int i=0;i<5;i++){
            Fruit banana = new Fruit("banana",R.drawable.banana);
            fruits.add(banana);
            Fruit s = new Fruit("strawberry",R.drawable.strewberry);
            fruits.add(s);
            Fruit r = new Fruit("raisin",R.drawable.raisin);
            fruits.add(r);
            Fruit w = new Fruit("watermelon",R.drawable.watermelon);
            fruits.add(w);
            Fruit o = new Fruit("orange",R.drawable.orange);
            fruits.add(o);
        }
    }
    private void initMsgs(){
        Msg msg1 = new Msg("HEY GUYS",Msg.TYPE_REC);
        Msg msg2 = new Msg("HEY GUYS",Msg.TYPE_SENT);
        Msg msg3 = new Msg("HEY GUYS",Msg.TYPE_REC);
        msgs.add(msg1);
        msgs.add(msg2);
        msgs.add(msg3);
    }
}
