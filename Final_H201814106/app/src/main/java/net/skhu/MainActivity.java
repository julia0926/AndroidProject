package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CREATE = 0;

    NoteAdapter noteAdapter;
    ArrayList<Note> arrayList; //입력받은 리스트를 사용하기위해

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Note>();
        arrayList.add(new Note("하나 ","one "));
        arrayList.add(new Note("둘 ","two"));
        arrayList.add(new Note("셋","three"));

        noteAdapter = new NoteAdapter(this,arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(noteAdapter);
    }

    //메뉴 등록
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    //메뉴 선택시
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //메뉴 중 아이템 선택했을 때
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, NoteEditActivity.class);
            startActivityForResult(intent, REQUEST_CREATE); //생성시에만 결과 값 전달
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Note note = (Note)intent.getSerializableExtra("NOTE");
            arrayList.add(note);
            noteAdapter.notifyDataSetChanged();
        }
    }
    public void removeNote(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인 "); //팝업창 제목
        builder.setMessage("삭제하시겠습니까?"); //팝업 창 메세지
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() { //오른쪽 버튼 예 버튼 클릭시 삭제 기능 구현
            @Override
            public void onClick(DialogInterface dialog, int index) {
                arrayList.remove(index);
            }
        });
        builder.setNegativeButton("아니요 ", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }






}