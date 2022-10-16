package com.example.ofoodadmin.API;


import com.example.ofoodadmin.Model.User.Block;
import com.example.ofoodadmin.Model.User.Product;
import com.example.ofoodadmin.Model.User.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {


    @GET("products")
    Call<List<Product>> getProductByCode(@Query("productCode") String barcode);

    @PATCH("blocks/{id}")
    Call<List<Block>> patchBlock(@Path("id") int id,@Body Block block);

    @PATCH("products/{id}")
    Call<List<Product>> patchProduct(@Path("id") int code,@Body Product product);

    @PATCH("users/{id}")
    Call<List<User>> patchUser(@Path("id") int id,@Body User user);
    @GET("users")
    Call<List<User>> getUser(@Query("password") String pass, @Query("username") String username);

    @GET("users")
    Call<List<User>> getExistsUser(@Query("username") String username);


    @POST("users")
    Call<User> createUser(@Body User user);
    @POST("products")
    Call<Product> createProduct(@Body Product product);

    @POST("blocks")
    Call<Block>  createBlock(@Body Block block);
    @GET("blocks")
    Call<List<Block>> getListBlock();
    @GET("users")
    Call<List<User>> getListUser();

    @DELETE("blocks/{id}")
    Call<Void> deleteBlock(@Path("id") int id);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
