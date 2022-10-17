package com.example.ofoodadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ofoodadmin.Model.User.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    public interface OnItemClickListener{
        public void onClick(User user);
    }

    private List<User> users;
    private OnItemClickListener listener;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public OnItemClickListener getListener() {
        return listener;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = users.get(position);
        if(user != null){
            if(user.isCer()){
                holder.txtRole.setText("Tổ chức chứng nhận");
            }else{
                holder.txtRole.setText("Nhà cung cấp");
            }
            holder.txtPhone.setText(user.getUsername());
            holder.txtRole.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!= null)
                        listener.onClick(user);
                }
            });
            holder.txtPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!= null)
                        listener.onClick(user);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(users == null)
            return 0;
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder{

        private TextView txtRole, txtPhone;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            txtRole = itemView.findViewById(R.id.txt_role);
            txtPhone = itemView.findViewById(R.id.txt_phone);
        }
    }
}
