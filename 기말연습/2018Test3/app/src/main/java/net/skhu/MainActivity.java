package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Memo> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Memo>();


        recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        Button b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e = (EditText) findViewById(R.id.editText);
                String s = e.getText().toString();
                EditText e2 = (EditText) findViewById(R.id.editText2);
                String s2 = e2.getText().toString();
                e.setText("");
                e2.setText("");
                arrayList.add(new Memo(s, s2));
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }
    //?????? ??????
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    //?????? ?????????
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_create){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("???"); //????????? ??????
            builder.setMessage("????????????????"); //?????? ??? ?????????
            builder.setPositiveButton("?????? ", new DialogInterface.OnClickListener() { //????????? ?????? ??? ?????? ????????? ?????? ?????? ??????
                @Override
                public void onClick(DialogInterface dialog, int index) {
                    Toast.makeText(MainActivity.this, "gg", Toast.LENGTH_SHORT).show();                }
            });
            builder.setNegativeButton("??????  ", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }else if (id == R.id.action_remove) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}