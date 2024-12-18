public class Produk{
    NodeProduk produk;
    Produk next;
    Produk prev;

    public Produk(NodeProduk produk) {
        this.produk = produk;
        this.next = null;
        this.prev = null;
    }
}
