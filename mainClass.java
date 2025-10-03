abstract class Shape {
    String name;
    Shape(String name) {this.name = name;}
    void print() {
        System.out.println(name + "(" + dims() + ") : " + area());
        System.out.println();
    }
    abstract String dims();
    abstract double area();
    abstract void draw();
}

class Circle extends Shape {
    int radius;
    Circle(String name, int radius) {
        super(name);
        this.radius = radius;
    }
    String dims() {
        return String.valueOf(radius);
    }
    double area() {
        return 3.14 * radius * radius;
    }
    void draw() {
        System.out.println("       ***   ");
        System.out.println("   *         *");
        System.out.println(" *             *");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println(" *             *");
        System.out.println("   *         *");
        System.out.println("       ***   ");
    }
}

class Triangle extends Shape {
    int base, height;
    Triangle(String name, int base, int height) {
        super(name);
        this.base = base;
        this.height = height;
    }
    String dims() {
        return base + ", " + height;
    }
    double area() {
        return (base * height) / 2;
    }
    void draw() {
        System.out.println("        *   ");
        System.out.println("      *   *  ");
        System.out.println("     *     * ");
        System.out.println("    *       * ");
        System.out.println("   *         * ");
        System.out.println("  *           * ");
        System.out.println(" *             * ");
        System.out.println("*****************");
    }
}

class Square extends Shape {
    int side;
    Square(String name, int side) {
        super(name);
        this.side = side;
    }
    String dims() {
        return String.valueOf(side);
    }
    double area() {
        return side * side;
    }
    void draw() {
        System.out.println("*****************");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*****************");
    }
}

class Rectangle extends Square {
    int width;
    Rectangle(String name, int side, int width) {
        super(name, side);
        this.width = width;
    }
    String dims() {
        return side + ", " + width;
    }
    double area() {
        return side * width;
    }
    void draw() {
        System.out.println("**********************");
        System.out.println("*                    *");
        System.out.println("*                    *");
        System.out.println("*                    *");
        System.out.println("*                    *");
        System.out.println("**********************");
    }
}

class ListNode {
    Shape shape;
    ListNode next;
    ListNode(Shape shape, ListNode next) {
        this.shape = shape;
        this.next = next;
    }
}

class Picture {
    ListNode head;
    Picture() {
        head = null;
    }
    void add(Shape sh) {
        head = new ListNode(sh, head);
    }
    void printAll() {
        for (ListNode shape_node = head; shape_node != null; shape_node = shape_node.next) {
            shape_node.shape.print();
        }
    } 
    void drawAll() {
        for (ListNode shape_node = head; shape_node != null; shape_node = shape_node.next) {
            shape_node.shape.draw();
        }
    }
    double totalArea() {
        double sum_area = 0.0;
        for (ListNode shape_node = head; shape_node != null; shape_node = shape_node.next) {
            sum_area += shape_node.shape.area();
        }
        return sum_area;
    }
}

public class mainClass {
    public static void main(String[] args) {
        int arg1 = Integer.valueOf(args[0]);
        int arg2 = Integer.valueOf(args[1]);
        int arg3 = arg1 - 1;
        int arg4 = arg2 - 1;
        Picture pic = new Picture();
        pic.add(new Rectangle("SecondRectangle", arg3, arg4));
        pic.add(new Rectangle("FirstRectangle", arg1, arg2));
        pic.add(new Square("SecondSquare", arg3));
        pic.add(new Square("FirstSquare", arg1));
        pic.add(new Circle("SecondCircle", arg3));
        pic.add(new Circle("FirstCircle", arg1));
        pic.add(new Triangle("SecondTriangle", arg3, arg4));
        pic.add(new Triangle("FirstTriangle", arg1, arg2));
        pic.printAll();
        pic.drawAll();
        System.out.println("Total : " + pic.totalArea());
    }
}
