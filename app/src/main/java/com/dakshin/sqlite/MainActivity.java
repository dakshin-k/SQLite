package com.dakshin.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db=SQLiteDatabase.openDatabase(new File(getExternalFilesDir(null),"dakshin.db").getAbsolutePath(),null,0);
        Cursor resultSet = db.rawQuery("Select * from grate_kancheepuram",null);
        int colsize=resultSet.getColumnCount();
        Col4RowItem item=new Col4RowItem(resultSet.getColumnNames());
        ArrayList<Col4RowItem> list=new ArrayList<>();
        list.add(item);
        while(resultSet.moveToNext()) {
            String names[]=new String[colsize];
            for (int i = 0; i < colsize; i++) {
                names[i]=resultSet.getString(i);
            }
            list.add(new Col4RowItem(names));
        }
        ListView listView=findViewById(R.id.listview);
        ListAdapter adapter=new Col4ListAdapter(list,this);
        listView.setAdapter(adapter);
    }
}
