package mobile.forkit.forkit_client.mainpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.forkit.forkit_client.R;

public class ForkitMainActivity extends AppCompatActivity {

    @BindView(R.id.mm_group)
    RelativeLayout groupBrowser;
    @BindView(R.id.mm_browse)
    RelativeLayout browseEateries;
    @BindView(R.id.mm_notes)
    RelativeLayout savedNotes;
    @BindView(R.id.mm_preferences)
    RelativeLayout userPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forkit_main);
        ButterKnife.bind(this);
    }
}
