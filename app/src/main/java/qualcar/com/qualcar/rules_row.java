package qualcar.com.qualcar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quique on 7/31/15.
 */
public class rules_row extends BaseAdapter
{
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private LayoutInflater inflater=null;
    Context ctx;

    public rules_row(Activity a, ArrayList<HashMap<String, String>> d)
    {
        ctx = a.getBaseContext();
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return data.size();
    }

    public Object getItem(int position)
    {
        return position;
    }

    public long getItemId(int position)
    {
        return position;
    }


    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi=convertView;

        if(convertView==null)
            vi = inflater.inflate(R.layout.rule_row, null);

        TextView condition = (TextView)vi.findViewById(R.id.condition);
        TextView action = (TextView) vi.findViewById(R.id.action);

        HashMap<String, String> category = new HashMap<String, String>();
        category = data.get(position);

        condition.setText(category.get("condition"));
        action.setText(category.get("action"));
        String itemId = category.get("itemId");

        return vi;
    }
}
