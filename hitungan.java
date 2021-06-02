
package newwp;

import java.util.Scanner;

class hitungan{
    Scanner in = new Scanner(System.in);
    int ja, jk;
    double sum_bobot, sum_vektor_s;
    double[] bobot;
    double[] pbobot;
    double[] totalvektors;
    String[] sifat;
    double[] vektorv;
    String[] altname;
    String[] critname;
    String[] critsifat;
    double[] critbobot;
    double[][] rating;
    
    public void perbaikanbobot(double[] b){
        double[] pbbt = new double[jk];
        for(int i=0;i<jk; i++){
            pbbt[i] = b[i]/sum_bobot;
        }
        this.pbobot = pbbt;
    }

    public double[] getPbobot() {
        return pbobot;
    }
    
    void hitungTotalVektorS(String[] sifatbobot, double[][] crit, double[] pbbt){
        double[][] vektor_s = new double[ja][jk];
        double[] totalvektorse = new double[ja];
        for(int i=0; i<ja; i++){
            totalvektorse[i] = 1;
            for(int j=0; j<jk; j++){
                if(sifatbobot[j] == "cost"){
                    vektor_s[i][j] = Math.pow(crit[i][j], -pbbt[j]);
                }
                else{
                    vektor_s[i][j] = Math.pow(crit[i][j], pbbt[j]);
                }
                totalvektorse[i] *= vektor_s[i][j];
            }
            this.sum_vektor_s += totalvektorse[i];
        }
        this.totalvektors = totalvektorse;
    }
    
    void hitungVektorV(double[] tvs, double svs){
        double vektorve[] = new double[ja];
        for(int i=0 ; i<ja; i++){
            vektorve[i] = tvs[i] / svs;
        }
        this.vektorv = vektorve;
    }
    
    void bubblesort(){
        for(int i = 0; i<ja-1; i++){
            double temp;
            String tempalt;
            for(int j = i+1; j<ja; j++){
                if(this.vektorv[i]<this.vektorv[j]){
                    temp = this.vektorv[i];
                    this.vektorv[i] = this.vektorv[j];
                    this.vektorv[j] = temp; 

                    tempalt = this.altname[i];
                    this.altname[i] = this.altname[j];
                    this.altname[j] = tempalt;
                }
            }
        }
    }
    
    void getRank(){
        for(int i = 0; i<ja; i++){
            System.out.println("Rangking ke-"+i+" adalah alternatif "+altname[i]+" dengan vektor v "+vektorv[i]+"");
        } 
    }
    
    
    
    public hitungan(int ja, int jk, double[] bobote, String[] critsifate, double[][] ratinge, double sumbobote, String[] altnamee){
        this.ja = ja;
        this.jk = jk;
        this.bobot = bobote;
        this.critsifat = critsifate;
        this.rating = ratinge;
        this.sum_bobot = sumbobote;
        this.altname = altnamee;
        perbaikanbobot(this.bobot);
        hitungTotalVektorS(this.critsifat, this.rating, this.getPbobot());
        hitungVektorV(this.totalvektors, this.sum_vektor_s);
        bubblesort();
        getRank();
    }
}
