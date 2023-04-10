# crud-carros-devops

![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/Gabriel-Venancio/crud-carros-devops/build.yml?style=plastic)<BR><BR>
Projeto da disciplina Integração Contínua e DevOps [23E1_3] da Pós Graduação de Engenharia de Software com Java do Instituto Infnet
--
Crie um projeto com Spring Boot expondo algumas APIS. O projeto pode ser o mais simples possível, um CRUD, um conversor de medidas etc. É importante construir o projeto através das seguintes regras:<BR>
<BR>
Criar testes unitários para métodos utilizando:<BR>
- JUNIT, MOCKITO, TESTContainers (Opcional).
- Expor o health check do seu projeto com o Actuator.
- Exportar métricas do seu projeto para o formato do Prometheus utilizando o micrometer.
- Exportar LOGs do seu projeto para alguma ferramenta de logs. (Ex. Papertrail)
- Exportar dados do seu projeto para o Zipkin.
- Criar Script no terraform em qualquer provedor que crie apenas uma máquina virtual de qualquer formato. Esse script deve possuir 1 arquivo main, um arquivo de variáveis e um arquivo de outputs.
- Criar um pipeline de build do seu projeto no Gitlab.


Instruções para executar o projeto
--
Rodar os comandos:
<code>
docker run -p 8080:8080 carros-crud-devops
docker build -t carros-crud-devops .
</code>
Baixar o arquivo [docker-compose.yml](https://github.com/Gabriel-Venancio/crud-carros-devops/blob/master/docker-compose.yml) (necessário ter o docker)<BR>
No mesmo diretorio onde o arquivo foi baixado, executar o comando: docker-compose up <BR>
URL da API: http://localhost:8080/cars <BR>
URL do Zipkin: http://localhost:9411 <BR>
URL do Prometheus: http://localhost:9090 <BR>
URL do Grafana: http://localhost:3000 <BR>


<BR>

A pipeline de build está sendo realizada pelo Github Actions.
