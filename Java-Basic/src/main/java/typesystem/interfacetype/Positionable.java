package typesystem.interfacetype;

interface Centered{}
interface Scalable{}
interface Translatable{}
interface Rotatable{}
public interface Positionable extends Centered {
    void setUpperRightCorner(double x, double y);
    double getUpperRightX();
    double getUpperRightY();
}
interface Transformable extends Scalable, Translatable, Rotatable {}
interface SuperShape extends Positionable, Transformable {}