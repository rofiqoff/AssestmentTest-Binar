package id.rofiqof.assesmenttest.module.list_data;

import id.rofiqof.assesmenttest.model.DataBarang;

public interface ListDataView {
    void getListDataViewSuccess(DataBarang data);
    void getListDataViewFailed(String message);
}
