package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private DBAccess dbaccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_report );

        dbaccess = new DBAccess( this );
        List<Item> items = dbaccess.getItemList();

        /* データの取得 */
        List<String> itemList = new ArrayList<>();
        for(Item item : items){
            itemList.add(item.toString());
        }

// アダプターの準備とリストへのセット
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, itemList);
        ListView list = findViewById(R.id.itemList);
        list.setAdapter(adapter);
    }

    public void onClickClearButton(View view) {
// データの消去
        dbaccess.deleteAllItems();
        Toast.makeText(this, "記録を消去しました",
                Toast.LENGTH_SHORT).show();
// 画面を閉じる
        finish();
    }
}

