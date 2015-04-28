package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Adi on 28.04.2015.
 */

@Table(name = "departments")
public class Departament {


    @Id(name = "Department_id")
    private int id;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "location")
    private int location;


    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
