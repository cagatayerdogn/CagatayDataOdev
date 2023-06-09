import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        IkiliAramaAgaci agac = new IkiliAramaAgaci(); // IkiliAramaAgaci sınıfından bir nesne oluşturdum.
      
        agac.ekle(70);  // Ağaca elemanları ekledim.
        agac.ekle(45);
        agac.ekle(32);
        agac.ekle(21);
        agac.ekle(13);
        agac.ekle(27);
        agac.ekle(40);
        agac.ekle(56);
        agac.ekle(46);
        agac.ekle(68);
        agac.ekle(87);
        agac.ekle(77);
        agac.ekle(73);
        agac.ekle(80);
        agac.ekle(79);
        agac.ekle(82);
        agac.ekle(92);
        agac.ekle(89);
        agac.ekle(99);

        System.out.println("Preorder Dolaşma:"); // Preorder sonucu ekrana yazdırılıyor.
        ArrayList<Integer> preorderSonuc = agac.preorder();  // Preorder dolaşma işlemi gerçekleştirilerek sonuç ArrayList'e kaydediliyor.
        for (int anahtar : preorderSonuc) {
            System.out.print(anahtar + " ");
        }
        System.out.println();

          // En küçük ortak ata bulma işlemi gerçekleştiriliyor.
        int anahtar1 = 27, anahtar2 = 46;
        Dugum ortakAta = agac.enKucukOrtakAta(anahtar1, anahtar2);
        System.out.println("En Küçük Ortak Ata (" + anahtar1 + " ve " + anahtar2 + "): " + ortakAta.anahtar);   // Bulunan en küçük ortak ata ekrana yazdırılıyor.

          // Başka bir en küçük ortak ata bulma işlemi gerçekleştiriliyor.
        int anahtar3 = 77, anahtar4 = 13;
        Dugum ortakAta2 = agac.enKucukOrtakAta(anahtar3, anahtar4);
        System.out.println("En Küçük Ortak Ata (" + anahtar3 + " ve " + anahtar4 + "): " + ortakAta2.anahtar);  // Yeni bulunan en küçük ortak ata ekrana yazdırılıyor.

       // Belirli bir anahtarı ağaçtan silme işlemi gerçekleştiriliyor.
        int silinecekAnahtar = 32; 
        agac.sil(silinecekAnahtar);
        System.out.println("Silindikten Sonra Preorder Dolaşma:");  // Silme işlemi sonrası preorder dolaşma işlemi gerçekleştirilerek sonuç ekrana yazdırılıyor.
        preorderSonuc = agac.preorder();
        for (int anahtar : preorderSonuc) {
            System.out.print(anahtar + " ");
        }
        System.out.println();

        System.out.println("Seviye Sıralaması:"); // Seviye sıralaması sonucu ekrana yazdırılıyor.
        ArrayList<Integer> seviyeSonuc = agac.seviyeSiralamasi();  // Seviye sıralaması işlemi gerçekleştirilerek sonuç ArrayList'e kaydediliyor.
        for (int anahtar : seviyeSonuc) {
            System.out.print(anahtar + " ");
        }
        System.out.println();
    }



}
