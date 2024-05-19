package com.kazimasum.qrdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scannerView extends AppCompatActivity implements ZXingScannerView.ResultHandler
{
   ZXingScannerView scannerView;

    String[] split2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView=new ZXingScannerView(this);
        setContentView(scannerView);

        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                     permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    @Override
    public void handleResult(Result rawResult) {

       String text=rawResult.getText();
       split2=text.split(",");
        Toast.makeText(this, "sdf"+split2[0]+split2[1]+split2[2], Toast.LENGTH_SHORT).show();

        home.scantext.setText(""+split2[0]);
        home.value.setText(""+split2[1]);
        home.discountvalue.setText(""+split2[2]);

    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(com.kazimasum.qrdemo.scannerView.this,home.class);
        intent.putExtra("scan",Integer.parseInt(home.discountvalue.getText().toString()));
        intent.putExtra("packet",Integer.parseInt(home.packet.getText().toString()));
        intent.putExtra("name",split2[0]);
        intent.putExtra("value",split2[1]);
        intent.putExtra("discout",split2[2]);
        startActivity(intent);
    }
}