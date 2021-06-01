package com.example.communitywatermis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ServicesActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView bills;
    private ImageView news;
    private ImageView projects;
    private ImageView offices;
    private ImageView caution;
    private ImageView support;
    private ImageView gallery;
    private ImageView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        bills = (ImageView)findViewById(R.id.bills);
        news = (ImageView)findViewById(R.id.news);
        projects = (ImageView)findViewById(R.id.projects);
        offices = (ImageView)findViewById(R.id.offices);
        caution = (ImageView)findViewById(R.id.caution);
        support = (ImageView)findViewById(R.id.support);
        gallery = (ImageView)findViewById(R.id.gallery);
        about = (ImageView)findViewById(R.id.about);


        bills.setOnClickListener(this);
        news.setOnClickListener(this);
        projects.setOnClickListener(this);
        offices.setOnClickListener(this);
        caution.setOnClickListener(this);
        support.setOnClickListener(this);
        gallery.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bills:
                Intent billsIntent = new Intent(ServicesActivity.this, PayBillActivity.class);
                startActivity(billsIntent);

                break;
            case R.id.news:
                Intent newsIntent = new Intent(ServicesActivity.this, ShowAnnouncementsActivity.class);
                startActivity(newsIntent);
                break;
            case R.id.projects:
                Intent projectsIntent = new Intent(ServicesActivity.this, ProjectsActivity.class);
                startActivity(projectsIntent);

                break;
            case R.id.offices:
                Intent officeIntent = new Intent(ServicesActivity.this, MapsActivity.class);
                startActivity(officeIntent);

                break;
            case R.id.caution:
                Intent cautionIntent = new Intent(ServicesActivity.this, CautionActivity.class);
                startActivity(cautionIntent);

                break;
            case R.id.support:
                Intent supportIntent = new Intent(ServicesActivity.this, SupportActivity.class);
                startActivity(supportIntent);

                break;
            case R.id.gallery:
                Intent galleryIntent = new Intent(ServicesActivity.this, GalleryActivity.class);
                startActivity(galleryIntent);

                break;
            case R.id.about:
                //Intent horizonIntent = new Intent(ServicesActivity.this, AppendActivity.class);
                Intent aboutIntent = new Intent(ServicesActivity.this, AboutActivity.class);
                startActivity(aboutIntent);

                break;
        }

    }
}