
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armok
 */
public class Model {
    //ArrayList<Ivent> Ivents = new ArrayList<>();
    
    Connection c;
    
    void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sql\\ivent.db");
        } catch (ClassNotFoundException ex){
        } catch (SQLException ex) {}
    }
    
    Model(){
        connect();
    }
    
    ArrayList<Ivent> getAllIvent() throws SQLException{
        ArrayList<Ivent> tmp = new ArrayList<>();
        
        if (c != null){
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery("select * from ivents");
            while(r.next()){
                Ivent ivt = new Ivent(r.getInt("hour"), r.getInt("min"), r.getInt("sec"), r.getString("description"));
                tmp.add(ivt);
            }
        }
        return tmp;
    }
    
    void AddIvent(Ivent iv){
        if (c != null){
            try {
                PreparedStatement pst = c.prepareStatement("Insert INTO ivents(hour, min, sec, description) VALUES(?, ?, ?, ?)");
                pst.setInt(1, iv.getHour());
                pst.setInt(2, iv.getMin());
                pst.setInt(3, iv.getSec());
                pst.setString(4, iv.getDescription());
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
