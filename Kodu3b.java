/******************************************************************
 * Programmeerimine II. LTAT.03.007
 * 2021/2022 kevadsemester
 *
 * Kodutöö ülesanne nr 3b
 * Teema:
 *             Massiivid
 *
 * Autor: Hannes Hendrik Kisel
 ******************************************************************/

public class Kodu3b{

    public static int[] korduvadRead(int[][] a){
        //leian rea pikkuse
        int n = a[0].length;
        //kopeerin rea pikkuse, et muutujaid erinevates kohtades kasutada
        int m = n;

        /*
        Järgmise kahekordse for-tsükli eesmärgiks on on järjest võtta alates teisest reast läbi kõik elemendid
        ja võrrelda neid kolmanda for-tsükli abil esimese reaga. Kui vastav element on esimeses reas olemas,
        siis liigutatakse esimeses reas see element esimesele kohale, vahetades esimese ja vastava elemendi
        kohad. Seejärel suurendadakse loendurit counter ühe võrra, mis on sisse kirjutatud kolmandasse for-
        tsüklisse, et enam ei otsitaks esimesest reast sobivat elementi esimeselt kohalt. See aitab meil
        kindlalt öelda, et ühtegi elementi ei loeta kaks korda. Pärast kohtade vahetamist ja counteri
        suurendamist lõpetatakse break'iga see tsükkel ja liigutakse uue elemendi kallale.
        Pärast iga rea kontrollimist näitab muutuja counter, mitu klappivat elementi leiti ja see arv omastatakse
        ka muutujale m. Edaspidi otsitakse käsitletava elemendi sobivust esimese rea esimese m elemendiga.
         */

        //analüüsin järjest läbi iga rea teisest viimaseni
        for (int i = 1; i < n; i++) {
            //taastan loenduri pärast iga rida algsesse seisundisse
            int counter1 = 0;
            //ja analüüsin igas reas igat elementi
            for (int j = 0; j < n; j++) {
                //omastan käsitletavale elemendile loetavuse mõttes muutuja
                int element = a[i][j];
                //vaatan, kas esimeses reas leidub käsitletav element, kui varem on elemente leitud, siis
                //nii mitut esimest elementi ei vaadata.
                for (int k = counter1; k < m; k++) {
                    //kui leidub, siis vahetan esimese ja leitud elemendi ära ja lisan counterile ühe.
                    //teise leitud elemendi liigutan teisele kohale jne.
                    if (element == a[0][k]) {
                        int temp = a[0][k];
                        a[0][k] = a[0][counter1];
                        a[0][counter1] = temp;
                        counter1++;
                        //kui leiame esimesest reast sobiva elemendi, siis edasi ei otsi ja liigume uue
                        //elemendi juurde
                        break;
                    }

                }

            }
            //pärast iga rea lõppu vaatame, mitu klappivat elementi leiti ja edaspidi otsime klappivaid
            //elemente esimese rea nii mitme esimese elemendi hulgast.
            m = counter1;
        }
        //loon uue massiivi,kuhu kirjutan sorteerimata vastuse
        int[] vastus = new int[m];
        for (int i = 0; i < m; i++) {
            vastus[i] = a[0][i];
        }
        //sorteerin masiivi kahekordse for-tsükliga. Liigutan iga kord väikseima elemendi omale kohale.
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (vastus[j] < vastus[i]) {
                    int temp1 = vastus[j];
                    vastus[j] = vastus[i];
                    vastus[i] = temp1;
                }
            }
        }
        //tagastan vastuse
        return vastus;
    }

    public static void main(String[] args) {
        int[][] a=
                {{2,2,1,4},
                        {4,1,2,2},
                        {7,1,2,2},
                        {2,10,2,1}};


    }//main

}//klass