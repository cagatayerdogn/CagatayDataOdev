import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Dugum {
    int anahtar;
    Dugum sol, sag;

    public Dugum(int item) {
        anahtar = item;
        sol = sag = null;
    }
}

class IkiliAramaAgaci {
    Dugum kok;

    IkiliAramaAgaci() {
        kok = null;
    }

    void ekle(int anahtar) {
        
        Dugum yeniDugum = new Dugum(anahtar); // Yeni bir düğüm oluşturdum.
        
        // Ağaç boşsa yeni düğümü kök olarak atıyoruz.
        if (kok == null) {
            kok = yeniDugum;
            return;
        }

        Dugum current = kok;
        Dugum parent = null;
        while (true) {
            parent = current;
            if (anahtar < current.anahtar) {
                current = current.sol;
                if (current == null) {
                    
                    parent.sol = yeniDugum; // Yeni düğümü uygun konuma yerleştiriyoruz.
                    return;
                }
            } else {
                current = current.sag;
                if (current == null) {
                    
                    parent.sag = yeniDugum; // Yeni düğümü uygun konuma yerleştiriyoruz.
                    return;
                }
            }
        }
    }

    ArrayList<Integer> preorder() {
        ArrayList<Integer> sonuc = new ArrayList<>();
        preorderRec(kok, sonuc);
        return sonuc;
    }

    void preorderRec(Dugum dugum, ArrayList<Integer> sonuc) {
        if (dugum != null) {
            
            sonuc.add(dugum.anahtar); // Düğümün anahtarını sonuç listesine ekliyoruz.
            
            preorderRec(dugum.sol, sonuc); // Sol alt ağacı öncelikli olarak dolaşıyoruz.
            
            preorderRec(dugum.sag, sonuc); // Sağ alt ağacı öncelikli olarak dolaşıyoruz.
        }
    }

    Dugum enKucukOrtakAta(int anahtar1, int anahtar2) {
        return enKucukOrtakAtaRec(kok, anahtar1, anahtar2);
    }

    Dugum enKucukOrtakAtaRec(Dugum dugum, int anahtar1, int anahtar2) {
        if (dugum == null)
            return null;

        if (dugum.anahtar > anahtar1 && dugum.anahtar > anahtar2)
            
            return enKucukOrtakAtaRec(dugum.sol, anahtar1, anahtar2); // Her iki anahtar da düğümün sol alt ağacında yer alıyorsa, sol alt ağaca geçiyoruz.
        else if (dugum.anahtar < anahtar1 && dugum.anahtar < anahtar2)
            
            return enKucukOrtakAtaRec(dugum.sag, anahtar1, anahtar2); // Her iki anahtar da düğümün sağ alt ağacında yer alıyorsa, sağ alt ağaca geçiyoruz.
        else
            
            return dugum; // Bu durumda düğüm, en küçük ortak ata oluyor.
    }

    void sil(int anahtar) {
        kok = silRec(kok, anahtar);
    }

    Dugum silRec(Dugum dugum, int anahtar) {
        if (dugum == null)
            return dugum;

        if (anahtar < dugum.anahtar)
           
            dugum.sol = silRec(dugum.sol, anahtar);  // Anahtar düğümün sol alt ağacında yer alıyorsa, sol alt ağacı güncelliyoruz.
        else if (anahtar > dugum.anahtar)
            
            dugum.sag = silRec(dugum.sag, anahtar); // Anahtar düğümün sağ alt ağacında yer alıyorsa, sağ alt ağacı güncelliyoruz.
        else {
            if (dugum.sol == null)
                
                return dugum.sag; // Sol alt ağacı boşsa, düğümün sağ alt ağacını geri döndürüyoruz.
            else if (dugum.sag == null)
                
                return dugum.sol; // Sağ alt ağacı boşsa, düğümün sol alt ağacını geri döndürüyoruz.

           
            dugum.anahtar = enKucukDugum(dugum.sag);  // Düğümün yerine geçecek olan en küçük düğüm bulunuyor.
            
            dugum.sag = silRec(dugum.sag, dugum.anahtar); // En küçük düğümün bulunduğu sağ alt ağaçtan, en küçük düğümü siliyoruz.
        }

        return dugum;
    }

    int enKucukDugum(Dugum dugum) {
        int enKucuk = dugum.anahtar;
        while (dugum.sol != null) {
           
            enKucuk = dugum.sol.anahtar;  // Sol alt ağaçta en küçük düğümü buluyoruz.
            dugum = dugum.sol;
        }
        return enKucuk;
    }

    ArrayList<Integer> seviyeSiralamasi() {
        ArrayList<Integer> sonuc = new ArrayList<>();
        
        // Ağaç boşsa sonuç boş olarak dönülüyor.
        if (kok == null)
            return sonuc;

        Queue<Dugum> kuyruk = new LinkedList<>();
        kuyruk.add(kok);

        // Seviye sıralaması için BFS (genişlik öncelikli arama) kullanılıyor.
        while (!kuyruk.isEmpty()) {
            Dugum dugum = kuyruk.poll();
            
            sonuc.add(dugum.anahtar); // Düğümün anahtarını sonuç listesine ekliyoruz.

            if (dugum.sol != null)
                
                kuyruk.add(dugum.sol); // Sol alt düğümü kuyruğa ekliyoruz.
            if (dugum.sag != null)
                
                kuyruk.add(dugum.sag); // Sağ alt düğümü kuyruğa ekliyoruz.
        }

        return sonuc;
    }
}
