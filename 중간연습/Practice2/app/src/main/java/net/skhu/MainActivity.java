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

    public void quiz1(View button){
        Intent intent=new Intent(this, Exam1Activity.class);
        startActivity(intent);
    }
    public void quiz2(View button){
        Intent intent=new Intent(this,Exam2Activity.class);
        startActivity(intent);
    }
    public void quiz3(View button){
        Intent intent=new Intent(this,Exam3Activity.class);
        startActivity(intent);
    }
    public void quiz4(View button){
        Intent intent=new Intent(this,Exam4Activity.class);
        startActivity(intent);
    }
    public void quiz5(View button){
        Intent intent=new Intent(this,Exam5Activity.class);
        startActivity(intent);
    }
}