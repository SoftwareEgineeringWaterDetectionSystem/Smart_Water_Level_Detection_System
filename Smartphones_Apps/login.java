package com.example.nano_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import org.json.*;


import java.io.*;
import java.net.*;




public class login extends Activity {

    EditText name, password;
    String Name, Password;
    String Names = null, Passwords = null;
    Context ctx=this;
    String NAME=null, PASSWORD=null, EMAIL=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nano_android.R.layout.login);
        name = (EditText) findViewById(com.example.nano_android.R.id.main_name);
        password = (EditText) findViewById(com.example.nano_android.R.id.main_password);
    }

    public void main_register(View v){
        startActivity(new Intent(this,register.class));
    }

    public void main_login(View v){
        Name = name.getText().toString();
        Password = password.getText().toString();
        BackGround b = new BackGround();
        b.execute(Name, Password);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String password = params[1];
            String data="";
            int tmp;

            try {
                URL url = new URL("https://softwareengineeing.000webhostapp.com/login.php");
                String urlParams = "name="+name+"&password="+password;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }

                is.close();
                httpURLConnection.disconnect();

                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            String err=null;
            try {
                System.out.println("start read");
                JSONObject root = new JSONObject(s);
                JSONObject user_data = root.getJSONObject("user");
                NAME = user_data.getString("name");
                PASSWORD = user_data.getString("password");
                EMAIL = user_data.getString("email");

                if ((PASSWORD.equalsIgnoreCase(Password)) && (NAME.equalsIgnoreCase(Name))){
                    System.out.println("Im in");
                    Intent i = new Intent(ctx, home.class);
                    i.putExtra("name", NAME);
                    i.putExtra("password", PASSWORD);
                    i.putExtra("email", EMAIL);
                   // i.putExtra("err", err);
                    finish();
                    startActivity(i);


                }

                else {
                    Intent i = new Intent(ctx, login.class);
                    name.setText("");
                    password.setText("");
                    startActivity(i);
                }

            }catch (JSONException e) {
                e.printStackTrace();
               //err = "Exception: "+e.getMessage();
            }







        }

    }
}
