## Mutation Test Kotlin

[![Minimum Kotlin Version](https://img.shields.io/badge/kotlin-%5E1.5.0-blue)](https://kotlinlang.org)
[![Coverage](https://img.shields.io/badge/coverage-100%25-green)](https://github.com/gustavofreze/mutation-test-kotlin)
[![Mutation](https://img.shields.io/badge/mutation-100%25-green)](https://github.com/gustavofreze/mutation-test-kotlin)

* [Introdução](#introduction)
* [Instalação](#installation)
* [Testes](#tests)
    - [Pitest](#pitest)
    - [Executando os testes](#execute)
    - [Úteis](#util)

<div id='introduction'></div> 

## Introdução

O teste de mutação é um sistema usado para projetar novos testes de software e avaliar a qualidade dos testes de
software existentes. O teste de mutação envolve a modificação de um programa em pequenas maneiras. O conceito de teste
de mutação é bem simples, bugs/mutantes, são inseridos no código e os testes são executados em cima do código mutado. Se
pelo menos um dos testes quebrar ou tiver timeout, o mutante é considerado morto, e aquele trecho de código alterado é
considerado como coberto pelos testes.

<div id='installation'></div>

## Instalação

- Abra seu terminal, navegue até o diretório de sua preferência, e execute:
  ```bash
  > git clone https://github.com/gustavofreze/mutation-test-kotlin.git
  ```

- Em seguida, execute o comando abaixo para configurar o projeto, e instalar as depêndencias:
  ```bash
  > make configure
  ```
  
<div id='tests'></div>

## Testes

<div id='pitest'></div>

### Pitest

Neste exemplo utilizarei o framework Pitest. O Pitest é um sistema de teste de mutação de última geração, 
fornecendo cobertura de teste para Java e jvm. É rápido, escalonável e 
se integra a ferramentas modernas de teste e construção. 
Mais detalhes sobre o [Pitest](https://pitest.org).

<div id='execute'></div>

### Executando os testes

```bash
> make test-unit       # Executa apenas os testes unitários
> make test-mutation   # Executa apenas os testes de mutação
```

<div id='util'></div>

### Úteis

Comandos úteis após a execução dos testes.

```bash
> make show-coverage # Abre no Google Chrome o coverage
```