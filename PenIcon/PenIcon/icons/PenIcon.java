import java.util.Scanner;
import java.io.*;

class PenIcon
{
static String path="";
final static String nn=System.getProperty("line.separator");
static String dnm;
static String iname;


/*-------------------------------Making icon Folder-----------------------------------------------*/
static void folder() throws Exception
{
path=dnm+":\\icon";
File ff=new File(path);
ff.mkdirs();
}


/*-------------------------------Making autorun.inf File-------------------------------------------*/
static void ifile()  throws Exception
{
FileOutputStream fout=new FileOutputStream(dnm+":\\autorun.inf");
String data="[autorun]"+nn+"Icon=icon/"+iname;
byte bt[]=data.getBytes();
fout.write(bt);
}


/*-------------------------------Copying Icon--------------------------------------------------------*/
static void icopy()  throws Exception
{
FileInputStream fin=new FileInputStream("icons\\"+iname);
FileOutputStream fout=new FileOutputStream(path+"\\"+iname);
int i;
while((i=fin.read())!=-1)
fout.write(i);
line('-');
System.out.println(" Pendrive Icon changed Successfully");
}


/*-----------------------------------Icon List--------------------------------------------------------------*/
static String[] ilist()
{
File ff[]=new File("icons").listFiles();
int a=0;
for(File fc:ff)
a++;
String nm[]=new String[a];
int b=0;
for(File fl:ff)
{
nm[b]=fl.getName();
b++;
}
return nm;
}


/*-----------------------------------------------Valid or Not----------------------------------------*/
static boolean valid()  
{
try{FileOutputStream foutt=new FileOutputStream(dnm+":\\autorun.inf");  return true;}
catch(Exception e){System.out.println("This drive does not exist"); line('='); return false;}
}


/*------------------------------Line--------------------------------*/
static void line(char a)
{
for(int i=0;i<50;i++)
System.out.print(a);
System.out.println("");
}


/*__________________________________________________________________*/
/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Main Method^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/
/*`````````````````````````````````````````````````````````````````````````````````````````````````````````````````*/

public static void main(String as[]) throws Exception
{
Scanner sc=new Scanner(System.in);

line('`');
System.out.println("\t\tWelcome to PenIcon ");
line('=');



/*------------------------------Drive name input--------------------------------------------------*/
do
{
System.out.print("Enter your drive name :- ");
dnm=sc.next();
dnm.toUpperCase();
}while(!valid());


String list[]=ilist();
int no=1;
line('*'); System.out.println("\t\tIcon List"); line('*');
for(String ina:list)
{
System.out.println("("+no+")  "+ina+"\b\b\b\b\t");
no++;
}

int val;
do
{
line('~');
System.out.print("Select your icon ");
int az=sc.nextInt();
try{iname=list[az-1]; val=1;} 
catch(ArrayIndexOutOfBoundsException ar){System.out.println("Invalid Choise"); val=0;}
}while(val==0);


folder();
ifile();
icopy();

line('-');
System.out.println(" Thanks for using this program....");
line('~');
Thread.sleep(5000);

}  //main end
}  //class end