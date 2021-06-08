package com.developeralamin.easydownloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.developeralamin.easydownloader.databinding.ActivityMainBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



        binding.youtube.setOnClickListener(v ->{
            startActivity(new Intent(this, YoutubeActivity.class));
        });



        binding.facebook.setOnClickListener(v ->{
            startActivity(new Intent(this, FacebookActivity.class));
        });


        binding.whatsapp.setOnClickListener(v ->{
            startActivity(new Intent(this, WhatappActivity.class));
        });


        binding.instagram.setOnClickListener(v ->{
            startActivity(new Intent(this, InstagramActivity.class));
        });


        binding.twitter.setOnClickListener(v ->{
            startActivity(new Intent(this, TwitterActivity.class));
        });


        binding.sharechaert.setOnClickListener(v ->{
            startActivity(new Intent(this, ShareChartActivity.class));
        });

        checkPermission();


    }

    private void checkPermission(){

        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (!report.areAllPermissionsGranted())
                    checkPermission();
            }
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
    }
}