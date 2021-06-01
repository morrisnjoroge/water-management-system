package com.example.communitywatermis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button logout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        textView=findViewById(R.id.textView);

        setSupportActionBar(toolbar);
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        //ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home: break;
            case R.id.nav_feedback:
                Intent feed = new Intent(AdminActivity.this, ShowFeedbackActivity.class);
                startActivity(feed);
                break;
            case R.id.nav_news:
                Intent news = new Intent(AdminActivity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_developer:
                Intent intent = new Intent(AdminActivity.this, DeveloperActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();

                break;

            case R.id.nav_report:
                Uri uri = Uri.parse("https://analytics.google.com/analytics/web/?hl=en_US#/p259945456/reports/defaulthome?params=_u..nav%3Ddefault"); // missing 'http://' will cause crashed
                Intent report = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(report);
                //Intent report = new Intent(AdminActivity.this, ReportActivity.class);
                //startActivity(report);

                break;

            case R.id.nav_share: Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Intent.ACTION_SEND );
                i.setType("message/html");
                //i.putExtra(Intent.ACTION_SEND, new String[]{"morrisnjoroge08@gmail.com"});
                i.putExtra(Intent.EXTRA_TEXT,"https://drive.google.com/file/d/1eBmM60-S6vkuEbmEZ-sevKdZC_PhuFOr/view?usp=sharing");
                startActivity(i);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }



        /*logout=(Button)findViewById(R.id.buttonLogoutAdmin);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });*/
    }
}