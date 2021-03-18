package com.gtsr.gtsr.testModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gtsr.gtsr.R;
import com.gtsr.gtsr.adapter.SelectStripAdapter;

public class SelectTestStripActivity extends AppCompatActivity {
RecyclerView stripListView;
   SelectStripAdapter stripAdapter;
    ImageView imgBack;
     Button btnNxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test_strip);
        imgBack = findViewById(R.id.back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnNxt = findViewById(R.id.btn_nxt);
        stripListView = findViewById(R.id.strip_list);
        stripAdapter = new SelectStripAdapter(SelectTestStripActivity.this);
        stripListView.setLayoutManager(new LinearLayoutManager(SelectTestStripActivity.this));
        stripListView.setAdapter(stripAdapter);
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PairDeviceViewController.class));
            }
        });
    }
}