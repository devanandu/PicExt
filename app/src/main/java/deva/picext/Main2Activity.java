package deva.picext;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    List<String> names=new ArrayList<>();
    ListView list;
    Spinner spin;
    ArrayAdapter<String> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list=(ListView)findViewById(R.id.list);
        spin=(Spinner)findViewById(R.id.spinner);
        load();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DB d=new DB(getApplicationContext());

                Toast.makeText(Main2Activity.this,"gfhjk",Toast.LENGTH_LONG);
            }
        });
    }
    void load(){
        DB d=new DB(this);
        Cursor c=d.all();
        while(c.moveToNext())
        {
            names.add(c.getString(0));
        }
        array=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        list.setAdapter(array);
        spin.setAdapter(array);
    }
}
