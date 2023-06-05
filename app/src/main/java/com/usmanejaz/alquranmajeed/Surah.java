package com.usmanejaz.alquranmajeed;

import androidx.appcompat.app.AppCompatActivity;
import com.usmanejaz.alquranmajeed.QuranData.QuranArabicText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Surah extends AppCompatActivity {

    ListView mListView;
    TextView mTextView;
    EditText mEditText;
    Button mButton;
    String[] data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        Intent intent = getIntent();
        String name = intent.getStringExtra("surahName");
        int position = intent.getIntExtra("SurahPosition", 0);
        int ayatCount = intent.getIntExtra("count", 0);
        int SSP = intent.getIntExtra("SSP", 0);

        mTextView = findViewById(R.id.name);
        mEditText = findViewById(R.id.ayatNumber);
        mListView  = findViewById(R.id.surahDisplay);
        mButton = findViewById(R.id.searchButton);

        mTextView.setText(name);
        QuranArabicText obj = new QuranArabicText();
             data = obj.GetData(SSP - 1, SSP + ayatCount - 1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String ayatNum = mEditText.getText().toString();
                mTextView.setText( name  + " " + ayatNum);
                   int ayatNumber = Integer.parseInt(ayatNum);
                    data = obj.GetData(SSP +ayatNumber -1, SSP + ayatCount - 1);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, data);
                mListView.setAdapter(arrayAdapter);


                }

        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(arrayAdapter);


    }


}