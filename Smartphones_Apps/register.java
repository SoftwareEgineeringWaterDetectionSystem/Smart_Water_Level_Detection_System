package com.example.nano_android;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class register extends Activity {

    EditText name, password, email;
    String Name, Password, Email;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nano_android.R.layout.register);
        name = (EditText) findViewById(com.example.nano_android.R.id.register_name);
        password = (EditText) findViewById(com.example.nano_android.R.id.register_password);
        email = (EditText) findViewById(com.example.nano_android.R.id.register_email);
    }

    public void register_register(View v){
        Name = name.getText().toString();
        Password = password.getText().toString();
        Email = email.getText().toString();
        BackGround b = new BackGround();
        b.execute(Name, Password, Email);
    }
    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String password = params[1];
            String email = params[2];
            String data="";
            int tmp;

            try {
                URL url = new URL("https://softwareengineeing.000webhostapp.com/register.php");
                String urlParams = "name="+name+"&password="+password+"&email="+email;

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
            if(s.equals("")){
                s="Data saved successfully.";
                Intent i = new Intent(ctx, login.class);
                finish();
                startActivity(i);
            }
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }

}
