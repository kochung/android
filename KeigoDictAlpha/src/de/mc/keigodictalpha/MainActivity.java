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
import java.io.InputStream;
import java.io.Reader;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class MainActivity extends Activity {
	private EditText inputText;
	private EditText sonkeigo;
	private EditText kenjogo;
	private String urlQuery;
	
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
		
		urlQuery = "https://reportsapi.zoho.com/api/kochung/KeigoDict/plainList?ZOHO_ACTION=EXPORT&ZOHO_OUTPUT_FORMAT=JSON&ZOHO_ERROR_FORMAT=XML&ZOHO_API_KEY=8482375e9dc9494e26dfdfd942dc0425&ZOHO_API_VERSION=1.0";
		try {
			URL url = new URL(urlQuery);
			HttpURLConnection con = (HttpURLConnection) url
					.openConnection();
			//readStream(con.getInputStream());
			
			InputStream source = con.getInputStream();
			Gson gson = new Gson();
			Reader reader = new InputStreamReader(source);
			//gson.fromJson(reader, );
			
		} catch (Exception e) {
	  		e.printStackTrace();
	  	}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void readStream(InputStream in) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
		    String line = "";
		    while ((line = reader.readLine()) != null) {
		      System.out.println(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
		        }
		    }
		}
	} 
	
}
