package com.ghost.mianmianwwallpaper.commen;

import android.os.AsyncTask;


import com.ghost.mianmianwwallpaper.commen.TextUtils;
import com.ghost.mianmianwwallpaper.configure.NetWorkConfig;
import com.ghost.mianmianwwallpaper.interfaces.IRequest;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ghost on 2017/3/9.
 */

public class StringRequest implements IRequest{
    class Truble{
         final Integer code;
        final String data;

        public Truble(Integer code, String data) {
            this.code = code;
            this.data = data;
        }
    }
    private ResponseCallback<String> mResponseCallback;
    private Map<String,Object> mParams;
    private String mBaseUrl = NetWorkConfig.gBaseUrl;
    private String mMethod;
    private AsyncTask<String,String,Truble> mHttpTask = new AsyncTask<String, String,Truble>() {
        @Override
        protected Truble doInBackground(String... strings) {
            String data = "";
            int code = 404;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod(strings[1]);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setDoInput(true);
                code = httpURLConnection.getResponseCode();
                InputStream is = httpURLConnection.getInputStream();
                byte[] responseByte = TextUtils.getBytesByInputStream(is);
                int e =responseByte.length;
                data = new String(responseByte,"UTF-8");
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Truble(code,data);

        }

        @Override
        protected void onPostExecute(Truble integerStringMap) {
            super.onPostExecute(integerStringMap);
            if (integerStringMap.code == NetWorkConfig.HTTP_OK){
                Gson gson = new Gson();
                mResponseCallback.onSuccess(integerStringMap.data);
            }else {
                mResponseCallback.onFail(integerStringMap.code);
            }
        }
    };

    public StringRequest(ResponseCallback mResponseCallback) {
        this.mResponseCallback = mResponseCallback;
    }

    public void get(Map<String,Object> params){
        this.mMethod = "GET";
        this.mParams = params;
        mHttpTask.execute(buildGetUrl(mBaseUrl,params),mMethod);
    }


    public void setResponseCallback(ResponseCallback responseCallback) {
        this.mResponseCallback = responseCallback;
    }

    @Override
    public Map<String, Object> getParams() {
        return mParams;
    }

    @Override
    public String getBaseUrl() {
        return mBaseUrl;
    }

    @Override
    public String getMothed() {
        return mMethod;
    }

    @Override
    public Map<String, String> getHeader() {
        return null;
    }

    private String buildGetUrl(String baseurl,Map<String,Object> params){
        if (android.text.TextUtils.isEmpty(baseurl)||params == null||params.size() == 0){
            return baseurl;
        }
        if (!baseurl.endsWith("?")){
            baseurl+="?";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> keys = params.keySet();
        for (String key:keys){
            if (params.get(key) == null){
                continue;
            }
            try {
                stringBuilder.append(key+"="+ URLEncoder.encode((String) params.get(key),"UTF-8")+"&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return baseurl+stringBuilder.toString();

    }

}
