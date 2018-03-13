package P1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.io.FileWriter;
import java.io.IOException;
public class MagicSquare {
	@SuppressWarnings("unchecked")
	public static boolean IsLegalMagicSquare(String filename) throws FileNotFoundException
	{
		int n = 0;
		int wnum = 0;
		int[][] a = new int[1001][1001];
		
		File file = new File("E:\\java\\LAB1_1160300922\\src\\P1\\txt\\" + filename);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);
		
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String[] s = line.split("\t");
			
			if(wnum == 0 || wnum == s.length)
				wnum = s.length;
			else
			{
				System.out.println("words unequal!");
				return false;
			}
			
			try
			{
				for(int i = 0; i < s.length; i++)
				{
					a[n][i] = Integer.valueOf(s[i]);
					if(a[n][i] < 0)
					{
						System.out.println("number unequal!");
						return false;
					}
				}
			}catch(NumberFormatException z){
				System.out.println("format unequal!");
				return false;
			}
			
			n++;
		}
		
		if(wnum != n)
		{
			System.out.println("line unequal!");
			return false;
		}
		
		int[] sum1 = new int[n];
		for(int i = 0; i < n; i++)
		{			
			for(int j = 0; j < n; j++)
			{
				sum1[i] = sum1[i] + a[i][j];
			}
			if(i >= 2 && sum1[i] != sum1[i - 1])
			{
				System.out.println("wrong line!");
				return false;
			}
		}
		
		int[] sum2 = new int[n];
		for(int j = 0; j < n; j++)
		{
			for(int i = 0; i < n; i++)
			{
				sum2[j] = sum2[j] + a[i][j];
			}
			if(j >= 2 && sum2[j] != sum2[j - 1])
			{
				System.out.println("wrong queue!");
				return false;
			}
		}
		
		int sum3 = 0;
		for(int i = 0; i < n; i++)
			sum3 = sum3 + a[i][i];
		int sum4 = 0;
		for(int i = 0; i < n; i++)
			sum4 = sum4 + a[i][n - i - 1];
		if(sum3 != sum4)
		{
			System.out.println("wrong cross!");
			return false;
		}
		@SuppressWarnings("rawtypes")
		HashSet h = new HashSet();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				h.add(a[i][j]);
			}
		}
		if(h.size() < n * n)
		{
			System.out.println("having same number!");
			return false;
		}
		System.out.println("true!");
		return true;
	}
	public static boolean generateMagicSquare(int n) throws IOException { 
		if(n < 0)
		{
			System.out.println("it's minus!");
			return false;
		}
		else if(n % 2 == 0)
		{
			System.out.println("it's even!");
			System.exit(0);
		}
		int magic[][] = new int[n][n];   
		int row = 0, col = n / 2, i, j, square = n * n; 		 
	    for (i = 1; i <= square; i++) 
        {    
	     	magic[row][col] = i;    
			if (i % n == 0)    
			    row++;    
			else 
			{     
				if (row == 0)      
					row = n - 1;     
				else      
					row--;    
				if (col == (n - 1))    
					col = 0;    
				else     
					col++; 
			}  
		} 		 
		for (i = 0; i < n; i++)
		{   
		    for (j = 0; j < n; j++)    
				System.out.print(magic[i][j] + "\t");    
			System.out.println();  
		}
			FileWriter writer = new FileWriter("E:\\java\\LAB1_1160300922\\src\\P1\\txt\\6.txt", true);
			for(int k = 0; k < n; k++)
			{
				for(int m = 0; m < n; m++)
				{
					writer.write(magic[k][m] + "\t");
				}
				writer.write("\n");
			}
			writer.close();		
		return true; 
	} 
	public static void main(String[] args) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		IsLegalMagicSquare("1.txt");
		IsLegalMagicSquare("2.txt");
		IsLegalMagicSquare("3.txt");
		IsLegalMagicSquare("4.txt");
		IsLegalMagicSquare("5.txt");
		generateMagicSquare(n);
		IsLegalMagicSquare("6.txt");
	}
}
