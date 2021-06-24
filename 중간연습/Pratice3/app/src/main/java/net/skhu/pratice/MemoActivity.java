package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        EditText editText1=(EditText) findViewById(R.id.editText_title);
        editText1.setText("제목: 공지사항 입니다.");
        EditText editText2=(EditText) findViewById(R.id.editText_content);
        editText2.setText("내용: 4주차나 5주차에 구현 시험을 봅니다.");

        Button button=(Button) findViewById(R.id.btnSave);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_title = (EditText) findViewById(R.id.editText_title);
                String title = editText_title.getText().toString();
                if (isEmptyOrWhiteSpace(title))
                    editText_title.setError("제목을 입력하세요.");
                EditText editText_content = (EditText) findViewById(R.id.editText_content);
                String content = editText_content.getText().toString();
                if (isEmptyOrWhiteSpace(content))
                    editText_content.setError("내용 을 입력하세요.");

                String msg = "저장 성공: " + title;
                Toast.makeText(MemoActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        };
        button.setOnClickListener(listener);
    }




    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.toString().trim().length() == 0;
    }

}