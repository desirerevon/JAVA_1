package com.desirerevon.project3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
//import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	//API with API Key
	//http://www.behance.net/v2/users?field=blogging&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7
	
	static String TAG = "NETWORK DATA - MAINACTIVITY";
	
	Context mContext;
	String[] dListItems;
	public static String _urlString = "";
	static TextView connectionView;
	TextView apiText;
	Spinner viewSpinner;
	Intent intent;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Initialize Constants
        mContext = this;
        dListItems = getResources().getStringArray(R.array.view_array);
        
       
        //Create Linear Layout
        LinearLayout layoutMain = new LinearLayout(mContext);
        layoutMain.setOrientation(LinearLayout.VERTICAL);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutMain.setLayoutParams(lp);
        
        //Title Text View
        TextView headerText = new TextView(mContext);
        headerText.setText(R.string.header_text);
        headerText.setTextSize(30);
        LayoutParams hView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        headerText.setLayoutParams(hView);
        
        
        //Title Second Text View
        TextView infoText = new TextView(mContext);
        infoText.setText(R.string.info_text);
        infoText.setTextSize(20);
        LayoutParams iView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        infoText.setLayoutParams(iView);
        
        
        //Text View For API output
        apiText = new TextView(mContext);
        LayoutParams aView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        apiText.setLayoutParams(aView);
        
        
        

        //Create Array Adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, dListItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    
       //Create A Spinner : Call spinner class
        viewSpinner = new Spinner(mContext);
        viewSpinner.setAdapter(spinnerAdapter);
        lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        viewSpinner.setLayoutParams(lp);
        viewSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
        	

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				

				if(position == 1){
						
					intent = new Intent(Intent.ACTION_VIEW, 
			Uri.parse("http://www.behance.net/v2/users?field=art+direction&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
								   		 startActivity(intent);
								   		 
								   		 
								   		 
				

				}else if(position == 2){
						
							 intent = new Intent(Intent.ACTION_VIEW, 
									 Uri.parse("http://www.behance.net/v2/users?field=blogging&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
									   		 startActivity(intent);
									   		 
					
				}else if(position == 3){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=branding&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 4){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=computer+animation&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 5){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=design&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 6){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=fashion&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 7){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=game+design&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 8){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=graphic+design&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 9){
					
					 intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=programming&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
				}else if(position == 10){
					
					intent = new Intent(Intent.ACTION_VIEW, 
							 Uri.parse("http://www.behance.net/v2/users?field=toy+design&api_key=Tr2Xe21p4yLOeY7DXGZuMom6VOI5a4i7"));
							   		 startActivity(intent);
							   		 
							   		 
							
						}
					}
				
        
	
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

		
        	
        	
        });
        
        
	
        
        //****** NETWORK CONNECTION *********//
   
        //Connection Text Alert View
        connectionView = new TextView(mContext);
        connectionView.setLayoutParams(lp);
        if(connectionStatus(mContext)){
        	getData data = new getData();
        	data.execute(_urlString);
        	//connectionView.setText("You have connected to the internet");
        }else{
        	connectionView.setText("Please check your internet connection");
        }
        
        
        //Add Layout Views : keep in order
        layoutMain.addView(connectionView);
        setContentView(layoutMain);
        layoutMain.addView(headerText);
        layoutMain.addView(infoText);
        layoutMain.addView(viewSpinner);
        //layoutMain.addView(btn);
        layoutMain.addView(apiText);

}
	
    public Boolean connectionStatus(Context context){
    	Boolean conn = false;
    	ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo ni = cm.getActiveNetworkInfo();
    	if(ni != null){
    		if(ni.isConnected()){
    			Log.i(TAG, "Connection Type: " + ni.getTypeName());
    			conn= true;
    		}
    	}
    	return conn;
    }
    
    
    

    
    
    
    //Create Class to Pull Data From URL
    
    public static String getResponse(URL url){
    	//capture response from call
    	String response = "";
    	try {
			URLConnection conn = url.openConnection(); //opens connection to url
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			//create class to keep track of how much data being pulled
			byte[] contextByte = new byte[1024];
			//keeps track of bytes read
			int byteRead= 0;
			//used to append data while pulling
			StringBuffer responseBuffer = new StringBuffer();
			//Take data from url and put into string buffer
			while ((byteRead = bin.read(contextByte)) != -1){
				response = new String(contextByte, 0 , byteRead);
				responseBuffer.append(response);
			}
			response = responseBuffer.toString();
			Log.i(TAG, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//App wont crash with returned error
			response = "There was an error retrieving data.";
			//error
			Log.e(TAG, "Something went wrong", e); //always use ,e to print error
		}
    	
    	return response;
    }
    
    
    //Network alls have to be handled in AsyncTask
    static class getData extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			//Call response string
			String responseString = "";
			try {
				//set it to url 
				URL url = new URL(_urlString);
				//return the response
				responseString = getResponse(url);
			} catch (MalformedURLException e) {
				responseString = "Something went wrong again";
				Log.e(TAG, "Error: ", e);
				e.printStackTrace();
			}
			return responseString;
			
			
		}
		
		@Override
		protected void onPostExecute(String result) {
			connectionView.setText(result);
			super.onPostExecute(result);
		}
    	
    	
    }
         //****** NETWORK CONNECTION *********//
  
	
} 