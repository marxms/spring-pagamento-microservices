package com.marx.instrutor.representation;

public enum GeneroEnum {

	MASCULINO("M"), FEMININO("F");
	
	private String value;
	
	private GeneroEnum(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
