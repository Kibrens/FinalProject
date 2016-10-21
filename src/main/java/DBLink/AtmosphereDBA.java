package DBLink;

import DBPackage.MySQLConnection;
import Classes.Atmosphere;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class AtmosphereDBA {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Atmosphere atmos, int recordCount){

        Statement stmtInsert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;
            
            insert = "INSERT into Atmosphere (humidity, preasure, visibility)\n" +
                    "values ("+atmos.getHumidity()+", "+atmos.getPressure()+
                    ", "+atmos.getVisibility()+")";
            stmtInsert.executeUpdate(insert);

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }

}
