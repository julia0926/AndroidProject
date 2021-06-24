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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            TextView textView1 = findViewById(R.id.textView1);
            TextView textView2 = findViewById(R.id.textView2);
            String editText1=findViewById(R.id.editText1).toString();
            String editText2=findViewById(R.id.editText2).toString();
            textView1.setText(editText1);
            textView2.setText(editText2);

        }
    }
}