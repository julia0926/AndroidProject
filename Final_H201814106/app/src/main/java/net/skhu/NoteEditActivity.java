package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        final EditText editText1 = findViewById(R.id.editText1);
        final EditText editText2 = findViewById(R.id.editText2);
        final Button button = findViewById(R.id.btnSave);
        button.setOnClickListener((view) -> {
            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();
            Note note = new Note(text1, text2);

            Intent intent = new Intent();
            intent.putExtra("NOTE", note);
            setResult(RESULT_OK, intent);
            finish();
        });

    }

}