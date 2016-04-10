package com.pake.aplications.tastyapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.pake.aplications.tastyapp.Utilities.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class Category extends AppCompatActivity {
    ListView list;
    TextView ver;
    TextView name;
    TextView api;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
    private static String url;
    JSONArray android = null;
    //JSON Node Names
    private static final String TAG_OS = "fotos";
    private static final String TAG_VER = "FotoId";
    private static final String TAG_NAME = "foto_link";
    private static final String TAG_API = "foto_data";

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
        url = "http://192.168.43.31:8000/database";
        new JSONParse().execute();

    }

    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ver = (TextView)findViewById(R.id.vers);
            name = (TextView)findViewById(R.id.name);
            api = (TextView)findViewById(R.id.api);
            pDialog = new ProgressDialog(Category.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected JSONObject doInBackground(String... args) {

            JSONParser jParser = new JSONParser();

            // Getting JSON from URL
            JSONObject json = jParser.getJSONFromUrl(url);
            return json;
        }
        @Override
        protected void onPostExecute(JSONObject json) {
            pDialog.dismiss();
            try {
                // Getting JSON Array from URL
                android = json.getJSONArray(TAG_OS);
                for(int i = 0; i < android.length(); i++){
                    JSONObject c = android.getJSONObject(i);

                    // Storing  JSON item in a Variable
                    String ver = c.getString(TAG_VER);
                    String name = c.getString(TAG_NAME);
                    String api = c.getString(TAG_API);

                    // Adding value HashMap key => value

                    HashMap<String, String> map = new HashMap<String, String>();

                    map.put(TAG_VER, ver);
                    map.put(TAG_NAME, name);
                    map.put(TAG_API, api);


                    oslist.add(map);
                    list=(ListView)findViewById(R.id.listaCategoria);

                    ListAdapter adapter = new SimpleAdapter(Category.this, oslist,
                            R.layout.list_element,
                            new String[] { TAG_VER,TAG_NAME, TAG_API }, new int[] {
                            R.id.vers,R.id.name, R.id.api});

                    list.setAdapter(adapter);

                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            Toast.makeText(Category.this, "You Clicked at " + oslist.get(+position).get("FotoId"), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
