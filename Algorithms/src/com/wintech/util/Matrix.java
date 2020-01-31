/**
 * @author Prabu
 * @date Mar 19, 2012
 */
package com.wintech.util;

import com.wintech.io.StdOut;

public class Matrix {
    /**
     * Vector dot product
     * 
     * @param x
     * @param y
     * @return 
     * @throws IllegalArgumentException, if vector sizes are not match.
     */
    public static double dot(double[] x, double[] y) {
        if(x.length != y.length)
            throw new IllegalArgumentException("Vector size should match.");
        
        double result = 0;
        for(int i = 0; i < x.length; i++) {
            result += (x[i] * y[i]);
        }
        return result;
    }
    
    /**
     * Matrix - Matrix product
     * 
     * @param x
     * @param y
     * @return 
     * @throws  IllegalArgumentException, if row of first matrix 
     *          and column of second matrix is not match.
     */
    public static double[][] multiply(double[][] x, double[][] y) {
        if(x[0].length != y.length)
            throw new IllegalArgumentException("Matrix sizes are not valid for multiply.");
        
        int rows = x.length; // first dimension of x
        int cols = y[0].length; // second dimension of y
        double[][] result = new double[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                for(int k = 0; k < y.length; k++) {
                    result[i][j] += (x[i][k] * y[k][j]);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Matrix - Vector product
     * 
     * @param x
     * @param y
     * @return 
     * @throws  IllegalArgumentException, if columns of matrix not match with
     *          vector size.
     */
    public static double[] multiply(double[][] a, double[] x) {
        if(x.length != a[0].length)
            throw new IllegalArgumentException("Matrix & Vector sizes are not valid for multiply.");
        
        int rows = a.length; // row of matrix would be size of result vector
        double[] result = new double[rows];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < x.length; j++) {
                result[i] += (a[i][j] * x[j]);
            }
        }
        
        return result;
    }

    /**
     * Transpose of a matrix
     * 
     * @param a
     * @return 
     */
    public static double[][] transpose(double[][] a) {
        int rows = a[0].length; // column of matrix a
        int cols = a.length;    // row of matrix a
        double[][] result = new double[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = a[j][i];
            }
        }
        
        return result;
    }
    
    /**
     * Test client
     * @param args 
     */
    public static void main(String[] args) {
        // Vector product
        double[] x = {14, 9, 3};
        double[] y = {12, 9, 8};
        StdOut.println("Vector - x: ");
        StdOut.print(x);
        StdOut.println("Vector - y: ");
        StdOut.print(y);
        StdOut.println("Vector dot product: " + Matrix.dot(x, y));
        
        // Matrix-matrix mutiply
        double[][] a = {{14,  9,  3},
                        { 2, 11, 15},
                        { 0, 12, 17},
                        { 5,  2,  3}};
        double[][] b = {{12, 25},
                        { 9, 10},
                        { 8,  5}};
        StdOut.println();
        StdOut.println("Matrix - A: ");
        StdOut.print(a);
        StdOut.println("Matrix - B: ");
        StdOut.print(b);
        StdOut.println("A x B: ");
        StdOut.print(Matrix.multiply(a, b));
        
        // matrix transpose
        StdOut.println();
        StdOut.println("Transpose - A: " );
        StdOut.print(Matrix.transpose(a));
        StdOut.println("Transpose - B: " );
        StdOut.print(Matrix.transpose(b));
        
        // Matrix-vector product
        double[][] c = {{1, -1, 2},
                        {0, -3, 1}};
        double[] v = {2, 1, 0};
        StdOut.println();
        StdOut.println("Matrix - C: ");
        StdOut.print(c);
        StdOut.println("Vector - V: ");
        StdOut.print(v);
        StdOut.println("C x V: ");
        StdOut.print(Matrix.multiply(c, v));
    }
}
