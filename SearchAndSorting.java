public class SearchAndSorting {
    //Searching
    public static NodeProduk cariProdukBerdasarkanNama(NodeProduk produkPertama, String nama) {
        NodeProduk produk = produkPertama;
        while (produk != null) {
            if (produk.nama.toLowerCase().contains(nama.toLowerCase())) {
                return produk;
            }
            produk = produk.nextProduk;
        }
        return null;
    }

    public static NodeProduk cariProdukBerdasarkanUkuran(NodeProduk produkPertama, String ukuran) {
        NodeProduk produk = produkPertama;
        while (produk != null) {
            if (produk.ukuran.equalsIgnoreCase(ukuran)) {
                return produk;
            }
            produk = produk.nextProduk;
        }
        return null;
    }

    //Sorting
    public static NodeProduk urutkanBerdasarkanHarga(NodeProduk produkPertama, boolean naikkan) {
        NodeProduk hasilUrut = null;
        NodeProduk produk = produkPertama;

        while (produk != null) {
            NodeProduk produkSelanjutnya = produk.nextProduk;
            
            if (hasilUrut == null || 
                (naikkan && produk.harga < hasilUrut.harga) || 
                (!naikkan && produk.harga > hasilUrut.harga)) {
                produk.nextProduk = hasilUrut;
                hasilUrut = produk;
            } else {
                NodeProduk pencarianPtr = hasilUrut;
                while (pencarianPtr.nextProduk != null && 
                       ((naikkan && pencarianPtr.nextProduk.harga < produk.harga) || 
                        (!naikkan && pencarianPtr.nextProduk.harga > produk.harga))) {
                    pencarianPtr = pencarianPtr.nextProduk;
                }
                produk.nextProduk = pencarianPtr.nextProduk;
                pencarianPtr.nextProduk = produk;
            }
            
            produk = produkSelanjutnya;
        }

        return hasilUrut;
    }

}
