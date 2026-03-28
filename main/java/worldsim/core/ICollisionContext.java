package worldsim.core;

import worldsim.core.animals.Animal;

public interface ICollisionContext {
    Animal getAttacker();
    void cancel();
    void defenderHasEvaded();
    void defenderHasDied();
    void attackerHasDied();
    boolean isResolved();
    CollisionResult getResult();
}
