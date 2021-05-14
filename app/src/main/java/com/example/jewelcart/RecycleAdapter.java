package com.example.jewelcart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    ArrayList<Products> setofProducts;
    Context context;

    public RecycleAdapter(Context context, ArrayList<Products> aProducts) {
        this.context = context;
        setofProducts = aProducts;
    }

    public Products getItem(int position) {
        return setofProducts.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Initialise the views
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign the views to IDs
            imageView = itemView.findViewById(R.id.recycle_image);
            textView = itemView.findViewById(R.id.recycle_text);
        }
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("Object", setofProducts.get(position));
                context.startActivity(intent);
            }
        });
        holder.imageView.setImageResource(setofProducts.get(position).getImageAddresses()[0]);
        holder.textView.setText(setofProducts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return setofProducts.size();
    }

}




