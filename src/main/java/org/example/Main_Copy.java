import java.util.Arrays;
import java.util.Scanner;

public class Main_Copy
{
    static int [] pomiary = null;
    static double czytaLiczbeDoubleZZakresu(String zaproszenie, double dolneOgraniczenie, double gorneOgraniczenie)
    {
        double liczba;
        Scanner wejscie = new Scanner(System.in);
        while (true)
            try
            {
                System.out.print(zaproszenie);
                liczba = wejscie.nextDouble();
                if (liczba >= dolneOgraniczenie && liczba <=gorneOgraniczenie)
                    break;
                else
                    System.out.printf("Dozwolony zakres od %.2f do %.2f\n", dolneOgraniczenie, gorneOgraniczenie);
            }
            catch (Exception e)
            {
                System.out.println("Błędna liczba");
                wejscie.next(); // Puste czytanie, czyszczenie bufora
            }
        return liczba;
    }
    static int czytaLiczbeIntZZakresu(String zaproszenie, int dolneOgraniczenie, int gorneOgraniczenie)
    {
        return (int)czytaLiczbeDoubleZZakresu(zaproszenie, dolneOgraniczenie, gorneOgraniczenie);
    }

    static void inicjalizacja()
    {
        System.out.println("Analiza pomiarow pulsu");
    }
    static char pokazMenuIWczytajWyborUzytkownika()
    {
        Scanner wejscie = new Scanner(System.in);
        System.out.println("Wybierz opcje:");
        System.out.print("1 Wprowadzanie\n2 Przeglad\n3 Statystyka\n4 Usun pomiary\n0 Koniec\n>> ");
//        String odpowiedz = wejscie.next();
//        return odpowiedz.charAt(0);
        return wejscie.next().charAt(0);
    }
    static void wczytajPomiary() {
        int liczbaPomiarow;
        int numerPomiaru = 0;

        if (pomiary != null && uzytkownikPotwierdzil("Czy dopisujemy nowe pomiary?"))
        {
            liczbaPomiarow = czytaLiczbeIntZZakresu("Ile bedzie nowych pomiarow: ", 1, 24);
            int[] nowa = new int[pomiary.length + liczbaPomiarow];
            System.arraycopy(pomiary, 0, nowa, 0, pomiary.length);
            numerPomiaru = pomiary.length;
            pomiary = nowa;
        }
        else
        {
            liczbaPomiarow = czytaLiczbeIntZZakresu("Ile bedzie pomiarow: ", 1, 24);
            pomiary = new int[liczbaPomiarow];
            numerPomiaru = 0;
        }
        // Wczytywanie pomiarów do tablicy
        for(; numerPomiaru < pomiary.length; numerPomiaru++)
        {
            String napis = String.format("%2d: ", numerPomiaru + 1);
            pomiary[numerPomiaru] = czytaLiczbeIntZZakresu(napis, 1, 250);
        }
    }
    static void pokazPomiary()
    {
        // Pokaż zawartość tablicy
        if(pomiary == null)
            System.out.println("Prosze wprowadzic pomiary");
        else
        {
            System.out.printf("Liczba wprowadzonych pomiarow to %2d, ich lista:\n", pomiary.length);
            for (int numerPomiaru = 0; numerPomiaru < pomiary.length; numerPomiaru++)
                System.out.printf("%2d: %d\n", numerPomiaru + 1, pomiary[numerPomiaru]);
        }
    }
    static double sumaPomiarow(int [] tablica)
    {
        int suma = 0;
        for(int i = 0; i < tablica.length; ++i)
            suma += tablica[i];
        return suma;
    }
    static double srednuPuls(int [] tablica)
    {
        return sumaPomiarow(tablica) / tablica.length;
    }
    static int maksymalnyPomiar(int [] tablica)
    {
        return 0;
    }
    static int minimalnyPomiar(int [] tablica)
    {
        return 0;
    }
    static double medianaPomiarow(int [] tablica)
    {
        double rezultat;
        int [] kopia = Arrays.copyOf(tablica, tablica.length);
        Arrays.sort(kopia);
        if(kopia.length % 2 == 0)
            rezultat = (kopia[kopia.length / 2] + kopia[(kopia.length / 2) - 1]) / 2.0;
        else
            rezultat = kopia[kopia.length / 2];
        return rezultat;
    }
    static double odchylenieStandarowe(int[] pomiary){
        double suma = 0;
        double srednia = srednuPuls(pomiary);
        for (int i = 0; i< pomiary.length; i++) {
            suma = (suma + Math.pow((pomiary[i] - srednia),2));
        }
        double odchylenie = suma/ pomiary.length;

        return Math.sqrt(odchylenie);
    }
    static void analizujPomiary()
    {
        if(pomiary == null)
        {
            System.out.println("Prosze wprowadzic pomiary");
            return;
        }
        System.out.printf("Sredni puls: %.2f\n", srednuPuls(pomiary));
        System.out.printf("Maksymalny puls: %d\n", maksymalnyPomiar(pomiary));
        System.out.printf("Minimalny puls: %d\n", minimalnyPomiar(pomiary));
        System.out.printf("Mediana pulsow: %.2f\n", medianaPomiarow(pomiary));
        System.out.printf("Odchylenie standardowe wynosi: %.2f\n", odchylenieStandarowe(pomiary));

    }
    static boolean uzytkownikPotwierdzil(String zapytanie)
    {
        char odpowiedz;
        Scanner wejscie = new Scanner(System.in);
        do
        {
            System.out.print(zapytanie + " [t/n]: ");
            odpowiedz = Character.toLowerCase(wejscie.next().charAt(0));
        }
        while(odpowiedz != 't' && odpowiedz != 'n');
        return odpowiedz == 't';
    }
    static void usunPomiary()
    {
        if(uzytkownikPotwierdzil("Czy rzeczywiscie usunac pomiary?"))
            pomiary = null;
    }
    static void  wykonanie()
    {
        char wyborUzytkownika;
        do
        {
            wyborUzytkownika = pokazMenuIWczytajWyborUzytkownika();
            switch (wyborUzytkownika)
            {
                case '1':   wczytajPomiary();
                    break;
                case '2':   pokazPomiary();
                    break;
                case '3':   analizujPomiary();
                    break;
                case '4':   usunPomiary();
                    break;
                case '5': odchylenieStandarowe(pomiary);
                    break;
            }
        }
        while(wyborUzytkownika != '0');
    }
    static void zakonczenie()
    {
        System.out.println("Do napisania :)");
    }


