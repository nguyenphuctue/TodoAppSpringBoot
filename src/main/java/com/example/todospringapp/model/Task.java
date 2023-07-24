package com.example.todospringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private int id;
    private String title;
    private String content;

    public Task(int id){
        this.id = id;
    }

}
