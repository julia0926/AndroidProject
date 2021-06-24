package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exam3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam3);

        Button b=findViewById(R.id.btnshift);
        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1=findViewById(R.id.editText_input);
                CharSequence s1=e1.getText();
                EditText e2=findViewById(R.id.editText_input2);
                CharSequence s2=e2.getText();
                e2.setText(s1);
                e1.setText("");
            }
        };
        b.setOnClickListener(listener);
    }
}