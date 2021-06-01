package com.example.communitywatermis;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowAnnouncementsActivity extends AppCompatActivity {
    private RecyclerView recyclerViewNews;
    private FirebaseDatabase news= FirebaseDatabase.getInstance();
    private DatabaseReference root=news.getReference().child("Announcements");
    private MyAdapter2 adapter2;
    private ArrayList<Model2> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_announcements);
        recyclerViewNews=findViewById(R.id.recyclerviewNews);
        recyclerViewNews.setHasFixedSize(true);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this));

        list2=new ArrayList<>();
        adapter2=new MyAdapter2(this,list2);

        recyclerViewNews.setAdapter(adapter2);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Model2 model2=dataSnapshot.getValue(Model2.class);
                    list2.add(model2);
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}