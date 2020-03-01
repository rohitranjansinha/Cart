package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView img1,img2;
    private Button cart;
    public MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new MyDBHandler(this, null, null, 1);
        //dbHandler.databaseToString();
        cart = (Button)findViewById(R.id.gotocart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printDatabase();
            }
        });

        img1 = (ImageView)findViewById(R.id.biscuit);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int shelf = 7;
                String title = "Biscuits";
                Products product = new Products(title,shelf);

                dbHandler.addProduct(product);
                Toast.makeText(getApplicationContext(),"Added to Cart", Toast.LENGTH_SHORT).show();
               // printDatabase();
            }
        });

        img2 = (ImageView)findViewById(R.id.cold_drink);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int shelf = 10;
                String title = "Cold Drink";
                Products product = new Products(title,shelf);

                dbHandler.addProduct(product);
                Toast.makeText(getApplicationContext(),"Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void printDatabase(){
        String data = dbHandler.findData();

        Intent intent = new Intent(getApplicationContext(), Cart.class);
        intent.putExtra("data", data);
        startActivity(intent);

    }
    @Override
    public void onDestroy()
    {
        dbHandler.deleteProduct();
        super.onDestroy();
    }

}
