
package newwp;

import java.util.Scanner;


class datax{
    Scanner in = new Scanner(System.in);
    int ja, jk;
    double sum_bobot=0;
    String[] altname;
    String[] critname;
    String[] critsifat;
    double[] critbobot;
    double[][] rating;

    public String[] getAltname() {
        return altname;
    }

    public double[] getCritbobot() {
        return critbobot;
    }

    public String[] getCritname() {
        return critname;
    }

    public String[] getCritsifat() {
        return critsifat;
    }

    public double[][] getRating() {
        return rating;
    }

    public double getSum_bobot() {
        return sum_bobot;
    }

    void setAltName(){
        String[] altnamee = new String[ja];
        for(int i=0;i<ja; i++){
            System.out.print("Masukkan nama alternatif ke-"+(i+1)+": "); 
           altnamee[i] = in.nextLine();
        }
        this.altname = altnamee;
    }
    
    void setCritName(){
        String[] critnamee = new String[jk];
        for(int i=0;i<jk; i++){
            System.out.print("Masukkan nama kriteria ke-"+(i+1)+": "); 
            critnamee[i] = in.nextLine();
        }
        this.critname = critnamee;
    }
    
    void setCritSifat(){
        String[] critsifate = new String[jk];
        for(int i=0;i<jk; i++){
            System.out.print("Masukkan sifat kriteria ke-"+(i+1)+": "); 
            critsifate[i] = in.nextLine();
        }
        this.critsifat = critsifate;
    }
    void setCritBobot(){
        double[] critbobote = new double[jk];
        for(int i=0;i<jk; i++){
            System.out.print("Masukkan bobot kriteria ke-"+(i+1)+" : "); 
            critbobote[i] = in.nextDouble();
            this.sum_bobot += critbobote[i];
        }
        this.critbobot = critbobote;
    }
    
    void inputRating(int x, int y){
       double[][] ratinge = new double[x][y];
       for(int i=0; i<x; i++){
           for(int j=0; j<y; j++){
               System.out.print("Masukkan nilai rating dari alt ke-"+(i+1)+" dan alternatif ke-"+(j+1)+": "); 
               ratinge[i][j] = in.nextDouble();
           }
       }
       this.rating = ratinge;
   }
    
    
    public datax(int ja,int jk){
        this.ja = ja;
        this.jk = jk;
        setAltName();
        setCritName();
        setCritSifat();
        setCritBobot();
        inputRating(ja, jk);
    }
}
