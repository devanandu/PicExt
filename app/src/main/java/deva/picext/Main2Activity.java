package deva.picext;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    List<String> names=new ArrayList<>();
    ArrayAdapter<CharSequence> adapter;
    ListView list;
    Spinner spin;
    ArrayAdapter<String> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list=(ListView)findViewById(R.id.list);
        spin=(Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.places, android.R.layout.select_dialog_item);
        spin.setAdapter(adapter);
        //load();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DB d=new DB(getApplicationContext());

               // Toast.makeText(Main2Activity.this,d.attend(array.getItem(position).toString()),Toast.LENGTH_LONG).show();
            }
        });
    }
//    void load(){
//        e1=(EditText)f
//        String ab;
//        t1=(TextView)findViewById(R.id.stud);
//        DB d=new DB(this);
//        ab=d.view()
//        //Cursor c=d.all();
//        while(c.moveToNext())
//        {
//            names.add(c.getString(0));
//        }
//        array=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,names);
//        list.setAdapter(array);
//        spin.setAdapter(array);
//    }
}
