package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSaving {
    private String urlSQLITE="jdbc:sqlite:Database.db";
    private String urlMSSQL="jdbc:sqlserver://localhost\\\\sqlexpress;user=sa;password=secret";
    private String driverSQLITE="org.sqlite.JDBC";
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
          // statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER ," + "punteggio INTEGER," + "ORDER BY punteggio)");
        }catch(SQLException e){

            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER ," + "punteggio INTEGER)");

        }


    }
    public int InsertScore(int id,int score) throws SQLException {
        int rowsAffected=0;
        try {


            rowsAffected = statement.executeUpdate("INSERT INTO Punteggi(id,punteggio) VALUES(" + id + "," + score + ")");
        }catch (SQLException e){
            e.printStackTrace();
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id ," + "punteggio INTEGER)");
        }


        return rowsAffected;
    }
    public int[] getTopScores() throws SQLException {
        ResultSet rs=null;
        int[] scores=new int[5];
        int index=0;
        try {

            rs=statement.executeQuery("SELECT * FROM Punteggi LIMIT 5"+"ORDER BY punteggio,id DESC");

        }catch (SQLException e){
            e.printStackTrace();
            statement.executeUpdate("DROP TABLE IF EXISTS Punteggi");
            statement.executeUpdate("CREATE TABLE Punteggi(" + "id INTEGER ," + "punteggio INTEGER)");
            while(rs !=null && rs.next()){
                scores[index]=rs.getInt("punteggio");
                index++;
            }
        }
        finally {

            rs=null;
        }

        return scores;
    }

}
