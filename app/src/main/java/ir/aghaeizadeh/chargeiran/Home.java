package ir.aghaeizadeh.chargeiran;



import java.io.File;
import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends Master {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        G.APIlevel = android.os.Build.VERSION.SDK_INT;
        InitializeFont();
        initializeLayout();
        SetFont();

		Log.i("HomeOnCreateFunction", "Yessssssssssssss !");
		shakeListener();
    }


    LinearLayout btnMH,btnMI,btnMR,btnCodeCharge,btnvimax,btn3g,btnshare,btnSuport , llDirectCharge;
    ImageView aghaeizadeh;
    TextView txt3g,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13;



    public void SetFont(){
        Typeface face = Typeface.createFromAsset(getAssets(),         "fonts/arial.ttf");
        txt3g.setTypeface(face);


        txt1.setText(Farsi.Convert("بدون نیاز به اینترنت"));
        txt5.setText(Farsi.Convert("خرید بسته"));
        txt7.setText(Farsi.Convert("خرید کد شارژ"));
        txt8.setText(Farsi.Convert("شارژ مستقیم"));
        txt9.setText(Farsi.Convert("پشتیبانی"));
        txt10.setText(Farsi.Convert("ارسال برنامه به دوستان"));

        if(G.APIlevel>=10){

            txt11.setText(Farsi.Convert("این برنامه با سیم کارت های ایرانسل و رایتل قابل استفاده است."));
        }else{

            txt11.setText(Farsi.Convert(".این برنامه با سیم کارت های ایرانسل و رایتل قابل استفاده است"));
        }

    }


    
	private void initializeLayout() {

		llDirectCharge = (LinearLayout) findViewById(R.id.llDirectCharge);
        btnCodeCharge=(LinearLayout) findViewById(R.id.btnCodeCharge);
		btn3g=(LinearLayout) findViewById(R.id.btn3g);
        btnshare=(LinearLayout) findViewById(R.id.llShare);
        btnSuport=(LinearLayout) findViewById(R.id.llSupport);
        txt1=(TextView) findViewById(R.id.txt1);
        txt2=(TextView) findViewById(R.id.txt2);
        txt3=(TextView) findViewById(R.id.txt3);
        txt4=(TextView) findViewById(R.id.txt4);
        txt5=(TextView) findViewById(R.id.txt5);
        txt7=(TextView) findViewById(R.id.txt7);
        txt8=(TextView) findViewById(R.id.txt8);
        txt9=(TextView) findViewById(R.id.tvSupport);
        txt10=(TextView) findViewById(R.id.tvShare);
        txt11=(TextView) findViewById(R.id.txt11);
        txt12=(TextView) findViewById(R.id.txt12);
        txt13=(TextView) findViewById(R.id.txt13);
        txt3g=(TextView) findViewById(R.id.txt3g);



        btnCodeCharge.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getApplicationContext(), kharid_charge.class);
                startActivity(intent);
            }
        });
	    btn3g.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(), Activity_3G_Irancell.class);
				intent.putExtra("Code", 3);
				startActivity(intent);
			}
		});

		llDirectCharge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(), Activity_Direct_Charge.class);
				intent.putExtra("Code", 4);
				startActivity(intent);
			}
		});




        btnSuport.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(), Support.class);
				startActivity(intent);
			}
		});

		btnshare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try{
				    ArrayList<Uri> uris = new ArrayList<Uri>();
				    Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
				    sendIntent.setType("application/vnd.android.package-archive");
				    uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
				    sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
				    startActivity(Intent.createChooser(sendIntent, null));


				}catch(Exception e){

				    ArrayList<Uri> uris = new ArrayList<Uri>();
				    Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
				    sendIntent.setType("application/zip");
				    uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
				    sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
				    startActivity(Intent.createChooser(sendIntent, null));
				}

			}
		});

	}

	@Override
	public void onResume() {
		super.onResume();
		// Add the following line to register the Session Manager Listener onResume
		mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	public void onPause() {
		// Add the following line to unregister the Sensor Manager onPause
		mSensorManager.unregisterListener(mShakeDetector);
		super.onPause();
	}
}