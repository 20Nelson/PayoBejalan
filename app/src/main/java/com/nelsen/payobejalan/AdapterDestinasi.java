package com.nelsen.payobejalan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDestinasi extends RecyclerView.Adapter<AdapterDestinasi.ViewHolderDestinasi>{
    private Context ctx;
    private ArrayList arrNama, arrAlamat, arrJam;

    public AdapterDestinasi(Context ctx, ArrayList arrNama, ArrayList arrAlamat, ArrayList arrJam) {
        this.ctx = ctx;
        this.arrNama = arrNama;
        this.arrAlamat = arrAlamat;
        this.arrJam = arrJam;
    }

    @NonNull
    @Override
    public ViewHolderDestinasi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDestinasi holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderDestinasi extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvJam;

        public ViewHolderDestinasi(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvJam = itemView.findViewById(R.id.tv_jam);
        }
    }
}
