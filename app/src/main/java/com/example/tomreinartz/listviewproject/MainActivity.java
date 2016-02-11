package com.example.tomreinartz.listviewproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.util.Log;
import android.content.Intent;
import android.widget.EditText;

import static com.example.tomreinartz.listviewproject.R.id.textView1;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Here is your message: ";

    public static final String KEY="theKey!";
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

        String[] dinosaurs = {"Velociraptors", "Triceratops", "Stegosaurus", "T-Rex", "Brachiosaurus", "Allosaurus", "Apatosaurus"};
        // ListAdapter theAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dinosaurs);
        //ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.textView1, dinosaurs);
        ListAdapter theAdapter = new MyAdapter(this, dinosaurs);
        ListView theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(theAdapter);
        mEditText=(EditText)findViewById(R.id.edit_text);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String s = "You clicked on" + String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                //intent.putExtra(KEY,mEditText.getText().toString());
                intent.putExtra(KEY,s);
                startActivity(intent);
                //this is now in git
            }
        });
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
