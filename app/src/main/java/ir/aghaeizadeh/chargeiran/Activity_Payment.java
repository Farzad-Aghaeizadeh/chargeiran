package ir.aghaeizadeh.chargeiran;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class Activity_Payment extends Master {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {

            Code = extras.getInt("Code");

        }


        InitializeFont();
        initializeLayout();
        SetFont();



        
        
        
    }
    String mablagh;
    CheckBox chbSave;
    Spinner num;
    LinearLayout BorderOperator,btnsubmit;
    TextView TextOperator , TextCharge,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    ImageView LogoOperator;
    int Code;
    int KeyListenerHandler=0;

    EditText bank,banki , bankii , bankiii;
    int Error=0;


    public void SetFont(){

        txt1.setText(Farsi.Convert("خرید کد شارژ"));
        txt2.setText(Farsi.Convert("اپراتور"));
        txt3.setText(Farsi.Convert("نوع شارژ"));
        txt4.setText(Farsi.Convert("تعداد"));
        txt5.setText(Farsi.Convert("شماره کارت بانکی"));
        txt6.setText(Farsi.Convert("ذخیره شماره کارت"));

        txt8.setText(Farsi.Convert("پرداخت"));
        if(G.APIlevel>=10){
            txt7.setText(Farsi.Convert("کد شارژ به موبایلتان پیامک زده خواهد شد."));
            txt9.setText(Farsi.Convert("جهت افزایش امنیت اطلاعات کارت بانکی شما،"));
            txt10.setText(Farsi.Convert("رمز دوم، در نرم افزار ذخیره نمی شود."));
        }else{
            txt7.setText(Farsi.Convert(".کد شارژ به موبایلتان پیامک زده خواهد شد"));
            txt9.setText(Farsi.Convert("،جهت افزایش امنیت اطلاعات کارت بانکی شما"));
            txt10.setText(Farsi.Convert(".رمز دوم، در نرم افزار ذخیره نمی شود"));
        }



    }

    private void ResetKeyHandler(){
        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    KeyListenerHandler=0;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }


	private void initializeLayout() {

        BorderOperator = (LinearLayout)findViewById(R.id.BorderOperator);
        TextOperator = (TextView)findViewById(R.id.TextOperator);
        TextCharge = (TextView)findViewById(R.id.TextCharge);
        LogoOperator = (ImageView)findViewById(R.id.LogoOperator);
        btnsubmit = (LinearLayout)findViewById(R.id.btnsubmit);
        bank = (EditText)findViewById(R.id.bank);
        banki = (EditText)findViewById(R.id.banki);
        bankii = (EditText)findViewById(R.id.bankii);
        bankiii = (EditText)findViewById(R.id.bankiii);
        chbSave = (CheckBox)findViewById(R.id.chbSave);
        num = (Spinner)findViewById(R.id.num);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt6 = (TextView)findViewById(R.id.txt6);
        txt7 = (TextView)findViewById(R.id.txt7);
        txt8 = (TextView)findViewById(R.id.txt8);
        txt9 = (TextView)findViewById(R.id.txt9);
        txt10 = (TextView)findViewById(R.id.txt10);



        MySpinnerAdapter adapter = new MySpinnerAdapter(
                getApplicationContext(),
                R.layout.row,
                Arrays.asList(getResources().getStringArray(R.array.nums))
        );
        num.setAdapter(adapter);
        num.setPrompt(mablagh);



        bank.setText(prefs.getString("bank", ""));
        banki.setText(prefs.getString("banki", ""));
        bankii.setText(prefs.getString("bankii", ""));
        bankiii.setText(prefs.getString("bankiii", ""));
        chbSave.setChecked(prefs.getBoolean("isSave", chbSave.isChecked()));






        if (Code==110){
            BorderOperator.setBackgroundColor(Color.parseColor("#ffcc00"));
            TextOperator.setText(Farsi.Convert("ایرانسل"));
            LogoOperator.setImageResource(R.drawable.irancellff);
            SetText("10.000" , "ریال" , null , null , TextCharge);

        }else if(Code==120){

            BorderOperator.setBackgroundColor(Color.parseColor("#ffcc00"));
            TextOperator.setText(Farsi.Convert("ایرانسل"));
            LogoOperator.setImageResource(R.drawable.irancellff);
            SetText("20.000", "ریال" , null , null , TextCharge);

        }else if(Code==150){

            BorderOperator.setBackgroundColor(Color.parseColor("#ffcc00"));
            TextOperator.setText(Farsi.Convert("ایرانسل"));
            LogoOperator.setImageResource(R.drawable.irancellff);
            SetText("50.000" , "ریال" , null , null , TextCharge);

        }else if(Code==1100){

            BorderOperator.setBackgroundColor(Color.parseColor("#ffcc00"));
            TextOperator.setText(Farsi.Convert("ایرانسل"));
            LogoOperator.setImageResource(R.drawable.irancellff);
            SetText("100.000" , "ریال" , null , null , TextCharge);

        }else if(Code==1200){

            BorderOperator.setBackgroundColor(Color.parseColor("#ffcc00"));
            TextOperator.setText(Farsi.Convert("ایرانسل"));
            LogoOperator.setImageResource(R.drawable.irancellff);
            SetText("200.000" , "ریال" , null , null , TextCharge);

        }else if(Code==210){

            BorderOperator.setBackgroundColor(Color.parseColor("#49c4cb"));
            TextOperator.setText(Farsi.Convert("همراه اول"));
            LogoOperator.setImageResource(R.drawable.hamraheavalff);
            SetText("10.000" , "ریال" , null , null , TextCharge);

        }else if(Code==220){

            BorderOperator.setBackgroundColor(Color.parseColor("#49c4cb"));
            TextOperator.setText(Farsi.Convert("همراه اول"));
            LogoOperator.setImageResource(R.drawable.hamraheavalff);
            SetText("20.000", "ریال" , null , null , TextCharge);

        }else if(Code==250){

            BorderOperator.setBackgroundColor(Color.parseColor("#49c4cb"));
            TextOperator.setText(Farsi.Convert("همراه اول"));
            LogoOperator.setImageResource(R.drawable.hamraheavalff);
            SetText("50.000" , "ریال" , null , null , TextCharge);

        }else if(Code==2100){

            BorderOperator.setBackgroundColor(Color.parseColor("#49c4cb"));
            TextOperator.setText(Farsi.Convert("همراه اول"));
            LogoOperator.setImageResource(R.drawable.hamraheavalff);
            SetText("100.000" , "ریال" , null , null , TextCharge);

        }else if(Code==2200){

            BorderOperator.setBackgroundColor(Color.parseColor("#49c4cb"));
            TextOperator.setText(Farsi.Convert("همراه اول"));
            LogoOperator.setImageResource(R.drawable.hamraheavalff);
            SetText("200.000" , "ریال" , null , null , TextCharge);

        }else if(Code==320){

            BorderOperator.setBackgroundColor(Color.parseColor("#840053"));
            TextOperator.setText(Farsi.Convert("رایتل"));
            LogoOperator.setImageResource(R.drawable.rightelff);
            SetText("20.000", "ریال" , null , null , TextCharge);

        }else if(Code==350){

            BorderOperator.setBackgroundColor(Color.parseColor("#840053"));
            TextOperator.setText(Farsi.Convert("رایتل"));
            LogoOperator.setImageResource(R.drawable.rightelff);
            SetText("50.000" , "ریال" , null , null , TextCharge);

        }else if(Code==3100){

            BorderOperator.setBackgroundColor(Color.parseColor("#840053"));
            TextOperator.setText(Farsi.Convert("رایتل"));
            LogoOperator.setImageResource(R.drawable.rightelff);
            SetText("100.000" , "ریال" , null , null , TextCharge);

        }else if(Code==3200){

            BorderOperator.setBackgroundColor(Color.parseColor("#840053"));
            TextOperator.setText(Farsi.Convert("رایتل"));
            LogoOperator.setImageResource(R.drawable.rightelff);
            SetText("200.000" , "ریال" , null , null , TextCharge);

        }else if(Code==3500){

            BorderOperator.setBackgroundColor(Color.parseColor("#840053"));
            TextOperator.setText(Farsi.Convert("رایتل"));
            LogoOperator.setImageResource(R.drawable.rightelff);
            SetText("500.000" , "ریال" , null , null , TextCharge);

        }else if(Code==420){

            BorderOperator.setBackgroundColor(Color.parseColor("#ff0026"));
            TextOperator.setText(Farsi.Convert("تالیا"));
            LogoOperator.setImageResource(R.drawable.taliyafff);
            SetText("20.000", "ریال" , null , null , TextCharge);

        }else if(Code==450){

            BorderOperator.setBackgroundColor(Color.parseColor("#ff0026"));
            TextOperator.setText(Farsi.Convert("تالیا"));
            LogoOperator.setImageResource(R.drawable.taliyafff);
            SetText("50.000" , "ریال" , null , null , TextCharge);

        }else if(Code==4100){

            BorderOperator.setBackgroundColor(Color.parseColor("#ff0026"));
            TextOperator.setText(Farsi.Convert("تالیا"));
            LogoOperator.setImageResource(R.drawable.taliyafff);
            SetText("100.000" , "ریال" , null , null , TextCharge);

        }else if(Code==4200){

            BorderOperator.setBackgroundColor(Color.parseColor("#ff0026"));
            TextOperator.setText(Farsi.Convert("تالیا"));
            LogoOperator.setImageResource(R.drawable.taliyafff);
            SetText("200.000" , "ریال" , null , null , TextCharge);

        }



        bank.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(cs.toString().length() >3){
                    bank.clearFocus();
                    banki.requestFocus();

                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {


            }

        });

        banki.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(cs.toString().length() >3){

                    banki.clearFocus();
                    bankii.requestFocus();

                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {


            }

        });
        bankii.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(cs.toString().length() >3){

                    bankii.clearFocus();
                    bankiii.requestFocus();

                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {


            }

        });
        bankiii.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(cs.toString().length() >3){

                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(bankiii.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {



            }

        });




        chbSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if((bank.getText().length()>=1) || (banki.getText().length()>=1) ||
                        (bankii.getText().length()>=1) || (bankiii.getText().length()>=1))  {

                    if(chbSave.isChecked()==false){
                        Dialog_CheckBox();
                    }



                }



            }
        });


        btnsubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                G.Error=0;
                try{


                    if((bank.getText().toString().length()<1)|| (banki.getText().length()<1) ||
                            (bankii.getText().length()<1) || (bankiii.getText().length()<1)){

                        G.Error=1;

                    }

                    if((bank.getText().length()>=1 && bank.getText().length()<4)|| (banki.getText().length()>=1 && banki.getText().length()<4)
                            || (bankii.getText().length()>=1 && bankii.getText().length()<4)|| (bankiii.getText().length()>=1 && bankiii.getText().length()<4)){

                        G.Error=6;

                    }




                if(G.Error==1){

                    CToast("لطفا فیلد های خالی را پر کنید");
                }
                else if (G.Error==6){

                Dialog_Error();

                }else{
                    doCharge();

                }

                }catch (Exception e){

                    e.printStackTrace();
                }



            }
        });




	}




    private void doCharge() {


        G.bank = bank.getText().toString().trim();
        G.banki=banki.getText().toString().trim();
        G.bankii=bankii.getText().toString().trim();
        G.bankiii=bankiii.getText().toString().trim();
        G.bankall = G.bank+G.banki+G.bankii+G.bankiii;

        SharedPreferences.Editor editor = prefs.edit();
        if(chbSave.isChecked()){
            editor.putString("bank",bank.getText().toString());
            editor.putString("banki",banki.getText().toString());
            editor.putString("bankii",bankii.getText().toString());
            editor.putString("bankiii",bankiii.getText().toString());
            editor.putBoolean("isSave", chbSave.isChecked());

        }else{

            editor.putString("bank",null);
            editor.putString("banki",null);
            editor.putString("bankii",null);
            editor.putString("bankiii",null);
            editor.putBoolean("isSave", false);
        }

        editor.commit();

        if (Code == 110) {
            String url = "tel:" + G.mainCode +"*2*1*1*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 120) {
            String url = "tel:" + G.mainCode +"*2*1*2*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 150) {
            String url = "tel:" + G.mainCode +"*2*1*3*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 1100) {
            String url = "tel:" + G.mainCode +"*2*1*4*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 1200) {
            String url = "tel:" + G.mainCode +"*2*1*5*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 210) {
            String url = "tel:" + G.mainCode +"*2*2*1*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 220) {
            String url = "tel:" + G.mainCode +"*2*2*2*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 250) {
            String url = "tel:" + G.mainCode +"*2*2*3*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 2100) {
            String url = "tel:" + G.mainCode +"*2*2*4*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 2200) {
            String url = "tel:" + G.mainCode +"*2*2*5*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 320) {
            String url = "tel:" + G.mainCode +"*2*3*1*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 350) {
            String url = "tel:" + G.mainCode +"*2*3*2*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 3100) {
            String url = "tel:" + G.mainCode +"*2*3*3*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 3200) {
            String url = "tel:" + G.mainCode +"*2*3*4*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 3500) {
            String url = "tel:" + G.mainCode +"*2*3*5*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 420) {
            String url = "tel:" + G.mainCode +"*2*4*1*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 450) {
            String url = "tel:" + G.mainCode +"*2*4*2*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 4100) {
            String url = "tel:" + G.mainCode +"*2*4*3*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }else if (Code == 4200) {
            String url = "tel:" + G.mainCode +"*2*4*4*"+(num.getSelectedItemId()+1)+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

        }





    }

    }


	
	
