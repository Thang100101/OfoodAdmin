package com.example.ofoodadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ofoodadmin.API.JsonPlaceHolder;
import com.example.ofoodadmin.API.RetrofitClient;
import com.example.ofoodadmin.Model.User.Block;
import com.example.ofoodadmin.Model.User.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlockDetailActivity extends AppCompatActivity {

    private Button btnSubmit, btnCancel;
    private JsonPlaceHolder jsonPlaceHolder;
    private RetrofitClient retrofitClient;
    private Block block;
    private TextView txt_user_name,txt_action,txt_product_code,txt_product_name,txt_vietgap_code,
    txt_address,txt_phone,txt_date,txt_expired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_detail);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("getblock");
        if(bundle!=null){
            block=(Block) bundle.getSerializable("block");
        }
        Mapping();
        evenHandler();
    }

    private void Mapping() {
        btnSubmit = findViewById(R.id.btn_submit);
        btnCancel = findViewById(R.id.btn_cancel);
        txt_action=findViewById(R.id.txt_action);
        txt_address=findViewById(R.id.txt_address);
        txt_date=findViewById(R.id.txt_date);
        txt_expired=findViewById(R.id.txt_expired);
        txt_phone=findViewById(R.id.txt_phone);
        txt_product_code=findViewById(R.id.txt_product_code);
        txt_product_name=findViewById(R.id.txt_product_name);
        txt_user_name=findViewById(R.id.txt_user_name);
        txt_vietgap_code=findViewById(R.id.txt_vietgap_code);
    }
    private void evenHandler(){
        txt_vietgap_code.setText(block.getProduct().getVietgapCode());
        txt_user_name.setText(block.getUser().getUsername());
        txt_product_name.setText(block.getProduct().getProductName());
        txt_phone.setText(block.getProduct().getPhone());
        txt_action.setText(block.getAction().toString());
        txt_address.setText(block.getProduct().getAddress());
        txt_product_code.setText(block.getProduct().getProductCode());
        txt_expired.setText(String.valueOf(block.getProduct().isExpỉed()));
        txt_date.setText(block.getProduct().getCertificationDate());
        ProgressDialog dialog = new ProgressDialog(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lí duyệt block và quay về main
                dialog.show();
                block.setStatus(true);
                jsonPlaceHolder=retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
                jsonPlaceHolder.patchBlock(block.getId(),block).enqueue(new Callback<List<Block>>() {
                    @Override
                    public void onResponse(Call<List<Block>> call, Response<List<Block>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<Block>> call, Throwable t) {

                    }
                });
                if(block.isStatus()) {
                    Product product = new Product(block.getProduct().getProductName(), block.getProduct().getProductCode(),
                            block.getProduct().getVietgapCode(), block.getProduct().getStatus(),
                            block.getProduct().getCertificationDate(), block.getProduct().getPhone(),
                            block.getProduct().getAddress(), block.getProduct().isExpỉed());
                    if(block.getAction() == Block.Action.Add) {
                        jsonPlaceHolder = retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
                        jsonPlaceHolder.createProduct(product).enqueue(new Callback<Product>() {
                            @Override
                            public void onResponse(Call<Product> call, Response<Product> response) {
                                finish();
                                dialog.dismiss();
                            }

                            @Override
                            public void onFailure(Call<Product> call, Throwable t) {
                                Toast.makeText(BlockDetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                    else if(block.getAction() == Block.Action.Update){
                        jsonPlaceHolder = retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
                        jsonPlaceHolder.patchProduct(block.getProduct().getId(),product).enqueue(new Callback<List<Product>>() {
                            @Override
                            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                                finish();
                                dialog.dismiss();
                            }

                            @Override
                            public void onFailure(Call<List<Product>> call, Throwable t) {
                                dialog.dismiss();
                            }
                        });
                    }
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lí không duyệt và xóa block, quay về main
                jsonPlaceHolder = retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
                jsonPlaceHolder.deleteBlock(block.getId()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }
}