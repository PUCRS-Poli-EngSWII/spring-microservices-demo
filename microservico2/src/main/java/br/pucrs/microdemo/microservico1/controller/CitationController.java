package br.pucrs.microdemo.microservico1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.microdemo.microservico1.business.CitationCollection;

import br.pucrs.microdemo.commons.ClasseComumEntidade;

@RestController
public class CitationController {
    @Autowired
    private CitationCollection citationCollection;

    @GetMapping("/citation")
    public String getCitation() {
        return citationCollection.getCitation();
    }
}
