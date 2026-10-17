package com.mycompany.denyutaksi;

public class PartisipanAksi {
    private int id;
    private String nama;
    private String namaProgram;
    public static int totalPartisipan = 0;

    public PartisipanAksi(int id, String nama, String namaProgram) {
        this.id = id;
        this.nama = nama;
        this.namaProgram = namaProgram;
        totalPartisipan++;
    }

    public int getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public String getNamaProgram() {
        return this.namaProgram;
    }

    public String getDetailAksi() {
        return "Mengikuti program aksi sosial.";
    }
}