package com.example.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBAccess {

    private MyDBHelper helper;
    SQLiteDatabase db ;
    private static final String TABLE_NAME = "items";
    private static final String TAG= "DBAccess";

    public DBAccess(Context context){
        this.helper = new MyDBHelper(context);
        db = helper.getWritableDatabase();
    }


    public List<Item> getItemList(){
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cs =  db.rawQuery( sql,null);
        return setItem( cs );
    }

    protected void deleteAllItems(){
        db.delete("items", null, null);
    }

    private List<Item> setItem(Cursor cs){
        List<Item> items = new ArrayList<>();
        if (cs.moveToFirst()) {
            do {
                Item item = new Item(cs.getString( 1 ),
                                Integer.parseInt( cs.getString( 2 ) ));
                Log.d(TAG,item.toString());
                items.add(item);
            } while (cs.moveToNext());
        }
        return  items;
    }

    public void  insertItem(String name , int price){
        String sql = "INSERT INTO items (name, price, created) VALUES (?, ?, ?)";
        SQLiteStatement stmt = db.compileStatement(sql);

        stmt.bindString( 1,name );
        stmt.bindLong( 2,price );
        stmt.bindLong( 3,(new Date().getTime()) );

        stmt.executeInsert();
    }
}
