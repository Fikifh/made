package com.dicoding.picodiploma.fiki.readwritefile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNew;
    Button btnOpen;
    Button btnSave;
    EditText editContent;
    EditText editTitle;

    File path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = findViewById(R.id.button_new);
        btnOpen = findViewById(R.id.button_open);
        btnSave = findViewById(R.id.button_save);
        editContent = findViewById(R.id.edit_file);
        editTitle = findViewById(R.id.edit_title);

        btnNew.setOnClickListener(this);
        btnOpen.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        path = getFilesDir();

    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button_new:

                break;
            case R.id.button_open:

                break;
            case R.id.button_save:

                break;
        }
    }

    public void newFile() {
        editTitle.setText("");
        editContent.setText("");
        Toast.makeText(this, "Clearing file", Toast.LENGTH_SHORT).show();
    }
}
