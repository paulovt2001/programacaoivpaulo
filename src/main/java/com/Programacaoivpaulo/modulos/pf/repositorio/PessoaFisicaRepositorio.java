package com.programacaoivpaulo.modulos.pessoaFisica.repositorio;

import com.programacaoivpaulo.modulos.pessoaFisica.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepositorio
  extends JpaRepository<PessoaFisica, Long> {}
