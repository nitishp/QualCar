package qualcar.com.qualcar;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Nitish on 7/29/2015.
 */
public class AddRuleSettings extends Fragment implements AdapterView.OnItemSelectedListener {

    public static TextView mTimeTextView;

    public static String finalTemperature = "";
    public static String finalTime = "";
    public static String finalDistance = "";

    private String rule = "";
    private TextView ruleTv;

    // Class to show time picker dialog box
    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            //Show in 12 Hour format
            String AMorPM = "AM";
            if(hourOfDay > 12)
            {
                hourOfDay -= 12;
                AMorPM = "PM";
            }
            finalTime = Integer.toString(hourOfDay) + ":" + Integer.toString(minute) + " " + AMorPM;
            mTimeTextView.setText("Time: " + Integer.toString(hourOfDay) + ":" + Integer.toString(minute) + " " + AMorPM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_rule_settings, container, false);

        ruleTv = (TextView) view.findViewById(R.id.rule_type);
        rule = ruleTv.getText().toString();

        //Set up the spinner
        Spinner spinner = (Spinner) view.findViewById(R.id.action_list);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.actions_string, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter3);
        spinner.setOnItemSelectedListener(this);

        // Set up the buttons

        // Select time
        Button changeTime = (Button) view.findViewById(R.id.change_time);
        mTimeTextView = (TextView) view.findViewById(R.id.time);
        changeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });

        Button changeDistance = (Button) view.findViewById(R.id.change_distance);
        final TextView mDistTextView = (TextView) view.findViewById(R.id.distance);
        changeDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDistanceFunc(mDistTextView);

            }
        });

        Button changeTemperature = (Button) view.findViewById(R.id.change_temperature);
        final TextView mTempTextView = (TextView) view.findViewById(R.id.temperature);
        changeTemperature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeTemperatureFunc(mTempTextView);
            }
        });

        Button addToDB = (Button) view.findViewById(R.id.add_to_db);
        addToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> conditions = new ArrayList();
                if (finalTemperature != "") {
                    conditions.add("Temp=" + finalTemperature);
                }
                if (finalTime != "") {
                    conditions.add("Time=" + finalTime);
                }
                if (finalDistance != "") {
                    conditions.add("Distance=" + finalDistance);
                }
                if ((finalTemperature != "") || (finalTime != "") || (finalDistance != "")) {
                    ArrayList<String> rules = new ArrayList<String>(Arrays.asList(rule));
                    MainScreen.currentUser.add_contextual_rule(new contextual_object(1, conditions, rules));
                    Toast.makeText(getActivity(), "Successfully added rule", Toast.LENGTH_SHORT).show();

                    // Transfer back to the mainActivity
                    Intent intent = new Intent(getActivity(), MainScreen.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    public void changeDistanceFunc(final TextView tv) {

        final Dialog d = new Dialog(getActivity());
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.number_picker);
        Button b1 = (Button) d.findViewById(R.id.set);
        Button b2 = (Button) d.findViewById(R.id.cancel);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100); // max value 100
        np.setMinValue(0);   // min value 0
        np.setWrapSelectorWheel(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finalDistance = String.valueOf(np.getValue());
                tv.setText("Distance: " + String.valueOf(np.getValue()) + " ft."); //set the value to textview
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });
        d.show();
    }

    public void changeTemperatureFunc(final TextView tv){

        final Dialog d = new Dialog(getActivity());
        d.setTitle("Temperature Selector");
        d.setContentView(R.layout.number_picker);
        Button b1 = (Button) d.findViewById(R.id.set);
        Button b2 = (Button) d.findViewById(R.id.cancel);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100); // max value 100
        np.setMinValue(0);   // min value 0
        np.setWrapSelectorWheel(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finalTemperature = String.valueOf(np.getValue());
                tv.setText("Temperature: " + String.valueOf(np.getValue()) + " Degrees"); //set the value to textview
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });
        d.show();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        ruleTv.setText(MainScreen.ACTIONS[pos]);
        rule = MainScreen.ACTIONS[pos];
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
