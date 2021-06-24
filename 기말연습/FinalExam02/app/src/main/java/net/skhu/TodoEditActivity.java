package net.skhu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TodoEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_edit);

        final EditText editText1 = findViewById(R.id.editText_title);
        final EditText editText2 = findViewById(R.id.editText_description);
        final Button button = findViewById(R.id.btnSave);
        button.setOnClickListener((view) -> {
            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();
            Todo todo = new Todo(text1,text2);
            Intent intent = new Intent();
            intent.putExtra("TODO", todo);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}

