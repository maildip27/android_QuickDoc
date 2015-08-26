package com.example.quickdoc;

import java.util.ArrayList;
import java.util.Arrays;

import com.ibm.mobile.services.cloudcode.IBMCloudCode;
import com.ibm.mobile.services.core.IBMBluemix;
import com.ibm.mobile.services.data.IBMData;
import com.ibm.mobile.services.push.IBMPush;

import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements android.widget.AdapterView.OnItemClickListener {

	ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	try{
        	IBMBluemix.initialize(getApplicationContext(), "f9c83509-b791-4897-b3b9-5614b77ff4ac", "311827ec4e5cc7b38b7ef5532ea7ef6cdc872c37", "http://quickdoc.eu-gb.mybluemix.net");
        	IBMCloudCode.initializeService();
        	IBMData.initializeService();
        	IBMPush.initializeService();
        	Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_LONG).show();
        	}catch(Exception e){
        		Toast.makeText(getApplicationContext(), "DisCon", Toast.LENGTH_LONG).show();
        	}
    	String[] st = getResources().getStringArray(R.array.country_arrays);
    	
    	Log.d("Main", String.valueOf(st.length));
    	ArrayList<String> ar = new ArrayList<String>(Arrays.asList(st));
    	/*ar.add("Item1");
    	ar.add("Item2");
    	ar.add("Item3");*/
    	ArrayAdapter<String> adap = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,ar);
    	Log.d("Main", "Entering");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.diease);
        lv.setAdapter(adap);
        Log.d("Main", "Entering");
        lv.setOnItemClickListener(new OnItemClickListener() {
        	
        	public void onItemClick(AdapterView <?> adapter,View v,int position,long arg3)
        	{
        		/*String value = (String)adapter.getItemAtPosition(position);
        		Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();*/
        		Intent intent = new Intent(MainActivity.this, Map.class);
        		intent.putExtra("disease", position);
        		startActivity(intent);
        	}
		});
        
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


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
}
