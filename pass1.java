import java.io.*;
import java.util.*;

class pass1
{
 
 public static void main(String args[])throws Exception
 { 
  int loc=0;
  int j=0,k,s;
  FileReader f1=new FileReader("input.txt");
  BufferedReader b1=new BufferedReader(f1); 

  FileReader f2=new FileReader("optab.txt");
  BufferedReader b2=new BufferedReader(f2);

  FileWriter f3=new FileWriter("symtab.txt");
  BufferedWriter b3=new BufferedWriter(f3);

  FileWriter f4=new FileWriter("intermediate.txt");
  BufferedWriter  b4=new BufferedWriter(f4);

  StringBuffer sb = new StringBuffer();
  String s3,s4,tmp,sd,sl;
  String s1[]=new String[3];
  String s2[]=new String[3];
  while((s=b1.readLine())!=null)
  { 
    int m=0;
   StringTokenizer st=new StringTokenizer(s);
   while(st.hasMoreTokens())
   {
    s1[m]=st.nextToken();
    m++;
   }
   if(s1[1].equals("START"))
   {
    b4.write("   ");
    for(int h=0;h<3;h++)
    {   
     b4.write("  ");
     b4.write("  "+s1[h]);
    }
    loc=Integer.parseInt(s1[2]);
    b4.newLine();
   }
   else 
   {
    b4.write(loc+"  ");
    if(s1[0].equals("-")!=true) 
    {
     b3.write(" "+s1[0]);
     b3.write(loc+" ");
    }
    while((sl=b2.readLine())!=null)     
    {
     j=0;
     StringTokenizer se=new StringTokenizer(sl);
     while(se.hasMoreTokens())
     {
      s2[j]=se.nextToken();
      j++;
     }
     if(s1[1].equals(s2[0])==true)
     loc=loc+3;
     break; 
    }
    if(s1[1].equals("BYTE"))
     loc=loc+1;
    else if(s1[1].equals("RESB"))
     loc=loc+(1*Integer.parseInt(s1[2]));
    else if(s1[1].equals("WORD"))
     loc=loc+3;
    else if(s1[1].equals("RESW"))
     loc=loc+(3*Integer.parseInt(s1[2]));
    for(int a=0;a<3;a++) 
    {
     b4.write("  ");
     b4.write("   "+s1[a]);
    }
    b4.newLine();
    b3.newLine();
   }
 }
b4.close();
b3.close();
}
}
