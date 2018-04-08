package id.rofiqof.assesmenttest.module.tambah_data;

import id.rofiqof.assesmenttest.model.DataBarang;

public class TambahDataPresenter implements TambahDataInterface, TambahDataOutput {

    private TambahDataInteractor interactor;
    private TambahDataView view;

    public TambahDataPresenter(TambahDataInteractor interactor, TambahDataView view) {
        this.interactor = interactor;
        this.view = view;

        interactor.output = this;
    }

    @Override
    public void addData(DataBarang dataBarang) {
        interactor.addData(dataBarang);
    }

    @Override
    public void addDataSuccess(String message) {
        view.addDataSuccess(message);
    }

    @Override
    public void addDataFailed(String message) {
        view.addDataFailed(message);
    }
}
