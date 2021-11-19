package com.longtran.todo.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.longtran.todo.model.Todo;

import java.util.List;

@Dao
public interface TodoDAO {
    @Insert
    void Insert(Todo todo);
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    LiveData<List<Todo>> getAllTodo();
}
