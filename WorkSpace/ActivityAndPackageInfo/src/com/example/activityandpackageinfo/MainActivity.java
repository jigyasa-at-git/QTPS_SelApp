package com.example.activityandpackageinfo;

import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private static final String TAG = " Installed app";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		final PackageManager pm = getPackageManager();

		Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

		List<ResolveInfo> appList = pm.queryIntentActivities(mainIntent, 0);
		Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pm));

		for (ResolveInfo temp : appList) {

			Log.v("my logs", "package and activity name = "
					+ temp.activityInfo.packageName + "    "
					+ temp.activityInfo.name);

		}
		/*
		final PackageManager pm = getPackageManager();
		//get a list of installed apps.
		List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

		for (ApplicationInfo packageInfo : packages) {
		    Log.d(TAG, "Installed package :" + packageInfo.packageName);
		    Log.d(TAG, "Source dir : " + packageInfo.sourceDir);
		    Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)); 
		}
*/
	
	}

}
