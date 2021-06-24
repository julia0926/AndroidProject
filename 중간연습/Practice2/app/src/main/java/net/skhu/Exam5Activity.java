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

public class Exam5Activity extends AppCompatActivity {

    RecyclerView2Adapter recyclerViewAdapter;
    ArrayList<Info> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam5);

        arrayList=new ArrayList<Info>();
        arrayList.add(new Info(201814106,"julia"));
        arrayList.add(new Info(201814107,"minu"));

        recyclerViewAdapter = new RecyclerView2Adapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        Button b = (Button)findViewById(R.id.btnSave);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText)findViewById(R.id.editText1);
                EditText e2 = (EditText)findViewById(R.id.editText2);
                int s1 = Integer.parseInt(String.valueOf(e1.getText()));
                String s2 = e2.getText().toString();
                e1.setText("");
                e2.setText("");
                arrayList.add(new Info(s1,s2));
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

}