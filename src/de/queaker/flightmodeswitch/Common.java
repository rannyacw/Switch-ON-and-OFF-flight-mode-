package de.queaker.flightmodeswitch;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

public class Common {

	public static boolean isAirplaneModeEnabled(Context context) {
		boolean isEnabled = Settings.System.getInt(
				context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON,
				0) == 1;
		return isEnabled;
	}

	public static void enableAirplaneMode(Context context) {

		if (isAirplaneModeEnabled(context) == false) {

			Settings.System.putInt(context.getContentResolver(),
					Settings.System.AIRPLANE_MODE_ON, 1);
			Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
			intent.putExtra("state", 1);
			context.sendBroadcast(intent);

		}
	}

	public static void disableAirplaneMode(Context context) {

		if (isAirplaneModeEnabled(context) == true) {

			Settings.System.putInt(context.getContentResolver(),
					Settings.System.AIRPLANE_MODE_ON, 0);
			Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
			intent.putExtra("state", 0);
			context.sendBroadcast(intent);

		}
	}
	
}
