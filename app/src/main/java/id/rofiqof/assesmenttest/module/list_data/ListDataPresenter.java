package id.rofiqof.assesmenttest.module.list_data;

import android.content.Context;
import android.content.Intent;

import java.util.List;

import id.rofiqof.assesmenttest.model.DataBarang;
import id.rofiqof.assesmenttest.view.tambah_data.TambahDataActivity;

public class ListDataPresenter implements ListDataInterface, ListDataOutput {

    private ListDataInteractor interactor;
    private ListDataView view;

    public ListDataPresenter(ListDataInteractor interactor, ListDataView view) {
        this.interactor = interactor;
        this.view = view;

        interactor.output = this;
    }

    @Override
    public void getListData() {
        interactor.getListData();
    }

    @Override
    public void toAddList(Context context) {
        Intent intent = new Intent(context, TambahDataActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void getListDataSuccess(List<DataBarang> data) {
        view.getListDataViewSuccess(data);
    }

    @Override
    public void getListDataFailed(String message) {
        view.getListDataViewFailed(message);
    }
}
