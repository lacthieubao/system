package application.config.enums;

public enum GenderEnum {
	
	MALE(0),
	FEMALE(1),
	OTHER(2);
	
	private int genderEnum;
	
	private GenderEnum(int genderEnum){
		this.genderEnum = genderEnum;
	}
	
	public GenderEnum getGender(int type){
		return valueOf(""+type);
	}
}
