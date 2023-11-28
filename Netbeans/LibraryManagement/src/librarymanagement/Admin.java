/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author user
 */
public class Admin {
    private String id;
    private String nama;
    private ArrayList<Buku> daftarBuku;
    private ArrayList<AnggotaPerpustakaan> daftarAnggota;

    public Admin(String nama, ArrayList<Buku> daftarBuku, ArrayList<AnggotaPerpustakaan> daftarAnggota) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.daftarBuku = daftarBuku;
        this.daftarAnggota = daftarAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public void setDaftarBuku(ArrayList<Buku> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public ArrayList<AnggotaPerpustakaan> getDaftarAnggota() {
        return daftarAnggota;
    }

    public void setDaftarAnggota(ArrayList<AnggotaPerpustakaan> daftarAnggota) {
        this.daftarAnggota = daftarAnggota;
    }
    
    public void addBook(Buku buku) {
        daftarBuku.add(buku);
    }
    
    public void removeBook(Buku buku) {
        daftarBuku.remove(buku);
    }

    public void addMember(AnggotaPerpustakaan newMember) {
        daftarAnggota.add(newMember);
    }
    
    public void removeMember(AnggotaPerpustakaan member) {
        daftarAnggota.remove(member);
    }
}
