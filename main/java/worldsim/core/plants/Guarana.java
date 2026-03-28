package worldsim.core.plants;

import worldsim.core.ICollisionContext;
import worldsim.core.IWorldContext;
import worldsim.core.Position;
import javafx.scene.paint.Color;

public class Guarana extends Plant {
    public Guarana(Position position) {
        super(0, Color.ORANGERED, position);
    }

    @Override
    protected void handleCollision(ICollisionContext collisionContext, IWorldContext worldContext) {
        worldContext.log(String.format("%s has been consumed which increased %s's strength", getName(), collisionContext.getAttacker().getName()));
        collisionContext.getAttacker().increaseStrength(3);
        collisionContext.defenderHasDied();
    }
}
