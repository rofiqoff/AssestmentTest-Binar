package id.rofiqof.assesmenttest.module.list_data;

import id.rofiqof.assesmenttest.model.DataBarang;

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
    public void getListDataSuccess(DataBarang data) {
        view.getListDataViewSuccess(data);
    }

    @Override
    public void getListDataFailed(String message) {
        view.getListDataViewFailed(message);
    }
}
