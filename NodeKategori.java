public class NodeKategori {
    String nama;
    NodeKategori subKategoriPertama;
    NodeKategori nextKategori;
    NodeProduk produkPertama;

    public NodeKategori(String nama) {
        this.nama = nama;
        this.subKategoriPertama = null;
        this.nextKategori = null;
        this.produkPertama = null;
    }

    public void tambahSubKategori(NodeKategori subKategori) {
        if (subKategoriPertama == null) {
            subKategoriPertama = subKategori;
        } else {
            NodeKategori current = subKategoriPertama;
            while (current.nextKategori != null) {
                current = current.nextKategori;
            }
            current.nextKategori = subKategori;
        }
    }

    public void tambahProduk(NodeProduk produk) {
        if (produkPertama == null) {
            produkPertama = produk;
        } else {
            NodeProduk current = produkPertama;
            while (current.nextProduk != null) {
                current = current.nextProduk;
            }
            current.nextProduk = produk;
        }
    }
}

