package com.example.zakatgoldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAboutUs, btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        btnCalculate = (Button) findViewById(R.id.btnCalHomepage);

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutActivity();
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalculator();
            }
        });
    }
    public void openAboutActivity(){
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }
    public void openCalculator(){
        Intent intent1 = new Intent(this,ZakatCalculator.class);
        startActivity(intent1);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//
//        return  true;
//    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);

                startActivity(intent);

                break;

            case R.id.calculator:
                Intent intent1 = new Intent(this, ZakatCalculator.class);

                startActivity(intent1);

               break;
        }

        return super.onOptionsItemSelected(item);
    }
}