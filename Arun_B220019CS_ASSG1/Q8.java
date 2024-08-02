import java.util.Scanner;

public class Q8{
    
    public static void main(String args[]){
        
        System.out.print("Enter 2D array size : ");
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of rows : ");
        int rows=sc.nextInt();
        
        System.out.print("Enter number of columns : ");
        int columns=sc.nextInt();

        System.out.println("Enter array elements : ");    
        
        int matA[][]=new int[rows][columns];
        int matB[][]=new int[columns][rows];
        

        for(int i=0; i<rows;i++)
        {            
            for(int j=0; j<columns;j++)
            {
                matA[i][j]=sc.nextInt();
                matB[j][i] = matA[i][j];
            }
        }

        System.out.print("Matrix A : \n");
        for(int []x : matA){
            for(int y : x){
                System.out.print(y+"        ");
            }
            System.out.println();
        }

        System.out.print("Transposed Matrix B : \n");
        for(int []x : matB){
            for(int y : x){
                System.out.print(y+"        ");
            }
            System.out.println();
        }
    }  
    
}