package com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight;

public class BoldFontWeightRenderer implements FontWeightRenderer {
    @Override
    public String render(String text) {
        return "<bold-weight>" + text + "</bold-weight>";
    }
}
