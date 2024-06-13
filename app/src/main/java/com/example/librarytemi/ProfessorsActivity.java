package com.example.librarytemi;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This class represents the activity for showing the user the Africana Studies professors
 *
 * @author Gavin Vogt
 */
public class ProfessorsActivity extends AppCompatActivity {

    /** WebView for accessing the professors site */
    private WebView webView;

    /** Africana Studies professors URL */
    private static final String PROFESSORS_URL = "https://africana.arizona.edu/people/faculty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.professors);
        setContentView(R.layout.web_activity);

        // Navigate to the courses webpage
        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(PROFESSORS_URL);
    }

}
