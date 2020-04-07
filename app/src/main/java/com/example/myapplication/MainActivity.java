package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText userName;
Button login;
ToggleButton btn;
    private List<Fruit> fruitList = new ArrayList<>();
    private long exitTime = 0;
    private String[] data = {"banana", "sdfghu", "dfgvbhnjkiuytgf", "sdfghjkiuytf", "dfghj", "dfghjujhghjk", "3456yg", "fghjhg", "bananar456789", "sdfgh788u", "dfgvbhnjkiuytgf",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("create", "56");
        if(savedInstanceState != null) {
            Log.d("store_data", savedInstanceState.getString("store_data"));
        }
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit1_item, fruitList);
        ListView listview = findViewById(R.id.list_view);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit f = fruitList.get(position);
                Toast.makeText(MainActivity.this, f.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        userName = findViewById(R.id.btn);
        login = findViewById(R.id.login);
        btn = findViewById(R.id.tgBtn);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "已经开启", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "已经关闭", Toast.LENGTH_LONG).show();
                }
            }
        });
        // 点击按钮的时候设置重写 click 事件，主要是通过设置点击时间
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "happy crismates";
                android.os.Process.killProcess(android.os.Process.myPid());
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, 1);
            }
        });
    }
    public void initFruits() {
        for(int i = 0; i < 10; i ++) {
            Fruit f = new Fruit("dfdfghghj"+i, i);
            fruitList.add(f);
        }
    }
    @Override
    protected void onActivityResult(int RequestCode, int ResultCode, Intent data) {
        if(ResultCode == RESULT_OK) {
                String return_data = data.getStringExtra("data_return");
                Log.d("return_data", return_data);
        }

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("stop", "56");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "56");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "56");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart", "56");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "56");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "56");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data = "store data";
        outState.putString("store_data", data);
    }
}
