package com.example.ofoodadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ofoodadmin.API.JsonPlaceHolder;
import com.example.ofoodadmin.API.RetrofitClient;
import com.example.ofoodadmin.Model.User.Block;
import com.example.ofoodadmin.Model.User.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity {
    
    private RecyclerView rclUser;
    private JsonPlaceHolder jsonPlaceHolder;
    private RetrofitClient retrofitClient;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        users=new ArrayList<>();
        rclUser = findViewById(R.id.rcl_user);
        UserAdapter adapter = new UserAdapter();
        adapter.setUsers(getUser(adapter));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rclUser.setAdapter(adapter);
        rclUser.setLayoutManager(layoutManager);
        adapter.setListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onClick(User user) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("user",user);
                Intent intent = new Intent(ListUserActivity.this, UserDetailActivity.class);
                intent.putExtra("getuser", bundle);
                startActivity(intent);
            }
        });
    }
    private List<User> getUser(UserAdapter adapter){
        jsonPlaceHolder=retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
        jsonPlaceHolder.getListUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                for(User user:response.body()){
                    if(!user.isAccessRights()){
                        users.add(user);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
        return users;
    }
}