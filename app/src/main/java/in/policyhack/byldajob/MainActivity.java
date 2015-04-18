package in.policyhack.byldajob;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new CategoryFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            TextView category = (TextView) rootView.findViewById(R.id.category);
            ImageView hospitality = (ImageView) rootView.findViewById(R.id.hospitality);
            ImageView security = (ImageView) rootView.findViewById(R.id.security);
            ImageView fabrication = (ImageView) rootView.findViewById(R.id.fabrication);
            ImageView garmentMaking = (ImageView) rootView.findViewById(R.id.garment);
            ImageView banking = (ImageView) rootView.findViewById(R.id.banking);
            ImageView informationTechnology = (ImageView) rootView.findViewById(R.id.information_technology);
            ImageView retail = (ImageView) rootView.findViewById(R.id.retail);
            ImageView electrical = (ImageView) rootView.findViewById(R.id.electrical);
            ImageView automotiveRepair = (ImageView) rootView.findViewById(R.id.automotive_repair);


            return rootView;
        }
    }
}
