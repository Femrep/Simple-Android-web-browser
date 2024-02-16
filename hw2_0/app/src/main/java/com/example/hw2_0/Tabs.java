package com.example.hw2_0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;

public class Tabs extends Fragment {
    private static final String ARG_URL = "url";
    private String url;

    // Add a WebView instance as a member variable
    private WebView webView;

    public Tabs() {
        // Required empty public constructor
    }

    public static Tabs newInstance(String url) {
        Tabs fragment = new Tabs();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);

        // Initialize the WebView
        webView = view.findViewById(R.id.myWebView);
        webView.setWebViewClient(new WebViewClient());

        // Load the URL into WebView when the fragment is created
        loadUrl(url, webView);

        return view;
    }

    // Method to load URL into the WebView
    public void loadUrl(String url, WebView webView) {
        webView.loadUrl(url);
    }

    // Getter method for the WebView
    public WebView getWebView() {
        return webView;
    }
}
