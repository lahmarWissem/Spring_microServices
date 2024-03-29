package com.wissem.users.entities;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
public class User {	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long user_id;

 @Column(unique=true)
	private String username;
	private String password;
	private Boolean enabled;
	
	@ManyToOne
	private Image image;
	
	
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
			   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Role> roles; 
    
    @Override
    public String toString() {
    	return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
    			+ ", roles=" + roles + "]";
    }
    
    public List<Role> getRoles() {
    	return roles;
    }
    public void setRoles(List<Role> roles) {
    	this.roles = roles;
    }
    
    public Long getUser_id() {
        return user_id;
    }

	
}
