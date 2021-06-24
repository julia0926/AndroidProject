package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ComputableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class CheckboxesAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxes);

        //체크박스 스위치
        CompoundButton.OnCheckedChangeListener listener1= new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String s=String.format("%s : %b", buttonView.getText(),isChecked);
                Toast.makeText(CheckboxesAcitivity.this,s,Toast.LENGTH_SHORT).show();
            }
        };
        //체크박스나 스위치 값이 변경되면 리스너 호출되도록 객체를 리스너에 등록한다.
        final CheckBox checkBox1=(CheckBox) findViewById(R.id.checkBox);
        final Switch switch1=(Switch) findViewById(R.id.switch1);
        checkBox1.setOnCheckedChangeListener(listener1);
        switch1.setOnCheckedChangeListener(listener1);

        //라디오 그룹
        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=(RadioButton) findViewById(checkedId);//새로 체크된 id값
                String s=radioButton.getText().toString();
                Toast.makeText(CheckboxesAcitivity.this,s,Toast.LENGTH_SHORT).show();
            }
        };

        final RadioGroup radioGroup1 =(RadioGroup)findViewById(R.id.radioGroup1);
        radioGroup1.setOnCheckedChangeListener(listener2);

        //라디오 그룹 2
        RadioGroup.OnCheckedChangeListener listener3= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int drawableId=0;
                switch(checkedId){
                    case R.id.radioCat: drawableId=R.drawable.animal_cat_large; break;
                    case R.id.radioDog: drawableId=R.drawable.animal_dog_large; break;
                    case R.id.radioOwl: drawableId=R.drawable.animal_owl_large; break;
                }
                ImageView imageView=(ImageView)findViewById(R.id.imageView);
                imageView.setImageResource(drawableId); //선택되면 drawableId값에 여러종류의 큰 이미지를 줘서 이미지를 바꿈

            }
        };

        final RadioGroup radioGroup2=(RadioGroup)findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(listener3);

        //버튼
        Button button = (Button)findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "checkBox1=" + checkBox1.isChecked() + " ";
                s += "switch1=" + switch1.isChecked() + " ";
                s += "radioGroup1=";
                switch (radioGroup1.getCheckedRadioButtonId()) {
                    case R.id.radioRed: s += "red "; break;
                    case R.id.radioPurple: s += "Purple "; break;
                    case R.id.radioBlue: s += "blue "; break;
                }
                switch (radioGroup2.getCheckedRadioButtonId()) {
                    case R.id.radioCat: s += "cat"; break;
                    case R.id.radioDog: s += "dog"; break;
                    case R.id.radioOwl: s += "owl"; break;
                }
                Toast.makeText(CheckboxesAcitivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });



    }
}