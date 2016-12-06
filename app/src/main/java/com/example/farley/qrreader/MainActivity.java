package com.example.farley.qrreader;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.farley.qrreader.databinding.ActivityMainBinding;
import com.example.farley.qrreader.fragments.QRScannerFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, QRScannerFragment.Ireader {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btnStartScan.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        loadReader();
    }

    private void loadReader(){
        QRScannerFragment fragment = new QRScannerFragment();
        fragment.setInterface(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_scann,fragment);
        transaction.commit();
        fragment.startScann();
    }

    @Override
    public void setResult(String result) {
        loadReader();
    }
}
