package com.ic.banking.glass.poc5_simplemap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

public class LiveCardMenuActivity extends Activity {

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Open the options menu right away.
        openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_stop:
                stopService(new Intent(this, SimpleMapService.class));
                return true;
            case R.id.action_get_directions:
                getDirections();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getDirections() {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mapIntent.setData(Uri.parse("google.navigation:ll=-34.903013,-56.136248&mode=w&title=Mdeo Shopping"));
        startActivity(mapIntent);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        finish();
    }
}
