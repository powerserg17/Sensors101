package com.serhiipianykh.sensors101;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public class SensorsListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return SensorsListFragment.newInstance();
    }
}
