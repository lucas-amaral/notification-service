package com.proposta.aceita.notificationservice.services;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;

@Service
public class TemplateService {

    private final TemplateEngine templateEngine;

    public TemplateService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String process(String templateName, Map<String, Object> variables) {
        final Context context = new Context();
        context.setVariables(variables);
        return templateEngine.process(templateName, context);
    }

    public String processWithoutVariables(String templateName) {
        final Context context = new Context();
        return templateEngine.process(templateName, context);
    }

}
