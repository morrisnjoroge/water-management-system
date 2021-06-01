package com.example.communitywatermis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SupportActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText Feedback;
    private Button buttonFeed,buttonDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        editTextName=(EditText)findViewById(R.id.editTextTextName);
        Feedback=(EditText)findViewById(R.id.editTextFeedback);
        buttonFeed=(Button) findViewById(R.id.buttonFeed);
        buttonDial=(Button) findViewById(R.id.buttonDial);

        buttonFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND );
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"morrisnjoroge08@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback abour NCWSC");
                i.putExtra(Intent.EXTRA_TEXT,"Name:"+editTextName.getText()+"\n Message:"+Feedback.getText());
                try {
                    startActivity(Intent.createChooser(i,"please select email"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(SupportActivity.this, "The are no email Clients", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL );
                i.setData(Uri.parse("tel:0704803268"));
                startActivity(i);

            }
        });


    }
}