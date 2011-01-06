package com.android.calcApp;

import android.app.TabActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TabHost;
import android.content.res.Resources;
import android.widget.TextView;

public class mainTab extends TabActivity {

    public static String shared = "";

    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	Resources res = getResources(); // Resource object to get Drawables
	TabHost tabHost = getTabHost();  // The activity TabHost
	TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	Intent intent;  // Reusable Intent for each tab

	// Create an Intent to launch an Activity for the tab (to be reused)
	intent = new Intent().setClass(this, mainCalc.class);
	//TextView mainTitle = new TextView(this);
	//mainTitle.setText("Main");
	// Initialize a TabSpec for each tab and add it to the TabHost
	spec = tabHost.newTabSpec("graph").setIndicator("Main").setContent(intent);
	tabHost.addTab(spec);
	tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 33;

	// Do the same for the other tabs
	intent = new Intent().setClass(this, convCalc.class);
	//TextView convTitle = new TextView(this);
	//mainTitle.setText("Conversion");
	spec = tabHost.newTabSpec("conv").setIndicator("Conversions")
	    //res.getDrawable(R.drawable.ic_tab_convcalc))
	    .setContent(intent);
	tabHost.addTab(spec);
	tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 33;

	intent = new Intent().setClass(this, graphCalc.class);
	//TextView imagTitle = new TextView(this);
	//mainTitle.setText("Imaginary");
	spec = tabHost.newTabSpec("graph").setIndicator("Graphing")
	    //res.getDrawable(R.drawable.ic_tab_imagecalc))
	    .setContent(intent);
	tabHost.addTab(spec);
	tabHost.getTabWidget().getChildAt(2).getLayoutParams().height = 33;

	tabHost.setCurrentTab(0);
    }
}