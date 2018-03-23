package registrationui;

import java.sql.SQLException;

public class Course {
    String id,title,progid,pTitle,pDept;
    int credit,tutionPerCredit;
    Program prog;
    IProgram iprog;
    
    public Course(String OID) throws SQLException{
        prog=new Program();
        iprog= new ProgramProxy(OID);
    }
    void setId(String id){
        this.id=id;        
    }
    void setTitle(String title){
        this.title=title;
    }
    void setCredit(int credit){
        this.credit=credit;
    }
    void setTutionPerCredit(int tutionPerCredit){
        this.tutionPerCredit=tutionPerCredit;
    }
    
    void setProgId(String progid){
        this.progid=progid;
    }
    void setProgTitle(String title){
        prog.setTitle(title);
    }
    void setProgDept(String dept){
        prog.setDept(dept);
    }
    String getId(){
        return id;
    }
    String getTitle(){
        return title;
    }
    int getCredit(){
        return credit;
    }
    int getTutionPerCredit(){
        return tutionPerCredit;
    }
    
    int getSubTotal(){
        return credit*tutionPerCredit;
    }
    
    String getProgramId(){
        return this.progid;
    }
    
    String getProgramTitle(){
        return iprog.getTitle();
    }
    
    String getProgramDept(){
        return iprog.getDept();
    }
 
}
