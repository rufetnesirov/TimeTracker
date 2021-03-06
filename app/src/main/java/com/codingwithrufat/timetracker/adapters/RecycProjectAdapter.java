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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycProjectAdapter extends RecyclerView.Adapter<RecycProjectAdapter.ViewHolder>{
    private String TAG="MyTagHere";
    private List<Project> myList;
    private Context context;

    public RecycProjectAdapter(List<Project> list,Context context){
        myList=list;
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
        Log.d(TAG, "onBindViewHolder: we are here!"+ myList.size());

        //Get date to the timer
//        String day = getDay(myList.get(position).getStart());
//        holder.date.setText(day);



        //code for recyclerView
        Log.d(TAG, "moveToProjectAdapter: secondPage:"+myList.get(0).getColor_code());
        RecycProjectSubAdapter subAdapter=new RecycProjectSubAdapter(myList,context);
        holder.subRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.subRecyclerView.setAdapter(subAdapter);
    }

    private String getDay(Long start) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date resultDate = new Date(start);
        return sdf.format(resultDate);

    }

    @Override
    public int getItemCount() {
        return myList.size();
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
