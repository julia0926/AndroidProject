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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;


public class RecyclerViewRealActivity extends AppCompatActivity {
    public static final int REQUEST_CREATE = 0;
    public static final int REQUEST_EDIT = 1;

    int memoIndex;

    RecyclerViewRealAdapter recyclerViewRealAdapter;
    ArrayList<InputMemo> arrayList; //입력받은 리스트를 사용하기위해

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_real);

        arrayList = new ArrayList<InputMemo>();
        arrayList.add(new InputMemo("one", "안녕하세요",new Date()));

        //목록 리싸이클러 뷰 구현
        recyclerViewRealAdapter = new RecyclerViewRealAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewRealAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //메뉴 생성시
        getMenuInflater().inflate(R.menu.menu_recycler_view3, menu);
        MenuItem menuItem = menu.findItem(R.id.action_remove); //삭제 메뉴를 찾는다
        menuItem.setVisible(recyclerViewRealAdapter.checkCount > 0); //메뉴의 체크된게 1개이상이면 삭제메뉴를 보임
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //메뉴 중 아이템 선택했을 때
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, MemoActivity.class);
            startActivityForResult(intent, REQUEST_CREATE); //생성시에만 결과 값 전달
        } else if (id == R.id.action_remove) { //메뉴 삭제클릭시
            removeMemos();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) { //결과 값을 받을 때 필요
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) { //결과 코드를 받았다면 !!!!
            InputMemo memo = (InputMemo)intent.getSerializableExtra("MEMO");
            if(requestCode==REQUEST_CREATE) arrayList.add(memo); //요청코드면 객체 추가
            else if(requestCode==REQUEST_EDIT) arrayList.set(memoIndex,memo); //수정이면 클릭한 인덱스 값에 메모객체를 수정
            recyclerViewRealAdapter.notifyDataSetChanged();
        }
    }

    private void removeMemos() {  //메뉴 선택시 제거 버튼 눌렀을 때
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm); //팝업창 제목
        builder.setMessage(R.string.doYouWantToDelete); //팝업 창 메세지
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { //오른쪽 버튼 예 버튼 클릭시 삭제 기능 구현
            @Override
            public void onClick(DialogInterface dialog, int index) {
                ListIterator<InputMemo> iterator = arrayList.listIterator();
                while (iterator.hasNext())
                    if (iterator.next().isChecked())
                        iterator.remove();
                recyclerViewRealAdapter.notifyDataSetChanged();
                recyclerViewRealAdapter.checkCount=0;
                invalidateOptionsMenu();
            }
        });
        builder.setNegativeButton(R.string.no, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}