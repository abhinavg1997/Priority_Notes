package com.example.architectureexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allnotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository=new NoteRepository(application);
        allnotes=repository.getAllNotes();
    }

    public void insert(Note note)
    {
        repository.insert(note);
    }

    public void update(Note note)
    {
        repository.update(note);
    }

    public void delete(Note note)
    {
        repository.delete(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNodes();
    }

    public LiveData<List<Note>> getAllnotes(){
        return allnotes;
    }

    public LiveData<List<Note>> getSearcged(String search)
    {
        return  repository.getSearched(search);
    }
}
