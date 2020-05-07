package com.example.talktome;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.talktome.adapters.NotesAdapter;
import com.example.talktome.database.DatabaseHandler;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initViews();
        loadNotes();

    }

    private void loadNotes() {

        DatabaseHandler db = new DatabaseHandler(this);

        notesList = db.getAllNotes();
        if(notesList.size() != 0){
            adapter = new NotesAdapter(this,notesList);
            rvNotes.setAdapter(adapter);
        }



    }

    private void initViews() {
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.fabAddNote)
    public void addNote(){
        Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
        startActivity(i);
    }




}
