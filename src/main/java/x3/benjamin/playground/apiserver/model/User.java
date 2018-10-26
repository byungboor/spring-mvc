package x3.benjamin.playground.apiserver.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@XmlRootElement(name = "user")
public class User {
    private Long userId;
    private String name;
    private String address;

    public User() {
    }

    public User(Long userId, String name, String address) {
        this.setUserId(userId);
        this.setName(name);
        this.setAddress(address);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
