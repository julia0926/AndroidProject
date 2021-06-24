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
import java.util.Date;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CREATE = 1;
    //public static final int REQUEST_EDIT = 1;

    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Todo> arrayList;
    int todoIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Todo>();
        arrayList.add(new Todo("one", "안녕하세요"));

        recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //메뉴 생성시
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //메뉴 중 아이템 선택했을 때
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, TodoEditActivity.class);
            startActivityForResult(intent, 0); //생성시에만 결과 값 전달
        } else if (id == R.id.action_remove) {
            removeTodo(); //삭제 팝업 메소드
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) { //결과 값을 받을 때 필요
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) { //결과 코드를 받았다면 !!!!
            Todo todo = (Todo)intent.getSerializableExtra("MEMO");
            if(requestCode==REQUEST_CREATE) arrayList.add(todo); //요청코드면 객체 추가
            //else if(requestCode==REQUEST_EDIT) arrayList.set(todoIndex,todo);
            // 수정이면 클릭한 인덱스 값에 메모객체를 수정
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }
    private void removeTodo() {  //메뉴 선택시 제거 버튼 눌렀을 때
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인"); //팝업창 제목
        builder.setMessage("삭제하시겠습니까?"); //팝업 창 메세지
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
        builder.setNegativeButton("아니요", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}