module worldsim {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens worldsim to javafx.fxml;
    exports worldsim;
    exports worldsim.controllers;
    exports worldsim.core;
    exports worldsim.core.animals;
    exports worldsim.core.plants;
    opens worldsim.controllers to javafx.fxml;
    exports worldsim.core.positions;
}