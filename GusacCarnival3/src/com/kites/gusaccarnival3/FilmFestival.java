package com.kites.gusaccarnival3;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FilmFestival extends ActionBarActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmfestival);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.workshopspager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
               

                case 0:
                	return new WorkshopsFragment();
                case 1:
                	return new FilmyTalksFragment();

                case 2:
                	return new ScreeningFragment();
                case 3:
                	return new Compt();

               
                	default:
                		return new WorkshopsFragment();

            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	switch(position)
        	{
        	
        	case 0:
        		return "Workshops";
        	case 1:
        		return "FilmTalks";
        	case 2:
        		return "Screening";
        	case 3:
        		return "Online Competitions";
        		
        	}
            return "Section " + (position + 1);
        }
    }
   
    public static class WorkshopsFragment extends Fragment {
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    	        Bundle savedInstanceState) {
    	        // Inflate the layout for this fragment
    	        return inflater.inflate(R.layout.ffworkshops, container, false);
    	    }
    }
    public static class FilmyTalksFragment extends Fragment {
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    	        Bundle savedInstanceState) {
    	        // Inflate the layout for this fragment
    	        return inflater.inflate(R.layout.fffilmytalks, container, false);
    	    }
    }
    public static class ScreeningFragment extends Fragment {
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    	        Bundle savedInstanceState) {
    	        // Inflate the layout for this fragment
    	        return inflater.inflate(R.layout.ffscreening, container, false);
    	    }
    }
    
    
    public static class Compt extends Fragment {
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    	        Bundle savedInstanceState) {
    	        // Inflate the layout for this fragment
    	        return inflater.inflate(R.layout.ffcomp, container, false);
    	    }
    }
   
    
    }