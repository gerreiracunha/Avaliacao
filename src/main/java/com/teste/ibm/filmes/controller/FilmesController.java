package com.teste.ibm.filmes.controller;

import com.teste.ibm.filmes.domain.Filmes;
import com.teste.ibm.filmes.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @CrossOrigin
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Filmes>> seacheTitile(@RequestParam(value = "Title", required = false) String title,
                                                     @RequestParam(value = "page", required = false) String page,
                                                     @RequestParam(value = "year", required = false) String year) {

        return new ResponseEntity<>(filmesService.seacheTitile(
                "Title=".concat(Optional.ofNullable(title).orElse("")),
                "page=".concat(Optional.ofNullable(page).orElse("1")),
                Optional.ofNullable(year).orElse("")), HttpStatus.OK);
    }
}
