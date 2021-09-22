package com.programacaoivpaulo.modulos.pessoaFisica.rest;

import com.programacaoivpaulo.modulos.pessoaFisica.model.PessoaFisica;
import com.programacaoivpaulo.modulos.pessoaFisica.servicos.PessoaFisicaServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoafisica")
public class PessoaFisicaRest implements PessoaFisicaApi {

  @Autowired
  PessoaFisicaServicos pessoaFisicaServicos;

  @GetMapping
  public ResponseEntity<List<PessoaFisica>> ListarPessoas() {
    List<PessoaFisica> list = pessoaFisicaServicos.buscarTodos();
    return ResponseEntity.ok().body(list);
  }
  @GetMapping(value = "/{id}")
  public ResponseEntity<PessoaFisica> BuscarPorId(@PathVariable Long id){
  	PessoaFisica pessoaFisica = pessoaFisicaServicos.buscarPorId(id);
  	return ResponseEntity.ok().body(pessoaFisica);
  }
  @PostMapping
  public ResponseEntity<PessoaFisica> Adcionar(@RequestBody PessoaFisica pessoaFisica){
  	System.out.println(pessoaFisica.getCpf());
  	pessoaFisica = pessoaFisicaServicos.inserir(pessoaFisica);
  	URI url = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
  			.buildAndExpand(pessoaFisica.getId()).toUri();
  	
  	return ResponseEntity.created(url).body(pessoaFisica);
  }
}
