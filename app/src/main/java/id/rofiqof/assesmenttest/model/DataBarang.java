package id.rofiqof.assesmenttest.model;

public class DataBarang {
    private String Nama;
    private String Jumlah;
    private String Pemasok;
    private String Tanggal;

    public DataBarang() {
    }

    public DataBarang(String nama, String jumlah, String pemasok, String tanggal) {
        Nama = nama;
        Jumlah = jumlah;
        Pemasok = pemasok;
        Tanggal = tanggal;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public String getPemasok() {
        return Pemasok;
    }

    public void setPemasok(String pemasok) {
        Pemasok = pemasok;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }
}
