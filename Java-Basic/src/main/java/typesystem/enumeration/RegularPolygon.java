package typesystem.enumeration;

import java.awt.*;
import java.io.Serializable;

public enum RegularPolygon {
    // The ; is mandatory for enums that have parameters
    TRIANGLE(3), SQUARE(4), PENTAGON(5), HEXAGON(6);


    private Shape shape;
    public Shape getShape() {
        return shape;
    }
    private RegularPolygon(int sides) {
        switch (sides) {
            case 3:
                // We assume that we have some general constructors
                // for shapes that take the side length and
                // angles in degrees as parameters
                //shape = new Triangle(1,1,1,60,60,60);
                break;
            case 4:
                shape = new Rectangle(1,1);
                break;
            case 5:
                //shape = new Pentagon(1,1,1,1,1,108,108,108,108,108);
                break;
            case 6:
                //shape = new Hexagon(1,1,1,1,1,1,120,120,120,120,120,120);
                break;
        }
    }
}