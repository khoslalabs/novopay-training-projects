package com.spring.professional.exam.tutorial.module01.question02.before;

import com.spring.professional.exam.tutorial.module01.question02.common.renderer.Renderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.FontColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.style.FontStyleRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.FontWeightRenderer;

class TextRenderer {

    private final FontStyleRenderer fontStyleRenderer;
    private final FontColorRenderer fontColorRenderer;
    private final FontWeightRenderer fontWeightRenderer;

    TextRenderer(FontStyleRenderer fontStyleRenderer, FontColorRenderer fontColorRenderer, FontWeightRenderer fontWeightRenderer) {
        this.fontStyleRenderer = fontStyleRenderer;
        this.fontColorRenderer = fontColorRenderer;
        this.fontWeightRenderer = fontWeightRenderer;
    }

    void render(String text) {
        String renderedText = applyRendering(text, fontStyleRenderer, fontColorRenderer, fontWeightRenderer);

        System.out.println(renderedText);
    }

    private String applyRendering(String text, Renderer... renderers) {
        for (Renderer renderer : renderers) {
            text = renderer.render(text);
        }
        return text;
    }
}
