package com.spring.professional.exam.tutorial.module01.question02.before;

import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.DefaultColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.RedColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.style.DefaultFontStyleRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.BoldFontWeightRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.DefaultFontWeightRenderer;

public class Runner {
    public static void main(String... args) {
        TextRenderer textRenderer = new TextRenderer(new DefaultFontStyleRenderer(), new DefaultColorRenderer(), new DefaultFontWeightRenderer());
        textRenderer.render("Default Rendering");

        TextRenderer redRenderer = new TextRenderer(new DefaultFontStyleRenderer(), new RedColorRenderer(), new DefaultFontWeightRenderer());
        redRenderer.render("Red Color Rendering");

        TextRenderer boldRenderer = new TextRenderer(new DefaultFontStyleRenderer(), new DefaultColorRenderer(), new BoldFontWeightRenderer());
        boldRenderer.render("Bold Rendering");
    }
}
