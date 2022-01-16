package com.example.fragments_java_task2.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragments_java_task2.R;
import com.example.fragments_java_task2.User;

public class SecondFragment extends Fragment {

    private SecondListener listener;
    TextView textData;
    Button bSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {
        textData = view.findViewById(R.id.second_text_data);
        bSecond = view.findViewById(R.id.b_second);
        bSecond.setOnClickListener(v -> {
            listener.onSecondGet(new User("Academy","23"));
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SecondListener) {
            listener = (SecondListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SecondListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateSecondText(User user) {
        textData.setText(user.toString());
    }

    public interface SecondListener {
        void onSecondGet(User user);
    }
}