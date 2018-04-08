package id.rofiqof.assesmenttest.module.list_data;

import java.util.List;

import id.rofiqof.assesmenttest.model.DataBarang;

interface ListDataInterface {
    void getListData();
}

interface ListDataInput {
    void getListData();
}

interface ListDataOutput {
    void getListDataSuccess(List<DataBarang> data);
    void getListDataFailed(String message);
}