    public static void main(String[] args)
    {
        inicjalizacja();
        wykonanie();
        zakonczenie();
    }
}
 
/* Wersja poprzednia
 
import java.util.Arrays;
import java.util.Scanner;
 
public class Main
{
    static int [] pomiary = null;
    static double czytaLiczbeDoubleZZakresu(String zaproszenie, double dolneOgraniczenie, double gorneOgraniczenie)
    {
        double liczba;
        Scanner wejscie = new Scanner(System.in);
        while (true)
            try
            {
                System.out.print(zaproszenie);
                liczba = wejscie.nextDouble();
                if (liczba >= dolneOgraniczenie && liczba <=gorneOgraniczenie)
                    break;
                else
                    System.out.printf("Dozwolony zakres od %.2f do %.2f\n", dolneOgraniczenie, gorneOgraniczenie);
            }
            catch (Exception e)
            {
                System.out.println("Błędna liczba");
                wejscie.next(); // Puste czytanie, czyszczenie bufora
            }
        return liczba;
    }
    static int czytaLiczbeIntZZakresu(String zaproszenie, int dolneOgraniczenie, int gorneOgraniczenie)
    {
        return (int)czytaLiczbeDoubleZZakresu(zaproszenie, dolneOgraniczenie, gorneOgraniczenie);
    }
 
    static void inicjalizacja()
    {
        System.out.println("Analiza pomiarow pulsu");
    }
    static char pokazMenuIWczytajWyborUzytkownika()
    {
        Scanner wejscie = new Scanner(System.in);
        System.out.println("Wybierz opcje:");
        System.out.print("1 Wprowadzanie\n2 Przeglad\n3 Statystyka\n0 Koniec\n>> ");
//        String odpowiedz = wejscie.next();
//        return odpowiedz.charAt(0);
        return wejscie.next().charAt(0);
    }
    static void wczytajPomiary()
    {
        int liczbaPomiarow;
        liczbaPomiarow = czytaLiczbeIntZZakresu("Ile bedzie pomiarow: ", 1, 24);
        pomiary = new int[liczbaPomiarow];
        // Wczytywanie pomiarów do tablicy
        for(int numerPomiaru = 0; numerPomiaru < pomiary.length; numerPomiaru++)
        {
            String napis = String.format("%2d: ", numerPomiaru + 1);
            pomiary[numerPomiaru] = czytaLiczbeIntZZakresu(napis, 1, 250);
        }
    }
    static void pokazPomiary()
    {
        // Pokaż zawartość tablicy
        if(pomiary == null)
            System.out.println("Prosze wprowadzic pomiary");
        else
        {
            System.out.printf("Liczba wprowadzonych pomiarow to %2d, ich lista:\n", pomiary.length);
            for (int numerPomiaru = 0; numerPomiaru < pomiary.length; numerPomiaru++)
                System.out.printf("%2d: %d\n", numerPomiaru + 1, pomiary[numerPomiaru]);
        }
    }
    static double sumaPomiarow(int [] tablica)
    {
        int suma = 0;
        for(int i = 0; i < tablica.length; ++i)
            suma += tablica[i];
        return suma;
    }
    static double srednuPuls(int [] tablica)
    {
        return sumaPomiarow(tablica) / tablica.length;
    }
    static int maksymalnyPomiar(int [] tablica)
    {
        return 0;
    }
    static int minimalnyPomiar(int [] tablica)
    {
        return 0;
    }
    static int medianaPomiarow(int [] tablica)
    {
        return 0;
    }
    static void analizujPomiary()
    {
        if(pomiary == null)
        {
            System.out.println("Prosze wprowadzic pomiary");
            return;
        }
        System.out.printf("Sredni puls: %.2f\n", srednuPuls(pomiary));
        System.out.printf("Maksymalny puls: %d\n", maksymalnyPomiar(pomiary));
        System.out.printf("Minimalny puls: %d\n", minimalnyPomiar(pomiary));
        System.out.printf("Mediana pulse: %d\n", medianaPomiarow(pomiary));
 
    }
 
    static void  wykonanie()
    {
        char wyborUzytkownika;
        do
        {
            wyborUzytkownika = pokazMenuIWczytajWyborUzytkownika();
            switch (wyborUzytkownika)
            {
                case '1':   wczytajPomiary();
                    break;
                case '2':   pokazPomiary();
                    break;
                case '3':   analizujPomiary();
                    break;
            }
        }
        while(wyborUzytkownika != '0');
    }*
    static void zakonczenie()
    {
        System.out.println("Do napisania :)");
    }
 
 
    public static void main(String[] args)
    {
        inicjalizacja();
        wykonanie();
        zakonczenie();
    }
}
 
}*/