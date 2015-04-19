package in.policyhack.byldajob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pujamathur on 19/4/15.
 */
public class IncomingSms extends BroadcastReceiver{
    final SmsManager smsManager = SmsManager.getDefault();
    @Override
    public void onReceive(final Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        if(bundle!=null){
            final Object[] pdus = (Object[]) bundle.get("pdus");
            for(int i = 0; i < pdus.length; i++){
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String number = smsMessage.getDisplayOriginatingAddress();
                String message = smsMessage.getDisplayMessageBody();
                if(message.equals("EMP Y")){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                    String location = preferences.getString("location","");
                    new QueryTask2(){

                        @Override
                        protected void onPostExecute(String s) {
                            String[] list = s.split(" ");
                            String message = "Hey!";
                            for(String string : list) {
                                try {
                                    SmsManager smsManager = SmsManager.getDefault();
                                    smsManager.sendTextMessage(string, null, message, null, null);
                                    Toast.makeText(context, "SMS sent.",
                                            Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    Toast.makeText(context,
                                            "SMS faild, please try again.",
                                            Toast.LENGTH_LONG).show();
                                    e.printStackTrace();
                                }
                            }

                        }
                    }.execute(location,number);

                }

            }
        }

    }

}

