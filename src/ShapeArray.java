abstract class Shape {
    protected double radius;

    public Shape(double radius) {
        this.radius = radius;
    }
    // Why are these necessary in our implementation? Solely just to override?
    public abstract double surfaceArea();
    public abstract double volume();
}

class Sphere extends Shape {
    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }
    // toString could probably be condensed/reused in the program with shared formatting
    @Override
    public String toString() {
        // Simplifying previous formatting
        // Old return: return "Sphere:\nRadius=" + radius + "\nSurface Area=" + surfaceArea() + "\nVolume=" + volume() + "\n";
        return String.format("Sphere:%nRadius=%.2f%nSurface Area=%.4f%nVolume=%.4f%n",
                radius, surfaceArea(), volume());
    }
}

class Cylinder extends Shape {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        // Simplifying previous formatting
        // Old return: return "Cylinder:\nRadius=" + radius + "\nHeight=" + height + "\nSurface Area=" + surfaceArea() + "\nVolume=" + volume() + "\n";
        return String.format("Cylinder:%nRadius=%.2f%nHeight=%.2f%nSurface Area=%.4f%nVolume=%.4f%n",
                radius, height, surfaceArea(), volume());
    }
}

class Cone extends Shape {
    private double height;

    public Cone(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height / 3;
    }

    @Override
    public String toString() {
        // Simplifying previous formatting
        // Old return: return "Cone:\nRadius=" + radius + "\nHeight=" + height + "\nSurface Area=" + surfaceArea() + "\nVolume=" + volume() + "\n";
        return String.format("Cone:%nRadius=%.2f%nHeight=%.2f%nSurface Area=%.4f%nVolume=%.4f%n",
                radius, height, surfaceArea(), volume());
    }
}

public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[3];
        shapeArray[0] = new Sphere(5.0);
        shapeArray[1] = new Cylinder(3.0, 7.0);
        shapeArray[2] = new Cone(4.0, 6.0);

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}