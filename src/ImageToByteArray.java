import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;
public class ImageToByteArray {
    public static void main(String args[]) throws Exception{
        Scanner sc=new Scanner(System.in);
        int i,j,k,l=0,change,count=0,p,q;
        int a[]=new int[8];
        int m[]=new int[10000000];
        for(p=0;p<m.length;p++)
        {
            m[p]=5;
        }
        BufferedImage bImage = ImageIO.read(new File("src/res/123.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        FileWriter fw=new FileWriter("out.txt");
        for(i=0;i<data.length;i++)
        {
            change=data[i];
            if(change<0)
            {
                change+=256;
            }
            j=7;
            while(change>0)
            {
                a[j]=change%2;
                change/=2;
                j--;
            }
            for(k=0;k<8;k++)
            {
                count++;
                if(a[k]==1)
                {
                    m[l++]=1;
                    fw.write(" 1");
                }
                else
                {
                    m[l++]=0;
                    fw.write(" 0");
                }
            }
            for(k=0;k<8;k++)
            {
                a[k] = 0;
            }
        }
        int lower=0,upper=0;
        System.out.println("Total number of bits : "+count);
        int o=1;
        while(o!=0)
        {
            System.out.print("Enter lower limit : ");
            lower=sc.nextInt();
            System.out.print("Enter upper limit : ");
            upper=sc.nextInt();
            if(lower>0 && lower<count && upper>0 && upper<count && lower<upper)
            {
                o=0;
            }
            else
            {
                System.out.println("Invalid input.");
            }
        }
        FileWriter fw1=new FileWriter("out1.txt");
        System.out.print("Bits : ");
        for(i=lower;i<=upper;i++)
        {
            if(m[i]==1)
            {
                System.out.print(m[i]+" ");
                fw1.write(" 1");
            }
            else
            {
                System.out.print(m[i]+" ");
                fw1.write(" 0");
            }
        }
        fw1.close();
        System.out.println();
    }
}