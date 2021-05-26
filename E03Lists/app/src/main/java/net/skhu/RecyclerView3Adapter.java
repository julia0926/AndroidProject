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
import java.util.ListIterator;

public class RecyclerView3Adapter extends RecyclerView.Adapter<RecyclerView3Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            view.setOnClickListener(this);
            checkBox = view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }

        public void setData(int index) {
            Memo3 memo = arrayList.get(index);
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
            checkBox.setChecked(memo.isChecked());
        }

        @Override
        public void onClick(View view) {
            selectedIndex=super.getAdapterPosition();
            Memo3 memo=arrayList.get(selectedIndex);
            if(memoClickListener != null) memoClickListener.onMemoClicked(memo);
        } //

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index = super.getAdapterPosition();
            Memo3 memo = arrayList.get(index);
            memo.setChecked(isChecked);
            if (isChecked) ++checkCount; else --checkCount;
            /*if (checkCount == 0 || checkCount == 1) {
                Activity activity = (Activity)textView1.getContext();
                activity.invalidateOptionsMenu();
            }  밑의 코드로 개선*/
            if(checkCountChangeListener!=null)
                checkCountChangeListener.onCheckCountChanged(checkCount);
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Memo3> arrayList;
    int checkCount = 0;
    int selectedIndex;
    OnMemoClickListener memoClickListener;
    OnCheckCountChangeListener checkCountChangeListener;

    public RecyclerView3Adapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<>();
    }

    public void setOnMemoClickListener(OnMemoClickListener listener){
        this.memoClickListener=listener;
    } // OnMemoClickListener 리스너 객체를 등록한다.

    public void setOnCheckCountChangeListener(OnCheckCountChangeListener listener){
        this.checkCountChangeListener=listener;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.memo2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }
    public void add(Memo3 memo){
        arrayList.add(memo);
        notifyItemInserted(arrayList.size()-1); //추가 된 부분만 다시 그린다
    }
    public void update(Memo3 memo){
        arrayList.set(selectedIndex, memo);
        notifyItemChanged(selectedIndex);
    }
    public void removeCheckedMemo(){
        ListIterator<Memo3> iterator=arrayList.listIterator();
        while(iterator.hasNext())
            if(iterator.next().isChecked())
                iterator.remove(); //체크된 것은 메모객체 리스트에서 지운다
        checkCount=0;
        checkCountChangeListener.onCheckCountChanged(checkCount);
        notifyDataSetChanged();
    }
}

