package id.rofiqof.assesmenttest.view.tambah_data;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.rofiqof.assesmenttest.R;
import id.rofiqof.assesmenttest.databinding.TambahDataActivityBinding;
import id.rofiqof.assesmenttest.model.DataBarang;
import id.rofiqof.assesmenttest.module.tambah_data.TambahDataInteractor;
import id.rofiqof.assesmenttest.module.tambah_data.TambahDataPresenter;
import id.rofiqof.assesmenttest.module.tambah_data.TambahDataView;

public class TambahDataActivity extends AppCompatActivity implements TambahDataView {

    TambahDataActivityBinding content;
    TambahDataPresenter presenter;

    ProgressDialog mDialog;
    Calendar mCurrentDate;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = DataBindingUtil.setContentView(this, R.layout.tambah_data_activity);
        content.setView(this);

        presenter = new TambahDataPresenter(new TambahDataInteractor(), this);

        setToolbar();

        checkEditTextEmpty(content.namaBarang);
        checkEditTextEmpty(content.jumlahBarang);
        checkEditTextEmpty(content.namaPemasok);
        checkEditTextEmpty(content.tanggal);
    }

    public void setTanggal() {
        showDateDialog(content.tanggal);
    }

    public void simpanData() {
        showDialog();

        String namaBarang = content.namaBarang.getText().toString();
        String jumlahBarang = content.jumlahBarang.getText().toString();
        String namaPemasok = content.namaPemasok.getText().toString();
        String tanggal = content.tanggal.getText().toString();

        presenter.addData(new DataBarang(namaBarang, jumlahBarang, namaPemasok, tanggal));
    }

    @Override
    public void addDataSuccess(String message) {
        mDialog.dismiss();
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void addDataFailed(String message) {
        mDialog.dismiss();
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void checkEditTextEmpty(EditText view) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()) {
                    content.simpan.setEnabled(false);
                } else {
                    if (content.namaBarang.getText().toString().isEmpty()
                            || content.jumlahBarang.getText().toString().isEmpty()
                            || content.namaPemasok.getText().toString().isEmpty()
                            || content.tanggal.getText().toString().isEmpty()) {

                        content.simpan.setEnabled(false);
                    } else {
                        content.simpan.setEnabled(true);

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setToolbar() {
        setSupportActionBar(content.toolbar.toolbar);
        getSupportActionBar().setTitle("Tambah Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        content.toolbar.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void showDialog() {
        mDialog = new ProgressDialog(TambahDataActivity.this);
        mDialog.setMessage("Please Wait ...");
        mDialog.setCancelable(false);
        mDialog.show();
    }

    private void showDateDialog(final EditText result) {
        mCurrentDate = Calendar.getInstance();

        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        month = month + 1;

        DatePickerDialog datePickerDialog = new DatePickerDialog(TambahDataActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String dateFormat = new SimpleDateFormat("MMMM").format(month);
                result.setText(dayOfMonth + " " + dateFormat + " " + year);
            }
        }, year, month, day);
        datePickerDialog.show();

    }
}
