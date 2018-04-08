package id.rofiqof.assesmenttest.module.list_data;

import id.rofiqof.assesmenttest.model.DataBarang;

interface ListDataInterface {
    void getListData();
}

interface ListDataInput {
    void getListData();
}

interface ListDataOutput {
    void getListDataSuccess(DataBarang data);
    void getListDataFailed(String message);
}
