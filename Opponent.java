package business;
/**
 *
 * @author Alyssa
 */
public class Opponent extends Generic_Combatant{
    private String diff_level;
    
    public Opponent(){
        super();
        this.diff_level = "";       
    }    
   
    public Opponent(int id, String n, int st, int ac, int sp, int sk, int kn, int lvl, String dl, String pl){
        super(id, n, st, ac, sp, sk, kn, lvl, pl);
        this.diff_level = dl;
        ;
    }

    public String getDiff_level() {
        return diff_level;
    }

    public void setDiff_level(String diff_level) {
        this.diff_level = diff_level;
    }

}