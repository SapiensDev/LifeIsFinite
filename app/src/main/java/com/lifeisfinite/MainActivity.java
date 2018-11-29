package com.lifeisfinite;

import android.app.ListActivity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();       //получить ресурсы
        int finish_age = resources.getInteger(R.integer.finish_age);
        int start_age = resources.getInteger(R.integer.start_age);
        String[] ages = new String[finish_age - start_age + 1];
        for (int i = 0; i < ages.length; i++)
            ages[i] = (new Integer(i + start_age)).toString();

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ages);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(), "Вы выбрали " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
