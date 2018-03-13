import java.awt.*;
import java.io.*;
import java.net.*;
class server implements Runnable
{
BufferedReader br1,br2;
PrintWriter pw1;
Thread t1,t2;
String st1,st2;
ServerSocket ss;
Socket s;
public server()
    {
    try {
    t1=new Thread(this);
    t2=new Thread(this);
    ss=new ServerSocket(5151);
    s=ss.accept();
    br1=new BufferedReader(new InputStreamReader(System.in));
    br2=new BufferedReader(new InputStreamReader(s.getInputStream()));
    pw1=new PrintWriter(s.getOutputStream(),true);
    t1.start();
    t2.start();
    }
   catch(Exception ee)
    {
    System.out.println(ee);
    }
    }
public void run()
    {
                    try {
    if(Thread.currentThread()==t1)
        {
    do  {
        st2=br2.readLine();
        System.out.println("Client:"+st2);
        }while(!st2.equals("exit"));
        }
    else
        {
        while(true)
            {
            st1=br1.readLine();
            pw1.println(st1);
            Thread.sleep(10);
            }
        }
    }
    catch(Exception ee) 
    {
    System.out.println(ee);
    }
    }
 
public static void main(String arg[])
    {
    new server();
    }
}
