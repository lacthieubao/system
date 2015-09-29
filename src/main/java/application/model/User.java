package application.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;





import com.vaadin.data.fieldgroup.PropertyId;

//import util.PasswordEncryptor;

import application.config.enums.RoleEnum;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 16, 2015
 */

@Entity
@Table(name = "users")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(name = "username",unique=true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email",unique=true)
    private String email;

    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "birthday")
    private Date birthday;
    
    @Column(name = "sex")
    private int sex;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> roles;
    
    public static User createUser(String username, String email, String password) {
        User user = new User();

        user.username = username;
        user.email = email;
        user.password = password;
//        user.password = PasswordEncryptor.getInstance().encrypt(password);

        if(user.roles == null) {
            user.roles = new HashSet<UserRole>();
        }

        //create a new user with basic user privileges
        user.roles.add(
                new UserRole(
                        RoleEnum.USER.toString(),
                        user
                ));

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
    
    
}

