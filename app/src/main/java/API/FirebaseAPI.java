package API;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import models.User;

public class FirebaseAPI {
    static String URL = "http://127.0.0.1:5000/";
    private RequestQueue queue;

    public  FirebaseAPI(Context context) {
        queue = Volley.newRequestQueue(context);

    }

    public void register(User user,Context context) throws JSONException {
        String url = URL + "user";


        try {

            // Make new json object and put params in it
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("name", user.getName());
            jsonParams.put("location", user.getLocation());
            jsonParams.put("birthday", user.getBirthday());
            jsonParams.put("email", user.getEmail());
            jsonParams.put("password", user.getPassword());


            // Building a request
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    // Using a variable for the domain is great for testing
                    URL+"user",
                    jsonParams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                                Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
                            }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "error occurred", Toast.LENGTH_SHORT).show();
                        }
                    });

             queue.add(request);

        } catch (JSONException ex) {
            throw ex;
        }



    }


}

