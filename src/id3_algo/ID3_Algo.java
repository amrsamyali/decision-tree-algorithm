/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3_algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.print.DocFlavor;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author manunited
 */
public class ID3_Algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      

        
     
        
        
        
    Scanner  write = new Scanner (System.in); //scan for inputs to write in consol
     
        int column_number;
        column_number = 1;   //document number start with 1 for 4 
      
        int num;
        System.out.println("Write Number of Col");
        int col_num ;
        
        col_num=write.nextInt();
        String [] collum_name = new String[1000];
        
        
        for(num=0;num<col_num;num++) //for loop to make 4 collumn
        {
            System.out.println("column Name"+column_number );
            collum_name[num]=write.next();
            
        final Formatter x; //to make document
        try{
            x= new Formatter(collum_name[num]+".txt");  // make document
            
          }
        
        
        catch(Exception e)
        {
            System.out.println("created Document"+ column_number +"Failed");
        }
         
        
            column_number ++;
        
    }

        
        
        








        
     int counter =0;
while (true)            
            
{
    System.out.println(collum_name[counter]+" Write in it");
    String Filename = collum_name[counter]+".txt"; 
    
    
    
    
     try{                                  
         FileWriter write_in_file = new FileWriter(Filename , true); // to write in document
          
             String pharse ;
             pharse = write.next();
             
             BufferedWriter bw = new BufferedWriter(write_in_file);
             bw.write(pharse);
             bw.newLine();
              bw.close();
       
        
       
         System.out.println("Done");
         
         
     }
     catch(Exception e)
     {
         System.out.println("Failed");
     }
    
    
   counter++;
    
    String answer ="";
    while(counter==num)
    {
       System.out.println("Are You Finsh Add");
    
    answer= write.next();
    if(answer.equals("yes") || answer.equals("Yes"))
    {
        break;
    }
    else if (answer.equals("no") || answer.equals("No"))
            {  counter= 0;}     
    else
    {
        System.out.println("Write yes or no");
    
    }
    }
   if(answer.equals("yes") || answer.equals("Yes"))
    {
        break;
    }
}









        String file_name_tsbet;
        System.out.println("Which colloumn you want to tsbet it");
        file_name_tsbet=write.next();
        
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");

  HashMap<String,HashMap<String,ArrayList<String>>>a = new HashMap<String,HashMap<String, ArrayList<String>>>();

for(num=0;num<col_num;num++)
{
    if(!collum_name[num].equals(file_name_tsbet))
    {
        
       HashMap<String,ArrayList<String>>b = new HashMap<String,ArrayList<String>>();
  
 // The name of the file to open.
        String fileName = collum_name[num]+".txt";
        String file_tsabet=file_name_tsbet+".txt";
        
        // This will reference one line at a time
        String line = null;
        String line1 = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
    FileReader fileReader1 = 
                new FileReader(file_tsabet);

            
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
BufferedReader bufferedReader1 = 
                new BufferedReader(fileReader1);

          
            while((line = bufferedReader.readLine()) != null && (line1 = bufferedReader1.readLine()) != null) {
          
                
           
               if(a.containsKey(collum_name[num])){
                    if(b.containsKey(line)){
                        
                        
                      
                        
            ArrayList<String>d1=new ArrayList<String>();
            
         
            d1.add(b.get(line).toString());
            d1.add(line1);
           
            b.put(line, d1);
            a.put(collum_name[num],b );
                    
                    
                    } else{
            ArrayList<String>d=new ArrayList<String>();
            d.add(line1);
            b.put(line, d);
            a.put(collum_name[num],b );
                 }
                               
                }else{ ArrayList<String>d=new ArrayList<String>();
            d.add(line1);
            b.put(line, d);
            a.put(collum_name[num],b );}
                
                
            
            
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }

}

    }


ArrayList<String> yes = new ArrayList<String>();
ArrayList<String> no = new ArrayList<String>();



