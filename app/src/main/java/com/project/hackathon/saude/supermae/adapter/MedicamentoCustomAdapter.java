package com.project.hackathon.saude.supermae.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
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
import com.project.hackathon.saude.supermae.model.Medicamento;

import java.util.ArrayList;

/**
 * Created by Matheus on 09/04/2017.
 */

public class MedicamentoCustomAdapter extends ArrayAdapter<Medicamento> implements View.OnClickListener {

    private ArrayList<Medicamento> dataSet;
    private Context mContext;

    private static class ViewHolder {
        ImageView img_medicamento;
        TextView tv_nome_remedio;
        TextView tv_data;
        LinearLayout ll_linha;
    }

    public MedicamentoCustomAdapter(ArrayList<Medicamento> data, Context context) {
        super(context, R.layout.row_item_consulta, data);

        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Medicamento medicamento = (Medicamento) object;

    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        final Medicamento medicamento = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_consulta, parent, false);

            viewHolder.img_medicamento = (ImageView) convertView.findViewById(R.id.img_consulta);
            viewHolder.tv_nome_remedio = (TextView) convertView.findViewById(R.id.tv_nome_doutor);
            viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_data_consulta);
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


        viewHolder.img_medicamento.setImageResource(R.drawable.medicamento);

        viewHolder.tv_nome_remedio.setText("" + medicamento.getNome());
        viewHolder.tv_nome_remedio.setTypeface(null, Typeface.BOLD);

        viewHolder.tv_data.setText("" + medicamento.getData());
        viewHolder.tv_data.setTypeface(null, Typeface.BOLD);


        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    Intent i = new Intent(mContext, InfoReuniaoActivity.class);
//
//                    i.putExtra("Id", String.valueOf(medicamento.getId()));
//
//                    mContext.startActivity(i);
            }
        });

        return convertView;
    }
}