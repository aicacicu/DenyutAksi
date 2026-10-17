package com.mycompany.denyutaksi;

public class RelawanFisik extends PartisipanAksi implements SertifikatRelawan, VerifikasiData {
    private String divisiTugas;

    public RelawanFisik(int id, String nama, String namaProgram, String divisiTugas) {
        super(id, nama, namaProgram);
        this.divisiTugas = divisiTugas;
    }

    public String getDivisiTugas() {
        return this.divisiTugas;
    }

    @Override
    public void caraPartisipasi() {
        System.out.println("    -> Aktivitas : Bertugas langsung di lapangan pada divisi " + this.divisiTugas + ".");
    }

    @Override
    public void hitungTargetAksi() {
        System.out.println("    -> Target Aksi: Menyelesaikan 8 jam shift kerja lapangan.");
    }

    @Override
    public void cetakSertifikat() {
        System.out.println("    -> [Sertifikat] E-Sertifikat Relawan diterbitkan untuk " + getNama() + ".");
    }

    @Override
    public void verifikasiBerkas() {
        System.out.println("    -> [Verifikasi] Berkas pendaftaran dan identitas relawan telah divalidasi.");
    }
}