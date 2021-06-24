package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        //수정기능
        EditText editText_title = (EditText) findViewById(R.id.editText_title);
        EditText editText_content = (EditText) findViewById(R.id.editText_content);
        InputMemo memo = (InputMemo)getIntent().getSerializableExtra("MEMO");
        if (memo != null) { //메모 객체가 널이 아니라면 즉, 객체가 있으면 그 객체의 제목,내용 저장
            editText_title.setText(memo.getTitle());
            editText_content.setText(memo.getContent());
        }

        Button button=findViewById(R.id.btnSave);
        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editText_title=findViewById(R.id.editText_title);
                String title=editText_title.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    editText_title.setError("제목을 입력하세요");
                    return;
                }

                EditText editText_content = (EditText) findViewById(R.id.editText_content);
                String content = editText_content.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    editText_content.setError("내용을 입력하세요");
                    return;
                }

                //저장 버튼을 누르고 메모 리스트객체에 입력한 메모 객체를 넣음
                InputMemo memo=new InputMemo(title,content,new Date());
                Intent intent=new Intent();
                intent.putExtra("MEMO",memo);
                setResult(RESULT_OK,intent);
                finish();

            }
        };
        button.setOnClickListener(listener); //마지막으로 온클릭 리스너에 리스너 추가

    }
}