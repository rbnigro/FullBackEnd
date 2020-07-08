package br.com.linx.cardValidator.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class BinFixTemplate {
    public static final String ANY_BIN_RESPONSE = "ANY_BIN_RESPONSE";
    public static final String ANY_BIN_REQUEST = "ANY_BIN_REQUEST";

    public static void loadTemplates () {
        anyBinResponse();
        anyBinRequest();
    }

    private static void anyBinResponse() {
        Fixture.of(br.com.linx.cardValidator.templates.BinTemplate.class).addTemplate(ANY_BIN_RESPONSE, new Rule(){{
            add("idBin", random(Long.class, range(1L, 200L)));
            add("idBrand", random(Long.class, range(1L, 200L)));
            add("bin", random(Long.class, range(1L, 200L)));
            add("country",  "BR");
            add("status",  "ATIVO");
            add("createdAt",  instant("now"));
            add("updatedAt", instant("now"));

        }});

    }

    private static void anyBinRequest() {
        Fixture.of(br.com.linx.cardValidator.templates.BinTemplate.class).addTemplate(ANY_BIN_REQUEST, new Rule(){{
            add("idBrand", random(Long.class, range(1L, 200L)));
            add("bin", random(Long.class, range(1L, 200L)));
            add("country",  "BR");
            add("status",  "ATIVO");
            add("createdAt",  instant("now"));
            add("updatedAt", instant("now"));

        }});

    }
}
