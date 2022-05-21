package com.example.ex220521_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navi;
    private FragmentInfo info;
    private FragmentManager fm;
    private Fragmentlist list;
    private EditText edt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        info = new FragmentInfo();
        list = new Fragmentlist();


        navi = findViewById(R.id.navi);
        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.info :
                        fm.beginTransaction().replace(R.id.frame, info).commit();
                        Toast.makeText(getApplicationContext(), "내정보", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.list:
                        fm.beginTransaction().replace(R.id.frame, list).commit();
                        Toast.makeText(getApplicationContext(), "친구목록", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(getApplicationContext(), "설정", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


    }
}