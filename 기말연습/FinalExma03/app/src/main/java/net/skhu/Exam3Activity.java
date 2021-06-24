package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exam3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam3);
    }
    public void btn_click(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("삭제여부"); //팝업창 제목
        builder.setMessage("삭제할까요?"); //팝업 창 메세지
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() { //오른쪽 버튼 예 버튼 클릭시 삭제 기능 구현
            @Override
            public void onClick(DialogInterface dialog, int index) {
                TextView text=findViewById(R.id.textView);
                text.setText("삭제성공");
                Toast.makeText(Exam3Activity.this,"삭제성공",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("아니요 ", new DialogInterface.OnClickListener() { //오른쪽 버튼 예 버튼 클릭시 삭제 기능 구현
            @Override
            public void onClick(DialogInterface dialog, int index) {
                TextView text=findViewById(R.id.textView);
                text.setText("삭제실패");
                Toast.makeText(Exam3Activity.this,"삭제실패",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}