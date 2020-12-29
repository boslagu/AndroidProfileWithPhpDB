package com.example.tottie.androidprofilewithphpdb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import static android.support.constraint.Constraints.TAG;

public class myConnection extends AsyncTask<String, String, String> {

    AlertDialog dialog;
    Context context;
    String myCollection = "";
    String fileName = "";
    public myConnection(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Connection Status...");
    }
    @Override
    protected void onPostExecute(String s) {
        myCollection = "";
            try {
                JSONObject obj = new JSONObject(s);
                myCollection =obj.getString("message");
                Log.d("My App", obj.getString("message"));
            } catch (Throwable t) {
                Log.d("My App", "Could not parse malformed JSON: \"" + s + "\"");
            }
//            if (dialog.dismiss()) {
        if (myCollection.equals("success")) {
            Intent i = new Intent(context, HomeActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            if (fileName.equals("signup.php")){
                ((CreateAccountActivity)context).finish();
            }
        }else{
            dialog.setMessage(myCollection);
            dialog.show();
        }
//            }
    }

    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        fileName = voids[0];
        String user = "";
        String pass = "";
        String myName="";
        String myMiddleName="";
        String myLastName="";
        String myCompany="";
        String myCompanyAdd="";
        String myContact="";
        String myEmail="";
        if (fileName.equals("login.php")){
            user = voids[1];
            pass = voids[2];
        }else{
            myName=voids[1];
            myMiddleName=voids[2];
            myLastName=voids[3];
            myCompany=voids[4];
            myCompanyAdd=voids[5];
            myContact=voids[6];
            myEmail=voids[7];
            user = voids[8];
            pass = voids[9];
        }
        String constrng = "https://memel22.000webhostapp.com/android/"+fileName;//This is my webhost
//        String constrng = "http://192.168.100.9/"+fileName;//this is my localhost home
//        String constrng = "http://192.168.8.101/androidConnection/"+fileName;//this is my localhost portable wifi
        try {
            URL url = new URL(constrng);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            OutputStream ops= http.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = "";
            if (fileName.equals("login.php")){
                data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                        +"&&"+ URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8");
            }else{
                data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                        +"&&"+ URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8")
                        +"&&"+ URLEncoder.encode("firstname", "UTF-8")+"="+URLEncoder.encode(myName, "UTF-8")
                        +"&&"+ URLEncoder.encode("middlename", "UTF-8")+"="+URLEncoder.encode(myMiddleName, "UTF-8")
                        +"&&"+ URLEncoder.encode("lastname", "UTF-8")+"="+URLEncoder.encode(myLastName, "UTF-8")
                        +"&&"+ URLEncoder.encode("company", "UTF-8")+"="+URLEncoder.encode(myCompany, "UTF-8")
                        +"&&"+ URLEncoder.encode("address", "UTF-8")+"="+URLEncoder.encode(myCompanyAdd, "UTF-8")
                        +"&&"+ URLEncoder.encode("contact", "UTF-8")+"="+URLEncoder.encode(myContact, "UTF-8")
                        +"&&"+ URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(myEmail, "UTF-8");
            }
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            ops.close();
            InputStream ips = http.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                result += line;
            }
            bufferedReader.close();
            ips.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e){
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }
        return result;
    }
}
