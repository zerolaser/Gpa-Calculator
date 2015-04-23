package com.example.gpa_calculator;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Toast;


public class CalActivity extends ActionBarActivity 
{
	LinearLayout containerlayout ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cal);
		Bundle extras = getIntent().getExtras();
		if(extras == null)
		{
			return;
		}
		int semester =  extras.getInt("semester");
		int classes = extras.getInt("classes");
		Toast.makeText(this, semester+" "+" "+classes, Toast.LENGTH_LONG).show();
		containerlayout = (LinearLayout) findViewById(R.id.LinearLayout2);
		ArrayList<String> gpaList = new ArrayList<String>();
		gpaList.add(" select ");
		gpaList.add(" A+ ");
		gpaList.add(" A ");
		gpaList.add(" A- ");
		gpaList.add(" B+");
		gpaList.add(" B ");
		gpaList.add(" B- ");
		gpaList.add(" C+ ");
		gpaList.add(" C ");
		gpaList.add(" C- ");
		gpaList.add(" D ");
		gpaList.add(" F ");
		
		
		int totClass= semester*classes;
		
		for(int i=0;i< totClass;i++)
		{
			LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.HORIZONTAL);
			TextView txt = new TextView(this);
			txt.setText("Class "+i);
			layout.addView(txt);
			Spinner spinner= new Spinner(this);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,gpaList);
			spinner.setAdapter(adapter);
			spinner.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,0.5f));
			layout.addView(spinner);
//			EditText gpa = new EditText(this);
//			gpa.setId(i);
//			gpa.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,1f));
//			layout.addView(gpa);
			
			EditText credits = new EditText(this);
			credits.setInputType(InputType.TYPE_CLASS_NUMBER);
			credits.setId(i);
			credits.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,1f));
			layout.addView(credits);
			
			containerlayout.addView(layout);
			
//			et.setTag("class"+i);
			
			
		}
		
//	     EditText edText = new EditText(this);
//         edText .setId(i);
//         edText .setLayoutParams(new LinearLayout.LayoutParams(
//                 LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
//                 1f));
//
//                 edText .setWidth(100);
//         edText .setImeOptions(EditorInfo.IME_ACTION_NEXT);
//         edText .setInputType(InputType.TYPE_CLASS_NUMBER);
//         edText .setKeyListener(DigitsKeyListener.getInstance());
//         edText .setMaxLines(1);
//                 edText .setOnFocusChangeListener(this);
//         edText .setOnEditorActionListener(this);
//         edText .addTextChangedListener(this);
//
//                 //this linearlayout id is declared inside your xml file
//                     LinearLayout linear=(LinearLayout)findViewById(R.id.linearLayout1);
//                     linear.addView(edText );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
