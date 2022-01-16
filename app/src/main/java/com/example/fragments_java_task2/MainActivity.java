package com.example.fragments_java_task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragments_java_task2.fragment.FirstFragment;
import com.example.fragments_java_task2.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstListener, SecondFragment.SecondListener {

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    @Override
    public void onFirstSend(User user) {
        secondFragment.updateSecondText(user);
    }

    @Override
    public void onSecondGet(User user) {
        firstFragment.updateFirstText(user);
    }

    private void initViews() {
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameFirst, firstFragment)
                .replace(R.id.frameSecond, secondFragment)
                .commit();

    }
}