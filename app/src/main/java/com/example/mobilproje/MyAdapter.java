package com.example.mobilproje;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<String> list;
    String[] oncelik;


    public MyAdapter(Context context, List<String> list,String[] oncelik){
        this.list=list;
        this.context=context;
        this.oncelik= Arrays.copyOf(oncelik,oncelik.length);


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.textView.setText(list.get(position));
        holder.textView.setTextColor(Color.BLACK);
        try{
            if(oncelik[position].equals("Low")){
                holder.textView.setTextColor(Color.GREEN);
            }else if(oncelik[position].equals("High")){
                holder.textView.setTextColor(Color.RED);
            }

        }catch (Exception e){

        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bakilannot=list.get(position);
                Intent intent=new Intent(".Notepage");
                intent.putExtra("bakilannot",bakilannot);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv);
        }
    }

}
