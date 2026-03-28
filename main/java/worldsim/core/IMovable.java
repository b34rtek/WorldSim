package worldsim.core;

public interface IMovable {
    Position getPosition();
    void moveTo(Position position);
}
