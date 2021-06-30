import java.util.ArrayList;

public class BuffGenerator {

    ArrayList<Brick> bricks;

    BuffGenerator(ArrayList<Brick> blist){
        bricks = blist;
    }

    public Buff GenerateBuff(String BuffType){
        
        if(BuffType.equals("Magazine")){
            Buff temp = new Buff();
            temp.generateBuff(bricks);
            Buff b = new Magazine(temp.buffXpos,temp.buffYpos);
            return b;
        }else if(BuffType.equals("Health")){
            Buff temp = new Buff();
            temp.generateBuff(bricks);
            Buff b = new Health(temp.buffXpos,temp.buffYpos);
            return b;
        }

        return null;
    }
}
