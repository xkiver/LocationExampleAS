package cl.telematica.android.locationapp.fragments;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import cl.telematica.android.locationapp.R;
import cl.telematica.android.locationapp.presenters.LocationPresenterImpl;
import cl.telematica.android.locationapp.views.LocationView;

/**
 * Created by franciscocabezas on 1/7/16.
 */
public class LocationFragment extends Fragment implements LocationView {

    private LocationPresenterImpl mLocationPresenter;

    private TextView mLatitudeData;
    private TextView mLongitudeData;

    /**
     * New instance of LocationFragment
     *
     * @return new instance of LocationFragment
     */
    public static LocationFragment newInstance() {
        LocationFragment fragment = new LocationFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.fragment_location, null);

        mLatitudeData = (TextView) mainView.findViewById(R.id.latitudeData);
        mLongitudeData = (TextView) mainView.findViewById(R.id.longitudeData);

        LocationManager mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        mLocationPresenter = new LocationPresenterImpl(getActivity(), mLocationManager, this);

        return mainView;
    }

    @Override
    public void onResume(){
        super.onResume();
        mLocationPresenter.startUpdates();
    }

    @Override
    public void onPause() {
        super.onPause();
        mLocationPresenter.stopUpdates();
    }

    @Override
    public void showLocationErrorMsg() {
        Toast.makeText(getActivity(), getString(R.string.location_error_msg), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPermissionErrorMsg() {
        Toast.makeText(getActivity(), getString(R.string.permission_error_msg), Toast.LENGTH_LONG).show();
    }

    @Override
    public void manageLocationChange(Location mLocation) {
        mLatitudeData.setText("" + mLocation.getLatitude());
        mLongitudeData.setText("" + mLocation.getLongitude());
    }

    @Override
    public void manageStatusChange(String provider, int status) {
        Toast.makeText(getActivity(), getString(R.string.status_msg) + "--> Provider: " + provider + " Status: " + status, Toast.LENGTH_LONG).show();
    }
}
