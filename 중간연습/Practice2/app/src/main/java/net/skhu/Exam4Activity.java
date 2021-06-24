package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Exam4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam4);

        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String s = radioButton.getText().toString();
                EditText e=findViewById(R.id.editText);
                e.setText(s);
            }
        };
        final RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup1.setOnCheckedChangeListener(listener2);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_userTypes);   //스피너 아이디 값 받아서
        AdapterView.OnItemSelectedListener listener3 = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s=parent.getSelectedItem().toString();
                Toast.makeText(Exam4Activity.this,s,Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner2.setOnItemSelectedListener(listener3);

    }

    public void okay(View button){
        EditText e=findViewById(R.id.editText);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_userTypes);
        String text = spinner.getSelectedItem().toString();
        e.setText(text);
    }



}