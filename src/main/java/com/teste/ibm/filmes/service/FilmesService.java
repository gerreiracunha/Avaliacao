package com.teste.ibm.filmes.service;

import com.teste.ibm.filmes.domain.CatalogoFilmes;
import com.teste.ibm.filmes.domain.Filmes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FilmesService {
    public static final String URL_API = "https://jsonmock.hackerrank.com/api/movies/search?";

    public List<Filmes> seacheTitile(String title, String page, String year) {
        CatalogoFilmes catalogoFilmes = new RestTemplate().getForObject(URL_API.concat(title.concat("&").concat(page)), CatalogoFilmes.class);
        if (catalogoFilmes==null)
            return Collections.emptyList();

        if (Objects.nonNull(year) && !year.isEmpty())
            catalogoFilmes.setData((ArrayList<Filmes>) catalogoFilmes.getData().stream().filter(filmes -> filmes.Year.equals(year)).collect(Collectors.toList()));

        return catalogoFilmes.getData().stream().sorted(Comparator.comparing(Filmes::getTitle)).collect(Collectors.toList());
    }
}
