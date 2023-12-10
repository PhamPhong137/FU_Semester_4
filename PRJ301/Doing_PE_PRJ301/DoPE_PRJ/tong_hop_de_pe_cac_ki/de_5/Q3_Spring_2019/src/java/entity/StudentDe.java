
package entity;

public class StudentDe {
     private int id;
    private String name;
    private String dob;
    private int gender;
    private int departmentid;
    private String departmentname;

    public StudentDe() {
    }
    public StudentDe(int departmengid, String departmentName) {
        this.departmentid = departmengid;
        this.departmentname = departmentName;
    }
    public StudentDe(int id, String name, String dob, int gender, int departmentid, String departmentname) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.departmentid = departmentid;
        this.departmentname = departmentname;
    }
     public StudentDe(String name, String dob, int gender, String departmentname) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.departmentname = departmentname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
    
}
