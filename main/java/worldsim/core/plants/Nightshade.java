package worldsim.core.plants;

import worldsim.core.ICollisionContext;
import worldsim.core.IWorldContext;
import worldsim.core.Position;
import javafx.scene.paint.Color;

public class Nightshade extends Plant {
    public Nightshade(Position position) {
        super(99, Color.PURPLE, position);
    }

    @Override
    protected void handleCollision(ICollisionContext collisionContext, IWorldContext worldContext) {
        collisionContext.defenderHasDied();
        collisionContext.attackerHasDied();
    }
}
