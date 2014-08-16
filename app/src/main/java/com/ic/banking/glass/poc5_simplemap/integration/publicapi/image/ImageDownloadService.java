package com.ic.banking.glass.poc5_simplemap.integration.publicapi.image;

import android.graphics.Bitmap;

import com.ic.banking.glass.poc5_simplemap.integration.publicapi.image.dto.ImageDTO;
import com.ic.banking.glass.poc5_simplemap.utils.BitmapUtils;

public class ImageDownloadService {

    private static ImageDownloadService instance = new ImageDownloadService();

    public static ImageDownloadService instance() {
        return instance;
    }

    public Bitmap getImage(int imageId) {
        ImageDTO imageDTO = ImageDownloadClient.instance().getImage(imageId);

        if (imageDTO == null) {
            throw new RuntimeException("Unable to recover image with id:" + imageId);
        }

        String imageBase64 = imageDTO.getImagePicture();
        return BitmapUtils.base64ToBitmap(imageBase64);
    }

}

