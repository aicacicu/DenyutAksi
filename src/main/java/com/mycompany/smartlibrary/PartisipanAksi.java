package com.mycompany.smartlibrary;

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

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Validasi Gagal: Nama tidak boleh kosong!");
        }
    }

    public String getNamaProgram() {
        return this.namaProgram;
    }

    public void tampilkanProfil() {
        System.out.println("Data Partisipan Aksi Sosial");
    }
}