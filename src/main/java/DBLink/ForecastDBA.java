package DBLink;

import DBPackage.MySQLConnection;
import Classes.Forecast;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class ForecastDBA {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Forecast fore, int recordCount){

        Statement stmtInsert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            //INSERT FORECASTS
            insert = "insert into Forecasts (idCity, idDay, idAtmosphericData, idWindData)\n" +
                    "values ("+recordCount+", "+recordCount+", "+recordCount+", "+recordCount+")";
            stmtInsert.executeUpdate(insert);

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }

}
