package mobile.forkit.forkit_client.browse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import mobile.forkit.forkit_client.R;
import mobile.forkit.forkit_client.utils.FragmentTransactionManager;

public class BrowseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        FragmentTransactionManager.switchFragments(R.id.browse_fragment_container,
                new EateriesSearchFragment(), this);
    }
}
