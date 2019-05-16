package models;

public class User {

    private int id;
    private String userName;
    private String userLastName;
    private String login;
    private String password;
    private String address;

    public User(){

    }

    public User(String login, String password){
       this.login = login;
       this.password = password;
    }

    public User(int id, String userName, String login, String password, String address) {
        this.id = id;
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.address = address;
    }

    public User(int id, String userName, String userLastName, String login, String password, String address) {
        this.id = id;
        this.userName = userName;
        this.userLastName = userLastName;
        this.login = login;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
