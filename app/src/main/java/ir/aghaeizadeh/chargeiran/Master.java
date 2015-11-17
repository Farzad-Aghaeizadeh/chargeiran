package ir.aghaeizadeh.chargeiran;





import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Master extends Activity {
    /**
     * Called when the activity is first created.
     */

    protected final static String SHAKE_KEY = "SHAKE_STATUS";
    protected final static String PAYMENT_CODE_KEY = "PAYMENT_CODE";
    protected boolean shakeIsOn = true;
    private String classKey = "shakeClassKey";
    protected SensorManager mSensorManager;
    protected Sensor mAccelerometer;
    protected ShakeDetector mShakeDetector;
    SharedPreferences shakePref ;
    public void SaveForShake(int code)
    {

        shakePref = getApplicationContext().getSharedPreferences("ir.aghaeizadeh.chargeiran.shakeAdress", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shakePref.edit();
        editor.putString(classKey, "ir.aghaeizadeh.chargeiran." + getClass().getSimpleName());
        editor.commit();
        if (code != 0)
        {
            editor.putInt(SHAKE_KEY, code);
            editor.commit();
        }
    }


    public ShakeDetector.OnShakeListener shake = new ShakeDetector.OnShakeListener()
    {

        @Override
        public void onShake(int count)
        {

            shakePref = getApplicationContext().getSharedPreferences("ir.aghaeizadeh.chargeiran.shakeAdress", Context.MODE_PRIVATE);
            String className = shakePref.getString(classKey , null);
            int shakeCode  = shakePref.getInt(SHAKE_KEY , 0);
            shakePref = getApplicationContext().getSharedPreferences("ir.aghaeizadeh.chargeiran.shake", Context.MODE_PRIVATE);
            boolean canShake = shakePref.getBoolean(SHAKE_KEY, true);




//            if (className == null || canShake == false)
//            Toast.makeText(getBaseContext(), className , Toast.LENGTH_SHORT).show();
            Intent intent = null;
            try
            {
                if(className != null && canShake == true)
                {
                    intent = new Intent(getApplicationContext(), Class.forName(className));
                    if ( shakeCode != 0)
                        intent.putExtra("Code",shakeCode);
                    else
                        intent.putExtra("Code", 1);
                    startActivity(intent);
                }
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }

        }
    };

    public void shakeListener()
    {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(shake);
        Log.i("getClassName",getClass().getSimpleName());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    String str1;
    TextView txt3g,txtOne,txtTwo,txtThree,txtFour,txtOneO,txtTwoO,txtThreeO,txtToast;
    LinearLayout Mainbox, Mainbox2;
    LinearLayout lyltop;
    SharedPreferences prefs;
    LinearLayout btnYes,btnNo,btnBack;
    EditText  bank, banki , bankii , bankiii;
    CheckBox chbSave;
    public void InitializeFont() {

        Mainbox = (LinearLayout) findViewById(R.id.MainBox);
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/farsi.ttf");
        FontsOverride.overrideFonts(getApplicationContext(),Mainbox);

    }

    public void Toast(final String text) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void CToast (final String txt){

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout_id));

                // set a message
                txtToast = (TextView) layout.findViewById(R.id.text);

                Typeface fc = Typeface.createFromAsset(getAssets(),  "fonts/farsi.ttf");
                txtToast.setTypeface(fc);
                txtToast.setText(Farsi.Convert(txt));

                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 60);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

            }
        });

    }



    public void SetText( String str1,  String str2, String str3,  String str4,  TextView txt) {


        if (str3!=null){

            if(G.APIlevel>=10){

                txt.setText(Farsi.Convert(str1) + " " + Farsi.Convert(str2) + " " + Farsi.Convert(str3) + " "+  Farsi.Convert(str4) +" ");
             }else{

                txt.setText(Farsi.Convert(str4) + " " + Farsi.Convert(str3) + " " + Farsi.Convert(str2) + " "+  Farsi.Convert(str1) +" ");
            }
        }else {

            if(G.APIlevel>=10){
                txt.setText(Farsi.Convert(str1) + " " + Farsi.Convert(str2) + " " );
            }else{
                txt.setText(Farsi.Convert(str2) + " " + Farsi.Convert(str1) + " " );
            }
        }


    }


    public void Dialog_Error(){

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_error);
        btnBack = (LinearLayout)dialog.findViewById(R.id.btnBack);
        txtOneO = (TextView)dialog.findViewById(R.id.txtOneO);
        txtTwoO = (TextView)dialog.findViewById(R.id.txtTwoO);
        txtThreeO = (TextView)dialog.findViewById(R.id.txtThreeO);


        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/farsi.ttf");
        txtOneO.setTypeface(face2);
        txtTwoO.setTypeface(face2);
        txtThreeO.setTypeface(face2);


        if(G.APIlevel>=10) {

            txtOneO.setText(Farsi.Convert("اطلاعات وارد شده صحیح نمی باشد."));

            if(G.Error==1){
                txtTwoO.setText(Farsi.Convert("لطفا فرمت شماره موبایل را صحیح وارد کنید. فقط پیش شماره های اپراتور ایرانسل قابل قبول می باشند."));
            }else if(G.Error==2){
                txtTwoO.setText(Farsi.Convert("ریال وارد کنید. 2.500.000 و 10.000 لطفا مبلغ شارژ را بین "));
            }else if(G.Error==3){
                txtTwoO.setText(Farsi.Convert("ریال وارد کنید. 2.500.000 و 10.000 لطفا مبلغ شارژ را بین "));
            }else if(G.Error==5){
                txtTwoO.setText(Farsi.Convert("لطفا شماره موبایل خود را کامل وارد کنید."));
            }else if(G.Error==6){
                txtTwoO.setText(Farsi.Convert("لطفا شماره کارت خود را کامل وارد کنید."));
            }else if(G.Error==7){

                txtTwoO.setText(Farsi.Convert("ریال وارد کنید. 500.000 و 10.000 لطفا مبلغ شارژ شگفت انگیز را بین"));
            }else if(G.Error==13){

                txtTwoO.setText("لطفا مبلغ شارژ را بین 10.000 و 500.000 ریال وارد کنید.");
            }else if(G.Error==8){
                txtTwoO.setText(Farsi.Convert("لطفا فرمت شماره موبایل را صحیح وارد کنید، فقط پیش شماره های اپراتور رایتل قابل قبول می باشند."));
            }else if(G.Error==9){
                txtTwoO.setText(Farsi.Convert("امکان شارژ مستقیم سیمکارت دائمی رایتل وجود ندارد، شما می توانید کد شارژ خریداری کنید."));
            }else if(G.Error==10){
                txtTwoO.setText(Farsi.Convert("لطفا فرمت شماره موبایل را صحیح وارد کنید، فقط پیش شماره های اپراتور همراه اول قابل قبول می باشند."));
            }else if(G.Error==11){
                txtTwoO.setText(Farsi.Convert("لطفا شناسه صحیح وایمکس را وارد کنید، فقط شناسه سرویس وایمکس ایرانسل قابل قبول می باشد."));
            }else if(G.Error==12){
                txtTwoO.setText(Farsi.Convert("لطفا شناسه وایمکس را کامل وارد کنید."));
            }

        }else{


            txtOneO.setText(Farsi.Convert(".اطلاعات وارد شده صحیح نمی باشد"));
            if(G.Error==1){
                txtTwoO.setText(Farsi.Convert("لطفا فرمت شماره موبایل را صحیح وارد کنید، فقط پیش شماره های اپراتور ایرانسل قابل قبول می باشند"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==2){
                txtTwoO.setText(Farsi.Convert("لطفا مبلغ شارژ را بین وارد کنید 10.000 و 2.500.000 ریال"));
                txtTwoO.setGravity(Gravity.RIGHT);


            }else if(G.Error==3){
                txtTwoO.setText(Farsi.Convert("لطفا مبلغ شارژ را بین وارد کنید 10.000 و 2.500.000 ریال"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==5){
                txtTwoO.setText(Farsi.Convert(".لطفا شماره موبایل خود را کامل وارد کنید"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==6){
                txtTwoO.setText(Farsi.Convert(".لطفا شماره کارت خود را کامل وارد کنید"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==7){



                txtTwoO.setText(Farsi.Convert("لطفا مبلغ شارژ را بین وارد کنید 10.000 و 500.000 ریال"));

                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==13){

                txtTwoO.setText(Farsi.Convert("لطفا مبلغ شارژ را بین وارد کنید 10.000 و 500.000 ریال"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==8){
                txtTwoO.setText(Farsi.Convert("لطفا فرمت شماره موبایل را صحیح وارد کنید، فقط پیش شماره های اپراتور رایتل قابل قبول می باشند"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==9){
                txtTwoO.setText(Farsi.Convert("امکان شارژ مستقیم سیمکارت دائمی رایتل وجود ندارد، شما می توانید کد شارژ خریداری کنید"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==10){
                txtTwoO.setText(Farsi.Convert("لطفا فرمت شماره موبایل را صحیح وارد کنید، فقط پیش شماره های اپراتور همراه اول قابل قبول می باشند"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==11){
                txtTwoO.setText(Farsi.Convert("لطفا شناسه صحیح وایمکس را وارد کنید، فقط شناسه سرویس وایمکس ایرانسل قابل قبول می باشد"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }else if(G.Error==12){
                txtTwoO.setText(Farsi.Convert(".لطفا شناسه وایمکس را کامل وارد کنید"));
                txtTwoO.setGravity(Gravity.RIGHT);
            }


        }






        txtThreeO.setText(Farsi.Convert("بازگشت"));


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.dismiss();
            }
        });


        dialog.setCancelable(false);



        dialog.show();
    }

    public void Dialog_CheckBox(){

        final SharedPreferences.Editor editor = prefs.edit();
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_error_checkbox);
        btnYes = (LinearLayout)dialog.findViewById(R.id.btnNo);
        btnNo = (LinearLayout)dialog.findViewById(R.id.btnYes);
       // txtOne = (TextView)dialog.findViewById(R.id.txtOne);
        txtTwo = (TextView)dialog.findViewById(R.id.txtTwo);
        txtThree = (TextView)dialog.findViewById(R.id.txtThree);
        txtFour = (TextView)dialog.findViewById(R.id.txtFour);
        chbSave = (CheckBox)findViewById(R.id.chbSave);

        bank = (EditText)findViewById(R.id.bank);
        banki = (EditText)findViewById(R.id.banki);
        bankii = (EditText)findViewById(R.id.bankii);
        bankiii = (EditText)findViewById(R.id.bankiii);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/farsi.ttf");
        txtTwo.setTypeface(face);
        txtThree.setTypeface(face);
        txtFour.setTypeface(face);


        if(G.APIlevel>=10) {
            txtTwo.setText(Farsi.Convert("آیا می خواهید شماره کارت بانکی شما به صورت کامل از نرم افزار حذف شود؟"));
        }else{
            txtTwo.setText(Farsi.Convert("آیا می خواهید شماره کارت بانکی شما به صورت کامل از نرم افزار حذف شود؟"));
            txtTwo.setGravity(Gravity.RIGHT);
        }
        txtThree.setText(Farsi.Convert("بلی"));
        txtFour.setText(Farsi.Convert("خیر"));

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               bank.setText(null);
               banki.setText(null);
               bankii.setText(null);
               bankiii.setText(null);

               editor.putString("bank",null);
               editor.putString("banki",null);
               editor.putString("bankii",null);
               editor.putString("bankiii",null);
               editor.putBoolean("isSave", false);
               editor.commit();

                dialog.dismiss();

            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                chbSave.setChecked(true);
            }
        });
        dialog.setCancelable(false);



        dialog.show();
    }


}
