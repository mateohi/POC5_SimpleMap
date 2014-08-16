package com.ic.banking.glass.poc5_simplemap;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;
import com.ic.banking.glass.poc5_simplemap.utils.async.FinishedTaskListener;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleMapService extends Service {

    private static final String LIVE_CARD_TAG = "SimpleMapService";

    private LiveCard liveCard;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            liveCard = new LiveCard(this, LIVE_CARD_TAG);
            setInitialRemoteViews();

            // Display the options menu when the live card is tapped.
            Intent menuIntent = new Intent(this, LiveCardMenuActivity.class);
            liveCard.setAction(PendingIntent.getActivity(this, 0, menuIntent, 0));
            liveCard.attach(this);
            liveCard.publish(PublishMode.REVEAL);

            getServerImage();
        } else {
            liveCard.navigate();
        }
        return START_STICKY;
    }

    private void setInitialRemoteViews() {
        RemoteViews initialViews =  new RemoteViews(getPackageName(), R.layout.loading);
        liveCard.setViews(initialViews);
    }

    private void getServerImage() {
        int imageId = 1; // En el producto podrian salir de los q tiene cerca, asi como mas datos

        new ImageDownloadTask(new FinishedTaskListener<Bitmap>() {
            @Override
            public void onResult(Bitmap result) {
                updateRemoteViews(result);
            }
        }).execute(imageId);
    }

    private void updateRemoteViews(Bitmap image) {
        if (image == null) {
            RemoteViews errorViews =  new RemoteViews(getPackageName(), R.layout.loading);
            errorViews.setTextViewText(R.id.loading, "No connectivity");
            liveCard.setViews(errorViews);
        }
        else {
            RemoteViews updatedViews = new RemoteViews(getPackageName(), R.layout.directions);
            updatedViews.setTextViewText(R.id.place_info, "Mdeo Shopping");
            updatedViews.setImageViewBitmap(R.id.place_image, image);
            liveCard.setViews(updatedViews);
        }
    }

    @Override
    public void onDestroy() {
        if (liveCard != null && liveCard.isPublished()) {
            liveCard.unpublish();
            liveCard = null;
        }
        super.onDestroy();
    }
}
