package ir.aghaeizadeh.chargeiran;



import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MySpinnerAdapter  extends ArrayAdapter<String>{

    private List<String> objects;
    private Context context;
    TextView label;

    public MySpinnerAdapter(Context context, int resourceId,
                              List<String> objects) {
        super(context, resourceId, objects);
        this.objects = objects;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        Typeface fc2 = Typeface.createFromAsset(getContext().getAssets(),  "fonts/farsi.ttf");


        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.row, parent, false);

        label=(TextView)row.findViewById(R.id.txtSp1);
        label.setTypeface(fc2);
        if(G.APIlevel>10){
            label.setText(objects.get(position));
        }else {
            label.setText(Farsi.Convert(objects.get(position)));
            label.setGravity(Gravity.RIGHT);
        }

        label.setTextColor(context.getResources().getColor(android.R.color.black));

        return row;
    }

}