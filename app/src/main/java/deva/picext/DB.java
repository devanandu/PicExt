package deva.picext;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deva on 06/07/17.
 */

public class DB extends SQLiteOpenHelper {
    public DB(Context context) {
        super(context,"database",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table parent(name text,pass text,child text)");
        db.execSQL("create table student(name text,attendence text)");

    }

    String view(String name,String pass)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select p.name,pass,child,attendence from parent p,student s where p.name='"+name+"' and child=s.name",null);
        //Cursor c=db.rawQuery("select * from parent where name='"+name+"' ",null);
        c.moveToFirst();
        if(c.getCount()==0)
            return "No Such username";
        else if(pass.equals(c.getString(1)))
            return c.getString(2)+" has attendence "+c.getString(3) ;
        else
            return "Incorrect password";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    Cursor all()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from student",null);
        return c;
    }
    String attend(String name)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select attendence from student where name='"+name+"' ",null);
        c.moveToFirst();
        return c.getString(0);

    }
}
