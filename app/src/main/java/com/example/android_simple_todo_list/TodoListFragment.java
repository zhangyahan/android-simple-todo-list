package com.example.android_simple_todo_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_simple_todo_list.databinding.FragmentTodoListBinding;

import java.util.ArrayList;

public class TodoListFragment extends Fragment {

    private FragmentTodoListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTodoListBinding.inflate(inflater, container, false);

        // 初始化代办事项列表
        binding.recyclerViewTodoList.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        binding.recyclerViewTodoList.setAdapter(new TodoListRecyclerAdapter<>(data));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}