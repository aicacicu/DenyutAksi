package com.mycompany.denyutaksi;

public class DonasiBarang extends PartisipanAksi implements SertifikatRelawan {
    private String jenisBarang;
    private int jumlahBarang;

    public DonasiBarang(int id, String nama, String namaProgram, String jenisBarang, int jumlahBarang) {
        super(id, nama, namaProgram);
        this.jenisBarang = jenisBarang;
        this.jumlahBarang = jumlahBarang;
    }

    @Override
    public void caraPartisipasi() {
        System.out.println("    -> Aktivitas : Menyerahkan bantuan logistik berupa " + this.jumlahBarang + " " + this.jenisBarang + ".");
    }

    @Override
    public void hitungTargetAksi() {
        System.out.println("    -> Target Aksi: Pemeriksaan kelayakan dan penyortiran barang logistik.");
    }

    @Override
    public void cetakSertifikat() {
        System.out.println("    -> [Sertifikat] Piagam apresiasi donatur logistik diterbitkan untuk " + getNama() + ".");
    }
}