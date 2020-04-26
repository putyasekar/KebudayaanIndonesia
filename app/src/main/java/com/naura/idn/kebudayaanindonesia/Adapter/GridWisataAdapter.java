package com.naura.idn.kebudayaanindonesia.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.naura.idn.kebudayaanindonesia.Model.Kebudayaan;
import com.naura.idn.kebudayaanindonesia.R;

import java.util.ArrayList;

public class GridWisataAdapter extends RecyclerView.Adapter<GridWisataAdapter.ViewHolder> {
    private ArrayList<Kebudayaan> listBudaya;
    private onItemClickCallBack onItemClickCallBack;

    public GridWisataAdapter(ArrayList<Kebudayaan> listBudaya) {
        this.listBudaya = listBudaya;

    }

    public void setOnItemClickCallBack(GridWisataAdapter.onItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    @NonNull
    @Override
    public GridWisataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridWisataAdapter.ViewHolder holder, int position) {
        Kebudayaan kebudayaan = listBudaya.get(position);
        Glide.with(holder.itemView.getContext()).load(kebudayaan.getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.imgphoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listBudaya.get(holder.getAdapterPosition()));
            }
        });
        holder.tvName.setText(kebudayaan.getName());
    }

    @Override
    public int getItemCount() {
        return listBudaya.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgphoto;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgphoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_budaya);
        }
    }

    public interface onItemClickCallBack {
        void onItemClicked(Kebudayaan data);
    }
}

