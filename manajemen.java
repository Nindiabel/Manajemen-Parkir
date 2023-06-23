import java.util.Scanner;

public class manajemen {
   private static final int KAPASITAS_PARKIR = 10;
   // array untuk menanmpung daftar parkir kendaraan
   private static String[] daftarKendaraan = new String[KAPASITAS_PARKIR];
   // input scanner
   static Scanner input = new Scanner(System.in);
   // variable untuk menampumg jumlahkendaraan yang terparkir
   private static int jumlahKendaraan = 0;

   public static void main(String[] args) {
      int pilihan;

      // looping while agar trus berulang
      boolean ulang = true;
      while (ulang) {
         System.out.println("===== Aplikasi Manajemen Parkir =====");
         System.out.println("1. Tambah Kendaraan");
         System.out.println("2. Keluarkan Kendaraan");
         System.out.println("3. Cari Kendaraan");
         System.out.println("4. Lihat Status Parkir");
         System.out.println("5. Keluar");
         System.out.print("Masukkan pilihan Anda: ");
         pilihan = input.nextInt();
         // pengkondisian menggunakan switch
         switch (pilihan) {
            case 1:
               tambahKendaraan();
               break;
            case 2:
               keluarkanKendaraan();
               break;
            case 3:
               cariKendaraan(daftarKendaraan);
               break;
            case 4:
               lihatStatusParkir();
               break;
            case 5:
               System.out.println("Terima kasih telah menggunakan aplikasi ini. Sampai jumpa!");
               ulang = false;
               break;
            default:
               System.out.println("Pilihan tidak valid. Silakan masukkan pilihan yang benar.");
               break;
         }
         System.out.println();
      }

   }

   // method tambah kendaraan
   private static void tambahKendaraan() {
      Scanner input = new Scanner(System.in);

      if (jumlahKendaraan < KAPASITAS_PARKIR) {
         System.out.print("Masukkan jenis kendaraan: ");
         String jenisKendaraan = input.nextLine();
         System.out.print("Masukkan No Parkir: 0 - " + KAPASITAS_PARKIR + " ");
         int noParkir = input.nextInt();
         if (daftarKendaraan[noParkir] == null) {
            daftarKendaraan[noParkir] = jenisKendaraan;
            jumlahKendaraan++;
            System.out.println("Kendaraan berhasil ditambahkan.");
         } else {
            System.out.println("No parkir tersebut sudah diisi");
         }
      } else {
         System.out.println("Parkir penuh. Maaf, tidak dapat menambahkan kendaraan baru.");
      }
   }

   // method keluarkan kendaraan
   private static void keluarkanKendaraan() {
      Scanner input = new Scanner(System.in);

      if (jumlahKendaraan > 0) {
         System.out
               .print("Masukkan nomor parkir kendaraan yang akan dikeluarkan ");
         int nomorParkir = input.nextInt();

         if (nomorParkir >= 0 && nomorParkir < KAPASITAS_PARKIR) {
            if (daftarKendaraan[nomorParkir] != null) {
               System.out.println("Kendaraan dengan nomor parkir " + nomorParkir + " (" + daftarKendaraan[nomorParkir]
                     + ") telah dikeluarkan.");
               daftarKendaraan[nomorParkir] = null;
               jumlahKendaraan--;
            } else {
               System.out.println("Nomor parkir masih kosong");
            }
         } else {
            System.out.println("Nomor parkir tidak valid.");
         }
      } else {
         System.out.println("Tidak ada kendaraan yang terparkir saat ini.");
      }
   }

   // method lihat status parkir
   private static void lihatStatusParkir() {
      if (jumlahKendaraan > 0) {
         System.out.println("Jumlah kendaraan terparkir: " + jumlahKendaraan);
         System.out.println("Daftar kendaraan terparkir:");
         for (int i = 0; i < daftarKendaraan.length; i++) {
            if (daftarKendaraan[i] != null) {
               System.out.println("Parkiran no " + (i) + ". " + daftarKendaraan[i]);
            }
         }
      } else {
         System.out.println("Tidak ada kendaraan yang terparkir saat ini.");
      }
   }

   // method pencarian kendaraan
   static void cariKendaraan(String arr[]) {
      int n = arr.length;

      if (jumlahKendaraan == 0) {
         System.out.println("Parkiran kosong");
         return;
      }

      System.out.println("Cari Jenis kendaraan");
      input.nextLine();
      String kendaraan = input.nextLine();

      for (int i = 0; i < n; i++) {
         if (arr[i] != null) {
            if (arr[i].equalsIgnoreCase(kendaraan)) {
               System.out.println(kendaraan + " Terparkir Di Nomor " + i);
               return;
            }
         }
      }
      System.out.println("Kendaraan tidak ditemukan");
   }
}
