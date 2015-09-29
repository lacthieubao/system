package application.config.enums;

/***
 * 
 * @author Vu, Nguyen
 * @Since Sept 17, 2015
 * @Description Defind  User Roles of system
 */

public enum RoleEnum {
	USER("user"),
	ADMIN("admin");
	
	private String roleName;
	
	private RoleEnum(String roleName){
		this.roleName = roleName;
	}
	
	public RoleEnum getRole(String roleName){
		return RoleEnum.valueOf(roleName);
	}
}
