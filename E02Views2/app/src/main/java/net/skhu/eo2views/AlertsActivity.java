package net.skhu.eo2views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AlertsActivity extends AppCompatActivity {

    int selectedAnimalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
    }

    public void button1_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.saveSuccess);
        builder.setNeutralButton(R.string.close,null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button2_clicked(View button){ //삭제 할지 여부를 묻는 Alerts
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm); //타이틀 지정
        builder.setMessage(R.string.doYouWantToDelete); //대화상자에 보여줄 간단한 메세지
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //삭제시 작업실행 할 리스너 객체
                Toast.makeText(AlertsActivity.this,"삭제 성공",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no,null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void button3_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals,selectedAnimalIndex,null); //대화상자가 처음 뜰 때 초기값
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListView listView = ((AlertDialog)dialog).getListView(); //리스트 뷰 객체 생성해서
                selectedAnimalIndex=listView.getCheckedItemPosition();//선택된 인덱스 값을 넣음
                String msg=selectedAnimalIndex+"번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this,msg,Toast.LENGTH_SHORT).show();

                int drawableId=0;
                switch(selectedAnimalIndex){
                    case 0:drawableId=R.drawable.animal_cat_large; break; //인덱스 0이라면 큰 고양이 이미지를 아이디값에 넣음
                    case 1:drawableId=R.drawable.animal_dog_large; break;
                    case 2:drawableId=R.drawable.animal_owl_large; break;
                }
                ImageView imageView=findViewById(R.id.imageView1);
                imageView.setImageResource(drawableId);
            }
        });
        builder.setNegativeButton(R.string.no,null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}