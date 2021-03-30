package de.queaker.flightmodeswitch;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class SwitchOnActivity extends Activity {

	private static final String TAG = "SwitchOnActivity";
	private boolean D = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (D) Log.d(TAG, "onCreate()");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		if (D) Log.d(TAG, "onStart()");
		if (D) Log.d(TAG, "Airmode is " + Common.isAirplaneModeEnabled(getBaseContext()));
		
		Toast.makeText(this, "Airmode on", Toast.LENGTH_LONG).show();
		Common.enableAirplaneMode(getBaseContext());
		
		finish();
	}

}
