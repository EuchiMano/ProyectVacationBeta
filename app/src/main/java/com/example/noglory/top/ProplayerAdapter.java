package com.example.noglory.top;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProplayerAdapter extends RecyclerView.Adapter<ProplayerAdapter.ViewHolder> {

    private List<ProPlayer> proplayers;
    private Context context;
    private OnItemClickListener listener;

    public ProplayerAdapter(List<ProPlayer> proplayers, OnItemClickListener listener) {
        this.proplayers = proplayers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_proplayer, viewGroup, false);
        this.context = viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ProPlayer proPlayer = proplayers.get(i);

        viewHolder.setListener(proPlayer, listener);
        viewHolder.tvNombre.setText(proPlayer.getNombreCompleto());
        viewHolder.tvOrden.setText(String.valueOf(proPlayer.getOrden()));
    }

    @Override
    public int getItemCount() {
        return this.proplayers.size();
    }

    public void add(ProPlayer proPlayer){
        if (!proplayers.contains(proPlayer)){
            proplayers.add(proPlayer);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imagePhoto)
        AppCompatImageView imagePhoto;
        @BindView(R.id.tvNombre)
        AppCompatTextView tvNombre;
        @BindView(R.id.tvOrden)
        AppCompatTextView tvOrden;
        @BindView(R.id.rlcontainerMain)
        RelativeLayout rlcontainerMain;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setListener(final ProPlayer proPlayer, final OnItemClickListener listener){
            rlcontainerMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(proPlayer);
                }
            });

            rlcontainerMain.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongItemClick(proPlayer);
                    return true;
                }
            });
        }
    }
}
