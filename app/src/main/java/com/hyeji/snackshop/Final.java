package com.hyeji.snackshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    TextView textViewPayment;
    Button button;
    ImageView imageViewPayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        button = findViewById(R.id.button);
        textViewPayment = findViewById(R.id.textViewPayment);
        imageViewPayImage = findViewById(R.id.imageViewPayImage);
        Intent intent = getIntent(); //intent객체생성
        Bundle bundle = intent.getExtras();
        String str = bundle.getString("결제수단");
        int image = bundle.getInt("paymentImage");
        //System.out.println(str);
        textViewPayment.setText(str);
        imageViewPayImage.setImageResource(image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Final.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}