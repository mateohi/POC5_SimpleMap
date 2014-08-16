package com.ic.banking.glass.poc5_simplemap;

import android.graphics.Bitmap;
import android.util.Log;

import com.ic.banking.glass.poc5_simplemap.integration.publicapi.image.ImageDownloadService;
import com.ic.banking.glass.poc5_simplemap.utils.async.FinishedTaskListener;
import com.ic.banking.glass.poc5_simplemap.utils.async.SimpleAsyncTask;

public class ImageDownloadTask extends SimpleAsyncTask<Bitmap> {

    private static final String TAG = ImageDownloadTask.class.getSimpleName();

    public ImageDownloadTask(FinishedTaskListener<Bitmap> listener) {
        super(listener);
    }

    @Override
    protected Bitmap doInBackground(Object... params) {
        Integer imageId = (Integer)params[0];

        //try {
            Bitmap bitmap = ImageDownloadService.instance().getImage(imageId);
            return bitmap;
        /*}
        catch (RuntimeException e) {
            Log.e(TAG, e.getMessage());
            return null;
        }*/
    }

}
