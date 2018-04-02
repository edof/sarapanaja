package com.edo.esarapan.model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edo.esarapan.R;
import com.edo.esarapan.activity.DetAspActivity;

import java.util.ArrayList;

/**
 * Created by Edo Firmansyah on 3/17/2018.
 */

public class AspirasiAdapter extends RecyclerView.Adapter<AspirasiAdapter.AspirasiViewHolder> {

    private Context mContext;
    private ArrayList<AspirasiItem> mAspList;

    public AspirasiAdapter( Context context, ArrayList<AspirasiItem> aspirasiList){
        this.mContext = context;
        this.mAspList = aspirasiList;
    }

    @NonNull
    @Override
    public AspirasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        view = inflater.inflate(R.layout.sarapan_card, parent, false);
        AspirasiViewHolder aspVH = new AspirasiViewHolder(view);
        return aspVH;
    }

    @Override
    public void onBindViewHolder(@NonNull AspirasiViewHolder holder, int position) {
        AspirasiItem aspirasiItem = mAspList.get(position);
        AspirasiViewHolder aspHolder = (AspirasiViewHolder) holder;

//        Glide.with(mContext)
//                .load()
        aspHolder.tvNama.setText(aspirasiItem.getNama());
        aspHolder.tvUraian.setText(aspirasiItem.getUraian());
        aspHolder.tvKategori.setText(aspirasiItem.getKategori());

    }

    @Override
    public int getItemCount() {

        if (mAspList !=null){
            return mAspList.size();
        }
        return 0;
    }

    public class AspirasiViewHolder extends RecyclerView.ViewHolder{

        CardView cvAsp;
        TextView tvNama, tvUraian, tvKategori;
        AspirasiViewHolder(View itemView) {
            super(itemView);
            cvAsp = itemView.findViewById(R.id.cvAspirasi);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvUraian = itemView.findViewById(R.id.tvUraian);
            tvKategori = itemView.findViewById(R.id.tvKategori);

            cvAsp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    AspirasiItem ai = mAspList.get(position);
                    Intent intent = new Intent(view.getContext(), DetAspActivity.class);

                    String getId = ai.getId_aspirasi();
                    intent.putExtra("id_aspirasi", getId);

                    String getNama = ai.getNama();
                    intent.putExtra("nama", getNama);


                    String getUraian = ai.getUraian();
                    intent.putExtra("uraian", getUraian);

                    String getKategori = ai.getKategori();
                    intent.putExtra("kategori", getKategori);


                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}
