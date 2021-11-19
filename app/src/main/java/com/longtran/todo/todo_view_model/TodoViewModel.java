package com.longtran.todo.todo_view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.longtran.todo.model.Todo;
import com.longtran.todo.repository.TodoRepository;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private TodoRepository repository;
    private LiveData<List<Todo>> todo;

    public TodoViewModel(@NonNull Application application) {
        super(application);

        repository = new TodoRepository(application);
        todo = repository.getTodo();
    }

    public void insert(Todo todo){
        repository.insert(todo);
    }

    public LiveData<List<Todo>> getTodo(){
        return todo;
    }
}
