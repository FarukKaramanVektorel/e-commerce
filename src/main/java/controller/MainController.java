package controller;

import java.util.Scanner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainController {

    private final CustomerController customerController;
    private final ProductController productController;
    private final CategoryController categoryController;
    private final CustomerInfoController customerInfoController;
    private final CustomerPriceController customerPriceController;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Yapmak istediğiniz işlemi seçin:");
            System.out.println("1. Müşteri işlemleri");
            System.out.println("2. Ürün işlemleri");
            System.out.println("3. Kategori işlemleri");
            System.out.println("4. Müşteri Bilgisi işlemleri");
            System.out.println("5. Müşteri Fiyat işlemleri");
            System.out.println("6. Çıkış");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    productMenu();
                    break;
                case 3:
                    categoryMenu();
                    break;
                case 4:
                    customerInfoMenu();
                    break;
                case 5:
                    customerPriceMenu();
                    break;
                case 6:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private void customerMenu() {
        while (true) {
            System.out.println("Müşteri işlemleri:");
            System.out.println("1. Müşteri oluştur");
            System.out.println("2. Müşteri getir");
            System.out.println("3. Tüm müşterileri getir");
            System.out.println("4. Müşteri güncelle");
            System.out.println("5. Müşteri sil");
            System.out.println("6. Geri dön");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customerController.musteriOlustur();
                    break;
                case 2:
                    customerController.musteriGetirById();
                    break;
                case 3:
                    customerController.tumMusterileriGetir();
                    break;
                case 4:
                    customerController.musteriGuncelle();
                    break;
                case 5:
                    customerController.musteriSil();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private void productMenu() {
        while (true) {
            System.out.println("Ürün işlemleri:");
            System.out.println("1. Ürün ekle");
            System.out.println("2. Ürün getir");
            System.out.println("3. Tüm ürünleri getir");
            System.out.println("4. Ürün güncelle");
            System.out.println("5. Ürün sil");
            System.out.println("6. Geri dön");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productController.urunEkle();
                    break;
                case 2:
                    productController.urunGetirById();
                    break;
                case 3:
                    productController.tumUrunleriGetir();
                    break;
                case 4:
                    productController.urunGuncelle();
                    break;
                case 5:
                    productController.urunSil();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private void categoryMenu() {
        while (true) {
            System.out.println("Kategori işlemleri:");
            System.out.println("1. Kategori ekle");
            System.out.println("2. Kategori getir");
            System.out.println("3. Tüm kategorileri getir");
            System.out.println("4. Kategori güncelle");
            System.out.println("5. Kategori sil");
            System.out.println("6. Geri dön");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    categoryController.kategoriEkle();
                    break;
                case 2:
                    categoryController.kategoriGetirById();
                    break;
                case 3:
                    categoryController.tumKategorileriGetir();
                    break;
                case 4:
                    categoryController.kategoriGuncelle();
                    break;
                case 5:
                    categoryController.kategoriSil();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private void customerInfoMenu() {
        while (true) {
            System.out.println("Müşteri Bilgisi işlemleri:");
            System.out.println("1. Müşteri bilgisi ekle");
            System.out.println("2. Müşteri bilgisi getir");
            System.out.println("3. Tüm müşteri bilgilerini getir");
            System.out.println("4. Müşteri bilgisi güncelle");
            System.out.println("5. Müşteri bilgisi sil");
            System.out.println("6. Geri dön");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customerInfoController.musteriBilgisiEkle();
                    break;
                case 2:
                    customerInfoController.musteriBilgisiGetirById();
                    break;
                case 3:
                    customerInfoController.tumMusteriBilgileriniGetir();
                    break;
                case 4:
                    customerInfoController.musteriBilgisiGuncelle();
                    break;
                case 5:
                    customerInfoController.musteriBilgisiSil();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private void customerPriceMenu() {
        while (true) {
            System.out.println("Müşteri Fiyat işlemleri:");
            System.out.println("1. Müşteri fiyatı ekle");
            System.out.println("2. Müşteri fiyatı getir");
            System.out.println("3. Tüm müşteri fiyatlarını getir");
            System.out.println("4. Müşteri fiyatı güncelle");
            System.out.println("5. Müşteri fiyatı sil");
            System.out.println("6. Geri dön");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customerPriceController.musteriFiyatEkle();
                    break;
                case 2:
                    customerPriceController.musteriFiyatGetirById();
                    break;
                case 3:
                    customerPriceController.tumMusteriFiyatlariniGetir();
                    break;
                case 4:
                    customerPriceController.musteriFiyatGuncelle();
                    break;
                case 5:
                    customerPriceController.musteriFiyatSil();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}

