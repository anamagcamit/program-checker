package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

import javafx.scene.control.TextArea;

public class Controller {

    public TextArea huhu;

    int filecounter = 0;    //this counts the number of files inside the folder
    String printing = "";


    String dirPath = "C:\\Users\\hp\\Desktop\\submitted";       //this is the directory of the folder
    File dir = new File(dirPath);                               //file io
    String[] files = dir.list();                                //this is an array of the file names
    String[] dirfile = new String[100];                         //this takes in the file names and includes the directory
    float[][] matrix= new float[100][100];

    DecimalFormat df = new DecimalFormat("###.##");
    //System.out.println(df.format(PI));

    public void GetFiles(){
        //this function basically takes in the files and places it inside an array.
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (String aFile : files) {
                String finname = "C:\\Users\\hp\\Desktop\\submitted\\" + aFile;
                System.out.println(finname);
                dirfile[filecounter] = finname;                 //this places the name of the file with the directory in an array so we can read the contents
                filecounter++;
            }
        }
    }

    public void ReadFile() throws IOException {
        //this function read the contents of the file.

        System.out.println("\n");
        //int i = 0; //counter

        for(int i=0;i<filecounter;i++){                       //first loop to open the current file
            for(int j=0;j<filecounter;j++){
                String[] line1= new String[100000];           //this stores the contents(by line of the first file) in an array for comparison
                String[] line2 = new String[100000];          //this stores the contents (by line of the second file) in an array for comparison
                int a=0;
                int b=0;

                //System.out.println("***************************************************************************************");

                File currentfile1 = new File(dirfile[i]);                                   //file io to read the first file to be compared
                BufferedReader br1 = new BufferedReader((new FileReader(currentfile1)));
                String st1;                                                                //this helps store the string in an array
                while((st1 = br1.readLine()) != null){                                      //this stores the string in the array until the end of the file.
                    line1[a] = st1;
                    //System.out.println(line1[a]);
                    a++;
                }
                //System.out.println("***************************************************************************************");
                File currentfile2 = new File(dirfile[j]);
                BufferedReader br2 = new BufferedReader((new FileReader(currentfile2)));
                String st2;
                while((st2 = br2.readLine()) !=null){
                    line2[b]=st2;
                    //System.out.println(line2[b]);
                    b++;
                }


                int k = 0;                                                              //a -> k. this is the counter for each line for file 1
                int l = 0;                                                              //b -> l. this is the counter for each line for file 2
                float totallines = a+b;
                float checker=0;
                float different = 0;
                float percent = 0;
                int diffchecker = 0;





              if(a>b){
                  for(int counter=0;counter<a;counter++){
                      if(line1[counter].equals(line2[counter])){
                          continue;
                      }
                      else {
                          diffchecker++;
                      }
                  }
                  different = totallines - diffchecker;
                  percent = (different/totallines);
                  matrix[i][j] = percent;
              }
              else{
                  for(int counter = 0; counter<b;counter++){
                      if(line2[counter].equals(line1[counter])){
                          continue;
                      }
                      else{
                          diffchecker++;
                          //System.out.println(line1[counter]);
                      }
                  }
                  different = totallines - diffchecker;
                  percent = (different/totallines);
                  matrix[i][j] = percent;
              }


              /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                /*
                if(a>b){                                    //this is when file1 has more lines than file2
                    for(int counter=0;counter<a;counter++){
                        for(int counter2=0; counter<b;counter2++){
                            if(line1[counter].equals(line2[counter2])){
                                checker++;
                                break;
                            }
                            else{
                                continue;
                            }
                        }
                        if(checker==0){
                            different++;
                        }
                        checker=0;
                    }
                    different = totallines - diffchecker;
                    percent = (different/totallines);
                    matrix[i][j] = percent;

                }

                else{
                    for(int counter = 0; counter<b;counter++){
                        for(int counter2=0;counter2<a;counter2++){
                            if(line2[counter]==line1[counter2]) {
                                checker++;
                                break;
                            }
                            else{
                                continue;
                            }
                        }
                        if(checker==0){
                            different++;
                        }
                        checker=0;
                    }
                    float totalsame = totallines - different;
                    percent=(totalsame/totallines);
                    matrix[i][j] = percent;
                }

                /*
                /*
                THIS FUNCTION JUST PRINTS OUT EACH FILE FOR ONE TO VIEW
                System.out.println("***************************************************************************************");
                while(k!= a){
                    System.out.println(line1[k]);
                    k++;
                }

                System.out.println("\n");
                System.out.println("***************************************************************************************");
                while(l!= b){
                    System.out.println(line2[l]);
                    l++;
                }*/
                //String numberstring = .toString(df.format(matrix[i][j]);
                //printing = printing + df.format(matrix[i][j]+ " ");

                String finalnumber = df.format(matrix[i][j]);
                printing = printing + finalnumber + "  ";
                System.out.print(finalnumber);
                //System.out.print(df.format(matrix[i][j])+ " ");


            }
            printing = printing + "\n\n";
            System.out.println("\n");

        }

    }

    public void Print(){
        huhu.setText(printing);
    }


    @FXML
    public void Read2(ActionEvent event) throws IOException{
        GetFiles();
        ReadFile();
        Print();
    }




}