package in.policyhack.byldajob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.HashMap;


public class ChooseEmployees extends ActionBarActivity {

    private ArrayAdapter arrayAdapter;
    private int i;
    ProgressBar p;


    SwipeFlingAdapterView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_employees);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        Intent intent = getIntent();
        intent.getBooleanExtra("relocate", false);
        i = Integer.valueOf(intent.getStringExtra("candidates"));



        arrayAdapter = new MyAdapter(getApplicationContext(),SpecialityFragment.employeeList);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                SpecialityFragment.employeeList.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                makeToast(ChooseEmployees.this, "Left!");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(ChooseEmployees.this, "Right!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //employeeList.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(ChooseEmployees.this, "Clicked!");
            }
        });
    }


    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_employees, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            chooseEmployeesFromAlgorithm(SpecialityFragment.employeeList);
            Intent intent = new Intent(getApplicationContext(), EmployeeListActivity.class);
            intent.putExtra("candidates",i);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void chooseEmployeesFromAlgorithm(ArrayList<Employee> employeeList) {
        double rating[] = new double[employeeList.size()];
        HashMap<Double,Employee> hashMap = new HashMap<>();
        for(int i = 0; i < employeeList.size(); i++) {
            rating[i] = Employee.rateEmployee(employeeList.get(i));
            Log.d("Sdf",employeeList.get(i).getName());
            hashMap.put(rating[i],employeeList.get(i));
        }
        SortingClass.sortEmployees(rating, hashMap);
    }


    public class MyAdapter extends ArrayAdapter<Employee> {

        private ArrayList<Employee> employeeList1;
        Context c;

        public MyAdapter(Context context, ArrayList<Employee> objects) {
            super(context,0,objects);
            employeeList1 = objects;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d("sdf","ho raha hia");
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.name_employee);
            TextView number = (TextView) convertView.findViewById(R.id.mobile_number);
            TextView aadhaar = (TextView) convertView.findViewById(R.id.aadhaar_number);
            TextView district = (TextView) convertView.findViewById(R.id.district_employee);
            TextView state = (TextView) convertView.findViewById(R.id.state_employee);
            TextView policeVerification = (TextView) convertView.findViewById(R.id.police_verification);
            TextView highestEducation = (TextView) convertView.findViewById(R.id.highest_education);
            TextView workExperience = (TextView) convertView.findViewById(R.id.work_ex);
            TextView marksReceived = (TextView) convertView.findViewById(R.id.marks);
            TextView expectedSalary = (TextView) convertView.findViewById(R.id.expected_salary);

            name.setText(employeeList1.get(position).getName());
            Log.d("Roalts1", ""+employeeList1.get(position).getName());
            number.setText(employeeList1.get(position).getMobileNumber()+ "");
            state.setText(employeeList1.get(position).getState());
            district.setText(employeeList1.get(position).getDistrict());
            policeVerification.setText(employeeList1.get(position).getPoliceVerification() + "");
            workExperience.setText(employeeList1.get(position).getWorkEx() + "");
            expectedSalary.setText(employeeList1.get(position).getPreviousSalary() + "");
            marksReceived.setText(employeeList1.get(position).getMarks() + "");
            highestEducation.setText(employeeList1.get(position).getHighestEducation() + "");
            aadhaar.setText(employeeList1.get(position).getAdhaarNumber() + "");

            return convertView;
        }

        @Override
        public Employee getItem(int position) {
            return employeeList1.get(position);
        }

        @Override
        public int getCount() {
            return employeeList1.size();
        }
    }
}

