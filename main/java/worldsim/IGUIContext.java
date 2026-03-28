package worldsim;

import worldsim.core.Log;
import worldsim.core.Organism;
import worldsim.core.Position;

import java.util.stream.Stream;

public interface IGUIContext {
    void clearScreen();
    void drawOrganism(Organism organism);
    void setupHumanControls(Stream<Position> allNearbyPositions);
    void stopGame();
    void log(Log log);
}

