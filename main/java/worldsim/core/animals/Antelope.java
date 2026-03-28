package worldsim.core.animals;

import worldsim.core.IActionContext;
import worldsim.core.ICollisionContext;
import worldsim.core.IWorldContext;
import worldsim.core.Position;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;

public class Antelope extends Animal {
    public Antelope(Position position) {
        super(4, 4, Color.ALICEBLUE, position);
    }

    @Override
    protected void handleAction(IActionContext context) {
        context.getRandomNearbyPosition(getPosition(), false, 2)
                .ifPresent(value -> context.move(this, value));
    }

    @Override
    protected void handleCollision(ICollisionContext collisionContext, IWorldContext worldContext) {
        super.handleCollision(collisionContext, worldContext);

        if (collisionContext.isResolved()) {
            return;
        }

        if (ThreadLocalRandom.current().nextBoolean()) {
            worldContext.getRandomNearbyPosition(getPosition(), true)
                    .ifPresent(newPosition -> {
                        worldContext.log(String.format("%s escaped!", getName()));
                        worldContext.move(this, newPosition);
                        collisionContext.defenderHasEvaded();
                    });
        }
    }
}
