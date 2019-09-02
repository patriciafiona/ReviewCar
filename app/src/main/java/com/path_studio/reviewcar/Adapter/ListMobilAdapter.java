package com.path_studio.reviewcar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.path_studio.reviewcar.Models.Mobil;
import com.path_studio.reviewcar.Models.MobilData;
import com.path_studio.reviewcar.R;
import com.path_studio.reviewcar.fragments.DetailMobilFragment;
import com.path_studio.reviewcar.fragments.HomeFragment;

import java.util.ArrayList;

public class ListMobilAdapter extends RecyclerView.Adapter<ListMobilAdapter.ListViewHolder>{

    private ArrayList<Mobil> listMobil;
    public ListMobilAdapter(ArrayList<Mobil> list) {
        this.listMobil = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_car, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Mobil mobil = listMobil.get(position);
        Glide.with(holder.itemView.getContext())
                .load(mobil.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(mobil.getMerk_mobil());
        holder.tvFrom.setText(mobil.getRange_harga());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listMobil.get(holder.getAdapterPosition()).getMerk_mobil(), Toast.LENGTH_SHORT).show();

                //menampilkan datanya
                MobilData  mobilData = new MobilData();
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.go_to_detail(mobilData.getDetailData(holder.getAdapterPosition()));
                
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMobil.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
        }
    }

}
