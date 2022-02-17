package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;
    String getPcode,getPname,getPrice;
    Databasehelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        dbhelper=new Databasehelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.Pcode);
        ed2=(EditText) findViewById(R.id.Pname);
        ed3=(EditText) findViewById(R.id.Price);
        b1=(AppCompatButton) findViewById(R.id.Sub);
        b2=(AppCompatButton)findViewById(R.id.BTM);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPcode=ed1.getText().toString();
                getPname=ed2.getText().toString();
                getPrice=ed3.getText().toString();
                boolean result=dbhelper.insertData(getPcode,getPname,getPrice);
                if (result==true)
                {
                    Toast.makeText(getApplicationContext(), "Product are inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}