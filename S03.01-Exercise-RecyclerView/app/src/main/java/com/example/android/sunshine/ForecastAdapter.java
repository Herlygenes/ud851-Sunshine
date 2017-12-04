package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Herlygenes Pinto on 03/12/2017.
 */

// TODO (15) Add a class file called ForecastAdapter
// TODO (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    // TODO (23) Create a private string array called mWeatherData
    private String[] mWeatherData;

    // TODO (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter() {
    }

    // TODO (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // TODO (17) Extend RecyclerView.ViewHolder
    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        // TODO (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;
        // TODO (19) Create a constructor for this class that accepts a View as a parameter
        public ForecastAdapterViewHolder(View itemView) {
            // TODO (20) Call super(view) within the constructor for ForecastAdapterViewHolder
            super(itemView);
            // TODO (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
            this.mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }

    // TODO (24) Override onCreateViewHolder
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO (25) Within onCreateViewHolder, inflate the list item xml into a view
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        // TODO (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
        return new ForecastAdapterViewHolder(view);
    }

    // TODO (27) Override onBindViewHolder
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        // TODO (28) Set the text of the TextView to the weather for this list item's position
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }


    // TODO (29) Override getItemCount
    @Override
    public int getItemCount() {
        // TODO (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
        return mWeatherData!=null?mWeatherData.length:0;
    }

    // TODO (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    public void setWeatherData(String[] weatherData){
        mWeatherData = weatherData;
        // TODO (32) After you save mWeatherData, call notifyDataSetChanged
        notifyDataSetChanged();
    }

}
