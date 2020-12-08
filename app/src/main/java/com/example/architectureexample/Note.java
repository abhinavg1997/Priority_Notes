package com.example.architectureexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String descrption;
    @ColumnInfo(name = "priority")
    private  int priority;

    public Note( String title, String descrption, int priority) {

        this.title = title;
        this.descrption = descrption;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescrption() {
        return descrption;
    }


    public int getPriority() {
        return priority;
    }




}
