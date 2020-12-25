package com.spring.professional.exam.tutorial.module01.question02.common.renderer.style;

public class ItalicStyleRenderer implements FontStyleRenderer {
    @Override
    public String render(String text) {
        return "<italic-style>" + text + "</italic-style>";
    }
}
