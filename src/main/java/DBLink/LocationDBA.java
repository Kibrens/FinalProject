package DBLink;

import DBPackage.MySQLConnection;
import Classes.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class LocationDBA {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Location loc, int recordCount){

        Statement stmtInsert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            insert = "INSERT into regions (region)\n" +
                    "values ('"+loc.getRegion()+"')";
            stmtInsert.executeUpdate(insert);

            insert = "INSERT into countries (country, idRegion)\n" +
                    "values ('"+loc.getCountry()+"', "+recordCount+")";
            stmtInsert.executeUpdate(insert);

            insert = "INSERT into cities (city, idCountry)\n" +
                    "values ('"+loc.getCity()+"', "+recordCount+")";
            stmtInsert.executeUpdate(insert);

            stmtInsert.close();
        }
        catch(Exception e){

        }



    }

}