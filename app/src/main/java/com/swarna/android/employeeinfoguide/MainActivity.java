package com.swarna.android.employeeinfoguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.swarna.android.employeeinfoguide.models.EmployeeInfo;
import com.swarna.android.employeeinfoguide.models.EmployeeInfoResponseModel;
import com.swarna.android.employeeinfoguide.restservice.GsonRequest;
import com.swarna.android.employeeinfoguide.restservice.VolleyHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;
    List<EmployeeInfo> employeeInfoList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        // API call
        getData();

    }

    private void init() {
        employeeInfoList = new ArrayList<EmployeeInfo>();
        listView = (ListView) findViewById(R.id.listView);

        customAdapter = new CustomAdapter(getApplicationContext(), employeeInfoList);
        listView.setAdapter(customAdapter);
    }

    private void getData() {

        String url = "https://guidebook.com/service/v2/upcomingGuides/";

        GsonRequest<EmployeeInfoResponseModel> gsonRequest = new GsonRequest<EmployeeInfoResponseModel>(url, EmployeeInfoResponseModel.class, null, new Response.Listener<EmployeeInfoResponseModel>() {

            @Override
            public void onResponse(EmployeeInfoResponseModel employeeInfoResponseModel) {

                if(null != employeeInfoResponseModel) {

                    employeeInfoList = employeeInfoResponseModel.getData();

                    // print all the data
                    Log.v("json response", "" + employeeInfoResponseModel);
                    Log.v("EmployeeInfo list", ""+employeeInfoList);

                    // showing it in list view with images
                    if(employeeInfoList.size() > 0) {
                        listView.setVisibility(View.VISIBLE);
                        customAdapter.setData(employeeInfoList);
                        customAdapter.notifyDataSetChanged();
                    }
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {

                Toast.makeText(getApplicationContext(), "some error occured pls try again !!!", Toast.LENGTH_LONG).show();
            }
        });

        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
