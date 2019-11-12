package com.example.hariswedira.vo2max;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ExcellentActivity extends AppCompatActivity {

    private ArrayList<Word> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excellent);

        data.add(new Word("Wetetti","Red",R.drawable.color_red));
        data.add(new Word("Chokokki","Green",R.drawable.color_green));
        data.add(new Word("Takaaki","Brown",R.drawable.color_brown));
        data.add(new Word("Topappi","Gray",R.drawable.color_gray));
        data.add(new Word("Kululli","Black",R.drawable.color_black));
        data.add(new Word("Kelelli","White",R.drawable.color_white));
        data.add(new Word("Topiisa","Dusty yellow",R.drawable.color_dusty_yellow));
        data.add(new Word("Chiwiita","Mustrat yellow",R.drawable.color_mustard_yellow));

        recyclerView = (RecyclerView) findViewById(R.id.worklist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(ExcellentActivity.this,manager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new MyAdapter(this,data,R.color.excellent);
        recyclerView.setAdapter(adapter);
    }
}
