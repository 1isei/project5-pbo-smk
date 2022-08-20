package project;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */

class Produk {
    private String[] nama_produk = {};
    private int[] stok_produk = {} , harga_satuan_produk = {} , harga_produk = {}; 
    private int total_harga;
    
    Produk(){
        this.inputProduk();
        this.output();
    }
    
    // Static method    
    public static String[] append(String[] array, String el) {
       array = Arrays.copyOf(array, array.length + 1);
       array[array.length - 1] = el;
       return array;
    }
    
    public static int[] append(int[] array, int el) {
       array = Arrays.copyOf(array, array.length + 1);
       array[array.length - 1] = el;
       return array;
    }
    
    public static String getRupiahWithRP(int price) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(price);
    }
    
    // Setter    
    public void setNamaProduk(String nama) {
        this.nama_produk = append(this.nama_produk, nama);
    }
    
    public void setStokProduk(int stok) {
        this.stok_produk = append(this.stok_produk, stok);
    }
    
    public void setHargaSatuanProduk(int harga_satuan) {
        this.harga_satuan_produk = append(this.harga_satuan_produk, harga_satuan);
    }
    
    public void setHargaProduk(int stok , int harga_satuan) {
        this.harga_produk = append(this.harga_produk, stok * harga_satuan);
    }
    
    public void setTotalHarga(int harga) {
        this.total_harga += harga;
    }
    
    // Getter    
    public String[] getNamaProduk() {
        return this.nama_produk;
    }
    
    public int getStokProduk(int i) {
        return this.stok_produk[i];
    }
    
    public int getHargaSatuanProduk(int i) {
        return this.harga_satuan_produk[i];
    }
    
    public int getHargaProduk(int i) {
        return this.harga_produk[i];
    }
    
    public int getTotalHarga() {
        return this.total_harga;
    }
    
    private void inputProduk() {
        Scanner scan = new Scanner(System.in);
        char lagi;
        int index = 0;
        
        System.out.println("\n\n---------- Input Produk Yang Akan Anda Jual ----------");
        do {
        System.out.println("======================================================");
        System.out.print("Masukkan nama produk = ");
        this.setNamaProduk(scan.next());
        System.out.print("Masukkan stok produk = ");
        this.setStokProduk(scan.nextInt());
        System.out.print("Masukkan harga satuan produk = ");
        this.setHargaSatuanProduk(scan.nextInt());
        
        this.setHargaProduk(this.getStokProduk(index), this.getHargaSatuanProduk(index));
        this.setTotalHarga(this.getHargaProduk(index));
        System.out.print("\nInput Produk Lagi? ( y/n ) = ");
        lagi = scan.next().charAt(0);
        index++;
        } while(lagi == 'y');
    }
    
    private void output() {
        System.out.println("\nDaftar Produk Anda");
        System.out.println("===================");
        int i = 1;
        for(String nama :  this.getNamaProduk()) {
            System.out.println(i + ". " + nama + 
                    "(" + getRupiahWithRP(this.getHargaSatuanProduk(i -1)) + " x " + this.getStokProduk(i -1) +  " buah) = " + 
                     getRupiahWithRP(this.getHargaProduk(i - 1)));
            i++;
        }
        System.out.println("======================================================");
        System.out.println("Total uang hasil penjualan semua produk : " + getRupiahWithRP(this.getTotalHarga()) + "\n\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Produk produk = new Produk();
    }
}
