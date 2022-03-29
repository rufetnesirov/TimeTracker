package com.codingwithrufat.timetracker.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.dataModels.TimeProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycProjectAdapter extends RecyclerView.Adapter<RecycProjectAdapter.ViewHolder>{
    private String TAG="MyTagHere";
    private List<String> myDateList;
    private Context context;

    public RecycProjectAdapter(List<String> list, Context context){
        myDateList=list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        //date
        holder.date.setText(myDateList.get(position));



        //code for recyclerView
        RecycProjectSubAdapter subAdapter=new RecycProjectSubAdapter(myDateList.get(position),context);
        holder.subRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.subRecyclerView.setAdapter(subAdapter);
    }


    @Override
    public int getItemCount() {
        return myDateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        RecyclerView subRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.projectTime);
            subRecyclerView=itemView.findViewById(R.id.subRecyclerView);
        }
    }
}
