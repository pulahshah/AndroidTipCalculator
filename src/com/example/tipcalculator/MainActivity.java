package com.example.tipcalculator;

import java.math.BigDecimal;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Float enteredAmount = 0.0f;
	Float tipAmount = 0.0f;
	EditText et_amount;
	TextView tv_finalAmount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calculateTip(View v){
		et_amount = (EditText)findViewById(R.id.et_enterAmount);
		
		if(et_amount.getText().toString().equals("")){
			Toast.makeText(getApplicationContext(), "Enter the bill amount", Toast.LENGTH_SHORT).show();
		}
		else{
			enteredAmount = Float.parseFloat(et_amount.getText().toString());
			Log.d("Entered amount", enteredAmount.toString());
			
			switch(v.getId()){
			case R.id.btn_tenPercent:
				tipAmount = (enteredAmount * 10)/100;
				break;
			case R.id.btn_fifteenPercent:
				tipAmount = (enteredAmount * 15)/100;
				break;
			case R.id.btn_twentyPercent:
				tipAmount = (enteredAmount * 20)/100;
				break;
			default:
				throw new RuntimeException("Unknow button ID");
			}
			
			// display the tip amount
			tv_finalAmount = (TextView)findViewById(R.id.tv_tipAmount);
			BigDecimal result = round(tipAmount, 2);
			Log.d("Result", result+"");
			
			tv_finalAmount.setText("$" + result.toString());
		}
	}

	public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
        return bd;
    }	
		
}
