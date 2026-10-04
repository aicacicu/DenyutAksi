package com.mycompany.smartlibrary;

import java.util.Scanner;

public class DenyutAksiApp {
    
    public static void cariData(int idCari, PartisipanAksi[] daftar, int jumlah) {
        boolean ketemu = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getId() == idCari) {
                daftar[i].tampilkanProfil();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Partisipan dengan ID " + idCari + " tidak ditemukan.");
        }
    }

    public static void cariData(String namaCari, PartisipanAksi[] daftar, int jumlah) {
        boolean ketemu = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().toLowerCase().contains(namaCari.toLowerCase())) {
                daftar[i].tampilkanProfil();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Partisipan dengan kata kunci '" + namaCari + "' tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PartisipanAksi[] daftarPartisipan = new PartisipanAksi[50];
        int jumlahData = 0;

        daftarPartisipan[jumlahData++] = new RelawanFisik(101, "Aisyah", "Cek Kesehatan Warga", "Tim Lapangan");
        daftarPartisipan[jumlahData++] = new DonasiMateri(102, "Arsel", "Bantuan Panti Asuhan", 500000);
        daftarPartisipan[jumlahData++] = new RelawanFisik(103, "Nad", "Pembagian Sembako", "Logistik & Perlengkapan");

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== PLATFORM DENYUT AKSI ===");
            System.out.println("1. Tambah Data Partisipan");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Cari Data Partisipan");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            
            if (!input.hasNextInt()) {
                System.out.println("Peringatan: Harap masukkan angka (1-4)!");
                input.next(); 
                continue;
            }
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahData < daftarPartisipan.length) {
                        System.out.println("\n-- Pilih Jenis Partisipasi --");
                        System.out.println("1. Relawan Turun Lapangan");
                        System.out.println("2. Donatur Dana");
                        System.out.print("Pilihan (1/2): ");
                        
                        if (!input.hasNextInt()) {
                            System.out.println("Pendaftaran Gagal: Pilihan harus berupa angka 1 atau 2!");
                            input.next();
                            break;
                        }
                        int jenis = input.nextInt();
                        input.nextLine();

                        if (jenis != 1 && jenis != 2) {
                            System.out.println("Pendaftaran Gagal: Pilihan tidak valid! Harap masukkan angka 1 atau 2.");
                            break;
                        }

                        System.out.print("Masukkan ID (Angka): ");
                        if (!input.hasNextInt()) {
                            System.out.println("Pendaftaran Gagal: ID wajib berupa angka!");
                            input.next();
                            break;
                        }
                        int idBaru = input.nextInt();
                        input.nextLine();

                        boolean idKembar = false;
                        for (int i = 0; i < jumlahData; i++) {
                            if (daftarPartisipan[i].getId() == idBaru) {
                                idKembar = true;
                                break;
                            }
                        }

                        if (idKembar) {
                            System.out.println("Pendaftaran Gagal: ID " + idBaru + " sudah digunakan! Silakan ulangi dengan ID lain.");
                            break;
                        }
                        
                        System.out.print("Masukkan Nama: ");
                        String namaBaru = input.nextLine();
                        if (namaBaru.trim().isEmpty()) {
                            System.out.println("Pendaftaran Gagal: Nama tidak boleh kosong!");
                            break;
                        }
                        
                        System.out.println("\n-- Pilih Program Aksi --");
                        System.out.println("1. Cek Kesehatan Warga");
                        System.out.println("2. Bantuan Panti Asuhan");
                        System.out.println("3. Pembagian Sembako");
                        System.out.print("Pilih Program (1-3): ");
                        
                        if (!input.hasNextInt()) {
                            System.out.println("Pendaftaran Gagal: Pilihan program harus berupa angka!");
                            input.next();
                            break;
                        }
                        int pilProgram = input.nextInt();
                        input.nextLine();
                        
                        String programBaru;
                        if (pilProgram == 1) {
                            programBaru = "Cek Kesehatan Warga";
                        } else if (pilProgram == 2) {
                            programBaru = "Bantuan Panti Asuhan";
                        } else if (pilProgram == 3) {
                            programBaru = "Pembagian Sembako";
                        } else {
                            programBaru = "Pembagian Sembako"; 
                        }

                        if (jenis == 1) {
                            System.out.println("\n-- Pilih Divisi Tugas --");
                            System.out.println("1. Tim Lapangan");
                            System.out.println("2. Logistik & Perlengkapan");
                            System.out.println("3. Dokumentasi & Publikasi");
                            System.out.println("4. Administrasi & Pendataan");
                            System.out.print("Pilih Divisi (1-4): ");
                            
                            if (!input.hasNextInt()) {
                                System.out.println("Pendaftaran Gagal: Pilihan divisi harus berupa angka!");
                                input.next();
                                break;
                            }
                            int pilDivisi = input.nextInt();
                            input.nextLine();
                            
                            String divisi;
                            if (pilDivisi == 1) {
                                divisi = "Tim Lapangan";
                            } else if (pilDivisi == 2) {
                                divisi = "Logistik & Perlengkapan";
                            } else if (pilDivisi == 3) {
                                divisi = "Dokumentasi & Publikasi";
                            } else {
                                divisi = "Administrasi & Pendataan";
                            }

                            daftarPartisipan[jumlahData] = new RelawanFisik(idBaru, namaBaru, programBaru, divisi);
                            jumlahData++;
                            System.out.println("\nSukses! Relawan berhasil ditambahkan.");
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Nominal Donasi: Rp ");
                            
                            if (!input.hasNextInt()) {
                                System.out.println("Pendaftaran Gagal: Nominal donasi harus berupa angka!");
                                input.next();
                                break;
                            }
                            int dana = input.nextInt();
                            input.nextLine();

                            if (dana <= 0) {
                                System.out.println("Pendaftaran Gagal: Nominal donasi harus lebih dari 0!");
                                break;
                            }
                            
                            daftarPartisipan[jumlahData] = new DonasiMateri(idBaru, namaBaru, programBaru, dana);
                            jumlahData++;
                            System.out.println("\nSukses! Donatur berhasil ditambahkan.");
                        }
                    } else {
                        System.out.println("Maaf, kapasitas penyimpanan penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n-------------------------------------------------------------------------------------------");
                    System.out.printf("| %-4s | %-15s | %-22s | %-37s |\n", "ID", "NAMA", "PROGRAM AKSI", "DETAIL PERAN");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    if (jumlahData == 0) {
                        System.out.println("Belum ada data partisipan.");
                    } else {
                        for (int i = 0; i < jumlahData; i++) {
                            daftarPartisipan[i].tampilkanProfil();
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("Total Terdaftar di Sistem: " + PartisipanAksi.totalPartisipan + " orang.");
                    break;

                case 3:
                    System.out.println("\n-- Fitur Cari Data --");
                    System.out.println("1. Cari berdasarkan ID (Angka)");
                    System.out.println("2. Cari berdasarkan Nama (Teks)");
                    System.out.print("Pilih opsi (1/2): ");
                    
                    if (!input.hasNextInt()) {
                        System.out.println("Pilihan mode cari tidak valid!");
                        input.next();
                        break;
                    }
                    int modeCari = input.nextInt();
                    input.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan ID Partisipan: ");
                        if (!input.hasNextInt()) {
                            System.out.println("ID yang dicari harus berupa angka!");
                            input.next();
                            break;
                        }
                        int idCari = input.nextInt();
                        input.nextLine();
                        cariData(idCari, daftarPartisipan, jumlahData);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Nama Partisipan: ");
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
                    System.out.println("Pilihan tidak tersedia. Silakan masukkan angka 1-4.");
                    break;
            }
        }
        input.close();
    }
}
