package com.daud.postapitask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText idEt,kitchenIdEt;
    private Button enterBtn;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AllOrderinterface allOrderinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        allOrderinterface = AllOrderRetro.getRetro().create(AllOrderinterface.class);

        enterBtn.setOnClickListener(view -> {
            String id = idEt.getText().toString();
            String kitchenid = kitchenIdEt.getText().toString();

            if (id.isEmpty()||kitchenid.isEmpty()){
                Toast.makeText(this, "Invalid Value", Toast.LENGTH_SHORT).show();
            }else{
                progressBar.setVisibility(View.VISIBLE);
                allOrderinterface.getData(id,kitchenid).enqueue(new Callback<AllOrderMc>() {
                    @Override
                    public void onResponse(Call<AllOrderMc> call, Response<AllOrderMc> response) {
                        if(response.isSuccessful()){
                            idEt.setText("");
                            kitchenIdEt.setText("");
                            List<OrderInfoMc> List = response.body().getData().getOrderinfo();
                            if (List.size() > 0){
                                progressBar.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                                recyclerView.setAdapter(new MyAdapter(MainActivity.this,List));
                                idEt.setHint("Now Id is: " + id);
                                kitchenIdEt.setHint("Now Kitchen Id is: " + kitchenid);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AllOrderMc> call, Throwable t) {

                    }
                });
            }
        });

    }

    private void initial() {
        idEt = findViewById(R.id.idEt);
        kitchenIdEt = findViewById(R.id.kitchenIdEt);
        enterBtn = findViewById(R.id.enterBtn);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}