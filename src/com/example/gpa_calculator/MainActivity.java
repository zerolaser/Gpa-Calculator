package com.example.gpa_calculator;

import java.util.ArrayList;

import android.R.layout;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener,OnClickListener {
	LinearLayout mainLayout;
	Button calc,reset,addClass,addSem;
	TextView classNum,semNum;
	int classint=1,semint=1;
	Spinner gpaSpin, creditSpin;
	ArrayList<String> gpaStore,creditStore;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
		gpaStore = new ArrayList<String>();
		creditStore = new ArrayList<String>();
		
		
		calc = (Button) findViewById(R.id.calc);
		reset = (Button) findViewById(R.id.reset);
		addClass = (Button) findViewById(R.id.addClass);
		addSem = (Button) findViewById(R.id.addSem);
		
		calc.setOnClickListener(this);
//		new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "You clicked Calculate" , Toast.LENGTH_SHORT).show();
//				for(int i=0;i<2;i++)
//				{
//				
////				gpaSpin.get
//				
//				Toast.makeText(getApplicationContext(), gpaSpin.getId()+""+creditSpin.getId(), Toast.LENGTH_SHORT).show();
//				
//				}
//
//			}
//		});
		reset.setOnClickListener(this);
//		new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "You clicked Reset" , Toast.LENGTH_LONG).show();
//
//			}
//		});
		addClass.setOnClickListener(this);
//				new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "You clicked Add a class" , Toast.LENGTH_LONG).show();
//
//			}
//		});
		addSem.setOnClickListener(this);
//				new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "You clicked add a semester" , Toast.LENGTH_LONG).show();
//
//			}
//		});
		
			addSemester();
			
		}

	public void addSemester()
	{
			classint=1;
			if(semint!=1)
			{
				LinearLayout lineLayout= new LinearLayout(this);
				lineLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				View view = new View(this);
				view.setBackgroundColor(getResources().getColor(android.R.color.black));
				view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,5));
				lineLayout.addView(view);
				mainLayout.addView(lineLayout);
	
			}
			LinearLayout semLayout = new LinearLayout(this);
			semLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			semNum = new TextView(this);
			semNum.setText("Semester "+semint+" :");
			semint++;
			semLayout.addView(semNum);
			mainLayout.addView(semLayout);
			for(int i=0;i<2;i++)
			{
					addClass(classint++);
			}
		}
	public void addClass(int i)
	{
		LinearLayout l1 = new LinearLayout(this);
		l1.setOrientation(LinearLayout.HORIZONTAL);
		l1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			classNum = new TextView(this);
			classNum.setText("Class "+i+" ");
			gpaSpin = new Spinner(this);
			gpaSpin.setId(100+i);
			ArrayAdapter<CharSequence> gpaAdapter = ArrayAdapter.createFromResource(this,R.array.Gpa,android.R.layout.simple_spinner_dropdown_item);
			gpaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			gpaSpin.setAdapter(gpaAdapter);
			gpaSpin.setLayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.5f));
			gpaSpin.setOnItemSelectedListener(this);
	//		spinner.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,0.5f));
			
			creditSpin =new Spinner(this);
			creditSpin.setId(200+i);
			ArrayAdapter<CharSequence> creditAdapter = ArrayAdapter.createFromResource(this,R.array.credit,android.R.layout.simple_spinner_item);
			creditAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			creditSpin.setLayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.5f));
			creditSpin.setAdapter(creditAdapter);
			creditSpin.setOnItemSelectedListener(this);
			
			l1.addView(classNum);
			l1.addView(gpaSpin);
			l1.addView(creditSpin);
			mainLayout.addView(l1);
			
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	
	public void onItemSelected(AdapterViewCompat<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
//		Toast.makeText(getApplicationContext(), (CharSequence) arg0.getItemAtPosition(arg2),Toast.LENGTH_SHORT).show();
		
	}

	public void onNothingSelected(AdapterViewCompat<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		double gpaint = 0,creditint,totalGradePts=0,FinalGpa,totCredits=0;
		if(v.getId()==R.id.calc)
		{
//			Toast.makeText(getApplicationContext(), "You clicked Calculate" , Toast.LENGTH_SHORT).show();
			for(int i=0 ;i<gpaStore.size();i++)
			{
				if(gpaStore.get(i).equals("A"))
				{
						gpaint=4;
				}
				else if(gpaStore.get(i).equals("A-"))
				{
						gpaint=3.7;
				}
				else if(gpaStore.get(i).equals("B+"))
				{
						gpaint=3.3;
				}
				else if(gpaStore.get(i).equals("B"))
				{
						gpaint=3.0;
				}
				else if(gpaStore.get(i).equals("B-"))
				{
						gpaint=2.7;
				}
				else if(gpaStore.get(i).equals("C+"))
				{
						gpaint=2.3;
				}
				else if(gpaStore.get(i).equals("C"))
				{
					gpaint=2.0;
				}
				else if(gpaStore.get(i).equals("C-"))
				{
						gpaint=1.7;
				}
				else if(gpaStore.get(i).equals("D"))
				{
						gpaint=1.0;
				}
				else if(gpaStore.get(i).equals("F"))
				{
						gpaint=0.0;
				}
				
			
				
				creditint= Integer.parseInt(creditStore.get(i));
				totCredits+=creditint;
				totalGradePts += gpaint* creditint;
				
			}
			FinalGpa = totalGradePts/totCredits;
			Toast.makeText(getApplicationContext(), "Final Gpa "+FinalGpa, Toast.LENGTH_SHORT).show();
			
			
		}
		if(v.getId()==R.id.reset)
		{
            startActivity(new Intent(MainActivity.this, MainActivity.class));

		}
		if(v.getId()==R.id.addClass)
		{
			addClass(classint);
			classint++;
//			Toast.makeText(getApplicationContext(), "You clicked Reset" , Toast.LENGTH_SHORT).show();

		}
		if(v.getId()== R.id.addSem)
		{
//			Toast.makeText(getApplicationContext(), "You clicked add a semester" , Toast.LENGTH_SHORT).show();
			addSemester();
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Spinner spinner = (Spinner)parent;
//		System.out.println(parent.getItemAtPosition(arg2)+"Im printing here"+parent.getItemIdAtPosition(arg2)+" "+spinner.getId());
		String temp = (String) spinner.getItemAtPosition(arg2);
		if(spinner.getId()<200)
		{
			gpaStore.add(temp);
		}
		else 
		{
			creditStore.add(temp);
		}
//		Toast.makeText(getApplicationContext(), (CharSequence) parent.getItemAtPosition(arg2)+""+spinner.getId(),Toast.LENGTH_SHORT).show();
			
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
