package com.pake.aplications.tastyapp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.pake.aplications.tastyapp.adater.CustomListAdapter;
import com.pake.aplications.tastyapp.app.AppController;
import com.pake.aplications.tastyapp.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Category extends AppCompatActivity {
    // Log tag
    private static final String TAG = Category.class.getSimpleName();
    //Movies json url
    private static final String url = "http://192.168.43.31:8000/database";
    private ProgressDialog pDialog;
    private List<Recipe> recipeList = new ArrayList<Recipe>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        String newTitle=bundle.getString("Name");
        setTitle(newTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Data from database
        loadRecipes();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    private void loadRecipes(){
        listView = (ListView) findViewById(R.id.listaCategoria);
        adapter = new CustomListAdapter(this, recipeList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest recipeReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        pDialog.hide();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Recipe recipe = new Recipe();
                                recipe.setID(obj.getInt("RecipeId"));
                                recipe.setTitle(obj.getString("recipe_title"));
                                recipe.setThumbnailUrl(obj.getString("recipe_image"));
                                recipe.setDescription(obj.getString("recipe_description"));



                                // adding recipe to recipe array
                                recipeList.add(recipe);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.hide();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(recipeReq);
    }

}
