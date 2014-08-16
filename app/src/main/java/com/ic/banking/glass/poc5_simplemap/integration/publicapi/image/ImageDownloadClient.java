package com.ic.banking.glass.poc5_simplemap.integration.publicapi.image;

import android.util.Log;

import com.google.gson.Gson;
import com.ic.banking.glass.poc5_simplemap.integration.publicapi.PublicUrls;
import com.ic.banking.glass.poc5_simplemap.integration.publicapi.image.dto.ImageDTO;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ImageDownloadClient {

    private static final String TAG = ImageDownloadClient.class.getSimpleName();

    private static ImageDownloadClient instance;
    private HttpClient httpClient;
    private Gson gson;

    private ImageDownloadClient() {
        this.httpClient = new DefaultHttpClient();
        this.gson = new Gson();
    }

    public static ImageDownloadClient instance() {
        if (instance == null) {
            instance = new ImageDownloadClient();
        }
        return instance;
    }

    public ImageDTO getImage(int imageId) {
        HttpGet httpGet = new HttpGet(String.format(PublicUrls.GET_IMAGE_URL, imageId));
        try {
            HttpResponse response = this.httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                String data = EntityUtils.toString(response.getEntity());
                ImageDTO imageDTO = this.gson.fromJson(data, ImageDTO.class);
                return imageDTO;
            }
        }
        catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

}

