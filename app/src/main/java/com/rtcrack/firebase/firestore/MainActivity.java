package com.rtcrack.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private Button btnInput;
    private EditText edtNama,edtAlamat,edtKelamin;
    private TextView tvStatus;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private void init(){
        btnInput = findViewById(R.id.btnInput);
        edtNama = findViewById(R.id.edtNama);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtKelamin = findViewById(R.id.edtKelamin);
        tvStatus = findViewById(R.id.tvStatus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionInput(edtNama.getText().toString(),edtAlamat.getText().toString(),edtKelamin.getText().toString(), FieldValue.serverTimestamp().toString());
            }
        });
    }

    private void actionInput(String nama, String alamat, String kelamin, String waktu) {
        final User data = new User(nama,alamat,kelamin, waktu);
        db.collection("User")
                .document()
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this,"Data Berhasil Ditambah",Toast.LENGTH_SHORT).show();
                tvStatus.setText(data.getNama().toString());
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        tvStatus.setText("Error Gan "+e.toString());
                    }
                });
    }
}
