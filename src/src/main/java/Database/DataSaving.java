package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSaving {
    private String urlSQLITE="jdbc:sqlite:prova.db";
    private String driverSQLITE="org.sqlite.JDBC";
    private Connection c=null;
    private Statement statement=null;
    private int ScoreToInsert=0;
    public DataSaving(int ScoreToInsert) throws SQLException {
        this.ScoreToInsert=ScoreToInsert;
        DBManager.setConnection(driverSQLITE,urlSQLITE);
        this.init();


    }
    public void init() throws SQLException{
        try {
            c = DBManager.getConnection();
            statement = c.createStatement();
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER PRIMARY KEY," + "punteggio INTEGER," + "ORDER BY punteggio)");
        }catch(SQLException e){
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER PRIMARY KEY," + "punteggio INTEGER)");

        }
        finally {
            if(c!=null)
                DBManager.close();
        }

    }
    public int InsertScore(int id,int score) throws SQLException {
        int rowsAffected=0;
        try {
            c = DBManager.getConnection();
            statement = c.createStatement();
            rowsAffected = statement.executeUpdate("INSERT INTO Punteggi(id,punteggio) VALUES(" + id + "," + score + ")");
        }catch (SQLException e){
            e.printStackTrace();
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER PRIMARY KEY," + "punteggio INTEGER)");
        }
        finally {
            if(c!=null)
                DBManager.close();
        }
        return rowsAffected;
    }
    public int[] getTopScores() throws SQLException {
        ResultSet rs=null;
        int[] scores=new int[5];
        int index=0;
        try {
            c = DBManager.getConnection();
            statement = c.createStatement();
            rs=statement.executeQuery("SELECT * FROM Punteggi LIMIT 5"+"ORDER BY punteggio DESC");

        }catch (SQLException e){
            e.printStackTrace();
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER PRIMARY KEY," + "punteggio INTEGER)");
        }
        finally {
            if(c!=null)
                DBManager.close();
        }
        while(rs !=null && rs.next()){
            scores[index]=rs.getInt("punteggio");
            index++;
        }
        return scores;
    }

}
