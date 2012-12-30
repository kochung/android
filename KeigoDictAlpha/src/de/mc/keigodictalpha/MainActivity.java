package de.mc.keigodictalpha;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

// for zoho test
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


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
		
		System.out.println("Test");
		
		/*
		// zoho test
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.zoho.cloudsql.jdbc.ZohoReportsDriver");
			Properties conProps = new Properties(); 
            
			conProps.put("ZOHO_API_KEY","8482375e9dc9494e26dfdfd942dc0425");
			// Zoho username to login to Zoho service
			conProps.put("user","kochung");
			// Zoho password to login to Zoho service
			conProps.put("password","Honkon83");
			/* Important Note: Connection is single threaded in Zoho Reports */
		/*
			// kochung is the owner of the database 'KeigoDict'
			con = DriverManager.getConnection("https://reportsapi.zoho.com/" + 
			"api/kochung/KeigoDict",conProps);
			stmt = con.createStatement();
			String sql ="select * from plainList";
			rs = stmt.executeQuery(sql);
			
			//while (rs.next()) {
		    //    String plain = rs.getString("plain");
		    //    String plainRomaji = rs.getString("plain_romaji");
		    //    String vocabType = rs.getString("vocab_type");
		    //    System.out.println(plain + " " + plainRomaji + " " + vocabType);
			//}
			
			sonkeigo.setText("îCñ±");
			kenjogo.setText("äÆê¨");
		}
		catch(SQLException se) {
			// handle any errors
			System.out.println("SQLException: " + se.getMessage());
			System.out.println("Zoho Reports Error code: " + se.getErrorCode());
			
			sonkeigo.setText("SQL Fail");
			kenjogo.setText("SQL Fail");
		}
		catch(Exception e) {
			// handle the exception
			System.out.println("Exception: " + e.getMessage());
			sonkeigo.setText("Fail");
			kenjogo.setText("Fail");
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				}
				catch(SQLException sqlEx) { } // ignore 
			}
			if(stmt != null) {
				try {
					stmt.close();
				}
				catch (SQLException sqlEx) { } // ignore
			}
			if(con != null) {
				try {
					con.close();
				}
				catch (SQLException sqlEx) { } // ignore
			}
		}
		*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
