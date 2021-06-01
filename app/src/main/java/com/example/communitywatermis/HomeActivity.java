package com.example.communitywatermis;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_Services:
                        Toast.makeText(HomeActivity.this, "Services", Toast.LENGTH_LONG).show();
                        Intent feedbackIntent = new Intent(HomeActivity.this, ServicesActivity.class);
                        startActivity(feedbackIntent);
                        break;
                    case R.id.action_Complaints:
                        Toast.makeText(HomeActivity.this, "Feedback", Toast.LENGTH_LONG).show();
                        Intent complainIntent = new Intent(HomeActivity.this, FeedbackActivity.class);
                        startActivity(complainIntent);
                        break;

                    case R.id.action_Logout:
                        Toast.makeText(HomeActivity.this, "Logout", Toast.LENGTH_LONG).show();
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        finish();
                        break;
                }
                return true;
            }
        });
    }
}