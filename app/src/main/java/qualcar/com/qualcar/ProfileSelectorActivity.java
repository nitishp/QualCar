package qualcar.com.qualcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Greg-Knox on 7/30/2015.
 */
public class ProfileSelectorActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_selector);
        mActivity = this;

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Switch to different profiles
        Button nitishButton = (Button) findViewById(R.id.b_change_nitish);
        nitishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainScreen.currentUser = MainScreen.nitish;
                Intent intent = new Intent(mActivity, MainScreen.class);
                startActivity(intent);
            }
        });
        Button ryanButton = (Button) findViewById(R.id.b_change_ryan);
        ryanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainScreen.currentUser = MainScreen.ryan;
                Intent intent = new Intent(mActivity, MainScreen.class);
                startActivity(intent);
            }
        });
        Button hannaButton = (Button) findViewById(R.id.b_change_hanna);
        hannaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainScreen.currentUser = MainScreen.hanna;
                Intent intent = new Intent(mActivity, MainScreen.class);
                startActivity(intent);
            }
        });
        Button enriqueButton = (Button) findViewById(R.id.b_change_enrique);
        enriqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainScreen.currentUser = MainScreen.enrique;
                Intent intent = new Intent(mActivity, MainScreen.class);
                startActivity(intent);
            }
        });
        Button gregButton = (Button) findViewById(R.id.b_change_greg);
        gregButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainScreen.currentUser = MainScreen.greg;
                Intent intent = new Intent(mActivity, MainScreen.class);
                startActivity(intent);
            }
        });
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
}
