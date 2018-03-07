package com.wen.day0108;

public class a {
	private int count;
	public static void main(String[] args) {

	}

	public a(int count) {
		this.count = count;
	}

	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj!=null&&a.class==obj.getClass()){
			a s=(a)obj;
			return this.count == s.count;
		}
		return false;
			
	}
}
