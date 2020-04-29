package com.stockers.stockers.user.controller;

import com.stockers.stockers.user.domain.Article;
import com.stockers.stockers.user.dto.ArticleDto;
import com.stockers.stockers.user.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/article")
@Api(tags = "articles")
public class ArticleController {
    private ArticleService articleService;
    private Article article;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    @ApiOperation(value = "Listado de articulos", notes = "Devuelve un listado de articulos")
    public ResponseEntity<List<Article>> article(){
        return ResponseEntity.ok(articleService.findAll());

    }
    @GetMapping(path = "/{articleId}")
    @ApiOperation(value = "Busca un articulo", notes = "Devuelve un articulo según ID")
    public ResponseEntity<Article> getArticle(@PathVariable Integer articleId){
        return ResponseEntity.ok(articleService.findById(articleId));
    }

    @PostMapping()
    @ApiOperation(value = "Crea un articulo", notes = "Crea un articulo y lo devuelve")
    public ResponseEntity<Article> createArticle(@RequestBody @Valid ArticleDto articleDto){
        Article article = new Article();
        article.setName(articleDto.getName());
        article.setArtCode(articleDto.getArtCode());
        article.setModel(articleDto.getModel());
        article.setType(articleDto.getType());
        article.setLocation(articleDto.getLocation());
        article.setQuantity(articleDto.getQuantity());
        article.setManufacturingDate(articleDto.getManufacturingDate());
        article.setDescription(articleDto.getDescription());
        article.setArticles(articleDto.getArticles());
        article.setPrice(articleDto.getPrice());
        return ResponseEntity.ok(articleService.create(article));
    }
    @PutMapping(path = "/{articleId}")
    @ApiOperation(value = "Actualiza un articulo", notes = "Actualiza un articulo y lo devuelve")
    public ResponseEntity<Article> updateArticle(@PathVariable Integer articleId, @RequestBody @Valid ArticleDto articleDto){
        Article article = new Article();
        article.setArticleId(articleDto.getArticleId());
        article.setName(articleDto.getName());
        article.setArtCode(articleDto.getArtCode());
        article.setModel(articleDto.getModel());
        article.setType(articleDto.getType());
        article.setLocation(articleDto.getLocation());
        article.setQuantity(articleDto.getQuantity());
        article.setManufacturingDate(articleDto.getManufacturingDate());
        article.setDescription(articleDto.getDescription());
        article.setArticles(articleDto.getArticles());
        article.setPrice(articleDto.getPrice());
        return ResponseEntity.ok((articleService.update(article)));

    }

    @DeleteMapping("/{ID de articulo}")
    @ApiOperation(value = "Eliminar articulo", notes = "Servicio para eliminar un articulo")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "articulo eliminado correctamente"),
            @ApiResponse(code = 404, message = "articulo no encontrado") })
    public void removeArticles (@PathVariable("ID de articulo") Integer articleId) {
        Article article = this.articleService.findById(articleId);
        if (article != null){
            this.articleService.delete(article);

        }
    }

}