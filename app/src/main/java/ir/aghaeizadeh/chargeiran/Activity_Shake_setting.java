package ir.aghaeizadeh.chargeiran;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Activity_Shake_setting extends Master
{
    public TextView tvShake1;
    public TextView tvShake2;
    public TextView tvShake3;
    public TextView tvShake4;
    public TextView tvShake5;
    public LinearLayout shakeMenu;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__shake_setting);
        tvShake1 = (TextView)findViewById(R.id.tvShake1);
        tvShake2 = (TextView)findViewById(R.id.tvShake2);
        tvShake3 = (TextView)findViewById(R.id.tvShake3);
        tvShake4 = (TextView)findViewById(R.id.tvShake4);
        tvShake5 = (TextView)findViewById(R.id.tvShake5);

        final CheckBox chbShake =  (CheckBox)findViewById(R.id.chbShakeActive);
        shakePref = getApplicationContext().getSharedPreferences("ir.aghaeizadeh.chargeiran.shake", Context.MODE_PRIVATE);
        boolean canShake = shakePref.getBoolean(SHAKE_KEY , true);
        if (canShake)
        {
            chbShake.setChecked(true);
        }
        else
            chbShake.setChecked(false);


        InitializeFont();
        SetFont();


    }

    public void onShakeCHeckBoxCheck(View v)
    {
        CheckBox chbV = (CheckBox) v;
        if (((CheckBox) v).isChecked()) {
            shakeIsOn = true;

            shakePref = getApplicationContext().getSharedPreferences("ir.aghaeizadeh.chargeiran.shake", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = shakePref.edit();
            editor.putBoolean(SHAKE_KEY, true);
            editor.commit();

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.shake_on), Toast.LENGTH_SHORT).show();
        }
        else {
            shakeIsOn = false;

            shakePref = getApplicationContext().getSharedPreferences("ir.aghaeizadeh.chargeiran.shake", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = shakePref.edit();
            editor.putBoolean(SHAKE_KEY, false);
            editor.commit();

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.shake_off), Toast.LENGTH_SHORT).show();
        }
    }


    public void SetFont(){

        tvShake1.setText(Farsi.Convert(getResources().getString(R.string.shakeTv1)));
        tvShake2.setText(Farsi.Convert(getResources().getString(R.string.shakeTv2)));
        tvShake3.setText(Farsi.Convert(getResources().getString(R.string.shakeTv3)));
        tvShake4.setText(Farsi.Convert(getResources().getString(R.string.shakeTv4)));
        tvShake5.setText(Farsi.Convert(getResources().getString(R.string.shakeTv5)));

    }


    public void InitializeFont() {

        shakeMenu = (LinearLayout) findViewById(R.id.shakeMenu);
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/farsi.ttf");
        FontsOverride.overrideFonts(getApplicationContext(), shakeMenu);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__shake_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
