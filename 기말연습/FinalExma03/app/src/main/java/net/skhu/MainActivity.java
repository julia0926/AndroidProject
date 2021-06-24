package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn1_click(View view){
        Intent intent=new Intent(this,Exam1Activity.class);
        startActivityForResult(intent, 0);
    }
    public void btn2_click(View view){
        Intent intent=new Intent(this,Exam2Activity.class);
        startActivityForResult(intent, 0);
    }
    public void btn3_click(View view){
        Intent intent=new Intent(this,Exam3Activity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            TextView textView1 = findViewById(R.id.textView1);
            TextView textView2 = findViewById(R.id.textView2);

            String text1 = intent.getStringExtra("text1");
            String text2 = intent.getStringExtra("text2");
            textView1.setText(text1);
            textView2.setText(text2);


        }
    }
}