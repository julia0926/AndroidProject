package net.skhu.a201814106;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        Switch switch1 = (Switch) findViewById(R.id.switch1);

        CompoundButton.OnCheckedChangeListener listener1 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView t2 = findViewById(R.id.textView2);
                String on=switch1.getTextOn().toString();
                String off=switch1.getTextOff().toString();
                if(isChecked==true)
                    t2.setText(on);
                if(isChecked==false)
                    t2.setText(off);
            }
        };
        switch1.setOnCheckedChangeListener(listener1);

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);//새로 체크된 id값
                TextView t3 = findViewById(R.id.textView3);
                String s=radioButton.getText().toString();
                t3.setText(s);
            }
        };
        radioGroup1.setOnCheckedChangeListener(listener2);
    }
}