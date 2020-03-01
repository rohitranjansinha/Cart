package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {

   // private MyDBHandler dbHandler;
    private TextView details;
  //  private Button empty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent i = getIntent();
     //   empty = (Button)findViewById(R.id.empty_cart);
        String data = i.getStringExtra("data");
        details = (TextView)findViewById(R.id.items);
        details.setText(data);



    }
}
