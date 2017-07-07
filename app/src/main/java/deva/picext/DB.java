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
        super(context,"tour",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(user text,pass text)");
        db.execSQL("insert into users values('hitha','abc')");

    }

    String view(String name,String pass)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from users where user='"+name+"' ",null);
        c.moveToFirst();
        if(c.getCount()==0)
            return "Error username";
        else if(pass.equals(c.getString(1)))
            return "success";
        else
            return "Incorrect password";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    void all()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("insert into users values('deva','abc')");
        Cursor c=db.rawQuery("select * from users",null);
    }

}