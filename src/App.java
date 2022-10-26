import java.util.Scanner;

class App {
    public double netMevduatKazanciHesapla(double gunSayisi, double faizOrani, double hesapBakiyesi,
            double vergiOrani) {
        double mevduatKazanci = (gunSayisi * faizOrani * hesapBakiyesi) / 36500;

        double vergiTutari = mevduatKazanci * vergiOrani;

        double netMevduatKazanci = mevduatKazanci - vergiTutari;

        return netMevduatKazanci;
    }

    public static void main(String[] args) {
        App app = new App();

        Scanner input = new Scanner(System.in);

        double faizOrani = 0.0;
        double vergiOrani = 0.0;

        double gunSayisi, hesapBakiyesi;

        while (true) {
            System.out.print("Lutfen kac gunluk hesap acmak istediginizi 0 dan buyuk olacak sekilde giriniz: ");
            while (!input.hasNextDouble()) {
                System.out.print("Lutfen sayisal bir deger giriniz: ");
                input.next();
            }
            gunSayisi = input.nextDouble();
            if (gunSayisi <= 0) {
                System.out.print("Lutfen 0 dan buyuk bir deger giriniz: ");
                input.next();
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Lutfen hesap bakiyenizi 0 dan buyuk olacak sekilde giriniz: ");
            while (!input.hasNextDouble()) {
                System.out.print("Lutfen sayisal bir deger giriniz: ");
                input.next();
            }
            hesapBakiyesi = input.nextDouble();
            if (hesapBakiyesi <= 0) {
                System.out.print("Lutfen 0 dan buyuk bir deger giriniz: ");
                input.next();
            } else {
                break;
            }
        }

        if (gunSayisi >= 1 && gunSayisi <= 30) {
            faizOrani = 17.3;
        } else if (gunSayisi >= 31 && gunSayisi <= 90) {
            faizOrani = 17.1;
        } else if (gunSayisi >= 90 && gunSayisi <= 180) {
            faizOrani = 16.5;
        } else if (gunSayisi >= 181) {
            faizOrani = 16;
        }

        if (hesapBakiyesi > 0 && hesapBakiyesi <= 10000) {
            vergiOrani = 0.10;
        } else if (hesapBakiyesi >= 10001 && hesapBakiyesi <= 50000) {
            vergiOrani = 0.12;
        } else if (hesapBakiyesi >= 50001) {
            vergiOrani = 0.15;
        }

        System.out.format("%.2f", app.netMevduatKazanciHesapla(gunSayisi, faizOrani, hesapBakiyesi, vergiOrani));

        input.close();
    }
}