package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
	
  //DataProvider 1
	
 @DataProvider(name="LoginData")
    public String[][] geData() throws IOException {
        String path =".\\testdata\\OpenCart_Login.xlsx";//taking xl file from testData
        ExcelUtility xlutil=new ExcelUtility(path); // Creating an object for xlutility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1",1);

       String logindata[][] = new String[totalrows][totalcols]; // created for two dimension array which can store row and col just like xl format

        for (int i = 1; i <=totalrows; i++) { //1 // read the data from xl storing in two dimensional array
            for (int j = 0; j < totalcols; j++) {//0   //i is rows j is col
                logindata[i - 1][j] = xlutil.getCellData("Sheet1",i, j);//1,0
            }
        }

 
        return logindata;//returning two dimension array
    }
   //Data Provider 2
 
 @DataProvider(name="RegisterData")
 public String[][] geData1() throws IOException {
     String path =".\\testdata\\OpenCart_Registration.xlsx";//taking xl file from testData
     ExcelUtility xlutil=new ExcelUtility(path); // Creating an object for xlutility

     int totalrows = xlutil.getRowCount("Sheet1");
     int totalcols = xlutil.getCellCount("Sheet1",1);

    String registerdata[][] = new String[totalrows][totalcols]; // created for two dimension array which can store row and col just like xl format

     for (int i = 1; i <=totalrows; i++) { //1 // read the data from xl storing in two dimensional array
         for (int j = 0; j < totalcols; j++) {//0   //i is rows j is col
             registerdata[i - 1][j] = xlutil.getCellData("Sheet1",i, j);//1,0
         }
     }


     return registerdata;//returning two dimension array
 }
 
 
   //Data Provider 3
 
   //Data Provider 4
}


