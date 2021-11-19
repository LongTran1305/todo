package com.longtran.todo.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.longtran.todo.DAO.TodoDAO;
import com.longtran.todo.database.TodoDatabase;
import com.longtran.todo.model.Todo;

import java.util.List;

public class TodoRepository {
    private TodoDAO todoDAO;
    private LiveData<List<Todo>> todo;

    public TodoRepository(Application application){
        TodoDatabase database = TodoDatabase.getInstance(application);
        todoDAO = database.todoDAO();
        todo = todoDAO.getAllTodo();
    }

    public void insert(Todo todo){
        new InsertNoteAsyncTask(todoDAO).execute(todo);
    }

    public LiveData<List<Todo>> getTodo() {
        return todo;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Todo,Void,Void> {
        private TodoDAO todoDAO;

        private InsertNoteAsyncTask(TodoDAO todoDAO){
            this.todoDAO = todoDAO;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDAO.Insert(todos[0]);
            return null;
        }
    }
}
