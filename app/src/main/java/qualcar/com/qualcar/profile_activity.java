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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;


public class profile_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Toolbar mToolbar;
    private ListView permission_list_view;
    private ListView rules_list_view;
    public static int id_num = 0;
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
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(id_num);

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

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        ProfileModel User = ProfileCreator.create_profiles(pos);
        populate_arrays(User);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    //TODO: Change the name of the spinner to the current user
    public boolean populate_arrays(ProfileModel user){
        ArrayList<permission> permissions = new ArrayList<permission>();
        ArrayList<contextual_object> contextual_objects = new ArrayList<contextual_object>();
        ArrayList<HashMap<String, String>> permission_array = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> rule_array = new ArrayList<HashMap<String, String>>();
        String name = user.get_name();

        permissions = user.get_permissions();
        contextual_objects = user.get_rules();
        int counter = 0;
        for (permission new_permission: permissions) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemId", String.valueOf(counter));
            map.put("permission", new_permission.get_string());
            permission_array.add(map);
            counter = counter + 1;
        }
        counter = 0;
        for (contextual_object new_rule: contextual_objects) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemId", String.valueOf(counter));
            String new_action = "";
            ArrayList<String> array_actions = new_rule.get_action();
            for(String conc_action: array_actions){
                new_action += conc_action;
                new_action += "\n";
            }
            map.put("action", new_action);
            String new_condition = "";
            ArrayList<String> array_condition = new_rule.get_condition();
            for(String conc_condition: array_condition){
                new_condition += conc_condition;
                new_condition += "\n";
            }
            map.put("condition", new_condition);
            rule_array.add(map);
            counter = counter + 1;
        }

        rules_row adapter = new rules_row(this, rule_array);
        rules_list_view.setAdapter(adapter);

        permission_row adapter2 = new permission_row(this, permission_array);
        permission_list_view.setAdapter(adapter2);

        return true;
    }
}
