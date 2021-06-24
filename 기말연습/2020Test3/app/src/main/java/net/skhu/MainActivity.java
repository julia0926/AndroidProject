package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CREATE = 0;
    public static final int REQUEST_EDIT = 1;
    int todoIndex;

    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Todo> arrayList; //입력받은 리스트를 사용하기위해

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Todo>();
        arrayList.add(new Todo("첫번째","hello"));
        arrayList.add(new Todo("두번째","졸려"));


        recyclerViewAdapter = new RecyclerViewAdapter(this,arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    //메뉴 등록
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //메뉴 선택시
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_create){
            //추가 한 값의 결과를 받기 기대 !!!!하고 수정페이지로
            Intent intent=new Intent(this,TodoEditActivity.class);
            startActivityForResult(intent, REQUEST_CREATE);
        }else if (id == R.id.action_remove) {
            removeTodo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //결과 데이터 받기!!!
    //입력한 결과 값을 받아서 리스트에 추가및수정 후 어댑터에 변화알림
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Todo todo = (Todo) intent.getSerializableExtra("TODO");
            if (requestCode == REQUEST_CREATE)
                arrayList.add(todo);
            else if (requestCode == REQUEST_EDIT)
                arrayList.set(todoIndex, todo);
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }

    //삭제 팝업창
    private void removeTodo() {  //메뉴 선택시예 제거 버튼 눌렀을 때
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("삭제여부"); //팝업창 제목
        builder.setMessage("삭제할까요?"); //팝업 창 메세지
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() { //오른쪽 버튼 예 버튼 클릭시 삭제 기능 구현
            @Override
            public void onClick(DialogInterface dialog, int index) {
                ListIterator<Todo> iterator = arrayList.listIterator();
                while (iterator.hasNext())
                    if (iterator.next().isChecked())
                        iterator.remove();
                recyclerViewAdapter.notifyDataSetChanged();
                invalidateOptionsMenu();
            }
        });
        builder.setNegativeButton("아니요 ", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}