package jpamvcexam.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dept {
    @Id
    private int deptno;
    private String dname;
    private String loc_code;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc_code() {
        return loc_code;
    }

    public void setLoc_code(String loc_code) {
        this.loc_code = loc_code;
    }

}
