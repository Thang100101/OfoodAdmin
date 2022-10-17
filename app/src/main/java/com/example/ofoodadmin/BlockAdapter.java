package com.example.ofoodadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ofoodadmin.Model.User.Block;

import java.util.List;

public class BlockAdapter extends  RecyclerView.Adapter<BlockAdapter.BlockHolder> {

    private List<Block> blocks;
    private OnClickItemListener listener;

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
        notifyDataSetChanged();
    }

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    public interface OnClickItemListener{
        public void onClickItem(Block block);
    }

    @NonNull
    @Override
    public BlockHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_block, parent, false);
        return new BlockHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlockHolder holder, int position) {
        Block block = blocks.get(position);
        if(block != null){
            holder.txtName.setText(block.getUser().getUsername());
            holder.txtAction.setText(block.getAction().toString());
            holder.txtProduct.setText(block.getProduct().getProductName());

            holder.txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        listener.onClickItem(block);
                    }
                }
            });
            holder.txtProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        listener.onClickItem(block);
                    }
                }
            });
            holder.txtAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        listener.onClickItem(block);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (blocks != null)
        {
            return blocks.size();
        }
        return 0;
    }


    public class BlockHolder extends RecyclerView.ViewHolder{
        private TextView txtName, txtProduct, txtAction;
        public BlockHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAction = itemView.findViewById(R.id.txt_action);
            txtProduct = itemView.findViewById(R.id.txt_product);
        }
    }
}