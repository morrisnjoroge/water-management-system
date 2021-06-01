package com.example.communitywatermis;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FeedbackActivity extends AppCompatActivity {
    private EditText mName,mLocation,mFeedback;
    private FloatingActionButton fab;
    private Button button,details;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mName=findViewById(R.id.name);
        mLocation=findViewById(R.id.location);
        mFeedback=findViewById(R.id.feedback);
        button=findViewById(R.id.buttonSend);
        details=findViewById(R.id.btn_details);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(FeedbackActivity.this, ComplainActivity.class);
                Toast.makeText(FeedbackActivity.this,"Get location",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setEnabled(true);
                String name=mName.getText().toString();
                String location=mLocation.getText().toString();
                String feedback=mFeedback.getText().toString();

                HashMap<String ,String> userMap=new HashMap<>();

                userMap.put("name",name);
                userMap.put("location",location);
                userMap.put("feedback",feedback);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(FeedbackActivity.this,"Data Saved",Toast.LENGTH_SHORT).show();

                    }
                });

                details.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                new AlertDialog.Builder(FeedbackActivity.this)
                                        .setTitle("Sent Details To Us:")
                                        .setMessage("Name - "+name +"\n\nLocation - "+ location +"\n\nFeedback - "+ feedback)
                                        .show();

                    }
                });

            }
        });


    }
}