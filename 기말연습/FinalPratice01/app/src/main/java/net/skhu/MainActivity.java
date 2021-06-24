package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnRecyclerView(View view){
        Intent intent=new Intent(this,RecyclerViewActivity.class);
        startActivity(intent);
    }
    public void btnMemo(View view){
        Intent intent=new Intent(this,MemoActivity.class);
        startActivityForResult(intent, 0);
    }

    public void btnRealRecyclerView (View view){
        Intent intent=new Intent(this,RecyclerViewRealActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            InputMemo memo = (InputMemo)intent.getSerializableExtra("MEMO");
            String s = String.format(
                    "<h1>%s</h1><p>%s</p><p style='color: blue'>%s</p>",
                    memo.getTitle(), memo.getDateFormatted(), memo.getContent());
            TextView textView = findViewById(R.id.textView);
            textView.setText(Html.fromHtml(s));
        }
    }



}