package net.skhu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView_title,textView2;


        public ViewHolder(View view) {
            super(view);
            textView_title=view.findViewById(R.id.textView1);
            textView2=view.findViewById(R.id.textView2);
        }

        public void setData(int index) {
            Note note=arrayList.get(index); //객체의 인덱스 번호에 삽입
            textView_title.setOnClickListener(this); //수정 기능 구현했으면 필요!!!!!
            textView_title.setText(note.getHeader()); //목록에 보여질 타이틀 추가
            textView2.setText(note.getBody()); //목록에 보여질 타이틀 추가

        }
        @Override
        public void onClick(View view) {
            int index = super.getAdapterPosition();
            MainActivity activity = (MainActivity) textView_title.getContext();
            activity.removeNote();
            notifyDataSetChanged();
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Note> arrayList;

    public NoteAdapter(Context context, ArrayList<Note> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList=arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.note, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }



}

