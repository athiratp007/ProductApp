package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper  extends SQLiteOpenHelper {
    static String Dbname="Product.db";
    static String Tablename="Product";
    static String col1="id";
    static String col2="Pcode";
    static  String col3="Pname";
    static  String col4="Price";

    public Databasehelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+
        col2+ " text,"+
        col3+ " text,"+
        col4+ " text )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String Pcode,String Pname,String Price)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(col2,Pcode);
        c.put(col3,Pname);
        c.put(col4,Price);
        long status= db.insert(Tablename,null,c);
        if(status==-1) {
            return false;
        }
        else {
            return true;

        }



    }


    public Cursor SearchData( String Pcode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+Tablename+
        " where "+col2+"='"+Pcode+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
}

