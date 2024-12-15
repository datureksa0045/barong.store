import java.util.Scanner;
class Barang {
    String namaBarang;
    int jumlahBarang;
}

public class Main {
    public static void main(String[] args) {
        Barang listBarang = new Barang();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== BARONG STORE ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. tampilkan semua barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Harap masukkan angka yang valid: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String newItem = scanner.nextLine();
                    break;

                case 2:
                    listBarang.displaySemuaBarang();
                    break;

                case 3:
                  System.out.print("Masukkan nama barang yang ingin dihapus: ");
                    String removeItem = scanner.nextLine();
                    listBarang.remove(removeItem);
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan Toko Online!");
                    break;

                default:
                    System.out.println("Opsi tidak valid! Harap pilih antara 1-4.");
            }
        } while (choice !=4);

        scanner.close();
    }
}
