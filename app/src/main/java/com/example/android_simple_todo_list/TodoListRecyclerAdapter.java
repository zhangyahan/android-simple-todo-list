package com.example.android_simple_todo_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_simple_todo_list.databinding.TodoListItemBinding;

import java.util.List;

public class TodoListRecyclerAdapter<V extends Object>
        extends RecyclerView.Adapter<TodoListViewHolder> {

    private List<V> data;

    public TodoListRecyclerAdapter(List<V> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public TodoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TodoListItemBinding binding = TodoListItemBinding.inflate(inflater, parent, false);
        return new TodoListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListViewHolder holder, int position) {
        V v = data.get(position);
        holder.binding.textViewTitle.setText(v.toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
