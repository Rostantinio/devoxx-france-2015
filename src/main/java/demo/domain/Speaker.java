package demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Speaker implements java.io.Serializable{
    @GeneratedValue
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private  String twitter;

    @Column(columnDefinition = "TEXT")
    private String bio;

    public Speaker() {
    }

    public Speaker(String firstName, String lastName, String twitter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.twitter = twitter;
    }

    public Long getId() {
        return id;
    }
}
