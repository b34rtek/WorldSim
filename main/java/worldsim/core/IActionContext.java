package worldsim.core;

import worldsim.IGUIContext;
import worldsim.core.animals.Animal;

import java.util.stream.Stream;

public interface IActionContext extends IWorldContext {
    int getNumberOfLivingOrganisms();
    Stream<Animal> getNearbyAnimals(Position position);
    Stream<Organism> getNearbyOrganisms(Position position);
    IGUIContext getGUIContext();
}
