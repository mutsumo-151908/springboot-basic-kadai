package com.example.springensyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springensyu.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
