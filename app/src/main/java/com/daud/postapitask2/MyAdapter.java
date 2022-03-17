package com.daud.postapitask2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<OrderInfoMc> List;

    public MyAdapter(Context context, java.util.List<OrderInfoMc> list) {
        this.context = context;
        List = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.orderIdVh.setText("Order Id: " + List.get(position).getOrderid());
        holder.customerVh.setText("Customer: " + List.get(position).getCustomer());
        holder.amountVh.setText("Amount: " + List.get(position).getAmount());
        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context, "Order Id is: "+List.get(position).getOrderid(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView orderIdVh,customerVh,amountVh;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            orderIdVh = itemView.findViewById(R.id.orderIdVh);
            customerVh = itemView.findViewById(R.id.customerVh);
            amountVh = itemView.findViewById(R.id.amountVh);
        }
    }
}
