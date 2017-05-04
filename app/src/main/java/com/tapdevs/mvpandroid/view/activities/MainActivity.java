package com.tapdevs.mvpandroid.view.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tapdevs.mvpandroid.App;
import com.tapdevs.mvpandroid.R;
import com.tapdevs.mvpandroid.abstractions.views.BaseActivity;
import com.tapdevs.mvpandroid.utils.AppConstants;
import com.tapdevs.mvpandroid.view.fragments.UsersFragment;

public class MainActivity extends BaseActivity {

    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(new UsersFragment());
    }

    @Override
    public void injectDependencies() {
        context=this;
//        App.get(context).getNetComponent().inject(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_view_on_github:
                //TODO: Add github link
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment,fragment.getClass().getSimpleName())
                .commit();
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_frame, fragment)
                .addToBackStack(AppConstants.BROWSE_FRAGMENT_TAG)
                .commit();
    }

}
