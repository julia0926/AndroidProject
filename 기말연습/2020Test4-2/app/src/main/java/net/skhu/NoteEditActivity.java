package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NoteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.btnSave);
        button.setOnClickListener((view) -> {
            String text = editText.getText().toString();
            Note note = new Note(text);
            Intent intent = new Intent();
            intent.putExtra("NOTE", note);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}

