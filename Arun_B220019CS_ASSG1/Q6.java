import java.util.Scanner;
class Q6{  
    public static void main(String args[])  
    {    
        long n1 = 0, n2 = 1, n3, i;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int count = sc.nextInt();

        System.out.print(n1+" "+n2);
            
        for(i=2;i<count;++i)
        {    
            n3=n1+n2;    
            System.out.print(" "+n3);    
            n1=n2;    
            n2=n3;    
        }    

        System.out.println();
    }
}      