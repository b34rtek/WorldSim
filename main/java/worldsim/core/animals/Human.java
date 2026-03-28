package worldsim.core.animals;

import worldsim.core.*;
import worldsim.core.Position;
import javafx.scene.paint.Color;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Human extends Animal {
    private boolean isSpecialPowerActive = false;
    private int specialPowerTimer = 0;

    public Human(Position position) {
        super(5, 4, Color.LIGHTCYAN, position);
    }

    @Override
    protected void handleAction(IActionContext context) {
        specialPowerTick(context);

        context.getGUIContext().setupHumanControls(getPosition().getAllNearbyPositions(1));
    }

    @Override
    public worldsim.core.Color getColor() {
        if (isSpecialPowerActive) {
            return new worldsim.core.Color(javafx.scene.paint.Color.DARKORANGE);
        }else {
            return super.getColor();
        }
    }

    public int getSpecialPowerTimer() {
        return specialPowerTimer;
    }

    public void tryToActivateSpecialPower(IActionContext context) {
        if (!isSpecialPowerActive && specialPowerTimer == 0) {
            context.log("Human special power actived!");
            isSpecialPowerActive = true;
            specialPowerTimer = 5;
        }

    }

    @Override
    protected void handleCollision(ICollisionContext collisionContext, IWorldContext worldContext) {
        super.handleCollision(collisionContext, worldContext);

        if (collisionContext.isResolved()) {
            return;
        }

        if (isSpecialPowerActive) {
            worldContext.log(String.format("%s Human pushed an organism using the superpower!at %s!", getName(), getPosition()));
            collisionContext.cancel();
        }else {
            collisionContext.defenderHasDied();
        }
    }

    private void specialPowerTick(IActionContext context) {
        specialPowerTimer = Math.max(0, specialPowerTimer - 1);

        if (specialPowerTimer == 0 && isSpecialPowerActive) {
            context.log("Human special power disabled");
            isSpecialPowerActive = false;
            specialPowerTimer = 5;
        }
    }


}


