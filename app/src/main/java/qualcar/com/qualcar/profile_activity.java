package qualcar.com.qualcar;

/**
 * Created by Nitish on 7/29/2015.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;


public class profile_activity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView permission_list_view;
    private ListView rules_list_view;
    //TODO: Use the users created by Greg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<HashMap<String, String>> permission_array = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> rule_array = new ArrayList<HashMap<String, String>>();


        permission_list_view = (ListView) findViewById(R.id.permissions_list);
        rules_list_view = (ListView) findViewById(R.id.rules_list);

        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();

        map.put("itemId", "1");
        map.put("condition", "Temperature > 80 °F");
        map.put("action", "Turn on the AC");

        rule_array.add(map);

        map2.put("itemId", "1");
        map2.put("permission", "Access to the car");

        permission_array.add(map2);

        rules_row adapter = new rules_row(this, rule_array);
        rules_list_view.setAdapter(adapter);

        permission_row adapter2 = new permission_row(this, permission_array);
        permission_list_view.setAdapter(adapter2);

        //Users
        Spinner spinner = (Spinner) findViewById(R.id.user_list);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.users_string, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter3);

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

    //TODO: FIX the action and condition for the contextual object
    //TODO: Use this function to populate the activity
    //TODO: Change the name of the spinner to the current user
    public boolean populate_arrays(ProfileModel user){
        ArrayList<permission> permissions = new ArrayList<permission>();
        ArrayList<contextual_object> contextual_objects = new ArrayList<contextual_object>();
        ArrayList<HashMap<String, String>> permission_array = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> rule_array = new ArrayList<HashMap<String, String>>();

        permissions = user.get_permissions();
        contextual_objects = user.get_rules();
        int counter = 0;
        for (permission new_permission: permissions) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemId", String.valueOf(counter));
            map.put("permission", new_permission.get_string());
            permission_array.add(map);
        }
        counter = 0;
        for (contextual_object new_rule: contextual_objects) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemId", String.valueOf(counter));
            map.put("action", new_rule.get_action().get(0));
            map.put("condition", new_rule.get_condition().get(0));
            permission_array.add(map);
        }

        rules_row adapter = new rules_row(this, rule_array);
        rules_list_view.setAdapter(adapter);

        permission_row adapter2 = new permission_row(this, permission_array);
        permission_list_view.setAdapter(adapter2);

        return true;
    }
}
