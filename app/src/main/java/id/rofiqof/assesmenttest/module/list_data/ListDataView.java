package id.rofiqof.assesmenttest.module.list_data;

import java.util.List;

import id.rofiqof.assesmenttest.model.DataBarang;

public interface ListDataView {
    void getListDataViewSuccess(List<DataBarang> data);
    void getListDataViewFailed(String message);
}
