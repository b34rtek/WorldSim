package worldsim.core;

import java.io.Serializable;

public record Log(int round, String message) implements Serializable {}
