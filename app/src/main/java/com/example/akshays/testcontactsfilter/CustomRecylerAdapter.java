package com.example.akshays.testcontactsfilter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.List;



public class CustomRecylerAdapter extends RecyclerView.Adapter<CustomRecylerAdapter.MyViewHolder> {
    private List<ContactsList> contactsList;

    public CustomRecylerAdapter(List<ContactsList> contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
ContactsList list = contactsList.get(position);
        holder.names.setText(list.getNames());
    }
    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public  TextView names;
        public MyViewHolder(View itemView) {
            super(itemView);
            names = (TextView) itemView.findViewById(R.id.contact_name);
        }
    }

    public void updateList(List<ContactsList> list){
        contactsList = list;
        notifyDataSetChanged();
    }
}
