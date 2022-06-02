package com.example.zakatgoldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;




public class ZakatCalculator extends AppCompatActivity implements View.OnClickListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return  true;
    }

    EditText etGoldWeigth, etGoldValue;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnCalculate, btnClear;
    TextView totValGold, totPayable, totZakat, urufVal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_calculator);

        etGoldWeigth = (EditText) findViewById(R.id.etBeratg);
        etGoldValue = (EditText) findViewById(R.id.etGoldVal);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnClear = (Button) findViewById(R.id.btnClear);
        totValGold = (TextView) findViewById(R.id.totValGold);
        urufVal = (TextView) findViewById(R.id.urufVal);
        totPayable = (TextView) findViewById(R.id.totPayable);
        totZakat = (TextView) findViewById(R.id.totZakat);

        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnCalculate:
                calculate();
                break;

            case R.id.btnClear:
                etGoldWeigth.setText(" ");
                etGoldValue.setText(" ");
                totValGold.setText(" ");
                urufVal.setText(" ");
                totPayable.setText(" ");
                totZakat.setText(" ");
                break;
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.homepage:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    //show choice on radio button
    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Type of gold: " + radioButton.getText(), Toast.LENGTH_SHORT).show();

    }

    //calculation class
    public void calculate() {

        try {


            double goldGram = Double.parseDouble(etGoldWeigth.getText().toString());
            double valGold = Double.parseDouble(etGoldValue.getText().toString());
            String value = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
            double totValue, totGoldW, totNeedPay, finalTot;

            Log.d("value", value);

            if (value.equalsIgnoreCase("Keep")) {
                totValue = goldGram * valGold;
                totGoldW = goldGram - 85;

                if (totGoldW > 0) {
                    totNeedPay = totGoldW * valGold;
                    finalTot = totNeedPay * 0.025;
                } else {
                    totNeedPay = 0;
                    finalTot = 0;
                }

                //display result
                totValGold.setText("Total value of gold: " + totValue);
                urufVal.setText("Value of gold that need zakat:" + totGoldW + "g");
                totPayable.setText("Total gold value that is zakat payable: RM" + totNeedPay);
                totZakat.setText("Total Zakat: RM" + finalTot);


            } else {
                totValue = goldGram * valGold;
                totGoldW = goldGram - 200;

                if (totGoldW > 0) {
                    totNeedPay = totGoldW * totValue;
                    finalTot = totNeedPay * 0.025;
                } else {
                    totNeedPay = 0;
                    finalTot = 0;
                }

                //display result
                totValGold.setText("Total value of gold: " + totValue);
                urufVal.setText("Value of gold that need zakat:" + totGoldW + "g");
                totPayable.setText("Total gold value that is zakat payable: RM" + totNeedPay);
                totZakat.setText("Total Zakat: RM" + finalTot);

            }
        }catch (java.lang.NumberFormatException nfe){
            Toast.makeText(this,"Please input a valid number",Toast.LENGTH_SHORT).show();


        }catch (Exception exp){
            Toast.makeText(this,"Unknown exeption"+exp.getMessage(),Toast.LENGTH_SHORT).show();
            Log.d("Exeption",exp.getMessage());
        }
    }
}