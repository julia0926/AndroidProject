package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void todo_clicked(View view){
        Intent intent = new Intent(this, TodoActivity.class);
        startActivity(intent);
    }
    public void memo_clicked(View view){
        Intent intent = new Intent(this, MemoResultActivity.class);
        startActivity(intent);
    }
}