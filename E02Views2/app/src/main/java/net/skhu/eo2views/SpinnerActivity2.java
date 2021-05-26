package net.skhu.eo2views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);

        String[] stringArray = { "카톡", "페북", "인스타그램" };
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_social);
        spinner.setAdapter(adapter);

        View.OnClickListener listener1=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Spinner spinner1=findViewById(R.id.spinner_phoneType);
                int index1=spinner1.getSelectedItemPosition();//선택된 항목의 인덱스를 가져옴
                String text1=spinner1.getSelectedItem().toString();//선택된 항목의 문자를 가져옴

                Spinner spinner2=findViewById(R.id.spinner_social);
                int index2=spinner2.getSelectedItemPosition();//선택된 항목의 인덱스를 가져옴
                String text2=spinner2.getSelectedItem().toString();//선택된 항목의 문자를 가져옴

                String msg=String.format("전화:%s(%d) , 소셜:%s(%d)",text1,index1,text2,index2);
                Toast.makeText(SpinnerActivity2.this,msg,Toast.LENGTH_SHORT).show();
            }
        };
        Button button=findViewById(R.id.btnSave);
        button.setOnClickListener(listener1); //버튼에 리스너 객체를 넣어 버튼이 눌리면 실행되게 끔 한다.

        AdapterView.OnItemSelectedListener listener2=new AdapterView.OnItemSelectedListener(){ //리스트를 클릭했을 때 실행되는 리스너

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s=parent.getSelectedItem().toString();
                Toast.makeText(SpinnerActivity2.this,s,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        };
        spinner.setOnItemSelectedListener(listener2);
    }

    //Spinner spinner1=findViewById(R.id.spinner_phoneType); //Spinner를 먼저 선언하여 아이디 값 갖고




}