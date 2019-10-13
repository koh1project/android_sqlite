package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private DBAccess dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        dbAccess = new DBAccess( this );
    }


    public void onClickAddButton(View view) {
        EditText nameEdit = findViewById(R.id.nameEdit);
        EditText priceEdit = findViewById(R.id.priceEdit);
// データの登録

//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("name", nameEdit.getText().toString());
//        values.put("price",
//                Integer.parseInt(priceEdit.getText().toString()));
//                values.put("created", (new Date()).getTime());
//        db.insert("items", null, values);

       dbAccess.insertItem( nameEdit.getText().toString(), Integer.parseInt(priceEdit.getText().toString()));

// フォームの内容をクリアする
        nameEdit.setText("");
        priceEdit.setText("");
// 品名入力にフォーカスをあわせる
        nameEdit.requestFocus();
// 完了メッセージ
        Toast.makeText(this, "登録しました", Toast.LENGTH_SHORT).show();
    }
    public void onClickReportButton(View view) {
// 記録画面を開く
        Intent i = new Intent(this, ReportActivity.class);
        startActivity(i);
    }


}
