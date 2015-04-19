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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ChooseEmployees extends ActionBarActivity {

    private ArrayList<Employee> employeeList;
    private ArrayAdapter arrayAdapter;
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
        String s = "[{\"Name\":\"Kishor Chandra Nayak\",\"Gender\":\"M\",\"DateofBirth\":\"01-Jan-90\",\"Caste\":\"ST\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Jharkhand\",\"District\":\"Latehar\",\"PoliceStation\":\"Balumath\",\"PoliceVerification\":\"No\",\"AadhaarNumber\":\"647298666287\",\"email\":\"Kishor.Chandra.Nayak@gmail.com\",\"mobile\":\"9143595010\",\"HighestEducation\":\"12th Class\",\"PreviousWorkExperience\":\"1\",\"Previousmonthlysalarydrawn\":\"4356\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"9\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"87\",\"currentemployment\":\"New Delhi\",\"employed\":\"1\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Dandapani Karjee\",\"Gender\":\"M\",\"DateofBirth\":\"12-Apr-93\",\"Caste\":\"ST\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Chhattisgarh\",\"District\":\"Janjgir-Champa\",\"PoliceStation\":\"Janjgir Naila\",\"PoliceVerification\":\"No\",\"AadhaarNumber\":\"930816886445\",\"email\":\"Dandapani.Karjee@gmail.com\",\"mobile\":\"8449309761\",\"HighestEducation\":\"12th Class\",\"PreviousWorkExperience\":\"3\",\"Previousmonthlysalarydrawn\":\"4994\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"12\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"50\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Sangita Xaxa\",\"Gender\":\"F\",\"DateofBirth\":\"25-Mar-95\",\"Caste\":\"ST\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Haryana\",\"District\":\"Rewari\",\"PoliceStation\":\"Rewari\",\"PoliceVerification\":\"Yes\",\"AadhaarNumber\":\"723829533018\",\"email\":\"Sangita.Xaxa@gmail.com\",\"mobile\":\"8010355328\",\"HighestEducation\":\"10th Class\",\"PreviousWorkExperience\":\"2\",\"Previousmonthlysalarydrawn\":\"5840\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"6\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"NCVT\",\"MarksReceived\":\"84\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Mahendra Singh\",\"Gender\":\"M\",\"DateofBirth\":\"15-May-93\",\"Caste\":\"Others\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Haryana\",\"District\":\"Hisar\",\"PoliceStation\":\"Hisar\",\"PoliceVerification\":\"Yes\",\"AadhaarNumber\":\"195844332465\",\"email\":\"Mahendra.Singh@gmail.com\",\"mobile\":\"9932963926\",\"HighestEducation\":\"12th Class\",\"PreviousWorkExperience\":\"4\",\"Previousmonthlysalarydrawn\":\"6735\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"3\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"70\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Pramila Kumari\",\"Gender\":\"F\",\"DateofBirth\":\"01-Jul-85\",\"Caste\":\"ST\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Married\",\"MotherTongue\":\"Hindi\",\"State\":\"Haryana\",\"District\":\"Hisar\",\"PoliceStation\":\"Hisar\",\"PoliceVerification\":\"Yes\",\"AadhaarNumber\":\"307062729753\",\"email\":\"Pramila.Kumari@gmail.com\",\"mobile\":\"9404483394\",\"HighestEducation\":\"10th Class\",\"PreviousWorkExperience\":\"4\",\"Previousmonthlysalarydrawn\":\"3195\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"6\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"58\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Nisha Devi\",\"Gender\":\"F\",\"DateofBirth\":\"20-Jun-88\",\"Caste\":\"SC\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Haryana\",\"District\":\"Panchkula\",\"PoliceStation\":\"pinjore\",\"PoliceVerification\":\"Yes\",\"AadhaarNumber\":\"516382995778\",\"email\":\"Nisha.Devi@gmail.com\",\"mobile\":\"9470513456\",\"HighestEducation\":\"12th Class\",\"PreviousWorkExperience\":\"1\",\"Previousmonthlysalarydrawn\":\"7446\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"3\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"57\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Satendra Yadav\",\"Gender\":\"M\",\"DateofBirth\":\"25-Dec-96\",\"Caste\":\"Others\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Haryana\",\"District\":\"Jhajjar\",\"PoliceStation\":\"Jhajjar\",\"PoliceVerification\":\"No\",\"AadhaarNumber\":\"634069064778\",\"email\":\"Satendra.Yadav@gmail.com\",\"mobile\":\"7904417314\",\"HighestEducation\":\"12th Class\",\"PreviousWorkExperience\":\"3\",\"Previousmonthlysalarydrawn\":\"7607\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"12\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"NCVT\",\"MarksReceived\":\"56\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Dewanti Kumari\",\"Gender\":\"F\",\"DateofBirth\":\"15-Jul-96\",\"Caste\":\"ST\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Haryana\",\"District\":\"Jhajjar\",\"PoliceStation\":\"Jhajjar\",\"PoliceVerification\":\"Yes\",\"AadhaarNumber\":\"212339194082\",\"email\":\"Dewanti.Kumari@gmail.com\",\"mobile\":\"9845216626\",\"HighestEducation\":\"10th Class\",\"PreviousWorkExperience\":\"1\",\"Previousmonthlysalarydrawn\":\"5242\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"12\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"53\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Vandana Devo\",\"Gender\":\"F\",\"DateofBirth\":\"05-May-94\",\"Caste\":\"Others\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Hindi\",\"State\":\"Jharkhand\",\"District\":\"Chatra\",\"PoliceStation\":\"Chatra Sadar\",\"PoliceVerification\":\"No\",\"AadhaarNumber\":\"189552953295\",\"email\":\"Vandana.Devo@gmail.com\",\"mobile\":\"9001446302\",\"HighestEducation\":\"<10th Class\",\"PreviousWorkExperience\":\"4\",\"Previousmonthlysalarydrawn\":\"6376\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"6\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"NCVT\",\"MarksReceived\":\"63\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"},{\"Name\":\"Monoo Kachi\",\"Gender\":\"M\",\"DateofBirth\":\"21-Aug-89\",\"Caste\":\"Others\",\"Religion\":\"Hindu\",\"MaritalStatus\":\"Single\",\"MotherTongue\":\"Oriya\",\"State\":\"Odisha\",\"District\":\"Gajapati\",\"PoliceStation\":\"PARALAKHEMUNDI\",\"PoliceVerification\":\"Yes\",\"AadhaarNumber\":\"486534334234\",\"email\":\"Monoo.Kachi@gmail.com\",\"mobile\":\"9913021128\",\"HighestEducation\":\"10th Class\",\"PreviousWorkExperience\":\"3\",\"Previousmonthlysalarydrawn\":\"5288\",\"Sectoroftraining\":\"Automotive Repair\",\"Courseoftraining\":\"AUR101-Basic Automotive Servicing (4 Wheelers)\",\"Durationofcourse\":\"6\",\"CertificateAvailable\":\"Yes\",\"CertifyingAgency\":\"SSC\",\"MarksReceived\":\"79\",\"currentemployment\":\"\",\"employed\":\"0\",\"retention\":\"0\",\"lastemployed\":\"0\"}]";

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(s);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Employee employee = new Employee();
                employee.setName(jsonObject.getString("Name"));
                employee.setState(jsonObject.getString("State"));
                employee.setDistrict(jsonObject.getString("District"));
                employee.setPoliceVerification(jsonObject.getString("PoliceVerification"));
                employee.setAdhaarNumber(jsonObject.getString("AadhaarNumber"));
                employee.setMobileNumber(jsonObject.getString("mobile"));
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
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


        arrayAdapter = new MyAdapter(getApplicationContext(),employeeList);
        flingContainer.setAdapter(arrayAdapter);
        Log.d("sdgf","" + flingContainer.getAdapter());
        Log.d("Raghav", "" + employeeList.size() +""+arrayAdapter.getCount());
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

