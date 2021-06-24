package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_title;
        CheckBox checkBox;
        public ViewHolder(View view) {
            super(view);
            textView_title = view.findViewById(R.id.textView_title);
            checkBox = view.findViewById(R.id.checkBox);
        }

        public void setData(int index) {
            Todo todo = arrayList.get(index);
            textView_title.setText(todo.getTitle());
        }

    }

    LayoutInflater layoutInflater;
    ArrayList<Todo> arrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Todo> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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

