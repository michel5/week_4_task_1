package com.example.michel_desktop.week_4_task_1.recyclerVieuw;

import android.arch.persistence.room.Update;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michel_desktop.week_4_task_1.R;
import com.example.michel_desktop.week_4_task_1.StorgeSaveModel;
import com.example.michel_desktop.week_4_task_1.UpdateData;

import java.util.List;

public class StorgeModelAdapter extends RecyclerView.Adapter<StorgeModelAdapter.ViewHolder>{
    private Context context;
    public List<StorgeSaveModel> listStorgeModel;

    /**
     * Construcotr
     * @param context context inhoud
     * @param listStorgeModel storge model
     */
    public StorgeModelAdapter(Context context, List<StorgeSaveModel> listStorgeModel) {
        this.context = context;
        this.listStorgeModel = listStorgeModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final StorgeSaveModel SSM = listStorgeModel.get(position);
        holder.titleView.setText(SSM.getTitel());
        holder.platformView.setText(SSM.getPlatform());
        holder.statusPlayingView.setText(SSM.getStatus());
        holder.datumView.setText(SSM.getDatum());

        //zet click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, UpdateData.class);
                intent.putExtra("ssm", SSM);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listStorgeModel.size();
    }

    /**
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleView;
        public TextView platformView;
        public TextView statusPlayingView;
        public TextView datumView;
        public View vieuw;

        /**
         * Constructor
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);

            this.titleView = itemView.findViewById(R.id.title_vieuw_id);
            this.platformView = itemView.findViewById(R.id.platform_vieuw_id);
            this.statusPlayingView = itemView.findViewById(R.id.status_id);
            this.datumView = itemView.findViewById(R.id.datum_vieuw_id);
            this.vieuw = itemView;
        }
    }
}