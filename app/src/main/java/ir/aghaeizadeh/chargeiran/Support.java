package ir.aghaeizadeh.chargeiran;



import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Support extends Master {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);

        InitializeFont();
        initializeLayout();
        SetFont();


    }

    LinearLayout btnCall,btnEmail;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;




    public void SetFont(){

        txt1.setText(Farsi.Convert("پشتیبانی"));
        txt2.setText(Farsi.Convert("شما می توانید در ساعات اداری با"));
        txt8.setText(Farsi.Convert("شماره تلفن"));
        txt3.setText(Farsi.Convert("021-89711111"));
        txt4.setText(Farsi.Convert("و در تمامی زمان ها از طریق"));
        if(G.APIlevel>=10){
            txt5.setText(Farsi.Convert("تماس بگیرید."));
        }else{
            txt5.setText(Farsi.Convert(".تماس بگیرید"));

        }

        txt6.setText(Farsi.Convert("تماس تلفنی"));
        txt7.setText(Farsi.Convert("ارسال ایمیل"));

    }


    private void initializeLayout(){

        btnCall = (LinearLayout)findViewById(R.id.btnCall);
        btnEmail = (LinearLayout)findViewById(R.id.btnEmail);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt6 = (TextView)findViewById(R.id.txt6);
        txt7 = (TextView)findViewById(R.id.txt7);
        txt8 = (TextView)findViewById(R.id.txt8);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "02189711111"));
                    startActivity(callIntent);

                }catch (Exception e){

                    e.printStackTrace();
                }

            }

            });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","support@up-konid.ir", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "درخواست پشتیبانی – شارژ الکترونیکی  version 1");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));

                }catch (Exception e){

                    e.printStackTrace();
                }

            }

            });




    }


}