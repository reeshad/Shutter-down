package com.example.listviewexample;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	String text1 = new String();
	
    String [] data = new String[] {"Adabor",
    		"Badda",
    		"Biman Bandar",
    		"Bangshal",
    		"Cantonment",
    		"Chawkbazar Model",
    		"Dakshinkhan",
    		"Darus Salam",
    		"Dhanmondi",
    		"Demra",
    		"Kotwali",
    		"Gendaria",
    		"Gulshan",
    		"Hazaribagh",
    		"Jatrabari",
    		"Kadamtali",
    		"Kafrul",
    		"Kalabagan",
    		"Kamringir Char",
    		"Khilkhet",
    		"Khilgaon",
    		"Lalbagh",
    		"Mirpur",
    		"Mohammadpur",
    		"Motijheel",
    		"New Market",
    		"Pallabi",
    		"Paltan",
    		"Ramna",
    		"Rampura",
    		"Sabujbagh",
    		"Shah Ali",
    		"Shahbagh",
    		"Sher-e-Bangla Nagor",
    		"Shyampur",
    		"Sutrapur",
    		"Tejgaon",
    		"Tejgaon Industrial Area",
    		"Turag",
    		"UttarKhan",
    		"Uttara"};
    int i[] = {R.drawable.badda_map,R.drawable.bimanbandar_thana,R.drawable.bar,
    		R.drawable.cantonment_thana,R.drawable.khu,R.drawable.bar,
    		R.drawable.dhk,R.drawable.dhanmondi_thana,R.drawable.demra_thana,
    		R.drawable.kotwali_thana,R.drawable.khu,R.drawable.gulshan_thana,
    		R.drawable.hazaribagh,R.drawable.khu,R.drawable.bar,
    		R.drawable.kafrul_thana,R.drawable.khu,R.drawable.kamrangirchar_thana,
    		R.drawable.dhk,R.drawable.khilgaon,R.drawable.bar,
    		R.drawable.mirpur_thana,R.drawable.mohammadpur_thana,R.drawable.motijheel_thana,
    		R.drawable.dhk,R.drawable.pallabi_thana,R.drawable.bar,
    		R.drawable.ramna_thana,R.drawable.khu,R.drawable.sabujbagh_thana,
    		R.drawable.dhk,R.drawable.shyampur_thana,R.drawable.sutrapur_thana,
    		R.drawable.tejgaon_thana,R.drawable.khu,R.drawable.bar,
    		R.drawable.dhk,R.drawable.uttara_thana,R.drawable.bar,
    		R.drawable.khu};
    
	 Point p;
	 //TextView tv2 = (TextView) findViewById(R.id.textView2);
	 
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        ListView ls1 = (ListView) findViewById(R.id.list);
       final MyAdapter ad = new MyAdapter(MainActivity.this,data,i);
        
        ls1.setAdapter(ad);
        
        ls1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
                //Toast.makeText(MainActivity.this,"Item Clicked :"+ad.getItem(position), Toast.LENGTH_LONG).show();
				

				
				//text1 = data[position];

	
				//tv2.setText(text1);

			       if (p != null)
			           showPopup(MainActivity.this, p, Integer.valueOf(ad.getItem(position).toString()), ad.getItem2(position).toString());
			       
			       		
			       
			         
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
	public void onWindowFocusChanged(boolean hasFocus) {

	   int[] location = new int[2];
	  // Button button = (Button) findViewById(R.id.show_popup);

	   // Get the x, y location and store it in the location[] array
	   // location[0] = x, location[1] = y.
	  // button.getLocationOnScreen(location);

	   //Initialize the Point with x, and y positions
	   p = new Point();
	   p.x = location[0];
	   p.y = location[1];
	}

	// The method that displays the popup.
	private void showPopup(final Activity context, Point p ,int j,String a) {
	   int popupWidth = 250;
	   int popupHeight = 250;

	   // Inflate the popup_layout.xml
	   LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
	   LayoutInflater layoutInflater = (LayoutInflater) context
	     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   View layout = layoutInflater.inflate(R.layout.popup_layout, viewGroup);

	   TextView tv0 = (TextView) layout.findViewById(R.id.textView2);
	   ImageView iv0 = (ImageView) layout.findViewById(R.id.imageView2);
	   
	   Typeface tf = Typeface.createFromAsset(getAssets(),"font/AnglicanText.ttf");
	   tv0.setTypeface(tf);
	   
	   iv0.setImageResource(j);
	   
	   tv0.setText(a);
	   
	   
	   
	   
	   // Creating the PopupWindow
	   final PopupWindow popup = new PopupWindow(context);
	   popup.setContentView(layout);
	   popup.setWidth(popupWidth);
	   popup.setHeight(popupHeight);
	   popup.setFocusable(true);

	   // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
	   int OFFSET_X = 30;
	   int OFFSET_Y = 30;

	   // Clear the default translucent background
	   popup.setBackgroundDrawable(new BitmapDrawable());

	   // Displaying the popup at the specified location, + offsets.
	   popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);

	   // Getting a reference to Close button, and close the popup when clicked.
	   Button close = (Button) layout.findViewById(R.id.close);
	   close.setOnClickListener(new OnClickListener() {

	     @Override
	     public void onClick(View v) {
	       popup.dismiss();
	     }
	   });
	}
}


