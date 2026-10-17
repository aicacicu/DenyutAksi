package com.mycompany.denyutaksi;

public abstract class PartisipanAksi {
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

    public void tampilkanInfo() {
        System.out.printf("ID : %-4d | Nama : %-15s | Program : %s\n", 
            this.id, this.nama, this.namaProgram);
    }

    public void caraPartisipasi() {
        System.out.println("    -> Mengikuti program aksi sosial secara umum.");
    }

    public abstract void hitungTargetAksi();
}