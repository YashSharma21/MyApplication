package com.example.yash.shop_stop1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

  private static ArrayList<String> categories =new ArrayList<>(Arrays.asList("Clothing", "Sports & Fitness", "Education", "Lifestyle", "Electronics", "Home Appliances"));
    private static ArrayList<String> clothing  = new ArrayList<>(Arrays.asList( "Trouser", "Shirt", "T-shirt"));
    private static ArrayList<String> sports = new ArrayList<>(Arrays.asList("Sports","Fitness","Outdoor & Adventure"));
    private static ArrayList<String> education = new ArrayList<>(Arrays.asList("Books", "Stationary","Office Equipment"));
    private static ArrayList<String> lifestyle = new ArrayList<>(Arrays.asList("Men", "Women", "Kids","Jwellery","Perfumes & Fragrances","Luggage"));
    private static ArrayList<String> electronics = new ArrayList<>(Arrays.asList("Mobile Phones","Tablets","Mobile Accessories","Mobile Cases & Covers","Power Banks", "Computers & Laptops","TVs & Audio-Video","Large Appliances","Home Appliances","Kitchen Appliances","Cameras & Accessories","Digital Cameras","DSLRs","Caemera Lenses","Camcorders","Digital Photo Frames"));
    private static ArrayList<String> home = new ArrayList<>(Arrays.asList("Kitchenware","Furniture", "Kichen appliances", "Home Decor","Tools & Hardware"));

    private AutoCompleteTextView actv;
    Spinner spinner_2;
    String item,item_item;
    List<String> list = new ArrayList<String>();
    int item1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categories);


        actv.setAdapter(adapter);
        actv.setThreshold(1);

        actv.setOnItemClickListener(this);
        spinner_2.setOnItemSelectedListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Prossesing your request", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = new Intent(getBaseContext(), webview.class);
                i.putExtra("Category",item);
                i.putExtra("Item",item_item);
                startActivity(i);


            }
        });







}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categories);


        actv.setAdapter(adapter);
        actv.setThreshold(1);


item1=categories.indexOf(actv.getText().toString());
        item=actv.getText().toString();
       /* for(int i=0;i<categories.size();i++){
            Log.e("MainActivity","In for loop");
            if(categories.equals(item)){
                item1=i;
                break;
            }
        }*/
        Log.e("MainActivity","Item clicked in actv  : "+item);
        Log.e("MainActivity","Item pos clicked in actv  : "+item1);
        fillSpinner();
        Log.e("MainActivity","Fill Spinner Called");

    }

    private void fillSpinner() {
        Log.e("MainActivty", "Call received in fill spinner");
        Log.e("MainActivity","Item : "+item);
        if(item1==0){
            Log.e("MainActivity", "Loop in clothing");
            ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,clothing);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_2.setAdapter(adapter1);
        }
        else if(item1==1){

            ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,sports);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_2.setAdapter(adapter1);
        }
        else if(item1==2){

            ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,education);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_2.setAdapter(adapter1);
        }
        else if(item1==3){

            ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lifestyle);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_2.setAdapter(adapter1);
        }

        else if(item1==4){

            ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,electronics);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_2.setAdapter(adapter1);
        }

        else if(item1==5){

            ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,home);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_2.setAdapter(adapter1);
        }




        else{
            Log.e("MainActivity","Call didnt went in clothing loop");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item_item=parent.getItemAtPosition(position).toString();
        Log.e("MainActivity","item_item : "+item_item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
