
import java.text.DecimalFormat;

public class RungeKutta4 {

    // Define the differential equation dy/dx = sin(2x) - y * tan(x)
    public static double f(double x, double y) {
        return Math.sin(2 * x) - y * Math.tan(x);
    }

    // Runge-Kutta 4th Order Method
    public static void rungeKutta4(double x0, double y0, double h, int steps) {
        double x = x0;
        double y = y0;

        // For formatting output to 6 decimal places
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println("x\t\ty (RK4)");
        System.out.println(df.format(x) + "\t" + df.format(y));

        for (int i = 1; i <= steps; i++) {
            double k1 = h * f(x, y);
            double k2 = h * f(x + h / 2, y + k1 / 2);
            double k3 = h * f(x + h / 2, y + k2 / 2);
            double k4 = h * f(x + h, y + k3);

            // Update y and x
            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x = x + h;

            // Print the result at each step
            System.out.println(df.format(x) + "\t" + df.format(y));
        }
    }

    public static void main(String[] args) {
        double x0 = 0.0;  // Initial x value
        double y0 = 1.0;  // Initial y value
        double h = 0.1;   // Step size
        int steps = 10;   // Number of steps

        System.out.println("Solving dy/dx = sin(2x) - y * tan(x) using RK4:");
        rungeKutta4(x0, y0, h, steps);
    }
}
