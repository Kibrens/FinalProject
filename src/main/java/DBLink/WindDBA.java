package DBLink;

import DBPackage.MySQLConnection;
import Classes.Wind;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class WindDBA {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Wind wind, int recordCount){

        Statement stmtInsert;

        try{
            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;
            insert = "insert into WindDatas (speed, direction)\n" +
                    "values ("+wind.getSpeed()+", "+wind.getDirection()+")";
            stmtInsert.executeUpdate(insert);

            stmtInsert.close();
        }
        catch(Exception e){
        }
    }
}
