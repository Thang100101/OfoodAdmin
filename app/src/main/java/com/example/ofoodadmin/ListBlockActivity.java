package com.example.ofoodadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.ofoodadmin.Model.User.Block;

import java.util.List;

public class ListBlockActivity extends AppCompatActivity {

    private RecyclerView rclBlock;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_block);
        rclBlock = findViewById(R.id.rcl_block);
        dialog = new ProgressDialog(this);
        dialog.show();
        getListBlock();
    }

    private void getListBlock() {
        BlockAdapter adapter = new BlockAdapter();
        adapter.setBlocks(getData());
        rclBlock.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rclBlock.setLayoutManager(layoutManager);
        adapter.setListener(new BlockAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(Block block) {
                Intent intent = new Intent(ListBlockActivity.this, BlockDetailActivity.class);
                intent.putExtra("block", block);
                startActivity(intent);
            }
        });
    }

    private List<Block> getData(){
        //Xử lí lấy về danh sách các block chưa duyệt sau đó tắt progress dialog;
        return null;
    }
}