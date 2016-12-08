package com.jahanbabu.khoj.adapter;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jahanbabu.khoj.R;
import com.jahanbabu.khoj.databinding.AdapterProductBinding;
import com.jahanbabu.khoj.model.Product;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private ArrayList<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private AdapterProductBinding productBinding;

        public MyViewHolder(AdapterProductBinding _productBinding) {
            super(_productBinding.getRoot());
            this.productBinding = _productBinding;
        }

        public void bindConnection(Product product){
            productBinding.setProduct(product);
        }

    }

    public ProductsAdapter(ArrayList<Product> productList) {
        this.productList = productList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterProductBinding productBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_product, parent, false);
        return new MyViewHolder(productBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindConnection(productList.get(position));
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
}
