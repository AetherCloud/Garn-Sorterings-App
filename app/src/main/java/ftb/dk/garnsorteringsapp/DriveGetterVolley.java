package ftb.dk.garnsorteringsapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.*;

public class DriveGetterVolley {

    public void httpGet(String urlString) {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringReq = new StringRequest(Request.Method.GET, urlString,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        textView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Log.i(TAG,"Error :" + error.toString());
                    }
                });
        queue.add(stringReq);
    }
}
