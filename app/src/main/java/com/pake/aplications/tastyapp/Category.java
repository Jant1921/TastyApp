package com.pake.aplications.tastyapp;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Category extends AppCompatActivity {
    // Log tag
    private static final String TAG = Category.class.getSimpleName();
    //Movies json url
    private static final String url = "http://192.168.43.147:8000";
    private ProgressDialog pDialog;
    private List<Recipe> recipeList = new ArrayList<Recipe>();
    private ListView listView;
    private CustomListAdapter adapter;
    private String newTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        newTitle=bundle.getString("Name");
        boolean fav = bundle.getBoolean("favorite");
        setTitle(newTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Data from database
        if(!fav) {
            if(bundle.getBoolean("twoWordsCategory")){
                newTitle=bundle.getString("newName");
            }
            loadRecipes();
        }else{
            try {
                loadFavorites();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long arg) {
                openRecipe(adapter.getItem(position).getId());
            }
        });

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

        String urlRequest = url+"/category?name="+newTitle;
        JsonArrayRequest recipeReq = new JsonArrayRequest(urlRequest,
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

    private void loadFavorites() throws IOException {
        listView = (ListView) findViewById(R.id.listaCategoria);
        adapter = new CustomListAdapter(this, recipeList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading favorites...");
        pDialog.show();
        final List<String> favs = readTxt();
        for(int y=0;y<favs.size();y++){
            String line = favs.get(y);
            int recipe_id = Integer.parseInt(line);//.substring(0, line.length() - 1)); //to delete '\n'
            String databaseRequest = url + "/favorite?recipe_id=" + recipe_id;
            JsonArrayRequest recipeReq = new JsonArrayRequest(databaseRequest,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // Parsing json
                            try {
                                JSONObject obj = response.getJSONObject(0);
                                Recipe recipe = new Recipe();
                                recipe.setID(obj.getInt("RecipeId"));
                                recipe.setTitle(obj.getString("recipe_title"));
                                recipe.setThumbnailUrl(obj.getString("recipe_image"));
                                recipe.setDescription(obj.getString("recipe_description"));
                                recipeList.add(recipe);
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
            try {
                Thread.sleep(100);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            AppController.getInstance().addToRequestQueue(recipeReq);

        }
        adapter.notifyDataSetChanged();
        pDialog.hide();
    }

    private List<String> readTxt() throws IOException {
        List<String> listado=new ArrayList<String>();
        String linea;
        BufferedReader fin =
                new BufferedReader(
                        new InputStreamReader(
                                openFileInput("prueba3.txt")));
        if(fin!=null) {
            while((linea=fin.readLine())!=null) {
                listado.add(linea);
            }
        }
        return listado;
    }

    private void openRecipe(int recipe_id ){
        Intent nuevaPantalla;
        nuevaPantalla = new Intent().setClass(
                Category.this, RecipeShow.class);
        nuevaPantalla.putExtra("recipe_id", recipe_id);
        startActivity(nuevaPantalla);
    }

}
