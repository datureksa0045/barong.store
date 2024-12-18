import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodeKategori kategoriUtama = null;
        KeranjangBelanja keranjang = new KeranjangBelanja();
        AntrianPengiriman antrianPengiriman = new AntrianPengiriman();

        while (true) {
            System.out.println("\n=== Barong Store : Sistem Terpadu Penjualan Baju Online ===");
            System.out.println("1. Tambah Kategori");
            System.out.println("2. Tambah Produk ke Kategori");
            System.out.println("3. Tampilkan Semua Kategori dan Produk");
            System.out.println("4. Tambah Produk ke Keranjang");
            System.out.println("5. Hapus Produk dari Keranjang");
            System.out.println("6. Buat Pesanan");
            System.out.println("7. Proses Antrian Pengiriman");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nama kategori: ");
                    String namaKategori = scanner.nextLine();
                    NodeKategori kategoriBaru = new NodeKategori(namaKategori);
                    if (kategoriUtama == null) {
                        kategoriUtama = kategoriBaru;
                    } else {
                        NodeKategori current = kategoriUtama;
                        while (current.nextKategori != null) {
                            current = current.nextKategori;
                        }
                        current.nextKategori = kategoriBaru;
                    }
                    System.out.println("Kategori berhasil ditambahkan!");
                    break;

                case 2:
                    if (kategoriUtama == null) {
                        System.out.println("Belum ada kategori. Tambahkan kategori terlebih dahulu!");
                        break;
                    }
                    System.out.print("Masukkan nama kategori untuk menambahkan produk: ");
                    String kategoriTujuan = scanner.nextLine();
                    NodeKategori targetKategori = kategoriUtama;
                    while (targetKategori != null && !targetKategori.nama.equalsIgnoreCase(kategoriTujuan)) {
                        targetKategori = targetKategori.nextKategori;
                    }
                    if (targetKategori == null) {
                        System.out.println("Kategori tidak ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan ID produk: ");
                    String idProduk = scanner.nextLine();
                    System.out.print("Masukkan nama produk: ");
                    String namaProduk = scanner.nextLine();
                    System.out.print("Masukkan harga produk: ");
                    double hargaProduk = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Masukkan kategori produk (e.g., Pria, Wanita): ");
                    String kategoriProduk = scanner.nextLine();
                    System.out.print("Masukkan ukuran produk: ");
                    String ukuranProduk = scanner.nextLine();
                    System.out.print("Masukkan warna produk: ");
                    String warnaProduk = scanner.nextLine();

                    NodeProduk produkBaru = new NodeProduk(idProduk, namaProduk, hargaProduk, kategoriProduk, ukuranProduk, warnaProduk);
                    targetKategori.tambahProduk(produkBaru);
                    System.out.println("Produk berhasil ditambahkan ke kategori " + kategoriTujuan);
                    break;

                case 3:
                    if (kategoriUtama == null) {
                        System.out.println("Belum ada kategori untuk ditampilkan.");
                        break;
                    }
                    NodeKategori currentKategori = kategoriUtama;
                    while (currentKategori != null) {
                        System.out.println("Kategori: " + currentKategori.nama);
                        NodeProduk currentProduk = currentKategori.produkPertama;
                        while (currentProduk != null) {
                            System.out.println("  - [" + currentProduk.id + "] " + currentProduk.nama + ", Harga: " + currentProduk.harga + ", Ukuran: " + currentProduk.ukuran + ", Warna: " + currentProduk.warna);
                            currentProduk = currentProduk.nextProduk;
                        }
                        currentKategori = currentKategori.nextKategori;
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID produk yang ingin ditambahkan ke keranjang: ");
                    String idCariKeranjang = scanner.nextLine();
                    NodeProduk produkDitemukan = null;
                    NodeKategori kategoriCari = kategoriUtama;
                    while (kategoriCari != null && produkDitemukan == null) {
                        produkDitemukan = SearchAndSorting.cariProdukBerdasarkanNama(kategoriCari.produkPertama, idCariKeranjang);
                        kategoriCari = kategoriCari.nextKategori;
                    }
                    if (produkDitemukan != null) {
                        keranjang.tambahKeKeranjang(produkDitemukan);
                        System.out.println("Produk berhasil ditambahkan ke keranjang!");
                    } else {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.print("Masukkan ID produk yang ingin dihapus dari keranjang: ");
                    String idHapusKeranjang = scanner.nextLine();
                    NodeProduk produkHapus = new NodeProduk(idHapusKeranjang, "", 0, "", "", "");
                    keranjang.hapusDariKeranjang(produkHapus);
                    System.out.println("Produk berhasil dihapus dari keranjang (jika ditemukan)!");
                    break;

                case 6:
                    System.out.print("Masukkan ID Pesanan: ");
                    String idPesanan = scanner.nextLine();
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    Pesanan pesananBaru = new Pesanan(idPesanan, namaPelanggan);
                    Produk currentProdukKeranjang = keranjang.head;
                    while (currentProdukKeranjang != null) {
                        pesananBaru.tambahProduk(currentProdukKeranjang.produk);
                        currentProdukKeranjang = currentProdukKeranjang.next;
                    }
                    antrianPengiriman.tambahAntrian(pesananBaru);
                    System.out.println("Pesanan berhasil dibuat dan dimasukkan ke antrian pengiriman!");
                    break;

                case 7:
                    Pesanan pesananDiproses = antrianPengiriman.keluarAntrian();
                    if (pesananDiproses == null) {
                        System.out.println("Tidak ada pesanan dalam antrian.");
                    } else {
                        System.out.println("Pesanan dengan ID " + pesananDiproses.IdPesanan + " untuk " + pesananDiproses.namaPelanggan + " sedang diproses.");
                    }
                    break;

                case 8:
                    System.out.println("Terima kasih telah menggunakan ParadaStore!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
