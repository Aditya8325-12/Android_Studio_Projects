package com.example.loginpagesample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class Register extends AppCompatActivity {


    EditText name,username,password;
    ImageView imageView;
    Button imageselector,register;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        imageView=findViewById(R.id.imageview);
        imageselector=findViewById(R.id.imagebutton);

        register=findViewById(R.id.register);

        imageselector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,12);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageuri=uri.toString();
                String name1=name.getText().toString();
                String pass1=password.getText().toString();
                String user1=username.getText().toString();

                StudentRegistration studentRegistration=new StudentRegistration(name1,user1,pass1,imageuri);
                //Firebase
                StorageReference storageReference=FirebaseStorage.getInstance().getReference("image/"+ UUID.randomUUID());
                storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(Register.this, "file upload", Toast.LENGTH_SHORT).show();
                    }
                });

                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("StudentRegistration");
                String id=databaseReference.push().getKey();
                databaseReference.child(id).setValue(studentRegistration);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            if(requestCode==12)
            {

                imageView.setImageURI(data.getData());
                imageView.setVisibility(View.VISIBLE);
                uri=data.getData();

            }
        }
    }
}