for (String name: a.keySet()){
    

            String key =name.toString();
            String value = a.get(name).toString();  
            System.out.println(key + " " + value);  
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println(key+"   ||   "+"   Yes   ||   "+"   No   ");
 
            StringTokenizer stk=new StringTokenizer(value,("!@#$%^&*()_+=-/?.,<>|[]{}"+" "));
 
           int count_row_yes = 0;
           int count_row_no = 0;
  
  while(stk.hasMoreTokens())
        {
            String element =stk.nextToken();
             if(element.equals("yes") || element.equals("y"))
             {
                 yes.add(element);
                 count_row_yes++;
                
             }
             else if(element.equals("no")|| element.equals("n"))
             {
                 no.add(element);
                 count_row_no++;
             }
             else {
                 
                if(count_row_yes!=0 || count_row_no!=0)
                {
                  System.out.println("::::::::::::>"+count_row_yes+"     ||     "+count_row_no);
                }
                  count_row_yes=0;
                  count_row_no=0;
                   System.out.println(element+"    ||   ");
             }
             
             if(!stk.hasMoreTokens())
             {
                  System.out.println("::::::::::::>"+count_row_yes+"     ||     "+count_row_no);
             }
         
        }
  
          
    System.out.println("------------------------------------------------------->");
} 

       

       double y_all =yes.size();
       double n_all =no.size();
       
        double sum =yes.size()+no.size();
        
         double info = (-(((double)y_all/sum)*Math.log((double)y_all/sum))/(Math.log(2)))-((((double)n_all/sum)*Math.log((double)n_all/sum))/(Math.log(2)));
         
           
        System.out.println("Entropy(D)=I("+yes.size()+","+no.size()+")= "+info);







        
        
        
        double usefull_field = -1000000000;
        
        for (String name: a.keySet()){
    

            String key =name.toString();
            String value = a.get(name).toString();  
        
            StringTokenizer stk=new StringTokenizer(value,("!@#$%^&*()_+=-/?.,<>|[]{}"+" "));
 
           double count_row_yes = 0;
           double count_row_no = 0;
  
            double info1 = 0.0;
           
           
  while(stk.hasMoreTokens())
        {
            String element =stk.nextToken();
             if(element.equals("yes") || element.equals("y"))
             {
                 yes.add(element);
                 count_row_yes++;
                
             }
             else if(element.equals("no")|| element.equals("n"))
             {
                 no.add(element);
                 count_row_no++;
             }
             else {
                 
                if(count_row_yes!=0 && count_row_no!=0)
                {
                    
                    
                     double sum2 = count_row_yes + count_row_no;
                    
             double info2 = (-(((double)count_row_yes/sum2)*Math.log((double)count_row_yes/sum2))/(Math.log(2)))-((((double)count_row_no/sum2)*Math.log((double)count_row_no/sum2))/(Math.log(2)));
           info1=((double)(((double)(((count_row_yes+count_row_no)/sum)*((double)info2)))+(double)info1));
           
                   
                   
                }
                
                else if(count_row_yes!=0 && count_row_no==0)
                {
                
                    
                      double sum2 = count_row_yes + count_row_no;
                    
             double info2 = (-(((double)count_row_yes/sum2)*Math.log((double)count_row_yes/sum2))/(Math.log(2)));
           info1=((double)(((double)(((count_row_yes+count_row_no)/sum)*((double)info2)))+(double)info1));
           
                    
                    
                    
                }
                 
                
                
                
                
                
                
                
                
                else if(count_row_yes==0 && count_row_no!=0)
                {
                
                      double sum2 = count_row_yes + count_row_no;
                    
             double info2 = -((((double)count_row_no/sum2)*Math.log((double)count_row_no/sum2))/(Math.log(2)));
           info1=((double)(((double)(((count_row_yes+count_row_no)/sum)*((double)info2)))+(double)info1));
           
                    
                    
                    
                }
                
                
                
                
                
                  count_row_yes=0;
                  count_row_no=0;
                  
             }
                
             if(!stk.hasMoreTokens())
             {
                
                    if(count_row_yes!=0 && count_row_no!=0)
                {
                    
                    
                     double sum2 = count_row_yes + count_row_no;
                    
           double info2 = (-(((double)count_row_yes/sum2)*Math.log((double)count_row_yes/sum2))/(Math.log(2)))-((((double)count_row_no/sum2)*Math.log((double)count_row_no/sum2))/(Math.log(2)));
           info1=((double)(((double)(((count_row_yes+count_row_no)/sum)*((double)info2)))+(double)info1));
           
                   
                   
                }
                
                else if(count_row_yes!=0 && count_row_no==0)
                {
                
                    
                      double sum2 = count_row_yes + count_row_no;
                    
             double info2 = (-(((double)count_row_yes/sum2)*Math.log((double)count_row_yes/sum2))/(Math.log(2)));
           info1=((double)(((double)(((count_row_yes+count_row_no)/sum)*((double)info2)))+(double)info1));
           
                    
                    
                    
                }
                 
                
                
                
                
                
                
                
                
                else if(count_row_yes==0 && count_row_no!=0)
                {
                
                      double sum2 = count_row_yes + count_row_no;
                    
             double info2 = -((((double)count_row_no/sum2)*Math.log((double)count_row_no/sum2))/(Math.log(2)));
           info1=((double)(((double)(((count_row_yes+count_row_no)/sum)*((double)info2)))+(double)info1));
           
                    
                    
                    
                }
                
                   
             }
         
        }
  
            System.out.println("Info "+ key +" (D)= "+info1);
            double gain = info-info1;
            
            System.out.println("Gain("+key+") = "+gain);
            
            if(gain>usefull_field)
            {
                usefull_field = gain;
              String use_field=name.toString();
            }
                    
    System.out.println("------------------------------------------------------->");
} 
        System.out.println("Usefull Field For Classification ("+usefull_field+")");    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        













    }
    
}
