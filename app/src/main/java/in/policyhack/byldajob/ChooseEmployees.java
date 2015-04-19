package in.policyhack.byldajob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ChooseEmployees extends ActionBarActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;


   SwipeFlingAdapterView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_employees);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        Intent intent = getIntent();
        intent.getBooleanExtra("relocate", false);
        String salary = intent.getStringExtra("proposed_salary");
        String specalization = intent.getStringExtra("specialization");

        new QueryTask(){
            @Override
            protected void onPostExecute(String s) {
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    ArrayList<Employee> employeeList = new ArrayList<Employee>();
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
                        employee.setRetention(jsonObject.getInt(""));
                        employee.setLastEmployedAt(jsonObject.getInt(""));
                        employee.setWorkEx(jsonObject.getInt("PreviousWorkExperience"));
                        employee.setPreviousSalary(jsonObject.getInt("Previousmonthlysalarydrawn"));
                        employeeList.add(i,employee);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute("SELECT * FROM tbl WHERE Courseoftraining = \""+specalization+"\" AND Previousmonthlysalarydrawn >= '"+ salary +"'");

        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );


        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
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
                al.add("XML ".concat(String.valueOf(i)));
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

}
