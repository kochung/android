package de.mc.keigodictalpha;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainActivity extends Activity {
	private EditText inputText;
	private EditText sonkeigo;
	private EditText kenjogo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inputText = (EditText) findViewById(R.id.editText1);
		sonkeigo = (EditText) findViewById(R.id.editText2);
		kenjogo = (EditText) findViewById(R.id.editText3);
	}

	public void onClick(View view) {
		
		if (inputText.getText().length() == 0) {
			Toast.makeText(this, "Please enter some text", Toast.LENGTH_LONG).show();
			return;
	    }
		
		String inputString = inputText.getText().toString();
		sonkeigo.setText(inputString);
		kenjogo.setText(inputString);
		
		System.out.println("Test Mac");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public static String httpGet(String urlStr) throws IOException {
		  URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  return sb.toString();
		}

}
