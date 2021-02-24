package com.spring.professional.exam.tutorial.module04.question23.auto.configuration.java.java8;

import com.spring.professional.exam.tutorial.module04.question23.auto.configuration.java.JavaEnvInfo;

class Java8EnvInfo implements JavaEnvInfo {
    @Override
    public void printJvmEnvInfo() {
        System.out.println("Java <=8 Env Info");
    }
}
