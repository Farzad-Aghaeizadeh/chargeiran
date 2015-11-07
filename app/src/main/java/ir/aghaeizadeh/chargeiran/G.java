package ir.aghaeizadeh.chargeiran;

import org.json.JSONObject;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;

public class G extends Application {

    public static int            RefreshTime   = 0;
    public static Context        context;
    public static LayoutInflater layoutInflater;
    public static String         FolderAddress = null;
    public static String         FOLDER        = Environment.getExternalStorageDirectory() + "/.attorney/";
    protected static JSONObject  productslistJson, newsJson, branchesJson = null;
    public static String         SERVER        = "http://www.dadporsarya.com/app/handler/";
    public static String         IMG_PATH      = "http://www.dadporsarya.com/app/portal/uploads/";
    protected static JSONObject catslistJson=null;
    public static int PDCAT=0;
    public static String PDSEARCH="";
	protected static String pdTitle="";
	public static String operator="1";
	public static String type="1";
	public static String mobile="";
	public static int pr = 0;

	public static String shVimax="";
	public static String mobileR="";
	public static String mobileH="";
	public static String price="2000";
	public static String bank="";
	public static String banki="";
	public static String bankii="";
	public static String bankiii="";
	public static String bankall="";
	public static String TotalCode="*789*9875*"+operator+"*"+type+"*"+mobile+"*"+price+"*"+bank+Uri.encode("#");
	public static String mainCode="*789*9875";
	public static int APIlevel=0;
	public static int Error=0;






    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        context = getApplicationContext();
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FolderAddress = Environment.getExternalStorageDirectory() + "/.attorney/.cache";
    }
    
    
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
