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

public class Exam2Activity extends AppCompatActivity {

    Exam2Adapter recyclerViewAdapter;
    ArrayList<Memo> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        arrayList=new ArrayList<Memo>();
        arrayList.add(new Memo("one",arrayList.size()+1));
        arrayList.add(new Memo("two",arrayList.size()+1));

        recyclerViewAdapter = new Exam2Adapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        Button b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText)findViewById(R.id.editText);
                String s1 = e1.getText().toString();
                e1.setText("");
                arrayList.add(new Memo(s1,arrayList.size()+1));
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }
}