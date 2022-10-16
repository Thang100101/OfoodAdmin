package com.example.ofoodadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ofoodadmin.API.JsonPlaceHolder;
import com.example.ofoodadmin.API.RetrofitClient;
import com.example.ofoodadmin.Model.User.Block;
import com.example.ofoodadmin.Model.User.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity {

    private JsonPlaceHolder jsonPlaceHolder;
    private RetrofitClient retrofitClient;
    private User user;
    private Button btnSubmit, btnCancel;
    private TextView txt_phone,txt_address,txt_owner_name,txt_city,txt_scope,txt_email,txt_locator_code;
    private ProgressDialog dialog = new ProgressDialog(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("getuser");
        if(bundle!=null){
            user=(User) bundle.getSerializable("user");
        }
        Mapping();
        evenHandler();
    }

    private void Mapping() {
        txt_phone=findViewById(R.id.txt_phone);
        txt_address=findViewById(R.id.txt_address);
        txt_owner_name=findViewById(R.id.txt_owner_name);
        txt_city=findViewById(R.id.txt_city);
        txt_scope=findViewById(R.id.txt_scope);
        txt_email=findViewById(R.id.txt_email);
        txt_locator_code=findViewById(R.id.txt_locator_code);
        btnSubmit = findViewById(R.id.btn_submit);
        btnCancel = findViewById(R.id.btn_cancel);
    }
    private void evenHandler(){
        if(user.isCer()){
            txt_phone.setText(user.getCertificator().getPhoneNumber());
            txt_address.setText(user.getCertificator().getAddress());
            txt_email.setText(user.getCertificator().getEmail());
            txt_locator_code.setText(user.getCertificator().getLocatorCode());
            txt_scope.setText(user.getCertificator().getCertficationScope());
        }
        else {
            txt_phone.setText(user.getProducer().getPhone());
            txt_owner_name.setText((user.getProducer().getOwnerName()));
            txt_address.setText(user.getProducer().getAddress());
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lí duyệt block và quay về main
                user.setAccessRights(true);
                jsonPlaceHolder=retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
                jsonPlaceHolder.patchUser(user.getId(),user).enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        finish();
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        dialog.dismiss();
                    }
                });
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lí không duyệt và xóa block, quay về main
                jsonPlaceHolder=retrofitClient.getInstance("https://ofood-database.herokuapp.com/").create(JsonPlaceHolder.class);
                jsonPlaceHolder.deleteUser(user.getId()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        finish();
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}