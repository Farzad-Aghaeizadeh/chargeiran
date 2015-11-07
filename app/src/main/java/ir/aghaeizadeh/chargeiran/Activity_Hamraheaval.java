package ir.aghaeizadeh.chargeiran;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Hamraheaval extends Master {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamraheaval);

        InitializeFont();
        initializeLayout();
        SetFont();
    }

    LinearLayout tenth;
    LinearLayout twoentyth;
    LinearLayout fiftyth;
    LinearLayout onehundredth;
    LinearLayout twohundredth;
    TextView txt1,txt2,txt3,txt4,txt5,txt6;

    public void SetFont(){

        txt1.setText(Farsi.Convert("کارت شارژ همراه اول"));
        SetText("10.000" , "ریال" , null , null , txt2);
        SetText("20.000" , "ریال" , null , null , txt3);
        SetText("50.000" , "ریال" , null , null , txt4);
        SetText("100.000" , "ریال" , null , null , txt5);
        SetText("200.000" , "ریال" , null , null , txt6);
    }


    private void initializeLayout() {

        tenth = (LinearLayout)findViewById(R.id.tenth);
        twoentyth = (LinearLayout)findViewById(R.id.twoentyth);
        fiftyth = (LinearLayout)findViewById(R.id.fiftyth);
        onehundredth = (LinearLayout)findViewById(R.id.onehundredth);
        twohundredth = (LinearLayout)findViewById(R.id.twohundredth);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt6 = (TextView)findViewById(R.id.txt6);


        tenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Activity_Payment.class);
                intent.putExtra("Code" ,210);
                startActivity(intent);

            }
        });

        twoentyth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Payment.class);
                intent.putExtra("Code" ,220);
                startActivity(intent);
            }
        });

        fiftyth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Payment.class);
                intent.putExtra("Code" ,250);
                startActivity(intent);
            }
        });

        onehundredth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Payment.class);
                intent.putExtra("Code" ,2100);
                startActivity(intent);
            }
        });

        twohundredth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Payment.class);
                intent.putExtra("Code" ,2200);
                startActivity(intent);
            }
        });


    }

}