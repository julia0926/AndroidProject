package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        View.OnClickListener listener= new View.OnClickListener() { //버튼 누를시 발생되는 리스너
            @Override
            public void onClick(View v) {
                String msg;
                int buttonId=v.getId();
                switch (buttonId){
                    case R.id.imageButton1: msg="첫번째 이미지 아이콘 클릭했습니다."; break;
                    case R.id.imageButton2: msg="두번째 이미지 아이콘 클릭했습니다."; break;
                    case R.id.button_re: msg="1-1번째 이미지 아이콘 클릭했습니다."; break;
                    case R.id.button_re2: msg="1-2째 이미지 아이콘 클릭했습니다."; break;
                    case R.id.button_re3: msg="1-3째 이미지 아이콘 클릭했습니다."; break;
                    default: msg="아무것도 클릭 안했음"; break;

                }
                Toast.makeText(ButtonActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        };

        Button button1=findViewById(R.id.button_re);
        Button button2=findViewById(R.id.button_re2);
        Button button3=findViewById(R.id.button_re3);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);

        ImageButton button4=findViewById(R.id.imageButton1);
        ImageButton button5=findViewById(R.id.imageButton2);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);


    }
}