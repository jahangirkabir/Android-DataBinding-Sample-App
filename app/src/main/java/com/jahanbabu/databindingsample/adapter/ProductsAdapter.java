package com.jahanbabu.databindingsample.adapter;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.jahanbabu.databindingsample.R;
import com.jahanbabu.databindingsample.databinding.ListItemBinding;
import com.jahanbabu.databindingsample.model.Blush;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private ArrayList<Blush> blushes;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding productBinding;

        public MyViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.productBinding = listItemBinding;
        }

        public void bindConnection(Blush blush){
            productBinding.setBlush(blush);
        }

    }

    public ProductsAdapter(ArrayList<Blush> productList) {
        this.blushes = productList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding productBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        return new MyViewHolder(productBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindConnection(blushes.get(position));
    }


    @Override
    public int getItemCount() {
        return blushes.size();
    }
}
