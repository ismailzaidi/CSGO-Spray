package com.csgo.spray.model;

import java.util.Comparator;

public class Weapon implements Comparable<Weapon>{
	private int weapon_image_id;
	private String weapon_name, category, weapon_price, weapon_kill_price;


	public Weapon(String weapon_name, String category,
			String weapon_price, String weapon_kill_price) {
		super();
		this.weapon_name = weapon_name;
		this.category = category;
		this.weapon_price = weapon_price;
		this.weapon_kill_price = weapon_kill_price;
	}
	public Weapon(int weapon_image_id, String weapon_name, String category,
			String weapon_price, String weapon_kill_price) {
		super();
		this.weapon_image_id = weapon_image_id;
		this.weapon_name = weapon_name;
		this.category = category;
		this.weapon_price = weapon_price;
		this.weapon_kill_price = weapon_kill_price;
	}

	public int getWeapon_image_id() {
		return weapon_image_id;
	}

	public void setWeapon_image_id(int weapon_image_id) {
		this.weapon_image_id = weapon_image_id;
	}

	public String getWeapon_name() {
		return weapon_name;
	}

	public void setWeapon_name(String weapon_name) {
		this.weapon_name = weapon_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWeapon_price() {
		return weapon_price;
	}

	public void setWeapon_price(String weapon_price) {
		this.weapon_price = weapon_price;
	}

	public String getWeapon_kill_price() {
		return weapon_kill_price;
	}

	public void setWeapon_kill_price(String weapon_kill_price) {
		this.weapon_kill_price = weapon_kill_price;
	}

	@Override
	public String toString() {
		return "Weapon [weapon_image_id=" + weapon_image_id + ", weapon_name="
				+ weapon_name + ", category=" + category + ", weapon_price="
				+ weapon_price + ", weapon_kill_price=" + weapon_kill_price
				+ "]";
	}


	@Override
	public int compareTo(Weapon another) {
		// TODO Auto-generated method stub
		String compareName = ((Weapon) another).getWeapon_name().toLowerCase();
		return this.weapon_name.compareTo(compareName);
	}
}
