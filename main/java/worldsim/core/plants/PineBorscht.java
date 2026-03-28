package worldsim.core.plants;

import worldsim.core.*;
import javafx.scene.paint.Color;
import worldsim.core.IActionContext;
import worldsim.core.ICollisionContext;
import worldsim.core.IWorldContext;
import worldsim.core.Position;

public class PineBorscht extends Plant {
    public PineBorscht(Position position) {
        super(10, Color.GRAY, position);
    }

    @Override
    protected void handleAction(IActionContext context) {
        context.getNearbyAnimals(getPosition())
                .forEach(context::kill);
        super.handleAction(context);
    }

    @Override
    protected void handleCollision(ICollisionContext collisionContext, IWorldContext worldContext) {
        collisionContext.defenderHasDied();
        collisionContext.attackerHasDied();
    }
}
