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
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MostaghimHamraheAval extends Master {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostaghim_hamraheaval);
        
        InitializeFont();
        initializeLayout();
        SetFont();



        
    }
    Spinner spnPrice;
    CheckBox chbSave;
    EditText bank , mobileH , price , banki , bankii , bankiii;
    LinearLayout btnsubmit;
    int p=0;
    String mablagh;
    String bankfeild;
    String mobilenumber = "";
    String[] nums;
    int Error=0;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txtSp1,txtSp2;
    String[] Sp1 = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"};
    String[] Sp2 = {"1", "2", "3",
            "4", "5", "6", "7"};

    public void SetFont(){


        Typeface tf = Farsi.GetFarsiFont(this);

        txt1.setTypeface(tf);
        txt2.setTypeface(tf);
        txt3.setTypeface(tf);
        txt4.setTypeface(tf);
        txt5.setTypeface(tf);
        txt6.setTypeface(tf);
        txt7.setTypeface(tf);
        txt8.setTypeface(tf);
        txt1.setText(Farsi.Convert("شارژ مستقیم همراه اول"));
        txt2.setText(Farsi.Convert("انتخاب مبلغ"));
        txt3.setText(Farsi.Convert("شماره موبایل"));
        txt4.setText(Farsi.Convert("شماره کارت بانکی"));
        txt5.setText(Farsi.Convert("ذخیره شماره کارت"));
        txt6.setText(Farsi.Convert("پرداخت"));
        if(G.APIlevel>=10){

            txt7.setText(Farsi.Convert("جهت افزایش امنیت اطلاعات کارت بانکی شما،"));
            txt8.setText(Farsi.Convert("رمز دوم، در نرم افزار ذخیره نمی شود."));
        }else{

            txt7.setText(Farsi.Convert("،جهت افزایش امنیت اطلاعات کارت بانکی شما"));
            txt8.setText(Farsi.Convert(".رمز دوم، در نرم افزار ذخیره نمی شود"));
        }

    }



	private void initializeLayout() {

        bank = (EditText)findViewById(R.id.bank);
        banki = (EditText)findViewById(R.id.banki);
        bankii = (EditText)findViewById(R.id.bankii);
        bankiii = (EditText)findViewById(R.id.bankiii);
        mobileH = (EditText)findViewById(R.id.mobileH);
        btnsubmit = (LinearLayout)findViewById(R.id.btnsubmit);
        chbSave = (CheckBox)findViewById(R.id.chbSave);
        spnPrice = (Spinner)findViewById(R.id.spnPrice);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt6 = (TextView)findViewById(R.id.txt6);
        txt7 = (TextView)findViewById(R.id.txt7);
        txt8 = (TextView)findViewById(R.id.txt8);


        MySpinnerAdapter adapter = new MySpinnerAdapter(
                getApplicationContext(),
                R.layout.row,
                Arrays.asList(getResources().getStringArray(R.array.sharj_mostaghim_hamraheaval))
        );
        spnPrice.setAdapter(adapter);
        spnPrice.setPrompt(mablagh);









        mobileH.setText(prefs.getString("mobileH", ""));
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


                SaveForShake(0);

        G.Error=0;

                try{




                    try {
                        mobilenumber = mobileH.getText().toString().trim().substring(0, 4);

                        final String[] nums = {"0910", "0911", "0913", "0914", "0915", "0916", "0917", "0918", "0919"};


                        if (!Arrays.asList(nums).contains(mobilenumber)) {

                            G.Error = 10;

                        }


                    }catch(Exception e){
                        e.printStackTrace();
                    }



                    if((mobileH.getText().length()<1)|| (bank.getText().length()<1) || (banki.getText().length()<1) ||
                            (bankii.getText().length()<1) || (bankiii.getText().length()<1)) {
                        G.Error=4;
                    }

                    if(mobileH.getText().length()>=1 && mobileH.getText().length()<11){
                        G.Error=5;

                    }
                    if((bank.getText().length()>=1 && bank.getText().length()<4)|| (banki.getText().length()>=1 && banki.getText().length()<4)
                            || (bankii.getText().length()>=1 && bankii.getText().length()<4)|| (bankiii.getText().length()>=1 && bankiii.getText().length()<4)){

                        G.Error=6;


                    }








                    if((G.Error ==10)||(G.Error==5)||(G.Error==6)){

                        Dialog_Error();


                    }else if(G.Error == 4) {

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


        G.mobileH=mobileH.getText().toString().trim();
        G.bank=bank.getText().toString().trim();
        G.banki=banki.getText().toString().trim();
        G.bankii=bankii.getText().toString().trim();
        G.bankiii=bankiii.getText().toString().trim();
        G.bankall = G.bank+G.banki+G.bankii+G.bankiii;


        SharedPreferences.Editor editor = prefs.edit();


        editor.putString("mobileH",mobileH.getText().toString());
        editor.putString("bank",bank.getText().toString());
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


        if(spnPrice.getSelectedItemId()==0){
            String url = "tel:" + G.mainCode +"*1*"+G.mobileH+"*1*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
        }else if(spnPrice.getSelectedItemId()==1){
            String url = "tel:" + G.mainCode +"*1*"+G.mobileH+"*2*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
        }else if(spnPrice.getSelectedItemId()==2){
            String url = "tel:" + G.mainCode +"*1*"+G.mobileH+"*3*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
        }else if(spnPrice.getSelectedItemId()==3){
            String url = "tel:" + G.mainCode +"*1*"+G.mobileH+"*4*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
        }else if(spnPrice.getSelectedItemId()==4){
            String url = "tel:" + G.mainCode +"*1*"+G.mobileH+"*5*"+G.bankall+""+ Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL" , Uri.parse(url)));
        }



    }
}