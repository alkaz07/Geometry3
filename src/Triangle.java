public class Triangle {
    Point vertex1, vertex2, vertex3;

    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    public double perimeter(){
        return vertex1.distanceTo(vertex2) + vertex2.distanceTo(vertex3) + vertex3.distanceTo(vertex1);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", vertex3=" + vertex3 +
                '}';
    }

    public double area(){
        double p = perimeter()/2;
        double ab = vertex1.distanceTo(vertex2);
        double bc = vertex2.distanceTo(vertex3);
        double ac = vertex1.distanceTo(vertex3);
        return Math.sqrt(p*(p-ab)*(p-ac)*(p-bc));
    }
}
