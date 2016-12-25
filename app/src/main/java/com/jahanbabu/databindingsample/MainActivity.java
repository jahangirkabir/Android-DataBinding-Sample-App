package com.jahanbabu.databindingsample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.jahanbabu.databindingsample.utils.GsonRequest;
import com.jahanbabu.databindingsample.utils.URLs;
import com.jahanbabu.databindingsample.adapter.ProductsAdapter;
import com.jahanbabu.databindingsample.model.Blush;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Blush> blushes;
    ProgressDialog pd;
    private Map<String, String> getBlushHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "jahangirkobir@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    private void getData() {
        pd = ProgressDialog.show(MainActivity.this, "", "Loading... Please wait");
        RequestQueue queue = Volley.newRequestQueue(this);
        GsonRequest<Blush[]> myReq = new GsonRequest<Blush[]>(
                URLs.BASEURL,
                Blush[].class, getBlushHeader,
                getBlushSuccessListener(),
                getBlushReqErrorListener()

        );
        queue.add(myReq);
    }

    private Response.Listener<Blush[]> getBlushSuccessListener() {
        return new Response.Listener<Blush[]>() {
            @Override
            public void onResponse(Blush[] response) {
                pd.dismiss();
                blushes =  new ArrayList<Blush>(Arrays.asList(response));
                populateListView();
            }
        };
    }

    private Response.ErrorListener getBlushReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                Log.d("onErrorResponse : ", error.toString());
            }
        };
    }

    private void populateListView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ProductsAdapter productsAdapter = new ProductsAdapter(blushes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
