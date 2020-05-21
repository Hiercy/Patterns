package com.mike.patterns.creational.builder;

public class Client {
    public static void main(String[] args) {
        Hero hero1 = new Hero.Builder("Hiercy", HairType.CURLY)
                .setArmor(Armor.PLATE)
                .setWeapon(Weapon.SWORD)
                .build();
        System.out.println(hero1);

        Hero hero2 = new Hero.Builder("Bob", HairType.BALD)
                .setArmor(Armor.RAGS)
                .setWeapon(Weapon.KNIFE)
                .build();
        System.out.println(hero2);

        Hero hero3 = new Hero.Builder("John", HairType.LONG_CURLY)
                .setArmor(Armor.CHAIN_MAIL)
                .setWeapon(Weapon.AXE)
                .build();
        System.out.println(hero3);

    }
}
