package DBLink;

import DBPackage.MySQLConnection;
import Classes.Day;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class DayDBA {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Day d, int recordCount){

        Statement stmtInsert;

        try{

            //INSERT DESCRIPTIONS
            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            insert = "insert into Descriptions (description)\n" +
                    "values ('"+d.getDescription()+"')";
            stmtInsert.executeUpdate(insert);

            //INSERT WEEKDAYS
            insert = "insert into WeekDays (weekDay)\n" +
                    "values ('"+d.getDay()+"')";
            stmtInsert.executeUpdate(insert);

            //INSERT DAYS
            insert = "insert into Days (date, idWeekDay, maxTemp, minTemp, idDescription)\n" +
                    "values ('"+d.getDate()+"', "+recordCount+", "+d.getMaxTemp()+
                    ", "+d.getMinTemp()+", "+recordCount+")";
            stmtInsert.executeUpdate(insert);

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }
}
