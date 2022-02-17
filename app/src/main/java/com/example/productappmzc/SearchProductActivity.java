package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchProductActivity extends AppCompatActivity {


    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;

    Databasehelper dbhelper;
    String getPcode,getPname,getPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        dbhelper=new Databasehelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.Pcode);
        ed2=(EditText) findViewById(R.id.Pname);
        ed3=(EditText) findViewById(R.id.Price);
        b1=(AppCompatButton) findViewById(R.id.srch);
        b2=(AppCompatButton) findViewById(R.id.BTM);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPcode=ed1.getText().toString();

                Cursor c=dbhelper.SearchData(getPcode);

                if(c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid Product code", Toast.LENGTH_SHORT).show();


                }
                else
                {
                    while(c.moveToNext())
                    {
                        getPname=c.getString(2);
                        getPrice=c.getString(3);
                    }
                    ed2.setText(getPname);
                    ed3.setText(getPrice);
                }

            }
        });

    }
}