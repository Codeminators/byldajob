package in.policyhack.byldajob;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpecialityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpecialityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialityFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private OnFragmentInteractionListener mListener;

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
        }
        String category = "";
        ArrayList<String> specialities = new ArrayList<>();
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);




        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
