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

    public void btnRecyclerView1_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView1Activity.class);
        startActivity(intent);
    }

    public void btnRecyclerView2_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView2Activity.class);
        startActivity(intent);
    }


    public void btnMemo3_clicked(View view) {
        Intent intent = new Intent(this, Memo3Activity.class);
        startActivityForResult(intent, 0);
    }

    public void btnRecyclerView3_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView3Activity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Memo3 memo = (Memo3)intent.getSerializableExtra("MEMO");
            String s = String.format(
                    "<h1>%s</h1><p>%s</p><p style='color: blue'>%s</p>",
                    memo.getTitle(), memo.getDateFormatted(), memo.getContent());
            TextView textView = findViewById(R.id.textView);
            textView.setText(Html.fromHtml(s));
        }
    }
}
