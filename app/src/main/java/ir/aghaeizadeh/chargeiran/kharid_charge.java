package ir.aghaeizadeh.chargeiran;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class kharid_charge extends Master {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kharid_charge);

        InitializeFont();
        initializeLayout();
        SetFont();

    }

    LinearLayout lylIrancell;
    LinearLayout lylHamraheaval;
    LinearLayout lylRightel;
    LinearLayout lylTaliya;
    TextView txt1,txt2,txt3,txt4;



    public void SetFont(){


        Typeface tf = Farsi.GetFarsiFont(this);

        txt1.setTypeface(tf);
        txt2.setTypeface(tf);
        txt3.setTypeface(tf);
        txt4.setTypeface(tf);
        txt1.setText(Farsi.Convert("ایرانسل"));
        txt2.setText(Farsi.Convert("همراه اول"));
        txt3.setText(Farsi.Convert("رایتل"));
        txt4.setText(Farsi.Convert("تالیا"));



    }



    private void initializeLayout() {


        lylIrancell = (LinearLayout)findViewById(R.id.lylIrancell);
        lylHamraheaval = (LinearLayout)findViewById(R.id.lylHamraheaval);
        lylRightel = (LinearLayout)findViewById(R.id.lylRightel);
        lylTaliya = (LinearLayout)findViewById(R.id.lylTaliya);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);



        lylIrancell.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Activity_Irancell.class);
                startActivity(intent);
            }
        });

        lylHamraheaval.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Activity_Hamraheaval.class);
                startActivity(intent);
            }
        });

        lylRightel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Activity_Rightel.class);
                startActivity(intent);
            }
        });

        lylTaliya.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Activity_Taliya.class);
                startActivity(intent);
            }
        });

    }

}