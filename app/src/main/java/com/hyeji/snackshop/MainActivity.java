package com.hyeji.snackshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity<Private> extends AppCompatActivity {
    ImageView imageViewRamen;
    ImageView imageViewTtuk;
    ImageView imageViewKal;
    TextView textViewMenu1;
    TextView textViewMenu2;
    TextView textViewMenu3;
    TextView textViewPrice1;
    TextView textViewPrice2;
    TextView textViewPrice3;
    EditText editText1, editText2, editText3;
    Button buttonCart1, buttonCart2, buttonCart3, buttonGoCart;
    Menu menu1;
    Menu menu2;
    Menu menu3;
    Intent intent;
    Bundle bundle;
    int count1, count2, count3, totalPrice1, totalPrice2, totalPrice3;
    String str1,str2,str3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuInit(); //menu초기화


    }
    void menuInit(){
        menu1 = new Menu("라면",10000,"맛있는 라면");
        menu2 = new Menu("떡볶이",7000,"빨간 떡볶이");
        menu3 = new Menu("칼국수",13000,"해물 칼국수");
        imageViewRamen = findViewById(R.id.imageViewRamen);
        imageViewTtuk = findViewById(R.id.imageViewTtuk);
        imageViewKal = findViewById(R.id.imageViewKal);
        imageViewRamen.setOnClickListener(imageViewSelectListener);
        imageViewTtuk.setOnClickListener(imageViewSelectListener);
        imageViewKal.setOnClickListener(imageViewSelectListener);
        textViewMenu1 = findViewById(R.id.textViewMenu1);
        textViewMenu2 = findViewById(R.id.textViewMenu2);
        textViewMenu3 = findViewById(R.id.textViewMenu3);
        textViewPrice1 = findViewById(R.id.textViewPrice1);
        textViewPrice2 = findViewById(R.id.textViewPrice2);
        textViewPrice3 = findViewById(R.id.textViewPrice3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        buttonCart1 = findViewById(R.id.buttonCart1);
        buttonCart2 = findViewById(R.id.buttonCart2);
        buttonCart3 = findViewById(R.id.buttonCart3);
        buttonGoCart = findViewById(R.id.buttonGoCart);
        buttonCart1.setOnClickListener(buttonSelectListener);
        buttonCart2.setOnClickListener(buttonSelectListener);
        buttonCart3.setOnClickListener(buttonSelectListener);
        buttonGoCart.setOnClickListener(buttonSelectListener);
        intent = new Intent(MainActivity.this,Calc.class);
        bundle = new Bundle();
        textViewMenu1.setText(menu1.getName());
        textViewPrice1.setText(Integer.toString(menu1.getPrice()));
        textViewMenu2.setText(menu2.getName());
        textViewPrice2.setText(Integer.toString(menu2.getPrice()));
        textViewMenu3.setText(menu3.getName());
        textViewPrice3.setText(Integer.toString(menu3.getPrice()));
    }
    private View.OnClickListener imageViewSelectListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageViewRamen:
                    System.out.println(menu1.getPrice());
                    bundle.putString("주문내역 :",menu1.getName());
                    bundle.putInt("가격 :",menu1.getPrice());
                    count1++;
                    break;
                case R.id.imageViewTtuk:
                    System.out.println(menu2.getPrice());
                    bundle.putString("주문내역 :",menu2.getName());
                    bundle.putInt("가격 :",menu2.getPrice());
                    count2++;
                    break;
                case R.id.imageViewKal:
                    System.out.println(menu3.getPrice());
                    bundle.putString("주문내역 :",menu3.getName());
                    bundle.putInt("가격 :",menu3.getPrice());
                    count3++;
                    break;
                default:
            }

        }

    };
    private  View.OnClickListener buttonSelectListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonCart1:
                    str1 = editText1.getText().toString();
                    count1 = Integer.parseInt(str1);
                    totalPrice1 = menu1.totalPrice(menu1.getPrice(),count1);
                    int[] intArray1 = {menu1.getPrice(),count1,totalPrice1};
                    bundle.putIntArray("라면",intArray1);
                    break;
                case R.id.buttonCart2:
                    str2 = editText2.getText().toString();
                    count2 = Integer.parseInt(str2);
                    totalPrice2 = menu2.totalPrice(menu2.getPrice(),count2);
                    int[] intArray2 = {menu2.getPrice(),count2,totalPrice2};
                    bundle.putIntArray("떡볶이",intArray2);
                    break;
                case R.id.buttonCart3:
                    str3 = editText3.getText().toString();
                    count3 = Integer.parseInt(str3);
                    totalPrice3 = menu3.totalPrice(menu3.getPrice(),count3);
                    int[] intArray3 = {menu3.getPrice(),count3,totalPrice3};
                    bundle.putIntArray("칼국수",intArray3);
                    break;
                case R.id.buttonGoCart:
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
            }
        }
    };


}