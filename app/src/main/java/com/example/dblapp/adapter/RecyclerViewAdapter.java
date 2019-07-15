package com.example.dblapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dblapp.R;
import com.example.dblapp.databinding.EquipListitemBindingImpl;
import com.example.dblapp.model.EquipUnit;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<EquipUnit> mEquips;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<EquipUnit> equipNames){
        mEquips = equipNames;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.equip_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        EquipListitemBindingImpl binding = holder.mBinding;
        binding.setEquipment(mEquips.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mEquips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        EquipListitemBindingImpl mBinding = DataBindingUtil.bind(itemView);

        public ViewHolder(View itemView){
            super(itemView);
        }
    }

}
