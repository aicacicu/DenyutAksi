package com.mycompany.smartlibrary;

public class DonasiMateri extends PartisipanAksi {
    
    private int jumlahDonasi;

    public DonasiMateri(int id, String nama, String namaProgram, int jumlahDonasi) {
        super(id, nama, namaProgram);
        this.jumlahDonasi = jumlahDonasi;
    }

    public int getJumlahDonasi() {
        return this.jumlahDonasi;
    }

    public void setJumlahDonasi(int jumlahDonasi) {
        if (jumlahDonasi > 0) {
            this.jumlahDonasi = jumlahDonasi;
        }
    }

    @Override
    public void tampilkanProfil() {
        String detail = "Donasi : Rp" + this.jumlahDonasi;
        System.out.printf("| %-4d | %-15.15s | %-22.22s | %-37s |\n", 
                          getId(), getNama(), getNamaProgram(), detail);
    }
}