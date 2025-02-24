package com.example.carpark;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
public class MainActivity2 extends AppCompatActivity {

    ImageView help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        help = findViewById(R.id.imageView9);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, help.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnMap = findViewById(R.id.button2);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the booking activity
                Intent intent = new Intent(MainActivity2.this, Map.class);
                startActivity(intent);
            }
        });

        Button btnAbs = findViewById(R.id.button5);
        btnAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the booking activity
                Intent intent = new Intent(MainActivity2.this, About_Us.class);
                startActivity(intent);
            }
        });

        ImageView btnProfile = findViewById(R.id.imageView5);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the booking activity
                Intent intent = new Intent(MainActivity2.this, Profile.class);
                startActivity(intent);
            }
        });
    }
}