package com.example.ofoodadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ofoodadmin.API.JsonPlaceHolder;
import com.example.ofoodadmin.API.RetrofitClient;
import com.example.ofoodadmin.Model.User.Block;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBlockActivity extends AppCompatActivity {

    private RecyclerView rclBlock;
    private ProgressDialog dialog;
    private JsonPlaceHolder jsonPlaceHolder;
    private RetrofitClient retrofitClient;
    private List<Block> blocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_block);
        rclBlock = findViewById(R.id.rcl_block);
        blocks=new ArrayList<>();
        dialog = new ProgressDialog(this);
        dialog.show();
        getListBlock();
    }

    private void getListBlock() {
        BlockAdapter adapter = new BlockAdapter();
        adapter.setBlocks(getData(adapter));
        rclBlock.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rclBlock.setLayoutManager(layoutManager);
        adapter.setListener(new BlockAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(Block block) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("block",block);
                Intent intent = new Intent(ListBlockActivity.this, BlockDetailActivity.class);
                intent.putExtra("getblock", bundle);
                startActivity(intent);
            }
        });
    }

    private List<Block> getData(BlockAdapter adapter){
        //Xử lí lấy về danh sách các block chưa duyệt sau đó tắt progress dialog;
        jsonPlaceHolder=retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
        jsonPlaceHolder.getListBlock().enqueue(new Callback<List<Block>>() {
            @Override
            public void onResponse(Call<List<Block>> call, Response<List<Block>> response) {
                for (Block block:response.body()){
                    if(!block.isStatus()) {
                        blocks.add(block);
                        dialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Block>> call, Throwable t) {
                Toast.makeText(ListBlockActivity.this, "Không có yêu cầu chờ duyệt", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        return blocks;
    }
}