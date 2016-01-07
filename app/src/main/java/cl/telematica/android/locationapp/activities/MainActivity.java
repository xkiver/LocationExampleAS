package cl.telematica.android.locationapp.activities;

import android.os.Bundle;

import cl.telematica.android.locationapp.R;
import cl.telematica.android.locationapp.fragments.LocationFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentFrame(R.id.content_frame);
        switchContent(LocationFragment.newInstance(), null);
    }
}
