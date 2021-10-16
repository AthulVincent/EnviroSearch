package com.example.envirosearch;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.*;

public class googleUtil {

    final static String API_KEY = "AIzaSyBkyHDstXezeXvAHdyiD1LyIaIp1satgQc";
    final static String cx = "4e507815c936bcf26";
    final static String GOOGLE_QUERY = "https://www.googleapis.com/customsearch/v1?exactTerms=";
    final static String orTerms = "environmental%20issues%2Cenvironmental%20problems%2Cenvironmental%20scandals%2Cpolluter%2Cnegative%20environmental%20impact%2Cnegative%20impact%20on%20environment";

    public static void getSearchResults(String companyName){

        String urlStr = GOOGLE_QUERY + companyName + "&cx=" + cx + "&orTerms=" + orTerms + "&safe=active&key=" + API_KEY;
        URL url = null;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
           //Display Error
        }

        GoogleSearchAsyncTask searchTask = new GoogleSearchAsyncTask();

        URLBundle urlBundle = new URLBundle(url, companyName);
        searchTask.execute(urlBundle);

    }
    private static class URLBundle{
        URL url;
        String companyName;
        URLBundle(URL url, String companyName){
            this.url = url;
            this.companyName = companyName;
        }
    }

    private static class GoogleSearchAsyncTask extends AsyncTask<URLBundle, Integer, ArrayList<searchResult>> {

        protected void onPreExecute(){
            //Progress bar
        }
        @Override
        protected ArrayList<searchResult> doInBackground(URLBundle... urlBundles) {

            URL url = urlBundles[0].url;
            Integer responseCode = null;
            String responseMessage = "";
            ArrayList<searchResult> SR = new ArrayList<searchResult>();

            HttpURLConnection connect = null;
            try {
                connect = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                //display error
            }
            try {
                responseCode = connect.getResponseCode();
                responseMessage = connect.getResponseMessage();
            } catch (IOException e) {
               //Display Error
            }

            try {
                if(responseCode != null && responseCode == 200) {

                    BufferedReader rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;

                    while ((line = rd.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    rd.close();

                    connect.disconnect();

                    JSONObject obj = new JSONObject(sb.toString());
                    sb = new StringBuilder();

                    JSONArray arr = obj.getJSONArray("items");
                    for (int i = 0; i < arr.length(); i++)
                    {
                        searchResult sr = extractData(arr.getJSONObject(i), urlBundles[0].companyName);
                        if(sr != null) {
                            SR.add(sr);
                            sb.append(sr.title + "\n" + sr.URL + "\n" + sr.Snippet + "\n\n");
                        }
                    }
                    return SR;

                }else{

                    String errorMsg = "Http ERROR response " + responseMessage + "\n";
                    return  null;
                }
            } catch (IOException | JSONException e) {
               //Display result
            }

            return null;
        }
        private searchResult extractData(JSONObject googleJSONObject, String companyName) throws JSONException {

            searchResult sr = new searchResult();

            if(googleJSONObject.getJSONObject("pagemap").getJSONArray("metatags").getJSONObject(0).has("og:title"))
                sr.title = googleJSONObject.getJSONObject("pagemap").getJSONArray("metatags").getJSONObject(0).getString("og:title");

            if(sr.title == null)
                return null;

            if (googleJSONObject.has("link"))
                sr.URL = googleJSONObject.getString("link");

            if(isCompanyWebsite(sr.URL, companyName))
                return null;

            if (googleJSONObject.has("snippet"))
                sr.Snippet = googleJSONObject.getString("snippet");

            return sr;
        }

        private boolean isCompanyWebsite(String url, String companyName) {

            url = url.split("\\.")[1];

            companyName = companyName.replaceAll("[^a-zA-Z]", "");
            companyName = companyName.toLowerCase();

            url = url.toLowerCase();
            url = url.replaceAll("[^a-zA-Z]", "");

            Log.d("googleUtil:", "url=" + url + "companyName=" + companyName);

            return url.contains(companyName);
        }
    }

}
