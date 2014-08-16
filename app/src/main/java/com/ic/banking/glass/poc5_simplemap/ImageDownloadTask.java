package com.ic.banking.glass.poc5_simplemap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.ic.banking.glass.poc5_simplemap.integration.publicapi.image.ImageDownloadService;

public class ImageDownloadTask extends AsyncTask<Integer, Void, Bitmap> {

    private static final String TAG = ImageDownloadTask.class.getSimpleName();
    private Context context;

    public ImageDownloadTask(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        Integer imageId = params[0];
        Bitmap bitmap = ImageDownloadService.instance().getImage(imageId);

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
    }

}
