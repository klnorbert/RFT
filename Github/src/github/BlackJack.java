
package github;
/**
 * 
 */
import java.util.Random;
import java.util.Scanner;
/**
 * <h1>BlackJack projekt</h1>
 * Ez a projekt elsődleges osztálya
 * 
 * @author Klement Norbert
 */
public class BlackJack {
    /**
     * oszto[] osztónak a lapjai
     * laposzt osztónak a lapjainak a száma
     * jatszo[] játszó félnek a lapjai
     * lapjatsz játszó félnek a lapjainak a száma
     */
    private int oszto[];
    private int laposzt=0;
    private int jatszo[];
    private int lapjatsz=0;
    
    
    /**
     * Az oszto kezében lévő kártyát viszaadja és egy X-et
     * @return a oszto allasat adja visza stringben egy erték eltakarásával
     * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    public String Oszto_kez()throws BlackJack_kivétel{
        
        if(laposzt==0){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
        String visza = "";
        for (int i = 0; i < this.laposzt - 1; i++) {
            switch (this.oszto[i]) {
                case 11:
                    visza = visza + "Bubi ";
                    break;
                case 12:
                    visza = visza + "Dáma ";
                    break;
                case 13:
                    visza = visza + "Király ";
                    break;
                case 14:
                    visza = visza + "Ász ";
                    break;
                default:
                    visza = visza + this.oszto[i] + " ";
                    break;
            }
        }
        visza = visza + "X";
        
        return visza;
        }
    }
    
    
    /**
     * Az oszto kezében lévő kártyákat viszaadja
     * @return a oszto allasat adja visza stringben
     * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    
    private String Oszto_kez_teljes()throws BlackJack_kivétel{
        
        if(laposzt==0){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
        String visza = "";
        for (int i = 0; i < this.laposzt; i++) {
            switch (this.oszto[i]) {
                case 11:
                    visza = visza + "Bubi ";
                    break;
                case 12:
                    visza = visza + "Dáma ";
                    break;
                case 13:
                    visza = visza + "Király ";
                    break;
                case 14:
                    visza = visza + "Ász ";
                    break;
                default:
                    visza = visza + this.oszto[i] + " ";
                    break;
            }
        }
        return visza;
        }
    }
    
    /**
     * A játszó kezében lévő kártyákat viszadja
     * @return a jatszo allasat adja visza stringben
     * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    
    public String Jatszo_kez()throws BlackJack_kivétel{
        
        if(lapjatsz==0){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
        String visza = "";
        
        for (int i = 0; i < this.lapjatsz; i++) {
            switch (this.jatszo[i]) {
                case 11:
                    visza = visza + "Bubi ";
                    break;
                case 12:
                    visza = visza + "Dáma ";
                    break;
                case 13:
                    visza = visza + "Király ";
                    break;
                case 14:
                    visza = visza + "Ász ";
                    break;
                default:
                    visza = visza + this.jatszo[i] + " ";
                    break;
            }
        }
        return visza;      
        }
    }
    
    
    /**
     * Viszaadja a jelenlegi állást
     * @return viszaadja a jelenlegi állás stringben
     * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    
    public String Allas()throws BlackJack_kivétel{
        if(this.jatszo==null){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
        String visza = "";
        
        visza = visza + Oszto_kez();
        
        visza = visza + " -- ";
        
        visza = visza + Jatszo_kez();
        
        return visza;
        }
    }
    
    /**
     * Viszaadja a jelenlegi állást eltakaras nelkül
     * @return viszaadja a jelenlegi állás stringben eltakarás nélkül
     * @throws BlackJack_kivétel ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    private String Vegso_Allas()throws BlackJack_kivétel{
        if(this.jatszo==null){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
        String visza = "";
        
        visza = visza + Oszto_kez_teljes();
        
        visza = visza + " -- ";
        
        visza = visza + Jatszo_kez();
        
        return visza;
        }
    }
    /**
     * viszaadja az elküldöt kártyák számbeli öszegét
     * @param kézben a kártyák ami az egyik félnél van
     * @param db hány db kártya van a kezében
     * @return a kártyák számbeli értékének az öszege
     * @throws BlackJack_kivétel ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    
    private int Allas_szam(int kézben[],int db)throws BlackJack_kivétel{
        if(db==0){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
            int eredmeny=0;
        
            int jel = 0;
            int asz = 0;
            for (int i = 0; i < db; i++) {
                if (kézben[i] < 11) {
                    eredmeny = eredmeny + kézben[i];
                } else {
                    if (kézben[i] < 14) {
                        eredmeny = eredmeny + 10;
                    } else {
                        asz = asz + 1;
                    }
                }
            }
            for (int i = asz; i > 0; i--) {
                if (jel > 10) {
                    eredmeny = eredmeny + 1;
                } else {
                    eredmeny = eredmeny + 11;
                }
            }
            return eredmeny;
        }
        
        
    }
    
    
    
    /**
     * Játék indítása
     * Húz két lapot és az adatokat lejegyzi az osztó lapjaiba
     * és 2 őt a jatszo félnek a lapjaiba
     * és kiírja a konzolra a jelenlegi állást
     */
    
