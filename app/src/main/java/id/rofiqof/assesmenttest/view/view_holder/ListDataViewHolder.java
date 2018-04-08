package id.rofiqof.assesmenttest.view.view_holder;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import id.rofiqof.assesmenttest.databinding.ListDataBarangBinding;
import id.rofiqof.assesmenttest.model.DataBarang;

public class ListDataViewHolder extends RecyclerView.ViewHolder {

    ListDataBarangBinding content;

    public ListDataViewHolder(View itemView) {
        super(itemView);
        content = DataBindingUtil.bind(itemView);
    }

    public void onBind(Context context, DataBarang model) {
        content.namaBarang.setText(model.getNama());
        content.jumlahBarang.setText(model.getJumlah());
        content.pemasok.setText(model.getPemasok());
        content.tanggal.setText(model.getTanggal());
    }
}
