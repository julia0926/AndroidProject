package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>   {


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public ViewHolder(View view){
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
        }

        public void setData(int index){
            Memo2 memo=arrayList.get(index);
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Memo2> arrayList;

    public RecyclerAdapter(Context context, ArrayList<Memo2> arrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount(){
        return arrayList.size();
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = layoutInflater.inflate(R.layout.date, viewGroup, false);
        return new RecyclerAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder viewHolder, final int index){
        viewHolder.setData(index);
    }
}

