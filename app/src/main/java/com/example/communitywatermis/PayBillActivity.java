package com.example.communitywatermis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class PayBillActivity extends AppCompatActivity {
    private ImageView mpesa,ussd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);
        mpesa=(ImageView)findViewById(R.id.imageViewMpesa);
        ussd=(ImageView)findViewById(R.id.imageViewDial);

        ImageSlider image=findViewById(R.id.payslider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/images/Website_slider2.jpg","Dial *188#"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/images/covid-19-website-slider3.jpg","Bill Paypoint partners"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/images/migration.png","Billing System"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/images/NCWSC-billing-msg.jpg","Multiple billing"));

        image.setImageList(slideModels,true);

        mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mpesaIntent = new Intent(PayBillActivity.this, MpesaActivity.class);
                startActivity(mpesaIntent);

            }
        });

        ussd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hash = Uri.encode("#");
                Intent i=new Intent(Intent.ACTION_DIAL );
                i.setData(Uri.parse("tel:*888"
                        + hash ));
                startActivity(i);
            }
        });
    }
}