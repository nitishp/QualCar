package qualcar.com.qualcar;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import qualcar.com.qualcar.view.graph_activity;

import qualcar.com.qualcar.view.SlidingTabLayout;


public class MainScreen extends AppCompatActivity {

    String TITLES[] = {"Add Rules", "Stats", "Profiles", "Switch User"};
    int ICONS[] = {R.drawable.config, R.drawable.stats, R.drawable.profiles, R.drawable.switch_user};
    public static String FAVORITES[] = {"LOCK CAR", "UNLOCK CAR", "START CAR"};
    public static String ACTIONS[] = {"LOCK CAR", "UNLOCK CAR", "START CAR", "STOP CAR", "DONE"};

    public static ProfileModel nitish = ProfileCreator.populateNitish();
    public static ProfileModel hanna = ProfileCreator.populateHanna();
    public static ProfileModel ryan = ProfileCreator.populateRyan();
    public static ProfileModel enrique = ProfileCreator.populateEnrique();
    public static ProfileModel greg = ProfileCreator.populateGreg();

    public static ProfileModel currentUser = nitish;

    private Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    SlidingTabLayout slidingTabLayout;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // Set up the viewpager
        CharSequence[] tabTitles = {"Favorites", "Actions"};
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabTitles, tabTitles.length);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerAdapter);

        // Set up the sliding tabs
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {
            @Override
            public int getIndicatorColor(int position)
            {
                return getResources().getColor(R.color.white);
            }
        });
        slidingTabLayout.setViewPager(viewPager);

        // Set up the navigation drawer
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mAdapter = new NavDrawerAdapter(TITLES,ICONS, currentUser.name, currentUser.picture_location, this);
        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State


        // Issue a notification for Enrique, Hanna and Ryan
        if(currentUser.name.equals("Ryan"))
        {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.emergency)
                            .setContentTitle("Tire Pressure Low")
                            .setContentText("Get your tires checked soon!");
            // Sets an ID for the notification
            int mNotificationId = 001;
            // Gets an instance of the NotificationManager service
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }
        if(currentUser.name.equals("Hanna"))
        {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.emergency)
                            .setContentTitle("Engine unable to start")
                            .setContentText("Go see a mechanic");
            // Sets an ID for the notification
            int mNotificationId = 001;
            // Gets an instance of the NotificationManager service
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }
        if(currentUser.name.equals("Enrique"))
        {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.emergency)
                            .setContentTitle("Theft Detected!")
                            .setContentText("Your car might have been broken into!");
            // Sets an ID for the notification
            int mNotificationId = 001;
            // Gets an instance of the NotificationManager service
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void launchActivity(String item)
    {
        if(item == "Add Rules")
        {
            Intent intent = new Intent(this, AddRuleActivity.class);
            startActivity(intent);
        }
        else if(item == "Profiles")
        {
            Intent intent = new Intent(this, profile_activity.class);
            startActivity(intent);
        }
        else if(item == "Stats")
        {
            Intent intent = new Intent(this, graph_activity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, ProfileSelectorActivity.class);
            startActivity(intent);
        }
    }
}
