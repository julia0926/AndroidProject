package net.skhu.endexam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        TextView textView_title, textView_name;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView_title = view.findViewById(R.id.textView_title);
            textView_title.setOnClickListener(this); //수정 기능 구현했으면 필요!!!!!
            checkBox = view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }

        public void setData(int index) {
            Todo todo = todoList.get(index); //객체의 인덱스 번호에 삽입
            textView_title.setText(todo.getTitle()); //목록에 보여질 타이틀 추가
            checkBox.setChecked(todo.isChecked());
        }

        @Override
        public void onClick(View v) {
            int index = super.getAdapterPosition(); //클릭된 목록의 인덱스 값
            MainActivity activity = (MainActivity) textView_title.getContext(); //목록 액티버티의 액티버티 가져옴
            activity.todoIndex = index; // 목록 액티버티의 인덱스 값에 지정
            Todo todo = todoList.get(index); // 리스트에서 인덱스 번호의 객체 가져옴
            Intent intent = new Intent(activity, TodoEditActivity.class); // 수정화면으로 전환
            intent.putExtra("TODO", todo); //수정한 객체를 삽입
            activity.startActivityForResult(intent, MainActivity.REQUEST_EDIT); //목록에 수정했다고 알림 !
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index = super.getAdapterPosition();
            Todo todo = todoList.get(index);
            if (isChecked == todo.isChecked()) return; //수정 후 개선된 ㄴ부분 ~!!
            todo.setChecked(isChecked);
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Todo> todoList = new ArrayList<>();

    public RecyclerViewAdapter(Context context,ArrayList<Todo> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todoList=arrayList;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.todo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }

}

