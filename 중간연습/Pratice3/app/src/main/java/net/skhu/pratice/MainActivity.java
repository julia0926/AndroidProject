package net.skhu.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //버튼 누르면
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button33);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                if(id==R.id.button1){
                    Intent intent = new Intent(MainActivity.this, Exam1Activity.class);
                    startActivity(intent);
                }
                else if(id==R.id.button2){
                    Intent intent = new Intent(MainActivity.this, Exam2Activity.class);
                    startActivity(intent);
                }
                else if(id==R.id.button33){
                    Intent intent = new Intent(MainActivity.this, Exam3Activity.class);
                    startActivity(intent);
                }

            }
        };
        b1.setOnClickListener(listenerObj);
        b2.setOnClickListener(listenerObj);
        b3.setOnClickListener(listenerObj);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_signUp) {
            Intent intent=new Intent(this,SignupActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_memo) {
            Intent intent=new Intent(this,MemoActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_button) {
            Intent intent=new Intent(this,ButtonActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_checkboxes) {
            Intent intent=new Intent(this,CheckboxesAcitivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}