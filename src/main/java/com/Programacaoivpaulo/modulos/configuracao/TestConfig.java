package com.programacaoivpaulo.modulos.config;

import com.programacaoivpaulo.modulos.pessoaFisica.model.PessoaFisica;
import com.programacaoivpaulo.modulos.pessoaFisica.repositorio.PessoaFisicaRepositorio;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private PessoaFisicaRepositorio pessoaFisicaRepositorio;

  @Override
  public void run(String... args) throws Exception {
    PessoaFisica pessoaFisica1 = new PessoaFisica(
      null,
      "Joao Lucas Lima",
      "joaolm@gmail.com",
      "021.016.576-99"
    );
    PessoaFisica pessoaFisica2 = new PessoaFisica(
      null,
      "Cirilo Joaci Gomes",
      "cjogomes@gmail.com",
      "799.484.597-81"
    );

    pessoaFisicaRepositorio.saveAll(
      Arrays.asList(pessoaFisica1, pessoaFisica2)
    );
  }
}
