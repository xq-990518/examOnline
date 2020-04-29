package entity;

public class Administor {
    private int id;
    private String admin_no;
    private String password;
    private String admin_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_no() {
        return admin_no;
    }

    public void setAdmin_no(String admin_no) {
        this.admin_no = admin_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public Administor(String admin_no, String password) {
        this.admin_no = admin_no;
        this.password = password;
    }

    public Administor() {
    }

    public Administor(int id) {
        this.id = id;
    }

    public Administor(int id, String admin_no, String password, String admin_name) {
        this.id = id;
        this.admin_no = admin_no;
        this.password = password;
        this.admin_name = admin_name;
    }
}
