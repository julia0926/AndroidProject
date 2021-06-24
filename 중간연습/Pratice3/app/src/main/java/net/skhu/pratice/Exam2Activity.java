package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        Button button1=(Button)findViewById(R.id.increase);
        Button button2=(Button)findViewById(R.id.decrease);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText e = (EditText)findViewById(R.id.editText_value);
                String s = e.getText().toString();
                int num=Integer.parseInt(s);
                num++;
                e.setText(String.valueOf((num)));
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText e = (EditText)findViewById(R.id.editText_value);
                String s = e.getText().toString();
                int num2=Integer.parseInt(s);
                num2--;
                e.setText(String.valueOf((num2)));
            }
        });


    }
}