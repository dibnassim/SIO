package dmjusteprix;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DMjusteprix {
Timer timer;

    public DMjusteprix(int seconds)
    {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Le temps est écoulé ! Le coffre restera fermé !");
            timer.cancel(); 
            System.exit(0);  
        } 
    }
    
    public static void difficulte(int nbval, int nbval2)
    {
        int nombre;
        
        for(int i=1; i<=3;++i)
        {
            System.out.print("Veillez trouver le " + i +" code .  ");
            Random r = new Random();
            
            int valeur = r.nextInt(nbval + nbval2 +1);
            

            do
            {
                Scanner keyb= new Scanner(System.in);
                System.out.println("Saisissez le bon numero : ");
                nombre = keyb.nextInt();
                if(nombre==valeur)
                {
                    System.out.println("Vous avez trouver le bon nombre "); 
                }
                else if (nombre < valeur)
                {
                    System.out.println("c'est plus ") ;   
                }
                else if (nombre > valeur)
                {
                    System.out.println("c'est moins ");
                }
            }while(nombre!=valeur);
        }
        System.out.println("WAOUW vous avez ouvert le coffre !");
        System.exit(0);
        
    }
    
    public static void main(String[] args) {
        String jouer;
        
        do
        {
            Scanner r= new Scanner(System.in); 
            System.out.println("Voici le but du jeu : Vous allez devoir déverouiller un coffre à 3 codes, il y à 3 niveaux de difficulté, vous pouvez aussi la personaliser. Voulez vous jouer ? (o/n) ");
            jouer = r.nextLine();
        }while(!"o".equals(jouer));
            
    
        Scanner sc= new Scanner(System.in); 
        System.out.println("En quelle difficulté jouer ? Facile ? (f) , moyenne ? (m) , difficile ? (d) , ou meme personaliser (p): ");
        String saisi = sc.nextLine();
        
        switch (saisi)
        {
            case "f": 
                System.out.println("Vous avez 4 minutes pour trouver les codes, les nombres se situent entre 1 et 100 ");
                new DMjusteprix(240);
                difficulte(1, 100);
                
                break;
            case "m":
                System.out.println("Vous avez 20 secondes pour trouver les codes, les nombres se situent entre 1 et 200 ");
                new DMjusteprix(20);
                difficulte(1, 200);
                 
                break;
            case "d":
                System.out.println("Vous avez 20 secondes pour trouver les codes, les nombres se situent entre 1 et 1000 ");
                new DMjusteprix(20);
                difficulte(1, 1000);
                 
                break;
            case "p":
                Scanner stemps = new Scanner(System.in);
                Scanner sinterv1 = new Scanner(System.in);
                Scanner sinterv2 = new Scanner(System.in);
                System.out.println("PERSONNALISE ");
                System.out.print("Définissez le temps impartis :  ");
                int t = stemps.nextInt();
                System.out.print("Définissez le premier interval :  ");
                int inter1 = sinterv1.nextInt();
                System.out.print("Définissez le second interval :  ");
                int inter2 = sinterv2.nextInt();
                
                new DMjusteprix(t);
                difficulte(inter1, inter2);
                break;
                
        }
    } 
}

    

