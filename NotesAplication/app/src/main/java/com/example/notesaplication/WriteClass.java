package com.example.notesaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class WriteClass extends AppCompatActivity {

    EditText editText;

    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_class);

        editText=findViewById(R.id.edittext);

        SharedPreferences sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);

        noteId=sharedPreferences.getInt("note",-1);


        if(noteId!=-1)
        {
            editText.setText(MainActivity.arrayList.get(noteId));
        }
        else
        {
            MainActivity.arrayList.add("");
            noteId=MainActivity.arrayList.size()-1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.arrayList.set(noteId,String.valueOf(s));
                MainActivity.arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}