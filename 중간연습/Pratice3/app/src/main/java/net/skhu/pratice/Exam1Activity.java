package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {
    public boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        Button b = (Button)findViewById(R.id.button3);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText)findViewById(R.id.editText);
                EditText e2 = (EditText)findViewById(R.id.editText2);
                CharSequence s = e.getText();
                CharSequence s2 = e2.getText();

                TextView t = (TextView)findViewById(R.id.textView);
                if(flag){
                    flag=false;
                    t.setText(s);
                }
                else{
                    t.setText(s2);
                    flag=true;
                }
            }
        };
        b.setOnClickListener(listenerObj);

    }
}