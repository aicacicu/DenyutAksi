package com.mycompany.denyutaksi;

public class RelawanFisik extends PartisipanAksi {
    private String divisiTugas;

    public RelawanFisik(int id, String nama, String namaProgram, String divisiTugas) {
        super(id, nama, namaProgram);
        this.divisiTugas = divisiTugas;
    }

    public String getDivisiTugas() {
        return this.divisiTugas;
    }

    @Override
    public String getDetailAksi() {
        return "Bertugas di lapangan pada divisi " + this.divisiTugas + ".";
    }
}