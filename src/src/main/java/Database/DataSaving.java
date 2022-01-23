package Database;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataSaving {
    private final String urlSQLITE="jdbc:sqlite:Database.db";
    ResultSet rs;
    private String urlMSSQL="jdbc:sqlserver://localhost\\\\sqlexpress;user=sa;password=secret";
    private final String driverSQLITE="org.sqlite.JDBC";
    private String driverMSSQL="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection c=null;
    private Statement statement=null;
    private int ScoreToInsert=0;
    public DataSaving() throws SQLException {
        DBManager.setConnection(driverSQLITE,urlSQLITE);
        this.init();
    }
    public void init() throws SQLException{
        try {
            c = DBManager.getConnection();
            statement = c.createStatement();
            //statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER ," + "punteggio INTEGER," + "ORDER BY punteggio)");
        }catch(SQLException e){

            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id DATE ," + "punteggio INTEGER)");

        }
    }
    public int InsertScore(int score) throws SQLException {
        int rowsAffected=0;
        try {
            rowsAffected = statement.executeUpdate("INSERT INTO Punteggi(id,punteggio) VALUES(" + "DATE('now')," + score + ")");
        }catch (SQLException e){
            e.printStackTrace();
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id Date," + "punteggio INTEGER)");
        }
        return rowsAffected;
    }
    public int[] getTopScores(int[] scores) throws SQLException {
        int index=0;
        try {
            rs=statement.executeQuery("SELECT * FROM Punteggi"+" ORDER BY punteggio DESC");
        }catch (SQLException e){
            e.printStackTrace();
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id DATE ," + "punteggio INTEGER)");

        }
        while(rs != null && rs.next() && index<5){
            scores[index]=rs.getInt("punteggio");
            index++;
        }
        return scores;
    }

}
