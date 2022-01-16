package com.example.fragments_java_task2.fragment;

import android.content.Context;
import android.content.Intent;
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

public class FirstFragment extends Fragment {

    private FirstListener listener;
    Button btn;
    TextView textData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initViews(view);
        return view;
    }

    void initViews(View view) {
        btn = view.findViewById(R.id.b_first);
        textData =  view.findViewById(R.id.first_text_data);
        btn.setOnClickListener(v -> {
            listener.onFirstSend(new User("PDP","22"));
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FirstListener) {
            listener = (FirstListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateFirstText(User user) {
        textData.setText(user.toString());
    }

    public interface FirstListener {
        void onFirstSend(User user);
    }
}