package com.mycompany.denyutaksi;

public class DonasiMateri extends PartisipanAksi {
    private int jumlahDonasi;

    public DonasiMateri(int id, String nama, String namaProgram, int jumlahDonasi) {
        super(id, nama, namaProgram);
        this.jumlahDonasi = jumlahDonasi;
    }

    public int getJumlahDonasi() {
        return this.jumlahDonasi;
    }

    @Override
    public String getDetailAksi() {
        return "Menyalurkan donasi dana sebesar Rp" + this.jumlahDonasi + ".";
    }
}