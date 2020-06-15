package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.StateModel;
import com.example.myapplication.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

   private ArrayList<StateModel> arrayList;

    public StateAdapter(ArrayList<StateModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.state_case,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {

        StateModel stateModel=arrayList.get(position);
        holder.stateName.setText(stateModel.getStateName());
        holder.stateCase.setText(stateModel.getStateCase());

    }

    @Override
    public int getItemCount()
    {
        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView stateName,stateCase;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

       stateCase=itemView.findViewById(R.id.state_case);
stateName=itemView.findViewById(R.id.stateName);
        }
    }
}
