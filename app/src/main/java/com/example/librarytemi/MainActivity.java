package com.example.librarytemi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnRobotReadyListener;

public class MainActivity extends AppCompatActivity implements OnRobotReadyListener {

    private Button findMaterialsButton;
    private Button borrowRequestButton;
    private Button reserveSpaceButton;
    private Button researchGuidesButton;
    private Button researchAssistanceButton;
    private Button specialCollectionsButton;
    private Button eventsButton;
    private Button downloadAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Materials button
        findMaterialsButton = findViewById(R.id.find_materials_button);
        findMaterialsButton.setOnClickListener((v) -> {
            openActivity(FindMaterialsActivity.class);
        });

        // Borrow/Request button
        borrowRequestButton = findViewById(R.id.borrow_request_button);
        borrowRequestButton.setOnClickListener((v) -> {
            openWebPage("https://example.com/borrow_request");
        });

        // Reserve Space button
        reserveSpaceButton = findViewById(R.id.reserve_space_button);
        reserveSpaceButton.setOnClickListener((v) -> {
            openWebPage("https://example.com/reserve_space");
        });

        // Research Guides button
        researchGuidesButton = findViewById(R.id.research_guides_button);
        researchGuidesButton.setOnClickListener((v) -> {
            openActivity(ResearchGuidesActivity.class);
        });

        // Research Assistance button
        researchAssistanceButton = findViewById(R.id.research_assistance_button);
        researchAssistanceButton.setOnClickListener((v) -> {
            openWebPage("https://example.com/research_assistance");
        });

        // Special Collections button
        specialCollectionsButton = findViewById(R.id.special_collections_button);
        specialCollectionsButton.setOnClickListener((v) -> {
            openWebPage("https://example.com/special_collections");
        });

        // Events button
        eventsButton = findViewById(R.id.events_button);
        eventsButton.setOnClickListener((v) -> {
            openWebPage("https://example.com/events");
        });

        // Download App button
        downloadAppButton = findViewById(R.id.download_app_button);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Robot.getInstance().addOnRobotReadyListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Robot.getInstance().removeOnRobotReadyListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            Robot.getInstance().hideTopBar();
        }
    }

    private void openActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}
