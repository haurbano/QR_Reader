package com.example.farley.qrreader.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farley.qrreader.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRScannerFragment extends Fragment implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;

    public QRScannerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        scannerView = new ZXingScannerView(getActivity());
        scannerView.setResultHandler(this);
        if (scannerView!=null)
            scannerView.startCamera();
        else
            Log.i("haur","Scannview null");
        return scannerView;
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getContext(),result.getText(),Toast.LENGTH_SHORT).show();
    }

    public void startScann(){
        if (scannerView!=null)
            scannerView.startCamera();
        else
            Log.i("haur","Scannview null");
    }

    @Override
    public void onDestroy() {
        if (scannerView!=null)
            scannerView.stopCamera();
        super.onDestroy();
    }
}
