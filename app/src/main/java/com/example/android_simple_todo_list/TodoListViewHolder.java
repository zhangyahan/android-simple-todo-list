package com.example.android_simple_todo_list;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_simple_todo_list.databinding.TodoListItemBinding;

public class TodoListViewHolder extends RecyclerView.ViewHolder {

    TodoListItemBinding binding;

    public TodoListViewHolder(@NonNull TodoListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
