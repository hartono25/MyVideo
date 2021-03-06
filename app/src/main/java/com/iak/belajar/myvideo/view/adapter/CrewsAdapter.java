package com.iak.belajar.myvideo.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iak.belajar.myvideo.R;
import com.iak.belajar.myvideo.model.Credit;
import com.iak.belajar.myvideo.restapi.RestAPIURL;
import com.iak.belajar.myvideo.utility.CommonFunction;

import java.util.List;


public class CrewsAdapter extends RecyclerView.Adapter<CrewsAdapter.ListHolder> {
    private Context context;
    private List<Credit.Crew> crews;

    public CrewsAdapter(Context context, List<Credit.Crew> crews) {
        this.context = context;
        this.crews = crews;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_movie_crews_cardview, null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListHolder holder, int position) {
        holder.detailCrewsName.setText(crews.get(position).getName());
        holder.detailCrewsJob.setText(crews.get(position).getJob());
        CommonFunction.setImage(context, RestAPIURL.getUrlImage(crews.get(position).getProfilePath()), holder.detailCrewsPic);
    }

    @Override
    public int getItemCount() {
        return crews.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {
        TextView detailCrewsName;
        TextView detailCrewsJob;
        ImageView detailCrewsPic;
        CardView detailCrewsLayout;

        ListHolder(View itemView) {
            super(itemView);
            detailCrewsName = (TextView) itemView.findViewById(R.id.detail_crews_name);
            detailCrewsJob = (TextView) itemView.findViewById(R.id.detail_crews_job);
            detailCrewsPic = (ImageView) itemView.findViewById(R.id.detail_crews_pic);
            detailCrewsLayout = (CardView) itemView.findViewById(R.id.detail_crews_layout);
        }
    }
}