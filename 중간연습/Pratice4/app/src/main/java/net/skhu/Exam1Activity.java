package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);
    }
    public void btnOk(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("시험");
        builder.setMessage("데이터 입력");
        builder.setPositiveButton("+1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                EditText e=findViewById(R.id.editText);
                int s=Integer.parseInt(e.getText().toString())+1;
                e.setText(String.valueOf(s));
            }
        });
        builder.setNegativeButton("-1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                EditText e=findViewById(R.id.editText);
                int s=Integer.parseInt(e.getText().toString())+1;
                e.setText(String.valueOf(s));
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}