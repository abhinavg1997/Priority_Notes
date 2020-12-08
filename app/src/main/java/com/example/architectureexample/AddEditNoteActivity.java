package com.example.architectureexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {

    public static final String EXTRA_ID="com.example.architectureexample.EXTRA_ID";

    public static final String EXTRA_TITLE=
            "com.example.architectureexample.EXTRA_TITLE";

    public static final String EXTRA_DESCRIPTION=
            "com.example.architectureexample.EXTRA_DESCRIPTION";

    public static final String EXTRA_PRIORITY=
            "com.example.architectureexample.EXTRA_PRIORITY";

    private EditText etTitle,etDesc;
    NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDescription);
        numberPickerPriority = findViewById(R.id.numberPickerPriority);
        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Node");
            etTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            etDesc.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY,1));
        } else {
            setTitle("Add Note");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.save_note:
                saveNote();
               return true;
                default:
                    return super.onOptionsItemSelected(item);

        }


    }

    private void saveNote() {
        String title=etTitle.getText().toString();
        String Desc=etDesc.getText().toString();
        int prority=numberPickerPriority.getValue();
        if(title.trim().isEmpty() || Desc.trim().isEmpty())
        {
            Toast.makeText(this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
            Intent data=new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,Desc);
        data.putExtra(EXTRA_PRIORITY,prority);

        int id=getIntent().getIntExtra(EXTRA_ID,-1);
        if(id!=-1)
        {
            data.putExtra(EXTRA_ID,id);
        }

        setResult(RESULT_OK,data);
        finish();


    }
}
