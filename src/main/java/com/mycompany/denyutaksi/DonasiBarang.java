package com.mycompany.denyutaksi;

public class DonasiBarang extends PartisipanAksi {
    private String jenisBarang;
    private int jumlahBarang;

    public DonasiBarang(int id, String nama, String namaProgram, String jenisBarang, int jumlahBarang) {
        super(id, nama, namaProgram);
        this.jenisBarang = jenisBarang;
        this.jumlahBarang = jumlahBarang;
    }

    @Override
    public String getDetailAksi() {
        return "Menyerahkan bantuan logistik berupa " + this.jumlahBarang + " " + this.jenisBarang + ".";
    }
}