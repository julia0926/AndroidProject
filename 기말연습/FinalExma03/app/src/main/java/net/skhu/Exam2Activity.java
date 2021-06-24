package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);
    }
    public void btn_save(View view){
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        String text1 = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String text2 = editText2.getText().toString();

        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("text1", text1);
        intent.putExtra("text2", text2);
        setResult(RESULT_OK, intent);
        finish();


    }
    public void btn_cancel(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}