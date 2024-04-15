import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Triangle> triangles = inputTriangles(2);
        //System.out.println(triangles);
        //double avgPerim = averagePerimeter(triangles);
        //System.out.println(avgPerim);
        ArrayList<Triangle> triangles2 = readTriangles("trtrtr.txt");
        System.out.println(triangles2);
        double sumS = sumArea(triangles2);
        System.out.println(sumS);
    }

    private static double sumArea(ArrayList<Triangle> triangles) {
        double sumS = 0;
        for (Triangle t : triangles) {
            sumS += t.area();
        }
        return sumS;
    }

    private static ArrayList<Triangle> readTriangles(String file) {
        try {
            Scanner scanner = new Scanner(new File(file));
            ArrayList<Triangle> triangles = new ArrayList<>();
            while(scanner.hasNext()) {
                String s = scanner.nextLine();
                Triangle t = makeTrFromStr(s);
                triangles.add(t);
            }
            return triangles;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private static Triangle makeTrFromStr(String s) {
        Scanner scanner = new Scanner(s);
        double x, y;
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        Point v1 = new Point(x, y);
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        Point v2 = new Point(x, y);
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        Point v3 = new Point(x, y);
        return new Triangle(v1, v2, v3);
    }

    private static double averagePerimeter(ArrayList<Triangle> triangles) {
        double sumP = 0;
        for (Triangle t : triangles) {
            sumP += t.perimeter();
        }
        return sumP / triangles.size();
    }

    public static ArrayList<Triangle> inputTriangles(int kolvo) {

        System.out.println("Введите треугольники");
        ArrayList<Triangle> triangles = new ArrayList<>(kolvo);
        for (int i = 0; i < kolvo; i++) {
            Triangle t = inputTr();
            triangles.add(t);
        }
        return triangles;
    }

    private static Triangle inputTr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите кординаты вершин треугольника");
        double x, y;
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        Point v1 = new Point(x, y);
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        Point v2 = new Point(x, y);
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        Point v3 = new Point(x, y);
        return new Triangle(v1, v2, v3);
    }
}