package in.policyhack.byldajob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class EmployeeListActivity extends Activity{

    private ListView listView;
    private Adapter adapter;
    private Button sendSms;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.fragment_employee_list);
        for(int i = 0; i < 3; i++){
            Employee employee = new Employee();
            employee.name = "Name";
            employee.state = "State";
            employee.district = "District";
            employee.adhaarNumber = 12;
            employee.mobileNumber = 10;
            Employee.chosenEmployee.add(employee);
        }
        listView = (ListView) findViewById(R.id.listView);
        sendSms = (Button) findViewById(R.id.smsButton);
        adapter = new Adapter(getApplicationContext());
        listView.setAdapter(adapter);
        Log.d("Array", Employee.chosenEmployee.toString());
        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSMessage("");
            }
        });

    }

    public class Adapter extends BaseAdapter{
        private TextView name;
        private TextView number;
        private TextView state;
        private TextView district;
        private TextView aadhar;
        Context c;

        public Adapter(Context context){
            this.c = context;
        }

        @Override
        public int getCount() {
            return Employee.chosenEmployee.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = convertView;
            if(convertView ==null) {
              v = inflater.inflate(R.layout.list_view_item, parent, false);
            }
            name = (TextView) v.findViewById(R.id.name);
            number = (TextView) v.findViewById(R.id.MobileNumber);
            aadhar = (TextView) v.findViewById(R.id.AadharNumber);
            district = (TextView) v.findViewById(R.id.District);
            state = (TextView) v.findViewById(R.id.State);
            name.setText(Employee.chosenEmployee.get(position).name);
            number.setText(Employee.chosenEmployee.get(position).mobileNumber + "");
            state.setText(Employee.chosenEmployee.get(position).state);
            district.setText(Employee.chosenEmployee.get(position).district);
            aadhar.setText(Employee.chosenEmployee.get(position).adhaarNumber + "");
            return v;
        }
    }

    public void sendSMSMessage(String phoneNo) {
        String message = "Hey";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
