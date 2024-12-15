//implementasi tree untuk kategori dan sub kategori produk.

class KategoriNode {
    String nama;
    KategoriNode subKategoriPertama;
    KategoriNode nextKategori;
    product firstProduct;

    public KategoriNode(String nama) {
        this.nama = nama;
        this.subKategoriPertama = null;
        this.nextKategori = null;
        this.firstProduct = null;
    }

    public void addProduct(product product) {
        if (firstProduct == null) {
            firstProduct = product;
        } else {
            product current = firstProduct;
            while (current.nextproduct != null) {
                current = current.nextproduct;
            }
            current.nextproduct = product;
        }
    }
}
