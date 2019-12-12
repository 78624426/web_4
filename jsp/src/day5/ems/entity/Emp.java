package day5.ems.entity;

public class Emp {
    Integer id;
    String name;
    double salary;
    String gender;
    String edu;
    String hobbies[];
    String hobbies_str;

    public String getHobbies_str() {
        return hobbies_str;
    }
    public void setHobbies_str(String hobbies_str) {
        this.hobbies_str = hobbies_str;
    }
    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies=hobbies;
        StringBuilder sb=new StringBuilder(6);
        for(String t:hobbies){
            sb.append(t).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        this.hobbies_str = sb.toString();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }



    public Emp() {
    }

    public Emp(Integer id, String name, double salary, String gender, String edu, String hobbies_str) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.edu = edu;
        this.hobbies_str = hobbies_str;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", edu='" + edu + '\'' +
                ", hobbies_str='" + hobbies_str + '\'' +
                '}';
    }
}
