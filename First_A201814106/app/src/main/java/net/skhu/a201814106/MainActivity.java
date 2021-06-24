package net.skhu.a201814106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                if(id==R.id.button1){
                    Intent intent = new Intent(MainActivity.this, Exam1Activity.class);
                    startActivity(intent);
                }
                else if(id==R.id.button2){
                    Intent intent = new Intent(MainActivity.this, Exam2Activity.class);
                    startActivity(intent);
                }

            }
        };
        b1.setOnClickListener(listenerObj);
        b2.setOnClickListener(listenerObj);

    }
}