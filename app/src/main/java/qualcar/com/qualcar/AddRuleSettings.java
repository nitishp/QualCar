package qualcar.com.qualcar;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Nitish on 7/29/2015.
 */
public class AddRuleSettings extends Fragment {

    public static TextView mTimeTextView;

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
            mTimeTextView.setText("Time: " + Integer.toString(hourOfDay) + ":" + Integer.toString(minute) + " " + AMorPM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_rule_settings, container, false);

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
}
