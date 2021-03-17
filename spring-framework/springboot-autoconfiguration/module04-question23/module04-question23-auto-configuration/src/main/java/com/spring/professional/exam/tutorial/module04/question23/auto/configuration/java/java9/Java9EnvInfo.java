package com.spring.professional.exam.tutorial.module04.question23.auto.configuration.java.java9;

import com.spring.professional.exam.tutorial.module04.question23.auto.configuration.java.JavaEnvInfo;

class Java9EnvInfo implements JavaEnvInfo {
    @Override
    public void printJvmEnvInfo() {
        System.out.println("Java >=9 Env Info");
    }
}
