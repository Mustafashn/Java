
package hafızaoyunu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OyunKayıt implements Serializable {
    public static void gameSave (Kart [] [] kartlar) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayıt.bin"))) {
            System.out.println("Oyun kaydediliyor...");
            
            out.writeObject(kartlar);
        } catch (IOException ex) {
            Logger.getLogger(OyunKayıt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Kart [] [] takeSave () {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayıt.bin"))) {
            Kart [] [] array = (Kart [] [])in.readObject();
            
            return array;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OyunKayıt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OyunKayıt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OyunKayıt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
