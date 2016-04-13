package com.pake.aplications.tastyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Search_Recipe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void cambiarPantalla(String nombrePantalla,String byCat){
        Intent nuevaPantalla;
        nuevaPantalla = new Intent().setClass(
                Search_Recipe.this, Category.class);
        nuevaPantalla.putExtra("Name", nombrePantalla);
        boolean value_fav = false;
        boolean twoWordsCategory = false;
        if(nombrePantalla=="Comfort Foods"){
                twoWordsCategory=true;
                nuevaPantalla.putExtra("newName","Comfort");
        }else{
               if(nombrePantalla=="Happy Hour"){
                    twoWordsCategory=true;
                    nuevaPantalla.putExtra("newName","Happy");
                }
        }
        nuevaPantalla.putExtra("twoWordsCategory", twoWordsCategory);
        nuevaPantalla.putExtra("favorite", value_fav);
        nuevaPantalla.putExtra("search", true);
        nuevaPantalla.putExtra("cat", byCat);
        startActivity(nuevaPantalla);
    }
    public void loadSearch(View view) {
        EditText txt = (EditText) findViewById(R.id.search_text);
        String busqueda = txt.getText().toString();
        String byCat = "";
        RadioButton r1 = (RadioButton) findViewById(R.id.rd_All);
        RadioButton r2 = (RadioButton) findViewById(R.id.rd_Happy);
        RadioButton r3 = (RadioButton) findViewById(R.id.rd_Apps);
        RadioButton r4 = (RadioButton) findViewById(R.id.rd_Desserts);
        RadioButton r5 = (RadioButton) findViewById(R.id.rd_Comfort);
        RadioButton r6 = (RadioButton) findViewById(R.id.rd_Dinners);
        RadioButton r7 = (RadioButton) findViewById(R.id.rd_Junior);
        RadioButton r8 = (RadioButton) findViewById(R.id.rd_Pizza);
        RadioButton r9 = (RadioButton) findViewById(R.id.rd_Cheese);

        if (r1.isChecked()) {
            byCat = "";
        } else if (r2.isChecked()) {
            byCat = "Happy";
        } else if (r3.isChecked()) {
            byCat = "Apps";
        } else if (r4.isChecked()) {
            byCat = "Desserts";
        } else if (r5.isChecked()) {
            byCat = "Comfort";
        } else if (r6.isChecked()) {
            byCat = "Dinners";
        } else if (r7.isChecked()) {
            byCat = "Junior";
        } else if (r8.isChecked()) {
            byCat = "Pizza";
        } else if (r9.isChecked()) {
            byCat = "Cheese";
        }
        cambiarPantalla(busqueda,byCat);
    }
}
