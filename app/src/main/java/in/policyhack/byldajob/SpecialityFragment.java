package in.policyhack.byldajob;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SpecialityFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private ArrayList<String> specialities;
    private ListView listView;
    private ArrayAdapter<String> listAdapter;

    // TODO: Rename and change types and number of parameters
    public static SpecialityFragment newInstance(String param1) {
        SpecialityFragment fragment = new SpecialityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SpecialityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            Log.d("sdfd",mParam1);
        }
        String category = mParam1.trim();
        specialities = new ArrayList<>();
        if(category.equals("Hospitality")){
            specialities.add("HOS101-Hospitality Assistant");
            specialities.add("HOS610-Front office cum receptionist Technology");
            specialities.add("HOS276 - Food and beverage service");
            specialities.add("HOS704-Housekeeper");
        }
        else if (category.equals("Security")) {
            specialities.add("SEC205-Security Guard(General) & Personal Security Guard");
        }
        else if (category.equals("Retail")) {
            specialities.add("RET104-Sales Person (Door to Door)");
            specialities.add("RET101-Sales Person ( Retail)");
            specialities.add("RAS/Q0102-Cashier");
            specialities.add("RAS/Q0104-Sales Associate");
        }
        else if (category.equals("Fabrication")) {
            specialities.add("FAB108-Basic Fitting Work");
            specialities.add("FAB706-Welder (Repair & Maintenance)");
        }
        else if (category.equals("Automotive Repair")) {
            specialities.add("AUR101-Basic Automotive Servicing (4 Wheelers)");
            specialities.add("AUR703-Driver cum Mechanic");
        }
        else if (category.equals("Bank & Accounting")) {
            specialities.add("BAN101-Accounting");
            specialities.add("BAN104-Mutual Fund Associate");
        }
        else if (category.equals("Electrical")) {
            specialities.add("ELE701-Electrician Domestic");
            specialities.add("ELE101-Basic Electrical Training");
        }
        else if (category.equals("Garment Making")) {
            specialities.add("GAR 516-Tailor (Basic Sewing Operator)");
            specialities.add("GAR515-Industrial Sewing Machine Operator");
        }
        else if (category.equals("Information And Communication Technology")) {
            specialities.add("ICT113-BPO Non Voice business training");
            specialities.add("ICT703-Computer Hardware Assistant");
            specialities.add("ICT701-Accounts Assistant using Tally");
            specialities.add("ICT101-Computer Fundamentals, MS-Office & Internet");
        }

        Log.d("jdsg","" +specialities);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_speciality, container, false);

        listView = (ListView) rootView.findViewById(R.id.listView);
        final CheckBox relocate = (CheckBox) rootView.findViewById(R.id.checkbox);
        final EditText editText = (EditText) rootView.findViewById(R.id.proposed_salary);
        final EditText location = (EditText) rootView.findViewById(R.id.location);
        listAdapter = new ArrayAdapter<>(getActivity(), R.layout.row_listview, specialities);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("location",location.getText().toString());
                editor.apply();
                Intent intent = new Intent();
                intent.putExtra("relocate", relocate.isChecked());
                intent.putExtra("proposed_salary",editText.getText().toString());
                intent.putExtra("specialization",specialities.get(i));
                startActivity(intent);
            }
        });
        return rootView;
    }

}
