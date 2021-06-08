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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

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
            Memo memo = arrayList.get(index);
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
            checkBox.setChecked(memo.isChecked());
        }

        @Override
        public void onClick(View view) {
            selectedIndex = super.getAdapterPosition();
            Memo memo = arrayList.get(selectedIndex);
            if (memoClickListener != null) memoClickListener.onMemoClicked(memo);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index = super.getAdapterPosition();
            Memo memo = arrayList.get(index);
            //if (isChecked==memo.isChecked()) return; //사람이 체크햇
            memo.setChecked(isChecked);
            if (isChecked) ++checkCount; else --checkCount;
            if (checkCountChangeListener != null)
                checkCountChangeListener.onCheckCountChanged(checkCount);
        }
    }

    ValueEventListener firebaseListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            GenericTypeIndicator<List<Memo>> typeIndicator = new GenericTypeIndicator<List<Memo>>() {};
            List<Memo> temp  = dataSnapshot.getValue(typeIndicator); //목록 전체가 전달
            if (temp != null) {
                arrayList = temp;
                notifyDataSetChanged(); //다시 화면에 그리게끔..
            }
        }
        @Override
        public void onCancelled(DatabaseError error) {
        }
    };

    LayoutInflater layoutInflater;
    List<Memo> arrayList;
    int checkCount = 0;
    int selectedIndex;
    OnMemoClickListener memoClickListener;
    OnCheckCountChangeListener checkCountChangeListener;
    DatabaseReference item02;

    public MemoAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<>();
        this.item02 = FirebaseDatabase.getInstance().getReference("item02");
        this.item02.addValueEventListener(firebaseListener);
    }

    public void setOnMemoClickListener(OnMemoClickListener listener) {
        this.memoClickListener = listener;
    }

    public void setOnCheckCountChangeListener(OnCheckCountChangeListener listener) {
        this.checkCountChangeListener = listener;
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

    public void add(Memo memo) { //새 메모 객체가 추가되면 메모 목록 전체를 firebaseDB에 저장한다.
        arrayList.add(memo);
        item02.setValue(arrayList);
    }

    public void update(Memo memo) {
        arrayList.set(selectedIndex, memo);
        item02.setValue(arrayList); //item02 전체를 set함
    }

    public void removeCheckedMemo() {
        ListIterator<Memo> iterator = arrayList.listIterator();
        while (iterator.hasNext())
            if (iterator.next().isChecked())
                iterator.remove();
        checkCount = 0;
        checkCountChangeListener.onCheckCountChanged(checkCount);
        item02.setValue(arrayList);
    }
}

