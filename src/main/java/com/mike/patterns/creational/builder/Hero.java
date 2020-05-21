package com.mike.patterns.creational.builder;

public class Hero {

    private final String name;
    private final Weapon weapon;
    private final Armor armor;
    private final HairType hair;

    public static class Builder {
        private final String name;
        private final HairType hair;

        private Weapon weapon;
        private Armor armor;

        public Builder(String name, HairType hair) {
            this.name = name;
            this.hair = hair;
        }

        public Builder setWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder setArmor(Armor armor) {
            this.armor = armor;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }

    private Hero(Builder builder) {
        this.name = builder.name;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
        this.hair = builder.hair;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", armor=" + armor +
                ", hair=" + hair +
                '}';
    }
}
