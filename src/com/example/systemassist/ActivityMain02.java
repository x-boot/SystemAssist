package com.example.systemassist;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.app.AlertDialog;

public class ActivityMain extends Activity {
	
	private Button btn_actyMain_reboot=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try{
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}catch(Exception e){
			new AlertDialog.Builder(ActivityMain.this).setTitle("Err").setMessage(e.getMessage()).setPositiveButton("ok", null).show();
		}
		setContentView(R.layout.layout_main);
		btn_actyMain_reboot=(Button)findViewById(R.id.btn_actyMain_reboot);
		btn_actyMain_reboot.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strCmd="su -c reboot";
				try{
					Runtime.getRuntime().exec(strCmd);
				}catch(IOException e){
					new AlertDialog.Builder(ActivityMain.this).setTitle("Err").setMessage(e.getMessage()).setPositiveButton("ok", null).show();
				}
	            
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
