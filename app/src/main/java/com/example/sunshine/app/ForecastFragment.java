package com.example.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A forecast fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        List<String> weekWeatherForecast = new ArrayList();

        weekWeatherForecast.add("Today - Sunny - 88/63");
        weekWeatherForecast.add("Tomorrow - Foggy - 70/46");
        weekWeatherForecast.add("Weds - Cloudy - 72/63");
        weekWeatherForecast.add("Thurs - Rainy - 64/51");
        weekWeatherForecast.add("Fri - Foggy - 70/46");
        weekWeatherForecast.add("Sat - Sunny - 76/78");
        weekWeatherForecast.add("Sun - Asteroids - 100/150");

        ArrayAdapter<String> forecastAdapter = new ArrayAdapter <String>(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                weekWeatherForecast);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(forecastAdapter);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            FetchWeatherTask task = new FetchWeatherTask();
            task.execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
