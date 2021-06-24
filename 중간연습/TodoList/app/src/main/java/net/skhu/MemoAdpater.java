package net.skhu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoAdpater extends RecyclerView.Adapter<MemoAdpater.ViewHolder>{

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{
        TextView textView1,textView2;
        CheckBox checkBox;

        public ViewHolder(View view){
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            view.setOnClickListener(this);
            checkBox = view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }

        @Override
        public void onClick(View view) {
            int index=super.getAdapterPosition();
            Memo memo=arrayList.get(index);
            String s=String.format("index: %d,  title: %s", index, memo.getTitle());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index=super.getAdapterPosition();
            Memo memo=arrayList.get(index);
            memo.setChecked(isChecked);
            if(isChecked) ++checkCount; else --checkCount;
            if(checkCount==0||checkCount==1){
                Activity activity=(Activity)textView1.getContext(); //제목만 가져옴
                activity.invalidateOptionsMenu();//엑티버티 메뉴가 다시 생성되도록 강제한다.
            }
        }

        public void setData(int index) {
            Memo memo = arrayList.get(index);
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
            checkBox.setChecked(memo.isChecked());

        }
    }
    LayoutInflater layoutInflater;
    ArrayList<Memo> arrayList;
    int checkCount = 0;

    public MemoAdpater(Context context, ArrayList<Memo> arrayList) {
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
