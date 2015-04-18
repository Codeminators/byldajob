package in.policyhack.byldajob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class CategoryFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String categoryName;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView category = (TextView) rootView.findViewById(R.id.category);
        ImageButton hospitality = (ImageButton) rootView.findViewById(R.id.hospitality);
        ImageButton security = (ImageButton) rootView.findViewById(R.id.security);
        ImageButton fabrication = (ImageButton) rootView.findViewById(R.id.fabrication);
        ImageButton garmentMaking = (ImageButton) rootView.findViewById(R.id.garment);
        ImageButton banking = (ImageButton) rootView.findViewById(R.id.banking);
        ImageButton informationTechnology = (ImageButton) rootView.findViewById(R.id.information_technology);
        ImageButton retail = (ImageButton) rootView.findViewById(R.id.retail);
        ImageButton electrical = (ImageButton) rootView.findViewById(R.id.electrical);
        ImageButton automotiveRepair = (ImageButton) rootView.findViewById(R.id.automotive_repair);

        hospitality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Hospitality";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Security";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        fabrication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Fabrication";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        garmentMaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Garment Making";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        electrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Electrical";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        automotiveRepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Automotive Repair";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Banking & Accounting";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        informationTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Information and Communication Technology";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        retail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryName = "Retail";
                final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, SpecialityFragment.newInstance(categoryName));
                ft.commit();
            }
        });

        return rootView;

    }

}
