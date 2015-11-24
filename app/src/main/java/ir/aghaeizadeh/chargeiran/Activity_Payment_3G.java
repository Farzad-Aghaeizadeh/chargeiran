package ir.aghaeizadeh.chargeiran;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

public class Activity_Payment_3G extends Master {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_3g);


        Bundle extras = getIntent().getExtras();
        if (extras != null){

            Code =  extras.getInt("Code");
        }


        InitializeFont();
        initializeLayout();
        SetFont();





    }

    CheckBox chbSave;
    EditText mobile , bank, banki , bankii , bankiii;
    TextView txtType , txtPrice,txt3g,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    LinearLayout btnsubmit,lylPrice;
    int Code;
    int p;
    String mablagh;
    String mobilenumber;
    String[] nums;
    int Error=0;




    public void SetFont(){


        Typeface face = Typeface.createFromAsset(getAssets(),         "fonts/arial.ttf");
        txt3g.setTypeface(face);

        txt1.setText(Farsi.Convert("انتخاب بسته"));
        txt2.setText(Farsi.Convert("ایرانسل"));
        txt5.setText(Farsi.Convert("شماره موبایل"));
        txt6.setText(Farsi.Convert("شماره کارت بانکی"));
        txt7.setText(Farsi.Convert("ذخیره شماره کارت"));
        txt8.setText(Farsi.Convert("انتخاب بسته"));
        if(G.APIlevel>=10){
            txt3.setText(Farsi.Convert("بسته :"));
            txt4.setText(Farsi.Convert("قیمت :"));
            txt9.setText(Farsi.Convert("جهت افزایش امنیت اطلاعات کارت بانکی شما،"));
            txt10.setText(Farsi.Convert("رمز دوم، در نرم افزار ذخیره نمی شود."));
        }else{
            txt3.setText(Farsi.Convert(" : بسته "));
            txt4.setText(Farsi.Convert(" : قیمت "));
            txt9.setText(Farsi.Convert("،جهت افزایش امنیت اطلاعات کارت بانکی شما"));
            txt10.setText(Farsi.Convert(".رمز دوم، در نرم افزار ذخیره نمی شود"));
        }



    }



    private void initializeLayout() {




        txtType = (TextView)findViewById(R.id.txtType);
        txtPrice = (TextView)findViewById(R.id.txtPrice);
        btnsubmit = (LinearLayout)findViewById(R.id.btnsubmit);
        lylPrice = (LinearLayout)findViewById(R.id.lylPrice);
        mobile = (EditText)findViewById(R.id.mobile);
        bank = (EditText)findViewById(R.id.bank);
        banki = (EditText)findViewById(R.id.banki);
        bankii = (EditText)findViewById(R.id.bankii);
        bankiii = (EditText)findViewById(R.id.bankiii);
        chbSave = (CheckBox)findViewById(R.id.chbSave);
        txt3g = (TextView)findViewById(R.id.txt3g);
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




        mobile.setText(prefs.getString("mobile",""));
        bank.setText(prefs.getString("bank", ""));
        banki.setText(prefs.getString("banki", ""));
        bankii.setText(prefs.getString("bankii", ""));
        bankiii.setText(prefs.getString("bankiii", ""));
        chbSave.setChecked(prefs.getBoolean("isSave", chbSave.isChecked()));




//
//        if (Code==3){
//            lylPrice.setVisibility(View.VISIBLE);
//            SetText("3" , "روزه" , "40" , "مگابایت" , txtType);
//            SetText("10.000" , "ریال" , null , null , txtPrice);
//
//        }else if (Code==5){
//            lylPrice.setVisibility(View.VISIBLE);
//            SetText("5" , "روزه" , "100" , "مگابایت" , txtType);
//            SetText("20.000" , "ریال" , null , null , txtPrice);
//
//        }else if (Code==10){
//            lylPrice.setVisibility(View.VISIBLE);
//            SetText("10" , "روزه" , "270" , "مگابایت" , txtType);
//            SetText("50.000" , "ریال" , null , null , txtPrice);
//
//        }else if (Code==15){
//            lylPrice.setVisibility(View.VISIBLE);
//            SetText("30" , "روزه" , "5000" , "مگابایت" , txtType);
//            SetText("218.000" , "ریال" , null , null , txtPrice);
//
//        }else if (Code==20){
//            lylPrice.setVisibility(View.VISIBLE);
//            SetText(null , "ماهانه", "200" , "مگابایت", txtType);
//            SetText("55.000" , "ریال" , null , null , txtPrice);
//
//        }




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
                if (cs.toString().length() > 3) {

                    banki.clearFocus();
                    bankii.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {


            }

        });
        bankii.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.toString().length() > 3) {

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
                if (cs.toString().length() > 3) {

                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(bankiii.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

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

                SaveForShake(0);

                try{


                G.Error=0;

                    try{
                    mobilenumber = mobile.getText().toString().trim().substring(0,4);

                    final String[] nums = { "0935", "0936", "0937", "0938", "0939", "0930","0933","0901","0902" ,"0903"};


                    if (!Arrays.asList(nums).contains(mobilenumber)) {

                        G.Error=1;

                    }}catch (Exception e){

                        e.printStackTrace();
                    }


                    if((mobile.getText().toString().length()<1 )
                            /*
                            || (bank.getText().toString().length()<1)
                            || (banki.getText().length()<1) ||
                            (bankii.getText().length()<1) ||
                            (bankiii.getText().length()<1) */) {
                        G.Error=2;
                    }

                    if(mobile.getText().length()>1 && mobile.getText().length()<11){
                        G.Error=5;

                    }
                    if((bank.getText().length()>=1 && bank.getText().length()<4)|| (banki.getText().length()>=1 && banki.getText().length()<4)
                            || (bankii.getText().length()>=1 && bankii.getText().length()<4)|| (bankiii.getText().length()>=1 && bankiii.getText().length()<4)){

                        G.Error=6;


                    }


                    if((G.Error ==1)||(G.Error==5)||(G.Error==6)){

                        Dialog_Error();

                    }

                    else if(G.Error == 2){
                        CToast("لطفا فیلد های خالی را پر کنید");

                    }

                    else {
                        DoCharge();
                    }
                }catch (Exception e){

                    e.printStackTrace();
                }



            }
        });




    }


    public void DoCharge(){



        G.mobile=mobile.getText().toString().trim();
        G.bank=bank.getText().toString().trim();
        G.banki=banki.getText().toString().trim();
        G.bankii=bankii.getText().toString().trim();
        G.bankiii=bankiii.getText().toString().trim();
        G.bankall = G.bank+G.banki+G.bankii+G.bankiii;


        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("mobile" , mobile.getText().toString());
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



       //     String url = "tel:"+G.mainCode+"*1*"+G.mobile+"*4*"+G.bankall+""+Uri.encode("#");
            String url = "tel:*789*1731*1*"+ G.mobile +"*4"+Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));


//        if(Code==3){
//
//            String url = "tel:"+G.mainCode+"*1*"+G.mobile+"*4*1*"+G.bankall+""+Uri.encode("#");
//            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
//
//        }else if(Code==5){
//
//            String url = "tel:"+G.mainCode+"*1*"+G.mobile+"*4*2*"+G.bankall+""+Uri.encode("#");
//            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
//
//        }else if(Code==10){
//
//            String url = "tel:"+G.mainCode+"*1*"+G.mobile+"*4*3*"+G.bankall+""+Uri.encode("#");
//            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
//
//        } else if(Code==15){
//
//            String url = "tel:"+G.mainCode+"*1*"+G.mobile+"*4*4*"+G.bankall+""+Uri.encode("#");
//            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
//
//        }else if(Code==20){
//
//            String url = "tel:"+G.mainCode+"*1*"+G.mobile+"*4*0*1*"+G.bankall+""+Uri.encode("#");
//            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
//
//        }

    }

    }

	
	
