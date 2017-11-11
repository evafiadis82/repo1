package Samples;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Median {

  
  public static void insertSorted(List<Integer> arr, int n) {
    
    int i = 0;
    
    while ( i < arr.size() && n > arr.get(i)) 
    	++i;
    
        arr.add(i, n);
  }
  
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); 
    int m = 0;
    int n = 0;
    List<Integer> gt = new ArrayList<Integer>();
    List<Integer> lt = new ArrayList<Integer>();
    
    for (int i = 1; i <= N; ++i) {
      n = sc.nextInt();
      if (i == 1) {
        m = n;
      }
      else if (i%2 == 0) {
        if (n > m) {
          // Insert to gt list
          insertSorted(gt, n);
          // Insert median to the end of the lt list
          lt.add(lt.size(), m); 
          // create "fake" median element
          m = (m + gt.get(0))/2;
        }
        else if (n < m) {
          // Insert to lt list
          insertSorted(lt, n);
          // Insert median to the beginning of the gt list
          gt.add(0, m);
          // create "fake" median element
          m = (m + lt.get(lt.size() - 1))/2;
        }
        else {
            insertSorted(lt, n);
            insertSorted(gt, n);
        }
      }
      else {
        if (n > m) {
          insertSorted(gt, n);
          m = gt.get(0);
          gt.remove(0);
        } 
        else if (n < m) {
          insertSorted(lt, n);
          m = lt.get(lt.size() - 1);
          lt.remove(lt.size() - 1);
        }
        else {
          m = n;
        }
        
      }
      System.out.println(m);
    }

  }
}
