package com.example.project1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView mainText;
	TextView userText;
	TextView dataType;
	EditText textEdit;
	Button btn;
	LinearLayout mainLayout;
	String userInput;
	String userNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Creates an alert dialog to let the user know which names are required
		// in order to test the app
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setMessage(R.string.title_title)
				.setTitle(R.string.dialog_fire_missiles)
				.setPositiveButton(R.string.fire,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {

							}
						})
				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								// User cancelled the dialog
							}
						});
		// Return alert box
		builder.show();

		// --------Create Linear Layout-----------

		// instantiates and then creates new context or activity
		mainLayout = new LinearLayout(this);
		// allows buttons, text etc stack on top of one another
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		// set params
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		// add params to main layout
		mainLayout.setLayoutParams(lp);

		// ---------Create Text View--------------

		mainText = new TextView(this);
		// Changes width and height : only be as high as content allows
		lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		mainText.setLayoutParams(lp);
		mainText.setText(R.string.main_text);
		mainLayout.addView(mainText);

		// ---------Create Edit Text--------------

		textEdit = new EditText(this);
		lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		textEdit.setHint("What's your name?");
		textEdit.setLayoutParams(lp);
		mainLayout.addView(textEdit);

		// --------Create Button For OnClick--------

		btn = new Button(this);
		lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		btn.setText(R.string.button_text);
		mainLayout.addView(btn);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				userInput = textEdit.getText().toString();
				if (userInput.contains("Josh")) {
					// Show it is inside box 1
					userText.setText(String.valueOf("Your Cool and "
							+ "Your Coolness level is:" + userNum));

				} else if (userInput.contains("Gyasi")) {
					// Show it is inside box 2
					// Log.i(userInput, "your awesome.");
					userText.setText(String
							.valueOf("Your Really Awesome Dude!!! "
									+ "Your Coolness level is:" + userNum));

				} else if (userInput.contains("Desire")) {
					userText.setText(String
							.valueOf("Im so AWESOME and I GET JAVA!!! "
									+ "Your Coolness level is:" + userNum));
				} else if (userInput.contains("")) {
					userText.setText(String.valueOf("Please enter a name."));

				}
			}

		});

		// ---------Create Second Text View--------------

		userText = new TextView(this);
		// Changes width and height : only be as high as content allows
		lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		userText.setLayoutParams(lp);
		mainLayout.addView(userText);

		setContentView(mainLayout);
	}

}
