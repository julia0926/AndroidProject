package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Exam3Activity extends AppCompatActivity {

    RecyclerViewAdapter exam1Adapter;
    ArrayList<Memo1> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam3);

        arrayList=new ArrayList<Memo1>();
        arrayList.add(new Memo1("one",arrayList.size() + 1));
        arrayList.add(new Memo1("two",arrayList.size() + 1));


        exam1Adapter = new RecyclerViewAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(exam1Adapter);

        Button b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText)findViewById(R.id.editText);
                String s = e.getText().toString();
                e.setText("");
                arrayList.add(new Memo1(s, arrayList.size()+1));
                exam1Adapter.notifyDataSetChanged();
            }
        });
    }
}