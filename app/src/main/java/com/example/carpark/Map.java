package com.example.carpark;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Map extends AppCompatActivity {
    private WebView webView;
    private Button findParkingButton;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map);

        webView = findViewById(R.id.webView);
        findParkingButton = findViewById(R.id.findParkingButton);

        // WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load HTML file
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/map.html"); // Ensure map.html is in 'assets' folder

        // Find Parking button click event
        findParkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.evaluateJavascript("searchParking();", null);
            }
        });
        Button btnBookParking = findViewById(R.id.bk);
        btnBookParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the booking activity
                Intent intent = new Intent(Map.this, Booking.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}