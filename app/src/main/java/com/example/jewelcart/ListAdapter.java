package com.example.jewelcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Products> {

    ArrayList<Products> products, orig;

    private static class ViewHolderItems {

        public ImageView ItemCover;
        public TextView ItemName;
        public TextView ItemPrice;
    }

    public ListAdapter(Context context, ArrayList<Products> aProducts) {

        super(context, 0, aProducts);
        products = aProducts;
    }

    public ListAdapter(Context context, int resID, ArrayList<Products> aProducts) {
        super(context, resID, aProducts);
        products = aProducts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get the data item for this position
        final Products curprod = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolderItems viewHolderProducts;

        if (convertView == null){
            viewHolderProducts = new ViewHolderItems();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list,parent,false);
            viewHolderProducts.ItemCover = (ImageView)convertView.findViewById(R.id.ItemCover);
            viewHolderProducts.ItemName = (TextView)convertView.findViewById(R.id.ItemName);
            viewHolderProducts.ItemPrice = (TextView)convertView.findViewById(R.id.ItemPrice);
            convertView.setTag(viewHolderProducts);
        } else{
            viewHolderProducts = (ViewHolderItems) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolderProducts.ItemName.setText(curprod.getName());
        viewHolderProducts.ItemPrice.setText(curprod.getPrice());

        int[] resID = curprod.getImageAddresses();

        viewHolderProducts.ItemCover.setImageResource(resID[0]);

        return convertView;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Products> results = new ArrayList<Products>();
                if (orig == null)
                    orig = products;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final Products g : orig) {
                            if (g.getName().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                ListAdapter adapter = new ListAdapter(getContext(), (ArrayList<Products>)results.values);
                notifyDataSetChanged();
            }
        };
    }


    public int getItemCount() {
        return products.size();
    }
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
