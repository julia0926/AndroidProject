package net.skhu.a201814106;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        Button button1=findViewById(R.id.button_one);
        Button button2=findViewById(R.id.button_two);
        Button button3=findViewById(R.id.button_three);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=findViewById(R.id.textView);
                String s=button1.getText().toString();
                t.setText(s);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=findViewById(R.id.textView);
                String s=button2.getText().toString();
                t.setText(s);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=findViewById(R.id.textView);
                String s=button3.getText().toString();
                t.setText(s);
            }
        });
    }
}