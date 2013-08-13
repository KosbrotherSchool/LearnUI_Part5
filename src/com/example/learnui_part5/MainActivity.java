package com.example.learnui_part5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button buttonConfirm;
	private String stringOrder = "你點了:";
	private String stringPay = "用現金付款!";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonConfirm = (Button) findViewById(R.id.button_confirm);
		buttonConfirm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, stringOrder + stringPay,
						Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onCheckboxClicked(View view) {
		// Is the view now checked?
		boolean checked = ((CheckBox) view).isChecked();

		// Check which checkbox was clicked
		switch (view.getId()) {
		case R.id.checkbox_hotpot:
			if (checked) {
				stringOrder = stringOrder + "火鍋,";
			} else {
				stringOrder = stringOrder.replace("火鍋,", "");
			}
			break;
		case R.id.checkbox_hamburger:
			if (checked) {
				stringOrder = stringOrder + "漢堡,";
			} else {
				stringOrder = stringOrder.replace("漢堡,", "");
			}
			break;
		case R.id.checkbox_spaghetti:
			if (checked) {
				stringOrder = stringOrder + "義大利麵,";
			} else {
				stringOrder = stringOrder.replace("義大利麵,", "");
			}
			break;
		}
	}

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch (view.getId()) {
		case R.id.radio_cash:
			if (checked)
				stringPay = "用現金付款!";
			break;
		case R.id.radio_card:
			if (checked)
				stringPay = "用信用卡付款!";
			break;
		}
	}

}
