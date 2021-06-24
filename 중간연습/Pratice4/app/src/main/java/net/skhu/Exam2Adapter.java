package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Exam2Adapter extends RecyclerView.Adapter<Exam2Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public ViewHolder(View view){
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
        }

        public void setData(int index){
            Memo memo=arrayList.get(index);
            int id=memo.getId();
            textView1.setText(memo.getTitle());
            textView2.setText(String.valueOf(id));
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Memo> arrayList;

    public Exam2Adapter(Context context, ArrayList<Memo> arrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount(){
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = layoutInflater.inflate(R.layout.memo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index){
        viewHolder.setData(index);
    }
}