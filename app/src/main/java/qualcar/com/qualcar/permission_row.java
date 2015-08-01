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
public class permission_row extends BaseAdapter
{
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private LayoutInflater inflater=null;
    Context ctx;

    public permission_row(Activity a, ArrayList<HashMap<String, String>> d)
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
            vi = inflater.inflate(R.layout.permission_row, null);

        TextView permission = (TextView)vi.findViewById(R.id.permission_text);

        HashMap<String, String> element = new HashMap<String, String>();
        element = data.get(position);

        permission.setText(element.get("permission"));
        String itemId = element.get("itemId");

        return vi;
    }
}