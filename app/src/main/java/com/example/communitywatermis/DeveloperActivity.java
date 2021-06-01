package com.example.communitywatermis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeveloperActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText Feedback;
    private Button buttonFeed,buttonDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        editTextName=(EditText)findViewById(R.id.editTextTextName);
        Feedback=(EditText)findViewById(R.id.editTextFeedback);
        buttonFeed=(Button) findViewById(R.id.buttonFeed);
        buttonDial=(Button) findViewById(R.id.buttonDial);

        buttonFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND );
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"morrismunyua278@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback From NCWSC APP by administrator");
                i.putExtra(Intent.EXTRA_TEXT,"Problem:"+editTextName.getText()+"\n Description of problem:"+Feedback.getText());
                try {
                    startActivity(Intent.createChooser(i,"please select email"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(DeveloperActivity.this, "The are no email Clients", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL );
                i.setData(Uri.parse("tel:0762391005"));
                startActivity(i);

            }
        });
    }
}