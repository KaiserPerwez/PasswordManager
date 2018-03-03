package com.qtechie.passwordmanager;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.qtechie.passwordmanager.database.AppDatabase;
import com.qtechie.passwordmanager.fragment.BottomSheetDialogAddPasswordFragment;
import com.qtechie.passwordmanager.fragment.PasswordFragment;
import com.qtechie.passwordmanager.model.PasswordModel;
import com.qtechie.passwordmanager.utils.ConstUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.content_frame)
    ContentFrameLayout contentFrameLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        toolbar.setTitle("No");
        setSupportActionBar(toolbar);

        loadPasswordListFragment();

        AppDatabase database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.passwordDao().deleteAllPasswordModels();
        // add some data
        List<PasswordModel> passwordModels = database.passwordDao().getAllPasswordModels();
        PasswordModel model;
        if (passwordModels.size() == 0) {
            List<PasswordModel> passwordModelList = new ArrayList<>();
            passwordModelList.add(new PasswordModel("", "my title", "", "", "", "", "", ""));
            passwordModelList.add(new PasswordModel("", "my title2", "", "", "", "", "", ""));
            passwordModelList.add(new PasswordModel("", "my title3", "", "", "", "", "", ""));
            database.passwordDao().addPassword(passwordModelList);
            model = database.passwordDao().getAllPasswordModels().get(0);
            Toast.makeText(this, String.valueOf(model.id), Toast.LENGTH_SHORT).show();
        }


    }

    private void loadPasswordListFragment() {
        PasswordFragment fragment = PasswordFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, ConstUtils.TAG_PASSWORD_FRAG);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Name: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @OnClick(R.id.fab)
    public void showDialogFragOnFabClick() {
        BottomSheetDialogAddPasswordFragment bottomSheetDialogAddPasswordFragment = new BottomSheetDialogAddPasswordFragment();
        bottomSheetDialogAddPasswordFragment.show(getSupportFragmentManager(), "tag");
    }
}
