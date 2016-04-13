package com.pake.aplications.tastyapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.pake.aplications.tastyapp.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class RecipeShow extends AppCompatActivity{
    private static final String url = "http://192.168.43.147:8000";
    private int recipe_id;
    private String title;
    private String ingredients;
    private String preparation;
    private String video_link;
    protected WebView webView;
    protected TextView data_ingredients;
    protected TextView data_preparation;
    ProgressDialog pDialog;

    int w= 480;//width


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display a indeterminate progress bar on title bar
        setContentView(R.layout.activity_recipe_show);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Bundle bundle = getIntent().getExtras();
        recipe_id=bundle.getInt("recipe_id");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        w = dm.widthPixels/2;



        getRecipe();


        FloatingActionButton share = (FloatingActionButton) findViewById(R.id.share_btn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! Check this recipe in TastyApp."+title );
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private class myWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Load the given URL on our WebView.
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            // When the page has finished loading, hide progress dialog and
            // progress bar in the title.
            super.onPageFinished(view, url);
        }
    }


    protected void cargarVideo(){
        // Tells JavaScript to open windows automatically.
        webView.getSettings().setJavaScriptEnabled(true);
        // Sets our custom WebViewClient.

        webView.setWebChromeClient(new WebChromeClient() {

        });
        // Loads the given URL

        webView.loadUrl(url + "/video?link=" + video_link + "&width=" + w);

    }


    private void getRecipe(){
        String databaseRequest = url+"/recipe?recipe_id="+recipe_id;
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading recipe...");
        pDialog.show();
        JsonArrayRequest recipeReq = new JsonArrayRequest(databaseRequest,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Parsing json
                        try {
                            JSONObject obj = response.getJSONObject(0);
                            title=obj.getString("recipe_title");
                            ingredients=obj.getString("recipe_ingredients");
                            preparation=obj.getString("recipe_preparation");
                            video_link=obj.getString("recipe_video");
                            setTitle(title);
                            data_ingredients = (TextView) findViewById(R.id.data_ingredients);
                            data_preparation = (TextView) findViewById(R.id.data_preparation);
                            webView = (WebView) findViewById(R.id.videoView);
                            cargarVideo();
                            data_ingredients.setText(ingredients);
                            data_preparation.setText(preparation);
                            pDialog.hide();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();

            }
        });
        AppController.getInstance().addToRequestQueue(recipeReq);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recipeshow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.fav_star) {
            try {
                OutputStreamWriter fout =
                        new OutputStreamWriter(
                                openFileOutput("favorites.txt", Context.MODE_APPEND));
                fout.write(recipe_id+"\n");
                fout.close();
                Toast.makeText(RecipeShow.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.on_star);
            } catch (Exception ex) {
                Toast.makeText(RecipeShow.this, "Error.. :/", Toast.LENGTH_SHORT).show();
                Log.e("Ficheros", "Error in writting");
            }
            Toast.makeText(RecipeShow.this, "Added to favorites", Toast.LENGTH_SHORT).show();
            item.setIcon(R.drawable.on_star);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onDestroy() {
        super.onDestroy();
    }



}
