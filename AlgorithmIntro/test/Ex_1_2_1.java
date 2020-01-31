/**
 * @author Prabu
 * @date Mar 12, 2012
 */

public class Ex_1_2_1 {
    public static void main(String[] args) {
        int N = 10;
        
        Point2D[] points = new Point2D[N];
        double minDistance = Double.MAX_VALUE;
        double curDistance;
        for(int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            System.out.println("Point-" + i + ": " + points[i]);
            for(int j = i - 1; j >= 0; j--) {
                curDistance = points[i].distanceTo(points[j]);
                if(curDistance < minDistance) {
                    minDistance = curDistance;
                    System.out.println("Distance between " + points[i] 
                            + " and " + points[j] + " is " + minDistance);
                }
            }
        }
        
        System.out.println("Final minimum distance: " + minDistance);
    }
}
