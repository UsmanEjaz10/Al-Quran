package com.usmanejaz.alquranmajeed;

import androidx.appcompat.app.AppCompatActivity;
import com.usmanejaz.alquranmajeed.QuranData.QuranArabicText;
import com.usmanejaz.alquranmajeed.QuranData.QDH;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // List<String> surahNames = new ArrayList<>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QDH obj = new QDH();
        List<String> surahNames = new ArrayList<>(obj.GetSurahNames());

        listview = findViewById(R.id.surahListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, surahNames);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String i =  surahNames.get(position).toString();

               Toast t  = Toast.makeText(getApplicationContext(), i, Toast.LENGTH_SHORT);
               t.show();

               Intent intent = new Intent(MainActivity.this, Surah.class);
               intent.putExtra("surahName", i);
               intent.putExtra("SurahPosition", position);
               intent.putExtra("SSP" , obj.getSurahStart(position));
               intent.putExtra("count" , obj.getSurahVerses(position));
               startActivity(intent);

            }
        });

    }
}