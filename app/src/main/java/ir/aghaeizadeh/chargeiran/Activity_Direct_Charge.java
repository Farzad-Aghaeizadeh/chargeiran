package ir.aghaeizadeh.chargeiran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


public class Activity_Direct_Charge extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__direct__charge);

        LinearLayout llDirectHamraheaval=(LinearLayout) findViewById(R.id.llDirect_to_hamraheaval);
        LinearLayout llDirectIrancell=(LinearLayout) findViewById(R.id.llDirect_to_irancell);
        LinearLayout llDirectRightell=(LinearLayout) findViewById(R.id.llDirect_to_rightell);
        LinearLayout llDirectVimaxIrancell=(LinearLayout) findViewById(R.id.llDirect_to_vimax_irancell);






                llDirectIrancell.setOnClickListener(new View.OnClickListener()
                {

                    @Override
                    public void onClick(View arg0)
                    {
                        Intent intent = new Intent(getApplicationContext(), Mostaghim.class);
                        intent.putExtra("Code", 1);
                        startActivity(intent);
                    }
                });

        llDirectRightell.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(getApplicationContext(), MostaghimRightel.class);
                intent.putExtra("Code", 1);
                startActivity(intent);
            }
        });

        llDirectHamraheaval.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(getApplicationContext(), MostaghimHamraheAval.class);
                intent.putExtra("Code", 1);
                startActivity(intent);
            }
        });



        llDirectVimaxIrancell.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(getApplicationContext(), Activity_Payment_Vimax.class);
                intent.putExtra("Code", 1);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__direct__charge, menu);
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
