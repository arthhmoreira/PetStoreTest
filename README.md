# PetStoreTest

Um projeto feito para o processo seletivo utilizando RestAssured e Java.

## Índice

- [Sobre](#sobre)
- [Como Usar](#como-usar)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

## Sobre

Este é um projeto de casos de testes para a API: https://petstore.swagger.io/.
Nele eu preciso garantir status code, estrutura da resposta e valores dos dados.

Deixei alguns testes já prontos para vermos sua utilização sendo eles os arquivos.
- "PetOrderTest.java"
- "SearchPetByStatusTest.java"
- "SearchPetTest.java"
- "UpdatePetDataTest.java"

### Pré-requisitos

Liste os pré-requisitos que você precisa para instalar o software, como:

- [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [RestAssured](https://rest-assured.io/)
- [Maven](https://maven.apache.org/) (Utilizando uma IDE como IntelliJ ele vem junto)

### Instalação

Passo a passo de como instalar o projeto.

```bash
# Exemplo de instalação

# Utilizar o git para clonar o repositório do projeto.
git clone https://github.com/arthhmoreira/PetStoreTest.git

# Navegar pelo terminal até a pasta destino.
cd PetStoreTest

# Comando maven para rodar os testes
mvn clean install # ou mvn test 


