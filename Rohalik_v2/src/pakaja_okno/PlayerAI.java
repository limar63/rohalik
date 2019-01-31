package pakaja_okno;

public class PlayerAI extends CreatureAI {

    public PlayerAI(Creature creature) {
    super(creature);
    }
    
    public void onEnter(int x, int y, Kletki kletki){
        if (kletki.isGround()){
            creature.x = x;
            creature.y = y;
        } else if (kletki.isDiggable()) {
            creature.dig(x, y);
        }
    }
}