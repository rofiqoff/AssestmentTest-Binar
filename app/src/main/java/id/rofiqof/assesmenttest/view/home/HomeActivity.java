package id.rofiqof.assesmenttest.view.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.rofiqof.assesmenttest.R;
import id.rofiqof.assesmenttest.databinding.ContentHomeBinding;
import id.rofiqof.assesmenttest.model.DataBarang;
import id.rofiqof.assesmenttest.module.list_data.ListDataInteractor;
import id.rofiqof.assesmenttest.module.list_data.ListDataPresenter;
import id.rofiqof.assesmenttest.module.list_data.ListDataView;
import id.rofiqof.assesmenttest.support.Adapter;
import id.rofiqof.assesmenttest.support.SessionData;
import id.rofiqof.assesmenttest.view.login.LoginActivity;
import id.rofiqof.assesmenttest.view.view_holder.ListDataViewHolder;

public class HomeActivity extends AppCompatActivity implements ListDataView {

    ContentHomeBinding content;

    ListDataPresenter presenter;

    SessionData session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = DataBindingUtil.setContentView(this, R.layout.content_home);
        content.setView(this);

        session = new SessionData(HomeActivity.this);

        presenter = new ListDataPresenter(new ListDataInteractor(), this);
        presenter.getListData();

        setSupportActionBar(content.toolbar.toolbar);
        getSupportActionBar().setTitle("List Barang");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            session.destroySession();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setList(DataBarang data) {

        List<DataBarang> list = new ArrayList<>();
        list.add(data);

        Adapter<DataBarang, ListDataViewHolder> adapter = new Adapter<DataBarang, ListDataViewHolder>(
                R.layout.list_data_barang, ListDataViewHolder.class, DataBarang.class, list) {
            @Override
            protected void bindView(ListDataViewHolder holder, DataBarang model, int position) {
                holder.onBind(getApplicationContext(), model);
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);

        content.list.setAdapter(adapter);
        content.list.setLayoutManager(layoutManager);
        content.list.setHasFixedSize(true);

    }

    public void addList() {

    }

    @Override
    public void getListDataViewSuccess(DataBarang data) {
        setList(data);
    }

    @Override
    public void getListDataViewFailed(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }
}
