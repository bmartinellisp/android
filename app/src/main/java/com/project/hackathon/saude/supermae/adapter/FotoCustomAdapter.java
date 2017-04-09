package com.project.hackathon.saude.supermae.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.hackathon.saude.supermae.R;
import com.project.hackathon.saude.supermae.model.Foto;

import java.util.List;

/**
 * Created by Matheus on 08/04/2017.
 */

public class FotoCustomAdapter extends RecyclerView.Adapter<FotoCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<Foto> newsfeedList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public LinearLayout ll_card_newsfeed;
        public MyViewHolder(View view) {
            super(view);
            title         = (TextView) view.findViewById(R.id.title);
            count         = (TextView) view.findViewById(R.id.count);
            thumbnail     = (ImageView) view.findViewById(R.id.thumbnail);
            overflow      = (ImageView) view.findViewById(R.id.overflow);
            ll_card_newsfeed = (LinearLayout) view.findViewById(R.id.foto_card);
        }
    }

    public FotoCustomAdapter(Context mContext, List<Foto> newsfeedList) {
        this.mContext = mContext;
        this.newsfeedList = newsfeedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.foto_card, parent, false);

        return new MyViewHolder(itemView);
    }
    Foto foto;
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        foto =  newsfeedList.get(position);
        holder.title.setText(foto.getNome());
        holder.count.setText(""  + foto.getNome());
        //holder.overflow.setImageResource(R.drawable.three_dots);
        holder.ll_card_newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
//                i.putExtra("id",newsfeed.getId());
//
//                mContext.startActivity(i);
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
//                i.putExtra("id",newsfeed.getId());
//
//                mContext.startActivity(i);
            }
        });


        Glide.with(mContext).load(foto.getImgPrincipal()).into(holder.thumbnail);

    }



    @Override
    public int getItemCount() {
        return newsfeedList.size();
    }
}
