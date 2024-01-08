import java.util.Vector;

class Complex{
    double r;
    double i;
    Complex(){
        r = 0;
        i = 0;
    }
    Complex(Object real) throws NotDouble {
        if (!(real instanceof Double)){
            throw new NotDouble();
        }
        r = (double)real;
        i = 0;
    }
    Complex (Object real, Object imaginary) throws NotDouble {
        if (!(real instanceof Double) || !(imaginary instanceof Double)){
            throw new NotDouble();
        }
        r = (double)real;
        i = (double)imaginary;


    }
    private void getComplex(double re, double im){
        if (im >= 0) {
            System.out.println(re + "+" + im + "i");
        }
        else {
            System.out.println(re + "" + im + "i");
        }
    }
    void Sum(Complex complex){
        double re = r + complex.r;
        double im = i + complex.i;
        getComplex(re,im);
    }
    void Multiply(Complex complex){
        double re = r*complex.r - i*complex.i;
        double im = r*complex.i + complex.r*i;
        getComplex(re,im);
    }
    void Dividing(Complex complex){
        double re =(r*complex.r + i*complex.i)/(Math.pow(complex.r,2) + Math.pow(complex.i,2));
        double im = (i*complex.r - r*complex.i)/(Math.pow(complex.r,2) + Math.pow(complex.i,2));
        getComplex(re,im);
    }
}

public class Main {
    public static void main(String[] args) throws NotDouble {
        System.out.println("часть А");
        Vector vector1 = new Vector();
        vector1.add(2.0);
        vector1.add("dsfg");
        System.out.println(vector1);
        Vector vector2 = new Vector();
        vector2.add(3.0);
        System.out.println(vector2);
        try {
            Complex complex1 = new Complex(vector1.elementAt(0),vector1.elementAt(1));
            Complex complex2 = new Complex(vector2.elementAt(0));
            complex1.Sum(complex2);
        }
        catch (NotDouble e){
            System.out.println("Невозможно добавить комплексное число, значение не является типом Double");
        }
    }
}
