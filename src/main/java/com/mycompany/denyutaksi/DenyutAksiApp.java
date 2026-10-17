package com.mycompany.denyutaksi;

import java.util.Scanner;

public class DenyutAksiApp {
    
    public static void cariData(int idCari, PartisipanAksi[] daftar, int jumlah) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan ID: " + idCari + " ---");
        boolean ketemu = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getId() == idCari) {
                System.out.printf("  [Ditemukan] ID: %-4d | Nama: %-15s | Program: %-22s\n", 
                    daftar[i].getId(), daftar[i].getNama(), daftar[i].getNamaProgram());
                System.out.println("              Keterangan: " + daftar[i].getDetailAksi());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("  Partisipan dengan ID " + idCari + " tidak ditemukan.");
        }
    }

    public static void cariData(String namaCari, PartisipanAksi[] daftar, int jumlah) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Nama: '" + namaCari + "' ---");
        boolean ketemu = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().toLowerCase().contains(namaCari.toLowerCase())) {
                System.out.printf("  [Ditemukan] ID: %-4d | Nama: %-15s | Program: %-22s\n", 
                    daftar[i].getId(), daftar[i].getNama(), daftar[i].getNamaProgram());
                System.out.println("              Keterangan: " + daftar[i].getDetailAksi());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("  Partisipan dengan kata kunci '" + namaCari + "' tidak ditemukan.");
        }
    }

    public static void simulasiAksi(PartisipanAksi item) {
        System.out.println("    -> Aktivitas : " + item.getDetailAksi());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PartisipanAksi[] daftarPartisipan = new PartisipanAksi[50];
        int jumlahData = 0;

        daftarPartisipan[jumlahData++] = new RelawanFisik(101, "Aisyah", "Cek Kesehatan Warga", "Tim Lapangan");
        daftarPartisipan[jumlahData++] = new DonasiMateri(102, "Arsel", "Bantuan Panti Asuhan", 500000);
        daftarPartisipan[jumlahData++] = new DonasiBarang(103, "Nad", "Pembagian Sembako", "Paket Sembako", 50);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n==========================================");
            System.out.println("          PLATFORM DENYUT AKSI            ");
            System.out.println("==========================================");
            System.out.println("1. Tambah Data Partisipan");
            System.out.println("2. Tampilkan Daftar Partisipan");
            System.out.println("3. Cari Data Partisipan");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");
            
            if (!input.hasNextInt()) {
                System.out.println("Peringatan: Harap masukkan angka 1 sampai 4!");
                input.next(); 
                continue;
            }
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahData < daftarPartisipan.length) {
                        System.out.println("\n--- Pilihlah Jenis Partisipasi ---");
                        System.out.println("1. Relawan Fisik");
                        System.out.println("2. Donatur Materi (Dana)");
                        System.out.println("3. Donatur Barang (Logistik)");
                        System.out.print("Pilihan (1-3): ");
                        
                        if (!input.hasNextInt()) {
                            System.out.println("Pendaftaran Gagal: Pilihan harus berupa angka!");
                            input.next();
                            break;
                        }
                        int jenis = input.nextInt();
                        input.nextLine();

                        if (jenis < 1 || jenis > 3) {
                            System.out.println("Pendaftaran Gagal: Pilihan tidak valid!");
                            break;
                        }

                        System.out.print("Masukkan ID Partisipan: ");
                        if (!input.hasNextInt()) {
                            System.out.println("Pendaftaran Gagal: ID wajib berupa angka!");
                            input.next();
                            break;
                        }
                        int idBaru = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan Nama Lengkap: ");
                        String namaBaru = input.nextLine();
                        if (namaBaru.trim().isEmpty()) {
                            System.out.println("Pendaftaran Gagal: Nama tidak boleh kosong!");
                            break;
                        }
                        
                        System.out.print("Masukkan Nama Program Aksi: ");
                        String programBaru = input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Divisi Tugas: ");
                            String divisi = input.nextLine();
                            daftarPartisipan[jumlahData] = new RelawanFisik(idBaru, namaBaru, programBaru, divisi);
                            jumlahData++;
                            System.out.println("\nSukses: Data Relawan Fisik berhasil ditambahkan.");
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Nominal Donasi (Rp): ");
                            int dana = input.nextInt();
                            input.nextLine();
                            daftarPartisipan[jumlahData] = new DonasiMateri(idBaru, namaBaru, programBaru, dana);
                            jumlahData++;
                            System.out.println("\nSukses: Data Donatur Materi berhasil ditambahkan.");
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Jenis Barang: ");
                            String jBarang = input.nextLine();
                            System.out.print("Masukkan Jumlah Barang: ");
                            int jmlBarang = input.nextInt();
                            input.nextLine();
                            daftarPartisipan[jumlahData] = new DonasiBarang(idBaru, namaBaru, programBaru, jBarang, jmlBarang);
                            jumlahData++;
                            System.out.println("\nSukses: Data Donatur Barang berhasil ditambahkan.");
                        }
                    } else {
                        System.out.println("Maaf, kapasitas penyimpanan data sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n==================================================================================");
                    System.out.println("                          DAFTAR SELURUH PARTISIPAN                               ");
                    System.out.println("==================================================================================");
                    if (jumlahData == 0) {
                        System.out.println(" Belum ada data partisipan yang terdaftar.");
                    } else {
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.printf(" [%d] ID : %-4d | Nama : %-15s | Program : %s\n", 
                                (i + 1), daftarPartisipan[i].getId(), daftarPartisipan[i].getNama(), daftarPartisipan[i].getNamaProgram());
                            simulasiAksi(daftarPartisipan[i]);
                            System.out.println("----------------------------------------------------------------------------------");
                        }
                    }
                    System.out.println("Total Partisipan Terdaftar: " + PartisipanAksi.totalPartisipan + " orang.");
                    break;

                case 3:
                    System.out.println("\n--- Menu Pencarian Data Partisipan ---");
                    System.out.println("1. Cari Berdasarkan ID");
                    System.out.println("2. Cari Berdasarkan Nama");
                    System.out.print("Pilih Opsi (1-2): ");
                    
                    if (!input.hasNextInt()) {
                        System.out.println("Pilihan tidak valid!");
                        input.next();
                        break;
                    }
                    int modeCari = input.nextInt();
                    input.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan ID yang dicari: ");
                        int idCari = input.nextInt();
                        input.nextLine();
                        cariData(idCari, daftarPartisipan, jumlahData);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Nama yang dicari: ");
                        String namaCari = input.nextLine();
                        cariData(namaCari, daftarPartisipan, jumlahData);
                    } else {
                        System.out.println("Pilihan opsi cari tidak tersedia.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan Platform Denyut Aksi!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia. Silakan masukkan angka 1 sampai 4.");
                    break;
            }
        }
        input.close();
    }
}