package com.project.hackathon.saude.supermae.adapter;

import android.content.Context;
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
import com.project.hackathon.saude.supermae.model.Consulta;

import java.util.ArrayList;

/**
 * Created by Matheus on 09/04/2017.
 */

public class ConsultaCustomAdapter extends ArrayAdapter<Consulta> implements View.OnClickListener {

    private ArrayList<Consulta> dataSet;
    private Context mContext;

    private static class ViewHolder {
        TextView tv_nome_doutor;
        TextView tv_data_consulta;
        LinearLayout ll_linha;
    }

    public ConsultaCustomAdapter(ArrayList<Consulta> data, Context context) {
        super(context, R.layout.row_item_consulta, data);

        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Consulta consulta = (Consulta) object;

    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        final Consulta consulta = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_consulta, parent, false);

            viewHolder.tv_nome_doutor = (TextView) convertView.findViewById(R.id.tv_nome_doutor);
            viewHolder.tv_data_consulta = (TextView) convertView.findViewById(R.id.tv_data_consulta);
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


        viewHolder.tv_nome_doutor.setText("" + consulta.getNomeDoutor());
        viewHolder.tv_nome_doutor.setTypeface(null, Typeface.BOLD);

        viewHolder.tv_data_consulta.setText("" + consulta.getData());
        viewHolder.tv_data_consulta.setTypeface(null, Typeface.BOLD);

        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    Intent i = new Intent(mContext, InfoReuniaoActivity.class);
//
//                    i.putExtra("Id", String.valueOf(consulta.getId()));
//
//                    mContext.startActivity(i);
            }
        });

        return convertView;
    }
}

