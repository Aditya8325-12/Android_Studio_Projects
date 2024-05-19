package com.kazimasum.qrdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrcodegenrator extends AppCompatActivity {

    EditText edit_input,value,discountvalue;
    Button bt_generate;
    ImageView iv_qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcodegenrator);


        edit_input = findViewById(R.id.edit_input);
        bt_generate = findViewById(R.id.bt_generate);
        iv_qr = findViewById(R.id.iv_qr);

        discountvalue=findViewById(R.id.discountvalue);
        value=findViewById(R.id.editvalu);

        bt_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateQR();
            }
        });
    }

    private void generateQR()
    {
        String discoutvalue1=discountvalue.getText().toString();
        String text = edit_input.getText().toString().trim();
        String textvalue=text+","+discoutvalue1+","+value.getText().toString();
        MultiFormatWriter writer = new MultiFormatWriter();
        try
        {
            BitMatrix matrix = writer.encode(textvalue, BarcodeFormat.QR_CODE,600,600);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            iv_qr.setImageBitmap(bitmap);

        } catch (WriterException e)
        {
            e.printStackTrace();
        }
    }
}