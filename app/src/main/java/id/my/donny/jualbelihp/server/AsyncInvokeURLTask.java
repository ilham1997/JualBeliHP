package id.my.donny.jualbelihp.server;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.text.format.Time;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.net.HttpCookie;
import java.util.ArrayList;

public class AsyncInvokeURLTask extends AsyncTask<Void, Void, String> {
    public String mNoteItWebUrl = "www.smartneasy.com";
    private ArrayList<NameValuePair> mParams;
    private OnPostExecuteListener onPostExecuteListener = null;
    private ProgressDialog dialog;
    public boolean showdialog = false;
    public String message = "Proses Data";
    public String url_server = "http://localhost/xphone/";
    public Context applicationContext;
    public static interface OnPostExecuteListener{
        void onPostExecute(String result);
    }
    public AsyncInvokeURLTask(
        ArrayList<NameValuePair> nameValuePairs;
        OnPostExecuteListener postExecuteListener) throws Exception{
        mParams = nameValuePairs;
        onPostExecuteListener = PostExecuteListener;
        if (onPostExecuteListener == null)
            throw new Exception("Params cannot be null.");
    }
    @Override
    public void onPreExecute(){
        if (showdialog)
            this.dialog = ProgressDialog.show(applicationContext, message, "Silakan Menunggu...", true);
    }
    @Override
    public String doInBackground(Void... params){
        String result = "timeout";
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httppost =  new HttpPost(url_server+mNoteItWebUrl);
        try {
            httppost.setEntity(new UrlEncodedFormEntity(mParams));
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null){
                InputStream inputStream = entity.getContent();
            }
        }
    }
}



