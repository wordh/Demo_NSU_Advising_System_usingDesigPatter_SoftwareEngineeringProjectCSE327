package registrationui;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseRDBMapper implements IMapper{
    
    DBManager dbm;
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public CourseRDBMapper() throws SQLException{
        dbm=new DBManager();
        con=dbm.connectDB();
        ps= con.prepareStatement("INSERT INTO course (Name, ID, Credit, Fee, Progid) VALUES (?,?,?,?,?)");
        st=con.createStatement();
        
    }
    @Override
    public Object get(String OID) {
        Course ad= null;
        IProgram iprog=null;
        try {
            rs=st.executeQuery("Select * from course where ID='"+OID+"'");
            if(!rs.next()){
                ad=null;                
            }else {
                ad=new Course(OID);
                do{
                    ad.setTitle(rs.getString(1));
                    ad.setId(OID);
                    ad.setCredit(Integer.valueOf(rs.getString(3))); 
                    ad.setTutionPerCredit(Integer.valueOf(rs.getString(4)));
                    ad.setProgId(rs.getString(5));
                    
                    iprog= new ProgramProxy(OID);
                    ad.setProgTitle(iprog.getTitle());
                    ad.setProgDept(iprog.getDept());
                    
                } while(rs.next());
            }
  
        } catch (SQLException ex) {
            Logger.getLogger(CourseRDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }

    @Override
    public int put(String OID, Object obj) {        
        int success=0;
        try {
            Admin ad= (Admin)obj;
            ps.setString(1,ad.getCName());
            ps.setString(2,ad.getCCode());
            ps.setInt(3, ad.getCCredit());
            ps.setInt(4,ad.getCreditFee());
            ps.setString(5,ad.getProgId());
            success=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseRDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
}
