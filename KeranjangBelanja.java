public class KeranjangBelanja {
    Produk head;
    Produk tail;
    int size;

    public KeranjangBelanja() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void tambahKeKeranjang(NodeProduk produk) {
        Produk newProduk = new Produk(produk);
        if (head== null) {
            head = tail = newProduk;
        } else {
            tail.next = newProduk;
            newProduk.prev = tail;
            tail = newProduk;
        }
        size++;
    }

    public void hapusDariKeranjang(NodeProduk produk) {
        Produk current = head;
        while (current != null) {
            if (current.produk.id.equals(produk.id)) {
                if (current.prev != null) {
                    current.prev.next = current.prev;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                break;
            }
            current = current.next;
        }
    }
    
}

