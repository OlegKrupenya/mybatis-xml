package com.testdev.domain;

import java.io.Serializable;


public class Employee implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5745730814176403349L;

    private Long employeeId;
    
    private String firstName;
    
    private String lastName;
    
    private Short age;
    
    public Employee() {}
    

    public Employee(Long employeeId, String firstName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
	}


	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result
                + ((employeeId == null) ? 0 : employeeId.hashCode());
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (employeeId == null) {
            if (other.employeeId != null)
                return false;
        } else if (!employeeId.equals(other.employeeId))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }



    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Short getAge() {
        return age;
    }



    public void setAge(Short age) {
        this.age = age;
    }
}
