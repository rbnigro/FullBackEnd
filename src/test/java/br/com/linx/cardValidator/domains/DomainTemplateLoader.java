package br.com.linx.cardValidator.domains;

import br.com.linx.cardValidator.templates.BinFixTemplate;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class DomainTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        BinFixTemplate.loadTemplates();
    }
}