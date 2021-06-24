package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
    }
    public void btnOk(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("시험");
        builder.setMessage("데이터 입력");
        builder.setPositiveButton(R.string.One, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                EditText e=findViewById(R.id.editText);
                e.setText(R.string.One);
            }
        });
        builder.setNegativeButton(R.string.Two, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                EditText e=findViewById(R.id.editText);
                e.setText(R.string.Two);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}