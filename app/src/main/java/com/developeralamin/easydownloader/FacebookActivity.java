package com.developeralamin.easydownloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.AsyncTask;
import android.os.Bundle;

import com.developeralamin.easydownloader.databinding.ActivityFacebookBinding;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

import java.io.IOException;

public class FacebookActivity extends AppCompatActivity {

    private ActivityFacebookBinding binding;
    private FacebookActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_facebook);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_facebook);
        activity = this;

        binding.downloadbtn.setOnClickListener(v -> {
            getFacebookData();
        });

    }

    private void getFacebookData() {
    }

    class CallGetFbData extends AsyncTask<String, Void, Document>{

        org.jsoup.nodes.Document fbDoc;


        @Override
        protected Document doInBackground(String... strings) {
            try {
                fbDoc = (org.jsoup.nodes.Document) Jsoup.connect(strings[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return (Document) fbDoc;
        }

//        @Override
//        protected void onPostExecute(Document document) {
//
//            String videoUrl = document.select("meta[property=\"og:video\"]")
//                    .last().attr("content");
//        }
    }
}