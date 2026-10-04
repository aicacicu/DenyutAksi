package com.mycompany.smartlibrary;

public class RelawanFisik extends PartisipanAksi {
    
    private String divisiTugas;

    public RelawanFisik(int id, String nama, String namaProgram, String divisiTugas) {
        super(id, nama, namaProgram);
        this.divisiTugas = divisiTugas;
    }

    public String getDivisiTugas() {
        return this.divisiTugas;
    }

    public void setDivisiTugas(String divisiTugas) {
        this.divisiTugas = divisiTugas;
    }

    @Override
    public void tampilkanProfil() {
        String detail = "Relawan: " + this.divisiTugas;
        System.out.printf("| %-4d | %-15.15s | %-22.22s | %-37s |\n", 
                          getId(), getNama(), getNamaProgram(), detail);
    }
}