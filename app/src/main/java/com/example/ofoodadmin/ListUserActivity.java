package com.example.ofoodadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ofoodadmin.Model.User.User;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    
    private RecyclerView rclUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        rclUser = findViewById(R.id.rcl_user);
        UserAdapter adapter = new UserAdapter();
        adapter.setUsers(getUser());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rclUser.setAdapter(adapter);
        rclUser.setLayoutManager(layoutManager);
        adapter.setListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onClick(User user) {
                Intent intent = new Intent(ListUserActivity.this, UserDetailActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
    private List<User> getUser(){
        List<User> users = null;
        // Xử lí lấy danh sách user dki
        return users;
    }
}