package com.company.existences;

import java.util.Objects;

public class Professor extends Gnome implements Researching{
    private int knowladgeLevel;
    public Professor(int x, int y, String name, int knowladgeLevel) {
        super(x, y, name);
        this.knowladgeLevel = knowladgeLevel;
    }

    public Professor(int x, int y, String name) {
        super(x, y, name);
    }

    public Professor(int x, int y) {
        super(x, y);
    }

    public void research(){
        this.knowladgeLevel+=Math.random()*5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return knowladgeLevel == professor.knowladgeLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), knowladgeLevel);
    }
}
