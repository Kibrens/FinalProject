package DBLink;

import DBPackage.MySQLConnection;
import Classes.Day;
import Classes.ExtendedForecast;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class ExtendedForecastDBA {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(ExtendedForecast extFore, int recordCount){

        Statement stmtInsert;
        String insert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();

            for(int i=0; i<10; i++){

                Day d = (Day)extFore.getExtForecast().get(i);
                insert = "INSERT into ExtendedForecasts(idForecast, date, weekDay, maxTemp, minTemp, description)\n" +
                        "values("+recordCount+", '"+d.getDate()+"', '"+d.getDay()+"', "+d.getMaxTemp()+", "+
                        d.getMinTemp()+", '"+d.getDescription()+"')";
                stmtInsert.executeUpdate(insert);

            }

            stmtInsert.close();
            mySQLCon.getCon().close();
        }
        catch(Exception e){

        }
    }

}
