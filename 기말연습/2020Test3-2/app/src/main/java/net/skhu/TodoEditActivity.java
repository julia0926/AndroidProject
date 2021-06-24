package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TodoEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_edit);

        EditText editText_title = (EditText) findViewById(R.id.editText_title);
        EditText editText_content = (EditText) findViewById(R.id.editText_description);
        Todo todo = (Todo)getIntent().getSerializableExtra("TODO");
        if (todo != null) {
            editText_title.setText(todo.getTitle());
            editText_content.setText(todo.getDescription());
        }

        Button button = (Button) findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_title.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    editText_title.setError("제목을 입력하세요");
                    return;
                }

                String content = editText_content.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    editText_content.setError("내용을 입력하세요");
                    return;
                }

                Todo todo = new Todo(title,content);
                Intent intent = new Intent();
                intent.putExtra("TODO", todo);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        button.setOnClickListener(listener);
    }

}