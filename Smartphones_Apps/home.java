package com.example.nano_android;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class home extends Activity {
    Context ctx=this;
    String DATES = null, TIMES = null, LEVEL = null;
    String name, password, email, dates, times, level, Err;
    String Name, Password, Email;
    //String names = "Nizam";
    //String passwords = "testmy";


    TextView nameTV, emailTV, passwordTV, datesTV, timesTV, levelTV, err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nano_android.R.layout.home);

        nameTV = (TextView) findViewById(com.example.nano_android.R.id.home_name);
        emailTV = (TextView) findViewById(com.example.nano_android.R.id.home_email);
        passwordTV = (TextView) findViewById(com.example.nano_android.R.id.home_password);
        datesTV = (TextView) findViewById(com.example.nano_android.R.id.home_dates);
        timesTV = (TextView) findViewById(com.example.nano_android.R.id.home_times);
        levelTV = (TextView) findViewById(com.example.nano_android.R.id.home_level);
        err = (TextView) findViewById(com.example.nano_android.R.id.err);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        password = intent.getStringExtra("password");
        email = intent.getStringExtra("email");
        Err = intent.getStringExtra("err");

        dates = intent.getStringExtra("dates");
        times = intent.getStringExtra("times");
        level = intent.getStringExtra("level");

        nameTV.setText("Welcome " + name);
        passwordTV.setText("Your password is " + password);
        emailTV.setText("Your email is " + email);
        err.setText(Err);

        datesTV.setText("Date: " + dates);
        timesTV.setText("Time: " + times);
        levelTV.setText("Water level: " + level);

        Button button = (Button) findViewById(com.example.nano_android.R.id.home_value);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ret_data();
            }
        });

        Button button2 = (Button) findViewById(com.example.nano_android.R.id.home_logout);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, login.class);
                finish();
                startActivity(i);
            }
        });
    }

    public void ret_data(){
        Name = name.toString();
        Password = password.toString();
        Email = email.toString();

        System.out.println(Name);
        System.out.println(Password);
        System.out.println(Email);
        home.BackGround b = new home.BackGround();
        b.execute(Name, Password, Email);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String password = params[1];
            String email = params[2];
            System.out.println("lat");
            String data = "";
            int tmp;
            try {
                URL url = new URL("https://softwareengineeing.000webhostapp.com/rpi_data_home.php");
                String urlParams = "";
                System.out.println("lat2");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                System.out.println("lat3");
                httpURLConnection.setDoOutput(true);
                System.out.println("lat4");
                OutputStream os = httpURLConnection.getOutputStream();
                System.out.println("lat5");
                os.write(urlParams.getBytes());
                System.out.println("lat6");
                os.flush();
                System.out.println("lat7");
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                while ((tmp = is.read()) != -1) {
                    data += (char) tmp;
                }

                System.out.println(data);

                is.close();
                httpURLConnection.disconnect();

                try {
                    System.out.println("start read");
                    JSONObject root = new JSONObject(data);
                    JSONObject user_data = root.getJSONObject("user");
                    DATES = user_data.getString("now_date");
                    TIMES = user_data.getString("now_time");
                    LEVEL = user_data.getString("level");

                    System.out.println(DATES);
                    System.out.println(TIMES);
                    System.out.println(LEVEL);

                    Intent i = new Intent(ctx, home.class);
                    i.putExtra("dates", DATES);
                    i.putExtra("times", TIMES);
                    i.putExtra("level", LEVEL);
                    i.putExtra("name", name);
                    i.putExtra("password", password);
                    i.putExtra("email", email);
                    finish();
                    startActivity(i);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return (data);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
        }

    }

    /////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////
}