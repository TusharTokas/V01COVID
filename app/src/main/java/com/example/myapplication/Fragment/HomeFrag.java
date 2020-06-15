package com.example.myapplication.Fragment;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Objects;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HomeFrag extends Fragment {



    TextView totalCase,totalDeath,totalRec;
    View view;
    Request request;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       view= inflater.inflate(R.layout.fragment_home, container, false);

       viewInit();
       getDataAPI();

    return view;
    }





    private void getDataAPI() {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());

        String url="https://corona.lmao.ninja/v2/all";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {


                    JSONObject jsonObject=new JSONObject(response);
                    totalCase.setText(jsonObject.getString("cases"));
                    totalDeath.setText(jsonObject.getString("deaths"));
                    totalRec.setText(jsonObject.getString("recovered"));


                } catch (JSONException e) {
                    e.printStackTrace();


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("tag", String.valueOf(error));
                Toast.makeText(getActivity(),""+error,Toast.LENGTH_SHORT).show();
            }
        });
requestQueue.add(stringRequest);

    }

    private void viewInit() {
        totalCase=view.findViewById(R.id.totalCaseN);
        totalDeath=view.findViewById(R.id.totalCaseD);
        totalRec=view.findViewById(R.id.totalCaseR);
    }
}
