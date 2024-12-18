public class NodeProduk {
    String id;
    String nama;
    double harga;
    String kategori;
    String ukuran;
    String warna;
    NodeProduk nextProduk; 

    public NodeProduk(String id, String nama, double harga, String kategori, String ukuran, String warna) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.ukuran = ukuran;
        this.warna = warna;
        this.nextProduk = null;
    }
}