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
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ChooseEmployees extends ActionBarActivity {

    private ArrayList<Employee> employeeList;
    private Adapter arrayAdapter;
    private int i;
    ProgressBar p;


   SwipeFlingAdapterView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_employees);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        employeeList = new ArrayList<Employee>();
        Intent intent = getIntent();
        intent.getBooleanExtra("relocate", false);
        String salary = intent.getStringExtra("proposed_salary");
        String specalization = intent.getStringExtra("specialization");
        Log.d("raghav", "SELECT * FROM tbl WHERE Courseoftraining = \""+specalization+"\" AND Previousmonthlysalarydrawn >= \""+ salary +"\"");

        new QueryTask(){
            @Override
            protected String doInBackground(String... strings) {

                p = (ProgressBar) findViewById(R.id.progess);
                p.setVisibility(View.VISIBLE);

                return super.doInBackground(strings);

            }

            @Override
            protected void onPostExecute(String s) {
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    p.setVisibility(View.VISIBLE);

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        Employee employee = new Employee();
                        employee.setName(jsonObject.getString("Name"));
                        employee.setState(jsonObject.getString("State"));
                        employee.setDistrict(jsonObject.getString("District"));
                        employee.setPoliceVerification(jsonObject.getString("PoliceVerification"));
                        employee.setAdhaarNumber(jsonObject.getLong("AadhaarNumber"));
                        employee.setMobileNumber(jsonObject.getLong("mobile"));
                        employee.setHighestEducation(jsonObject.getString("HighestEducation"));
                        employee.setSector(jsonObject.getString("Sectoroftraining"));
                        employee.setSpeciality(jsonObject.getString("Courseoftraining"));
                        employee.setMarks(jsonObject.getInt("MarksReceived"));
                        employee.setRetention(jsonObject.getInt("retention"));
                        employee.setLastEmployedAt(jsonObject.getInt("lastemployed"));
                        employee.setWorkEx(jsonObject.getInt("PreviousWorkExperience"));
                        employee.setPreviousSalary(jsonObject.getInt("Previousmonthlysalarydrawn"));
                        employeeList.add(i,employee);

                    }
                    arrayAdapter = new Adapter(getApplication(), employeeList);
                    flingContainer.setAdapter(arrayAdapter);
                    Log.d("Raghav", "" + employeeList.size() +""+arrayAdapter.getCount());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }.execute("SELECT * FROM tbl WHERE Courseoftraining = \""+specalization+"\" AND Previousmonthlysalarydrawn >= \""+ salary +"\"");

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                employeeList.remove(0);
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
            chooseEmployeesFromAlgorithm(employeeList);
            Intent intent = new Intent(getApplicationContext(), EmployeeListActivity.class);
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


    public class Adapter extends BaseAdapter {
        private TextView name;
        private TextView number;
        private TextView state;
        private TextView district;
        private TextView aadhaar;
        private TextView policeVerification;
        private TextView highestEducation;
        private TextView workExperience;
        private TextView expectedSalary;
        private TextView marksReceived;

        private ArrayList<Employee> employeeList1;
        Context c;


        public Adapter(Context context, ArrayList<Employee> employeeList){
            this.employeeList1 = employeeList;
            Log.d("Roalts", "" + employeeList.size());
            this.c = context;
        }

        @Override
        public int getCount() {
            Log.d("Roalts22", "" + employeeList.size());
            return employeeList.size();
        }

        @Override
        public Object getItem(int position) {
            return employeeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            LayoutInflater inflater = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = convertView;
            if(convertView == null) {
                v = inflater.inflate(R.layout.item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.name = (TextView) v.findViewById(R.id.name_employee);
                viewHolder.number = (TextView) v.findViewById(R.id.mobile_number);
                viewHolder.aadhaar = (TextView) v.findViewById(R.id.aadhaar_number);
                viewHolder.district = (TextView) v.findViewById(R.id.district_employee);
                viewHolder.state = (TextView) v.findViewById(R.id.state_employee);
                viewHolder.policeVerification = (TextView) v.findViewById(R.id.police_verification);
                viewHolder.highestEducation = (TextView) v.findViewById(R.id.highest_education);
                viewHolder.workExperience = (TextView) v.findViewById(R.id.work_ex);
                viewHolder.marksReceived = (TextView) v.findViewById(R.id.marks);
                viewHolder.expectedSalary = (TextView) v.findViewById(R.id.expected_salary);
                v.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) v.getTag();
            }

            viewHolder.name.setText(employeeList1.get(position).getName());
            Log.d("Roalts1", ""+employeeList1.get(position).getName());
            viewHolder.number.setText(employeeList1.get(position).getMobileNumber()+ "");
            viewHolder.state.setText(employeeList1.get(position).getState());
            viewHolder.district.setText(employeeList1.get(position).getDistrict());
            viewHolder.policeVerification.setText(employeeList1.get(position).getPoliceVerification() + "");
            viewHolder.workExperience.setText(employeeList1.get(position).getWorkEx() + "");
            viewHolder.expectedSalary.setText(employeeList1.get(position).getPreviousSalary() + "");
            viewHolder.marksReceived.setText(employeeList1.get(position).getMarks() + "");
            viewHolder.highestEducation.setText(employeeList1.get(position).getHighestEducation() + "");
            viewHolder.aadhaar.setText(employeeList1.get(position).getAdhaarNumber() + "");

            return v;
        }

    }
    public static class ViewHolder {
        private TextView name;
        private TextView number;
        private TextView state;
        private TextView district;
        private TextView aadhaar;
        private TextView policeVerification;
        private TextView highestEducation;
        private TextView workExperience;
        private TextView expectedSalary;
        private TextView marksReceived;

    }
}

