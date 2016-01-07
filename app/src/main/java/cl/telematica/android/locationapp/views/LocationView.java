package cl.telematica.android.locationapp.views;

import android.location.Location;

/**
 * Created by franciscocabezas on 1/7/16.
 */
public interface LocationView {

    public void showLocationErrorMsg();

    public void showPermissionErrorMsg();

    public void manageLocationChange(Location mLocation);

    public void manageStatusChange(String provider, int status);

}
