package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String edition;
    private String rarity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sale",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<User> userList;

    public Card() {
    }

    public Card(String name, String edition, String rarity) {
        this.name = name;
        this.edition = edition;
        this.rarity = rarity;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<User> getUserList(){
        return userList;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
    }
}
