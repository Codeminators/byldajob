package in.policyhack.byldajob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by pujamathur on 19/4/15.
 */
public class IncomingSms extends BroadcastReceiver{
    final SmsManager smsManager = SmsManager.getDefault();
    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        if(bundle!=null){
            final Object[] pdus = (Object[]) bundle.get("pdus");
            for(int i = 0; i < pdus.length; i++){
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String number = smsMessage.getDisplayOriginatingAddress();
                String message = smsMessage.getDisplayMessageBody();
//                if(message.equals("EMP Y")){
//                    new QueryTask(){
//                        @Override
//                        protected void onPostExecute(String s) {
//
//                        }
//                    }.execute("UPDATE tbl SET employed='1', currentemployment = 'New Delhi' WHERE mobile = '" + number + "'");
//
//                }

            }
        }

    }
}
