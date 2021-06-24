package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);
    }
    public void action_change(View button){
        EditText e=findViewById(R.id.editText);
        TextView t=findViewById(R.id.textView1);
        String s1=e.getText().toString();
        String s2=t.getText().toString();
        t.setText(s1);
        e.setText(s2);

    }
}