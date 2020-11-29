/**
 * 
 */
package github;

/**
 *<h1>BlackJack kivétel osztály</h1>
 * kivétel bisztosítása számítás közben.
 * @author Klement Norbert,
 */
public class BlackJack_kivétel extends Exception {


    /**
     * Alapértelmezet konstruktor
     */
    public BlackJack_kivétel() {
    }

    /**
     * Konstruktor, a hibaüzenetek átasása
     * @param msg Az üzenet ami a kivétel hívásakor átadódik.
     */
    public BlackJack_kivétel(String msg) {
        super(msg);
    }
}
