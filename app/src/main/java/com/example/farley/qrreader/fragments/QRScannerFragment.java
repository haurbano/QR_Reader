package com.example.farley.qrreader.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
    Ireader ireader;

    public QRScannerFragment() {
        // Required empty public constructor
    }

    public interface Ireader{
        void setResult(String result);
    }

    public void setInterface(Ireader ireader){
        this.ireader =ireader;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Premio");
        builder.setMessage(result.getText());
        builder.create().show();
        ireader.setResult(result.getText());
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
