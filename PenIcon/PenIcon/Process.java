import java.io.*;
import java.util.StringTokenizer;
class Process extends Thread
{
final static String nn=System.getProperty("line.separator");
static long length;

Process(long len)
{
length=len;
}




public void run() 
{
try{pro(length);} catch(Exception e){}
System.out.println("");
line('"');
System.out.println("\n Pendrive Icon changed Successfully\n");
line('-');
System.out.println("\n Thanks for using this program....");
line('~');
try{Thread.sleep(2000);} catch(Exception e) {}
}



/*------------------------------------------Line-------------------------------------------------*/
static void line(char a)
{
for(int i=0;i<100;i++)
System.out.print(a);
}


static void pro(long ln) throws Exception
{
long lg=(long)(ln/4700);

line('_');
System.out.println("");
for(int i=0;i<100;i++)
{
for(int j=0;j<=i;j++)
System.out.print("#");

for(int k=99;k>i;k--)
System.out.print(" ");

System.out.print("["+(i+1)+"]% "+((lg/10)-((lg*(i+1))/1000))+ " sec left");
Thread.sleep(lg);
System.out.print("\r");
}
}




}

