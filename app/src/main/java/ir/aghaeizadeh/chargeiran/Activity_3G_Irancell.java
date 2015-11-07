package ir.aghaeizadeh.chargeiran;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_3G_Irancell extends Master {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3g_irancell);
        
        InitializeFont();
        initializeLayout();
        SetText3g();



    }


    RelativeLayout  btnthree, btnfive , btnten , btnfifteen , btntwenty;
    TextView txt3g,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12;



    public void SetText3g(){



        Typeface face = Typeface.createFromAsset(getAssets(),         "fonts/arial.ttf");
        txt3g.setTypeface(face);


        txt1.setText(Farsi.Convert("انتخاب بسته"));
        txt2.setText(Farsi.Convert("ایرانسل"));

        SetText("3" , "روزه" , "40" , "مگابایت" , txt3);
        SetText("5" , "روزه" , "100" , "مگابایت" , txt5);
        SetText("10" , "روزه" , "270" , "مگابایت" , txt7);
        SetText("30" , "روزه" , "5000" , "مگابایت" , txt9);
        SetText("به صرفه ترین" , null,null , null, txt11);
        SetText("10/000" , "ریال" , null , null , txt4);
        SetText("20/000" , "ریال" , null , null , txt6);
        SetText("50/000" , "ریال" , null , null , txt8);
        SetText("218/000" , "ریال" , null , null , txt10);
        SetText("200/000" , "ریال" , null , null , txt12);

    }


    private void initializeLayout() {

        btnthree = (RelativeLayout)findViewById(R.id.three);
        btnfive = (RelativeLayout)findViewById(R.id.five);
        btnten = (RelativeLayout)findViewById(R.id.ten);
        btnfifteen = (RelativeLayout)findViewById(R.id.fifteen);
        btntwenty = (RelativeLayout)findViewById(R.id.twenty);
        txt1=(TextView) findViewById(R.id.txt1);
        txt2=(TextView) findViewById(R.id.txt2);
        txt3=(TextView) findViewById(R.id.txt3);
        txt4=(TextView) findViewById(R.id.txt4);
        txt5=(TextView) findViewById(R.id.txt5);
        txt6=(TextView) findViewById(R.id.txt6);
        txt7=(TextView) findViewById(R.id.txt7);
        txt8=(TextView) findViewById(R.id.txt8);
        txt9=(TextView) findViewById(R.id.txt9);
        txt10=(TextView) findViewById(R.id.txt10);
        txt11=(TextView) findViewById(R.id.txt11);
        txt12=(TextView) findViewById(R.id.txt12);
        txt3g=(TextView) findViewById(R.id.txt3g);





        btnthree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Activity_Payment_3G.class);
                intent.putExtra("Code" ,3 );
                startActivity(intent);
            }
        });

        btnfive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Activity_Payment_3G.class);
                intent.putExtra("Code" ,5 );
                startActivity(intent);
            }
        });

        btnten.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Activity_Payment_3G.class);
                intent.putExtra("Code" ,10 );
                startActivity(intent);
            }
        });
        btnfifteen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Activity_Payment_3G.class);
                intent.putExtra("Code" ,15 );
                startActivity(intent);
            }
        });

        btntwenty.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Activity_Payment_3G.class);
                intent.putExtra("Code" ,20 );
                startActivity(intent);
            }
        });

	}
 }
	
