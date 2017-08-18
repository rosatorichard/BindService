package com.batchmates.android.binderproject.view.secondactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.batchmates.android.binderproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 8/18/2017.
 */

public class RecyclerAdapterHelper extends RecyclerView.Adapter<RecyclerAdapterHelper.ViewHolder>{

    List<String> myList= new ArrayList<>();

    public RecyclerAdapterHelper(List<String> myList) {
        this.myList = myList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String current= myList.get(position);
        holder.randomText.setText(current.toString());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView randomText;
        public ViewHolder(View itemView) {
            super(itemView);
            randomText=itemView.findViewById(R.id.tvStringList);
        }
    }
}
