package com.spring.professional.exam.tutorial.module07.question15.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


public class Statistics {
    private int numberOfCharacters;
    private int codeLength;
    private int firstNameLength;
    private int lastNameLength;

    public Statistics() {
    }

    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }

    public void setNumberOfCharacters(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getFirstNameLength() {
        return firstNameLength;
    }

    public void setFirstNameLength(int firstNameLength) {
        this.firstNameLength = firstNameLength;
    }

    public int getLastNameLength() {
        return lastNameLength;
    }

    public void setLastNameLength(int lastNameLength) {
        this.lastNameLength = lastNameLength;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "numberOfCharacters=" + numberOfCharacters +
                ", codeLength=" + codeLength +
                ", firstNameLength=" + firstNameLength +
                ", lastNameLength=" + lastNameLength +
                '}';
    }

    public Statistics(int numberOfCharacters, int codeLength, int firstNameLength, int lastNameLength) {
        this.numberOfCharacters = numberOfCharacters;
        this.codeLength = codeLength;
        this.firstNameLength = firstNameLength;
        this.lastNameLength = lastNameLength;
    }
}
