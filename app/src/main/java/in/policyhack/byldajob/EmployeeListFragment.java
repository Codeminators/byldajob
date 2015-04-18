package in.policyhack.byldajob;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class EmployeeListFragment extends android.support.v4.app.Fragment {

    private ListView listView;
    private Adapter adapter;
    private Button sendSms;


    public static EmployeeListFragment newInstance() {
        EmployeeListFragment fragment = new EmployeeListFragment();
        return fragment;
    }

    public EmployeeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_employee_list, container, false);
        for(int i = 0; i < 3; i++){
            Employee employee = new Employee();
            employee.name = "Name";
            employee.state = "State";
            employee.district = "District";
            employee.adhaarNumber = 12.5;
            employee.mobileNumber = 10.0;
            Employee.chosenEmployee.add(employee);
        }
        listView = (ListView) v.findViewById(R.id.listView);
        sendSms = (Button) v.findViewById(R.id.smsButton);
        adapter = new Adapter(getActivity().getApplicationContext());
        listView.setAdapter(adapter);
        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSMessage("");
            }
        });
        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
            View v = inflater.inflate(R.layout.list_view_item, parent, false);
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
            Toast.makeText(getActivity().getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity().getApplicationContext(),
                    "SMS faild, please try again.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
