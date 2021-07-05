package com.ashraf.inward;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.List;

public class InwardAdapter extends FirestoreRecyclerAdapter<Inward_Model,InwardAdapter.viewholder> {


    public InwardAdapter(@NonNull FirestoreRecyclerOptions<Inward_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull Inward_Model model) {
        holder.tv.setText(model.getName());
        Glide.with(holder.imv.getContext()).load(model.getPic()).into(holder.imv);

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new viewholder(view);
    }

    static class viewholder extends RecyclerView.ViewHolder{

       TextView tv;
       ImageView imv;
       public viewholder(@NonNull View itemView) {
           super(itemView);

           tv = itemView.findViewById(R.id.TVname);
           imv = itemView.findViewById(R.id.imgv);


       }
   }

}
