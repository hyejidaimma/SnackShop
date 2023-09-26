package com.hyeji.snackshop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Set;

public class Calc extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView10;
    ImageView imageViewCard, imageViewMoney, imageViewApplePay, imageViewSamSungPay, imageViewKakaoPay;
    ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        calcInit();

        TextView[] textViews = {textView1, textView2, textView3, textView10};
        for (TextView t : textViews)
            t.setVisibility(View.INVISIBLE);

        ImageView[] imageViews = {imageView1, imageView2, imageView3};
        for (ImageView i : imageViews)
            i.setVisibility(View.INVISIBLE);

        setText();
    }
    void calcInit() {
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView10 = findViewById(R.id.textView10);
        imageViewCard = findViewById(R.id.imageViewCard);
        imageViewMoney = findViewById(R.id.imageViewMoney);
        imageViewApplePay = findViewById(R.id.imageViewApplePay);
        imageViewSamSungPay = findViewById(R.id.imageViewSamSungPay);
        imageViewKakaoPay = findViewById(R.id.imageViewKakaoPay);
        imageViewCard.setOnClickListener(imageViewSelectListener);
        imageViewMoney.setOnClickListener(imageViewSelectListener);
        imageViewApplePay.setOnClickListener(imageViewSelectListener);
        imageViewSamSungPay.setOnClickListener(imageViewSelectListener);
        imageViewKakaoPay.setOnClickListener(imageViewSelectListener);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
    }
    private View.OnClickListener imageViewSelectListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(Calc.this, Final.class);
            String paymentMethod = "";
            int paymentImage = 0;

            switch (v.getId()) {
                case R.id.imageViewCard:
                    paymentImage = R.drawable.card;
                    bundle.putString("결제수단", "신용카드");
                    break;
                case R.id.imageViewMoney:
                    paymentImage = R.drawable.money;
                    bundle.putString("결제수단", "현금");
                    break;
                case R.id.imageViewApplePay:
                    paymentImage = R.drawable.applepay;
                    bundle.putString("결제수단", "APPLE PAY");
                    break;
                case R.id.imageViewSamSungPay:
                    paymentImage = R.drawable.samsungpay;
                    bundle.putString("결제수단", "SamSungPay");
                    break;
                case R.id.imageViewKakaoPay:
                    paymentImage = R.drawable.kakao;
                    bundle.putString("결제수단", "KakaoPay");
                    break;
                default:
            }

            Toast.makeText(getApplicationContext(), bundle.getString("결제수단") + "(으)로 결제합니다.", Toast.LENGTH_SHORT).show();
            bundle.putInt("paymentImage", paymentImage);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
    @SuppressLint("DefaultLocale")
    void setText() {
        int total = 0; // declare and initialize total to 0
        textView10.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int size = bundle.size();
        if (size >= 1 && size <= 3) {
            TextView[] textViews = {textView1, textView2, textView3};
            for (int i = 0; i < size; i++)
                textViews[i].setVisibility(View.VISIBLE);
            ImageView[] imageViews = {imageView1, imageView2, imageView3};
            for (int i = 0; i < size; i++)
                imageViews[i].setVisibility(View.VISIBLE);
            String[] keys = {"라면", "떡볶이", "칼국수"};
            int[] images = {R.drawable.ramen, R.drawable.ttuk, R.drawable.kal};
            int index = 0;
            for (int i = 0; i < keys.length; i++) {
                if (bundle.containsKey(keys[i])) {
                    imageViews[index].setImageResource(images[i]);
                    int[] intArray = bundle.getIntArray(keys[i]);
                    textViews[index].setText("단가: " + String.format("%d", intArray[0]) + " 수량: " + String.format("%d", intArray[1]) + " 총 금액: " + String.format("%d", intArray[2]));
                    total += intArray[2]; // add intArray[2] to total
                    index++;
                }
            }
            textView10.setText(String.format("%d", total)+" 원"); // setText the value of total in textView10
        } else {
            textView1.setVisibility(View.VISIBLE);
            textView1.setText("시스템 오류. 다시 시도 바랍니다.");
        }
    }
}
