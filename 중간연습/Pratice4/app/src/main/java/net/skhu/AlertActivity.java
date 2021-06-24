package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }
    public void alert (View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("동물을 입력");
        builder.setSingleChoiceItems(R.array.phoneTypes, index, null);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // 선택된 항목에 대한 작업 실행
                ListView listView = ((AlertDialog) dialog).getListView();
                index = listView.getCheckedItemPosition();
                String msg = index + " 번째 항목이 선택되었습니다.";
                Toast.makeText(AlertActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("취소", null);
            AlertDialog dialog = builder.create();
        dialog.show();

        }
}