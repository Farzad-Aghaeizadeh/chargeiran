package ir.aghaeizadeh.chargeiran;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MostaghimRightel extends Master {
    /** Called when the activity is first created. */





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostaghim_rightel);
        
        InitializeFont();
        initializeLayout();
        SetFont();

    }

    CheckBox chbSave;
    EditText bank , price , banki , bankii , bankiii ,mobileR;
    LinearLayout btnsubmit;
    int p=0;
    String mobilenumber = "";
    String[] nums;
    int Error=0;
    TextView debug ,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
    String Test;
    public void SetFont(){

        txt1.setText(Farsi.Convert("شارژ مستقیم رایتل"));
        txt2.setText(Farsi.Convert("شماره موبایل"));
        txt3.setText(Farsi.Convert("مبلغ شارژ"));
        txt4.setText(Farsi.Convert("ریال"));
        txt5.setText(Farsi.Convert("شماره کارت بانکی"));
        txt6.setText(Farsi.Convert("ذخیره شماره کارت"));
        txt7.setText(Farsi.Convert("پرداخت"));
        if(G.APIlevel>=10){

            txt8.setText(Farsi.Convert("جهت افزایش امنیت اطلاعات کارت بانکی شما،"));
            txt9.setText(Farsi.Convert("رمز دوم، در نرم افزار ذخیره نمی شود."));
        }else{

            txt8.setText(Farsi.Convert("،جهت افزایش امنیت اطلاعات کارت بانکی شما"));
            txt9.setText(Farsi.Convert(".رمز دوم، در نرم افزار ذخیره نمی شود"));
        }



    }




	private void initializeLayout() {


        bank = (EditText)findViewById(R.id.bank);
        banki = (EditText)findViewById(R.id.banki);
        bankii = (EditText)findViewById(R.id.bankii);
        bankiii = (EditText)findViewById(R.id.bankiii);
        mobileR = (EditText)findViewById(R.id.mobileR);
        price = (EditText)findViewById(R.id.price);
        btnsubmit = (LinearLayout)findViewById(R.id.btnsubmit);
        chbSave = (CheckBox)findViewById(R.id.chbSave);
        debug = (TextView)findViewById(R.id.debug);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt6 = (TextView)findViewById(R.id.txt6);
        txt7 = (TextView)findViewById(R.id.txt7);
        txt8 = (TextView)findViewById(R.id.txt8);
        txt9 = (TextView)findViewById(R.id.txt9);


        price.addTextChangedListener(new NumberTextWatcher(price));


        mobileR.setText(prefs.getString("mobileR", ""));
        price.setText(prefs.getString("price", ""));
        bank.setText(prefs.getString("bank", ""));
        banki.setText(prefs.getString("banki", ""));
        bankii.setText(prefs.getString("bankii", ""));
        bankiii.setText(prefs.getString("bankiii", ""));
        chbSave.setChecked(prefs.getBoolean("isSave", chbSave.isChecked()));




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


//                CToast(price.getText().toString().St);
//
//                String test = price.getText().toString();
//                char First = test.charAt(0);
//                CToast(First+"");
//
//                String str = reverseIt(test);
//                CToast(test);
//                CToast(str);

                SaveForShake(0);

        G.Error=0;

                try{

                    try {

                        mobilenumber = mobileR.getText().toString().trim().substring(0, 4);
                        final String[] nums = {"0921"};
                        if (!Arrays.asList(nums).contains(mobilenumber)) {
                            G.Error = 8;
                        }
                        if(mobilenumber.equals("0920")){
                            G.Error=9;
                        }

                    }catch(Exception e){
                        e.printStackTrace();
                    }



                    Test = price.getText().toString().replace(",", "");

                    Test=Test.replace("٬", "");
                    Test=Test.replace("۹", "9");
                    Test=Test.replace("۱", "1");
                    Test=Test.replace("۲", "2");
                    Test=Test.replace("۳", "3");
                    Test=Test.replace("۴", "4");
                    Test=Test.replace("۵", "5");
                    Test=Test.replace("۶", "6");
                    Test=Test.replace("۷", "7");
                    Test=Test.replace("۸", "8");
                    Test=Test.replace("۰", "0");
                    p = Integer.parseInt(Test);


                        if(p>500000){

                            G.Error = 13;
                        }else if(p<10000) {
                            G.Error = 13;
                        }




                    if((mobileR.getText().length()<1)|| (price.getText().length()<1) ||
                            (bank.getText().length()<1) || (banki.getText().length()<1) ||
                            (bankii.getText().length()<1) || (bankiii.getText().length()<1)) {

                        G.Error=4;

                    }

                    if(mobileR.getText().length()>=1 && mobileR.getText().length()<11){
                        G.Error=5;

                    }
                    if((bank.getText().length()>=1 && bank.getText().length()<4)|| (banki.getText().length()>=1 && banki.getText().length()<4)
                            || (bankii.getText().length()>=1 && bankii.getText().length()<4)|| (bankiii.getText().length()>=1 && bankiii.getText().length()<4)){

                        G.Error=6;


                    }







                     if((G.Error ==8)||(G.Error==13) || (G.Error==5)||(G.Error==6) ||(G.Error==9)){

                         Dialog_Error();

                     }else if(G.Error == 4){

                         CToast("لطفا فیلد های خالی را پر کنید");
                    }else{
                        DoCharge();
                    }





                }catch (Exception e){

                    e.printStackTrace();
                }



            }
        });

    }




    public void DoCharge(){


        G.mobileR=mobileR.getText().toString().trim();
        G.bank=bank.getText().toString().trim();
        G.banki=banki.getText().toString().trim();
        G.bankii=bankii.getText().toString().trim();
        G.bankiii=bankiii.getText().toString().trim();
        G.bankall = G.bank+G.banki+G.bankii+G.bankiii;


        SharedPreferences.Editor editor = prefs.edit();


        editor.putString("mobileR",mobileR.getText().toString());
        editor.putString("price",price.getText().toString());
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


        String pr =  price.getText().toString().replace(",","");


        editor.commit();


            String url = "tel:" + G.mainCode +"*1*"+G.mobileR+"*"+pr+"*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));

          //  debug.setText(url);

    }
    public static String reverseIt(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }

}