    public void game() {
        Random rn = new Random();

        this.jatszo = new int[10];
        this.oszto = new int[10];

        this.oszto[0] = rn.nextInt(12) + 2;
        this.oszto[1] = rn.nextInt(12) + 2;
        this.jatszo[0] = rn.nextInt(12) + 2;
        this.jatszo[1] = rn.nextInt(12) + 2;
        this.lapjatsz = 2;
        this.laposzt = 2;
        
    }
        
        
     /**
      * húz mégegy kártyát és berakja a jatszó paklijába és végül 
      * kiirja a jelenlegi állást
      * Kártya húzás random fügvényel történik
      * adatok mentése a jatszo[] játszó félnek a lapjai
      * lapjatsz játszó félnek a lapjainak a száma használatával történik
      * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
      */   
    public void huz() throws BlackJack_kivétel{
        if(this.lapjatsz==0){
            throw new BlackJack_kivétel("Még nem kezdődöt ell a játék!");
        }
        else{
        Random rn = new Random();

        this.jatszo[this.lapjatsz] = rn.nextInt(12) + 2;;
        this.lapjatsz = this.lapjatsz + 1;
        }
    }
    
    /**
     * Ez a fügvény hirdeti meg az eredményt
     * Az osztó ilyenkor huz és vizsgálja meg az adatokat
     * és addig huz mig nem lesz nagyob a miénknél kivéve ha többet huzot a huzó mint 21
     * és végül kiírja a végeredmény néhány alkalmazot játékszabályal
     * Kártya húzás random fügvényel történik
     * adatok mentése a jatszo[] játszó félnek a lapjai
     * lapjatsz játszó félnek a lapjainak a száma 
     * oszto[] osztónak a lapjai
     * laposzt osztónak a lapjainak a száma
     * használatával történik
     * Black Jacket is figyelembe veszi
     * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    public void end() throws BlackJack_kivétel {
        Random rn = new Random();
        
        
        int jel = Allas_szam(this.jatszo,this.lapjatsz);
        
        int jel2= Allas_szam(this.oszto,this.laposzt);
        
        if (jel > 21 || jel < jel2) {
            System.out.println(Vegso_Allas()+"\nVesztetél Te: " + jel + " Osztó: " + jel2);
        }
        else{
            while (jel > jel2 ) {
                
                this.oszto[this.laposzt] = rn.nextInt(12) + 2;;
                this.laposzt = this.laposzt + 1;

                jel2=Allas_szam(this.oszto,this.laposzt);
            }
            
            System.out.println(Vegso_Allas());
            
            if (jel2 > 21) {
                System.out.println("Nyertél Te: " + jel + " Osztó: " + jel2);
            }
            else if (this.lapjatsz == 2 && this.jatszo[0] > 9 && this.jatszo[1] > 9) {
                int asz3 = 0;
                int seged = 0;
                if (this.jatszo[0] == 14) {
                    asz3 = 1;
                } else {
                    seged = 1;
                }
                if (this.jatszo[1] == 14) {
                    asz3 = 1;
                } else {
                    seged = 1;
                }

                if (seged == 1 && asz3 == 1) {
                    if (this.laposzt == 2 && this.oszto[0] > 9 && this.oszto[1] > 9) {
                        int asz4 = 0;
                        int seged2 = 0;
                        if (this.jatszo[0] == 14) {
                            asz4 = 1;
                        } else {
                            seged2 = 1;
                        }
                        if (this.jatszo[1] == 14) {
                            asz4 = 1;
                        } else {
                            seged2 = 1;
                        }
                        if (seged2 == 1 && asz4 == 1) {
                            System.out.println("Döntetlen Te: " + jel + " Osztó: " + jel2);
                        } else {
                            System.out.println("Vesztetél Te: " + jel + " Osztó: " + jel2);
                        }
                    } else {
                        System.out.println("Nyertél BlackJack Te: " + jel + " Osztó: " + jel2);
                    }

                }
                if(this.jatszo[0] > 9 && this.jatszo[0] < 14 && this.jatszo[1] > 9 && this.jatszo[1] < 14){
                    if(jel>jel2)
                        System.out.println("Nyertél Te: " + jel + " Osztó: " + jel2);
                    else
                        System.out.println("Vesztetél Te: " + jel + " Osztó: " + jel2);
                }
                    
            } else if(jel==jel2){
                System.out.println("Döntetlen  Te: " + jel + " Osztó: " + jel2);
            }else if(jel>jel2){
                System.out.println("Nyertél Te: " + jel + " Osztó: " + jel2);
            }else{
                System.out.println("Vesztetél Te: " + jel + " Osztó: " + jel2);
            }
        } 
    }    
    /**
     * A program főmetódusa, a pelépési pont
     * @param args Parancssoi paraméterek a program hívásakor.
     * Egyy alap leírása a programra 1 es és kettes számmal működikés hívja meg az egyes fügvényeket
     * @throws BlackJack_kivétel  ha nem kezdte volna ell a játékot akkor hibbát dobjon fel hogy nincs az osztó és a kezdő kezében semmi
     */
    public static void main(String[] args) throws BlackJack_kivétel {
        Scanner be = new Scanner(System.in);
        BlackJack game = new BlackJack();
        game.game();
        game.Allas();
        
        System.out.println("Készítete: Klement Norbert,,");
        System.out.println(game.Allas()+"\n1 = laphuzas\t2 = megallas");
        int a=0;
        int adat=0;
        while(a==0){
            System.out.print("\nvalaszt: ");
            adat = be.nextInt();
            if(adat==1){
                game.huz();
                System.out.println(game.Allas());
            }
            if(adat==2){
                game.end();
                a=1;
            }
        }
    }
    
}
