package net.skhu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewRealAdapter extends RecyclerView.Adapter<RecyclerViewRealAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            textView1.setOnClickListener(this);
            checkBox = view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }

        public void setData(int index) {
            InputMemo memo = arrayList.get(index);
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
            checkBox.setChecked(memo.isChecked());
        }

        @Override
        public void onClick(View view) {
            int index = super.getAdapterPosition();
            RecyclerViewRealActivity activity=(RecyclerViewRealActivity)textView1.getContext(); //목록의 엑티버티를 가져와야함!!!
            activity.memoIndex=index;
            InputMemo memo=arrayList.get(index);
            Intent intent=new Intent(activity,MemoActivity.class);
            intent.putExtra("MEMO",memo);
            activity.startActivityForResult(intent, RecyclerViewRealActivity.REQUEST_EDIT);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index = super.getAdapterPosition();
            InputMemo memo = arrayList.get(index);
            if (isChecked == memo.isChecked()) return;
            memo.setChecked(isChecked);
            if(isChecked) ++checkCount; else --checkCount; //체크된 게 있음 체크변수 증가
            if(checkCount==0||checkCount==1){
                Activity activity=(Activity)textView1.getContext();
                activity.invalidateOptionsMenu(); //메뉴가 다시 생기기를 강제
            }

        }
    }

    LayoutInflater layoutInflater;
    ArrayList<InputMemo> arrayList;
    int checkCount=0;

    public RecyclerViewRealAdapter(Context context, ArrayList<InputMemo> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.memo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }
}

