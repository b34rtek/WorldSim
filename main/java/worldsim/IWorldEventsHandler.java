package worldsim;

import worldsim.core.World;

public interface IWorldEventsHandler {
    IGUIContext getGUIContext();
    void updateWorld(World world);
}
