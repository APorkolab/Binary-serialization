package pkg_29_1_b_binaris_szerializalacio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class Binaris  {
//
//}
public class Szamok implements Serializable {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int adat;
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("szamok.bin"))) {
            String str[] = ois.readObject().toString().split(", ");
            List<String> al = new ArrayList<String>();
            al = Arrays.asList(str);
            int osszeg = 0;
            int minimum = Integer.MAX_VALUE;
            int maximum = Integer.MIN_VALUE;
            int parosOsszeg = 0;
            for (int i = 0; i < al.size(); i++) {
                try {
                    adat = Integer.parseInt(al.get(i));
                } catch (NumberFormatException e) {
                    adat = 0;
                }
                osszeg = osszeg + adat;
                if (adat < minimum) {
                    minimum = adat;
                }
                if (adat > maximum) {
                    maximum = adat;
                }
                if (adat % 2 == 0) {
                    parosOsszeg = parosOsszeg + adat;
                }
            }
            System.out.println(al.get(1));
            System.out.println("A bináris adatok összege: " + osszeg);
            System.out.println("A bináris adatok minimuma: " + minimum);
            System.out.println("A bináris adatok maximuma: " + maximum);
            System.out.println("A páros számok összege: " + parosOsszeg);
        } catch (IOException ex) {
            System.out.println("Olvasási hiba: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Nem találom az osztályt???");
        }
    }
}
