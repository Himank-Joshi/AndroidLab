package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRollNumber, editTextName, editTextMarks;
    private TextView display;
    private Button buttonAdd, buttonView;
    private SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextRollNumber = findViewById(R.id.editTextRollNumber);
        editTextName = findViewById(R.id.editTextName);
        editTextMarks = findViewById(R.id.editTextMarks);
        display=findViewById(R.id.textView);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonView = findViewById(R.id.buttonView);

        // Create or open the database
        mydatabase = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);
        // Create table if not exists
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Student (RollNumber VARCHAR, Name VARCHAR, Marks VARCHAR);");

        // Add student button click listener
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        // View students button click listener
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStudents();
            }
        });
    }

    private void addStudent() {
        String rollNumber = editTextRollNumber.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String marks = editTextMarks.getText().toString().trim();

        if (rollNumber.isEmpty() || name.isEmpty() || marks.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Insert data into table
        ContentValues contentValues = new ContentValues();
        contentValues.put("RollNumber", rollNumber);
        contentValues.put("Name", name);
        contentValues.put("Marks", marks);
        long result = mydatabase.insert("Student", null, contentValues);

        if (result != -1) {
            Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add student", Toast.LENGTH_SHORT).show();
        }

        // Clear input fields
        editTextRollNumber.getText().clear();
        editTextName.getText().clear();
        editTextMarks.getText().clear();
    }

    private void viewStudents() {
        // Retrieve data from table
        Cursor resultSet = mydatabase.rawQuery("SELECT * FROM Student", null);
        StringBuilder stringBuilder = new StringBuilder();

        if (resultSet.moveToFirst()) {
            do {
                String rollNumber = resultSet.getString(0);
                String name = resultSet.getString(1);
                String marks = resultSet.getString(2);

                stringBuilder.append("Roll Number: ").append(rollNumber).append(", Name: ").append(name)
                        .append(", Marks: ").append(marks).append("\n");
            } while (resultSet.moveToNext());
        }

        resultSet.close();

        // Display data
        display.setText(stringBuilder);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database connection
        if (mydatabase != null) {
            mydatabase.close();
        }
    }
}
