package mobile.forkit.forkit_client.utils;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by horimori on 6/20/17.
 */

public class FragmentTransactionManager {
    public static void switchFragments(int replacementId, Fragment newFragment, AppCompatActivity activity) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(replacementId, newFragment);
        transaction.commit();
    }
}
