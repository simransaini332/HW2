package sortingofarray;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class sortarray {
	static void sort(List<String> arr)
	{  int flag=0;
	for(int k=0;k<arr.size();k++)
	{
	  for(int a=0;a<(arr.size()-1);a++)
	  { 
		 String str1=arr.get(a);
		 String str2=arr.get(a+1);
		 int j=0;
		 while(j<str1.length() && j<str2.length())
		 {
		  	if(str1.charAt(j)>str2.charAt(j))
		  	{
		  	 arr.set(a,str2);
		  	 arr.set(a+1,str1); 
		  	 flag=1;
		  	 break;
		     }
		  	if(str1.charAt(j)<str2.charAt(j))
		  		break;
		  	j++; 
	     } 	
	}
	 if(flag==0)
		  break; 
}
	}
	static boolean search(List<String> arr,String keyword)
	{	
	boolean ans=false;
	for(int i=0;i<arr.size();i++)
	{
      if(arr.get(i).equals(keyword))
      {
    	  ans=true;
    	  break;
      }
		
	}
	 /*int l=0;
	 int b=arr.size()-1;
	int m=l+((b-l)/2);

	 while(l<b)
	 {
	   if((arr.get(m)).equals(keyword))	
		   {ans=true;
		   System.out.println(keyword);
		   break;
		   }
		   
	   else 
	   {
			String str1=arr.get(m);
			int j=0;
			 while(j<str1.length() && j<keyword.length())
			{
			 if(keyword.charAt(j)>str1.charAt(j))
			 {//System.out.println(arr.get(m)+"*");
			   l=m+1;
			   break;
			 }
			 if(keyword.charAt(j)<str1.charAt(j))
			 {
				b=m-1; 
				break;
			 }
			 j++;
			}
	   }
	   m=l+((b-l)/2);
	
	 }*/
	   
	return ans;
	}
	public static void main(String[] args) throws IOException
	{
	 List<String> dictionary = new ArrayList<String>();
	 List<String> keyword = new ArrayList<String>();
	 File file1=new File("C:\\Users\\hp\\Desktop\\csx-351-hw2-simrankaur-master\\HW2-keywords.txt");
	 File file2=new File("C:\\Users\\hp\\Desktop\\csx-351-hw2-simrankaur-master\\HW2-dictionary.txt");
	 Scanner sc1=new Scanner(file1);
	 Scanner sc2=new Scanner(file2);
	int i=0;
	while(sc2.hasNextLine())
	{
		 dictionary.add(sc2.nextLine());	
	}
	while(sc1.hasNextLine())
	{
		 keyword.add(sc1.nextLine());	
	}
	
	sort(keyword);
	//System.out.println("hello");
	sort(dictionary);
	
	sc1.close();
	sc2.close();
	FileWriter fw = new FileWriter("C:\\Users\\hp\\Desktop\\csx-351-hw2-simrankaur-master\\data.txt");
	int c=0;
	for(i=0;i<keyword.size();i++)
	{
		boolean ans=search(dictionary,keyword.get(i));
		//System.out.println(ans);
		if(ans==false)
		{
		 fw.write("keyword not found:");
		 fw.write(keyword.get(i));
		 fw.write(System.getProperty( "line.separator" ));
		 c++;
		}	
	}
	fw.write(" Number of keyword not found:");
	fw.write(String.valueOf(c));
	fw.write(System.getProperty( "line.separator" ));
	fw.close();
}
}