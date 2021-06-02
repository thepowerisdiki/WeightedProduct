
package newwp;

import java.util.Scanner;


public class NewWP {
    
    static int jml_alt, jml_crit;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan banyak alternatif : ");
        jml_alt = in.nextInt();
        
        System.out.print("Masukkan banyak kriteria : ");
        jml_crit = in.nextInt();
        
        datax inp = new datax(jml_alt, jml_crit);
        hitungan hit = new hitungan(jml_alt, jml_crit, inp.getCritbobot(), inp.getCritsifat(), inp.getRating(), inp.getSum_bobot(), inp.getAltname());
//        hit.perbaikanbobot(inp.getCritbobot());
//        System.out.println(hit.pbobot[1]);
    }
    
}
