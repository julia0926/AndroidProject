package net.skhu.eo2views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AlertsAcitivity2 extends AppCompatActivity {

    int selectedIndexAnimal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts_acitivity2);
    }

    public void button_clicked1(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("삭제 유무");
        builder.setMessage("저장성공");
        builder.setNeutralButton("닫기",null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void button_clicked2(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setMessage("삭제하시겠습니까");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertsAcitivity2.this,"삭제 성공",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No",null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void button_clicked3(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals,selectedIndexAnimal,null);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListView listView = ((AlertDialog)dialog).getListView();
                selectedIndexAnimal=listView.getCheckedItemPosition();
                String msg=selectedIndexAnimal+"번째 항목 선택";
                Toast.makeText(AlertsAcitivity2.this,msg,Toast.LENGTH_SHORT).show();

                int drawableId=0; //선택 된 다음 설정할 아이디 값
                switch (selectedIndexAnimal){
                    case 0: drawableId=R.drawable.animal_cat_large; break;
                    case 1: drawableId=R.drawable.animal_owl_large; break;
                    case 2: drawableId=R.drawable.animal_dog_large; break;
                }
                ImageView imageView1=findViewById(R.id.imageView1);
                imageView1.setImageResource(drawableId);
            }
        });
        builder.setNegativeButton("NO",null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}