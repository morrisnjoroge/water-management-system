package com.example.communitywatermis;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class NewsActivity extends AppCompatActivity {

    private EditText mDate,mArea,mAnnouncements;
    private Button submit,submission;
    private FirebaseDatabase news= FirebaseDatabase.getInstance();
    private DatabaseReference root=news.getReference().child("Announcements");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mDate=findViewById(R.id.date);
        mArea=findViewById(R.id.area);
        mAnnouncements=findViewById(R.id.announcements);
        submit=findViewById(R.id.buttonSubmit);
        submission=findViewById(R.id.buttonSubmission);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submission.setEnabled(true);
                String date=mDate.getText().toString();
                String area=mArea.getText().toString();
                String announcements=mAnnouncements.getText().toString();

                HashMap<String ,String> userMap=new HashMap<>();

                userMap.put("date",date);
                userMap.put("area",area);
                userMap.put("announcements",announcements);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(NewsActivity.this,"Data Saved",Toast.LENGTH_SHORT).show();

                    }
                });
                submission.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(NewsActivity.this)
                                .setTitle("Sent Details To Users:")
                                .setMessage("Date - "+date +"\n\nArea - "+ area +"\n\nAnnouncement - "+ announcements)
                                .show();

                    }
                });


            }
        });


    }
}