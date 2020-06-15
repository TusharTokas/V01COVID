package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.CountryModel;
import com.example.myapplication.Model.StateModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

   private ArrayList<CountryModel> arrayList;

    public CountryAdapter(ArrayList<CountryModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_case,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {

            CountryModel countryModel=arrayList.get(position);
        holder.countryName.setText(countryModel.getCountryName());
        holder.countryCase.setText(countryModel.getCountryCase());

    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView countryName,countryCase;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

       countryCase=itemView.findViewById(R.id.country_case);
countryName=itemView.findViewById(R.id.countryName);
        }
    }
}
