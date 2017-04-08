package com.project.hackathon.saude.supermae.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.hackathon.saude.supermae.R;
import com.project.hackathon.saude.supermae.model.Ranking;

import java.util.ArrayList;

/**
 * Created by Matheus on 08/04/2017.
 */

public class RankingCustomAdapter extends ArrayAdapter<Ranking> implements View.OnClickListener {

    private ArrayList<Ranking> dataSet;
    private Context mContext;

    private static class ViewHolder {
        ImageView img_mamae;
        TextView tv_posicao;
        TextView tv_nome;
        LinearLayout ll_linha;
    }

    public RankingCustomAdapter(ArrayList<Ranking> data, Context context) {
        super(context, R.layout.row_item_ranking, data);

        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Ranking ranking = (Ranking) object;

    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        final Ranking ranking = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_ranking, parent, false);

            viewHolder.img_mamae = (ImageView) convertView.findViewById(R .id.img_mamae);
            viewHolder.tv_posicao = (TextView) convertView.findViewById(R.id.tv_posicao);
            viewHolder.tv_nome = (TextView) convertView.findViewById(R.id.tv_nome);
            viewHolder.ll_linha = (LinearLayout) convertView.findViewById(R.id.ll_linha);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.img_mamae.setImageResource(R.drawable.mae1);

        viewHolder.tv_posicao.setText("" + ranking.getPosicao());
        viewHolder.tv_posicao.setTypeface(null, Typeface.BOLD);

        viewHolder.tv_nome.setText("" + ranking.getNome());
        viewHolder.tv_nome.setTypeface(null, Typeface.BOLD);

        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    Intent i = new Intent(mContext, InfoReuniaoActivity.class);
//
//                    i.putExtra("Id", String.valueOf(ranking.getId()));
//
//                    mContext.startActivity(i);
            }
        });

        return convertView;
    }
}
