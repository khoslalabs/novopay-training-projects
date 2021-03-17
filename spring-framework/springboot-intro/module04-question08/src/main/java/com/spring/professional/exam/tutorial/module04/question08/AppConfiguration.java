package com.spring.professional.exam.tutorial.module04.question08;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")

public class AppConfiguration {
    private int propertyA;
    private int propertyB;
    private int propertyC;
    private int propertyD;
    private int propertyE;
    private int propertyF;
    private int propertyG;
    private int propertyH;
    private int propertyI;
    private int propertyJ;
    private int propertyK;
    private int propertyL;
    private int propertyM;
    private int propertyN;
    private int propertyO;
    private int propertyP;

    public int getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(int propertyA) {
        this.propertyA = propertyA;
    }

    public int getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(int propertyB) {
        this.propertyB = propertyB;
    }

    public int getPropertyC() {
        return propertyC;
    }

    public void setPropertyC(int propertyC) {
        this.propertyC = propertyC;
    }

    public int getPropertyD() {
        return propertyD;
    }

    public void setPropertyD(int propertyD) {
        this.propertyD = propertyD;
    }

    public int getPropertyE() {
        return propertyE;
    }

    public void setPropertyE(int propertyE) {
        this.propertyE = propertyE;
    }

    public int getPropertyF() {
        return propertyF;
    }

    public void setPropertyF(int propertyF) {
        this.propertyF = propertyF;
    }

    public int getPropertyG() {
        return propertyG;
    }

    public void setPropertyG(int propertyG) {
        this.propertyG = propertyG;
    }

    public int getPropertyH() {
        return propertyH;
    }

    public void setPropertyH(int propertyH) {
        this.propertyH = propertyH;
    }

    public int getPropertyI() {
        return propertyI;
    }

    public void setPropertyI(int propertyI) {
        this.propertyI = propertyI;
    }

    public int getPropertyJ() {
        return propertyJ;
    }

    public void setPropertyJ(int propertyJ) {
        this.propertyJ = propertyJ;
    }

    public int getPropertyK() {
        return propertyK;
    }

    public void setPropertyK(int propertyK) {
        this.propertyK = propertyK;
    }

    public int getPropertyL() {
        return propertyL;
    }

    public void setPropertyL(int propertyL) {
        this.propertyL = propertyL;
    }

    public int getPropertyM() {
        return propertyM;
    }

    public void setPropertyM(int propertyM) {
        this.propertyM = propertyM;
    }

    public int getPropertyN() {
        return propertyN;
    }

    public void setPropertyN(int propertyN) {
        this.propertyN = propertyN;
    }

    public int getPropertyO() {
        return propertyO;
    }

    public void setPropertyO(int propertyO) {
        this.propertyO = propertyO;
    }

    public int getPropertyP() {
        return propertyP;
    }

    public void setPropertyP(int propertyP) {
        this.propertyP = propertyP;
    }

    @Override
    public String toString() {
        return "AppConfiguration{" +
                "propertyA=" + propertyA +
                ", propertyB=" + propertyB +
                ", propertyC=" + propertyC +
                ", propertyD=" + propertyD +
                ", propertyE=" + propertyE +
                ", propertyF=" + propertyF +
                ", propertyG=" + propertyG +
                ", propertyH=" + propertyH +
                ", propertyI=" + propertyI +
                ", propertyJ=" + propertyJ +
                ", propertyK=" + propertyK +
                ", propertyL=" + propertyL +
                ", propertyM=" + propertyM +
                ", propertyN=" + propertyN +
                ", propertyO=" + propertyO +
                ", propertyP=" + propertyP +
                '}';
    }
}
