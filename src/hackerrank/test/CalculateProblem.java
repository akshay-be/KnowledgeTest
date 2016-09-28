package hackerrank.test;

import java.io.IOException;
import java.util.Scanner;

public class CalculateProblem {

}


class Calculate {
    public Scanner scanner = new Scanner(System.in);
    Output output = new Output();

    public int get_int_val() throws IOException {
        int input = readInt();
        if (input <= 0) {
            throw new NumberFormatException("All the values must be positive");
        }
        return input;
    }

    public int readInt() {
        return scanner.nextInt();
    }

     //Being forced to create volume object
    public static double get_volume(int a) {
        return new Volume().main(a);
    }
    
    public static double get_volume(int a,int b, int c) {
        return new Volume().main(a,b,c);
    }
    
    public static double get_volume(double a) {
        return new Volume().main(a);
    }
    
    public static double get_volume(double r, double h) {
        return new Volume().main(r,h);
    }

    public double get_double_val() throws IOException {
        double input = scanner.nextDouble();
        if (input <= 0) {
            throw new NumberFormatException("All the values must be positive");
        }
        return input;
    }
    
    public static Calculate do_calc()
    {
        return new Calculate();
    }
}

//Simple to the damn point volume class. No extra bs - Being unnecessarily forced to overload the damn main class
class Volume {

    //Overload for Cube
    public double main(int a) {
        return a * a * a;
    }

    //Overload for Cuboid
    public double main(int l, int b, int h) {
        return l * b * h;
    }

    //Overload for Hemisphere
    public double main(double r) {
        return (2 * Math.PI * r * r * r) / 3;
    }

    //Overload for Cylinder
    public double main(double r, double h) {
        return Math.PI * (r * r) * h;
    }
}

//Given their retarded function calls, I'm being forced to make an unnecessary Output object
class Output{
    void display(double num){
        System.out.println(String.format("%.3f", num));
    }
}