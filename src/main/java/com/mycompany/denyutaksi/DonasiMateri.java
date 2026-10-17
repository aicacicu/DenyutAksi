package com.mycompany.denyutaksi;

public class DonasiMateri extends PartisipanAksi implements VerifikasiData {
    private int jumlahDonasi;

    public DonasiMateri(int id, String nama, String namaProgram, int jumlahDonasi) {
        super(id, nama, namaProgram);
        this.jumlahDonasi = jumlahDonasi;
    }

    public int getJumlahDonasi() {
        return this.jumlahDonasi;
    }

    @Override
    public void caraPartisipasi() {
        System.out.println("    -> Aktivitas : Menyalurkan donasi dana finansial sebesar Rp" + this.jumlahDonasi + ".");
    }

    @Override
    public void hitungTargetAksi() {
        System.out.println("    -> Target Aksi: Validasi pencairan dana bantuan 100% tersalurkan.");
    }

    @Override
    public void verifikasiBerkas() {
        System.out.println("    -> [Verifikasi] Bukti transfer/pembayaran donasi dana telah diverifikasi.");
    }
}