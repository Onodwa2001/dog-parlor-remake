package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Role implements Serializable {

    @Id
    private String roleID;
    private String name;

    protected Role(){}


    private Role(Builder builder){
        this.roleID = builder.roleID;
        this.name = builder.name;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleID == role.roleID && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{
        private String roleID;
        private String name;

        public Builder(){}

        public Builder setRoleID(String roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Role role){
            this.roleID = role.roleID;
            this.name = role.name;
            return this;
        }

        public Role build(){
            return  new Role(this);
        }
    }
}
