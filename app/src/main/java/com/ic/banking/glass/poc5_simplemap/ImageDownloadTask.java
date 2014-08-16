package com.ic.banking.glass.poc5_simplemap;

import android.graphics.Bitmap;

import com.ic.banking.glass.poc5_simplemap.integration.publicapi.image.ImageDownloadService;
import com.ic.banking.glass.poc5_simplemap.utils.async.FinishedTaskListener;
import com.ic.banking.glass.poc5_simplemap.utils.async.SimpleAsyncTask;

public class ImageDownloadTask extends SimpleAsyncTask<Bitmap> {

    public ImageDownloadTask(FinishedTaskListener<Bitmap> listener) {
        super(listener);
    }

    @Override
    protected Bitmap doInBackground(Object... params) {
        Integer imageId = (Integer)params[0];
        Bitmap bitmap = ImageDownloadService.instance().getImage(imageId);

        return bitmap;
    }

}
