# EcoWater 🚢🌎

# Sumário
[Integrantes](#integrantes)  
[Como rodar a aplicação](#como-rodar-a-aplicação)  
[Diagramas](#diagramas)  
[Link do Video](#link-do-video)    
[End Points](#end-points)   

# Integrantes

### Leonardo Blanco – rm99119
Ficou responsavel por Java

### Leonardo Yuuki – rm550373
Ficou responsavel por fazer IA, Mobile

### Gustavo Moreira - rm97999
Ficou responsavel por fazer QA

### Paulo Henrique – rm98082
Ficou responsavel por Banco de Dados

### Daniel Soares -rm552184
Ficou responsavel por C#, Devops

# Como rodar a aplicação

    SRC > MAIN > JAVA > BR.COM.FIAP.GLOBAL > GlobalSolution  
Rodar a aplicação atraves do 'GlobalSolution'.

# Diagramas

## Diagrama de Classes de Entidade
![entity.png](documentacao%2Fdiagramas-classes%2Fentity.png)

## Diagrama de Classes de Request (DTO's)
![request.png](documentacao%2Fdiagramas-classes%2Frequest.png)

## Diagrama de Classes de Response (DTO's)
![response.png](documentacao%2Fdiagramas-classes%2Fresponse.png)

## Diagrama de Arquitetura
![arquitetura.png](documentacao%2Fdiagramas-classes%2Farquitetura.png)

# Link do Video
https://www.youtube.com/watch?v=V7Ntv5wPsF0

# End Points

    1. **ProprietariosResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/proprietarios" - **POST**
        2. "localhost/proprietarios" - **GET by Example**,
        3. "localhost/proprietarios/{id}" - **GET**
    
    2. **EmbarcacoesResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/embarcacoes" - **POST**
        2. "localhost/embarcacoes" - **GET by Example**,
        3. "localhost/embarcacoes/{id}" - **GET**
        
    3. **SensoresResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/sensores" - **POST**
        2. "localhost/sensores" - **GET by Example**,
        3. "localhost/sensores/{id}" - **GET**

    4. **IncidentesResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/incidentes" - **POST**
        2. "localhost/incidentes" - **GET by Example**,
        3. "localhost/incidentes/{id}" - **GET**

    5. **MonitoramentosResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/monitoramentos" - **POST**
        2. "localhost/monitoramentos" - **GET by Example**,
        3. "localhost/monitoramentos/{id}" - **GET**

    6. **RegistrosPoluicaoResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/registros-poluicao" - **POST**
        2. "localhost/registros-poluicao" - **GET by Example**,
        3. "localhost/registros-poluicao/{id}" - **GET**
        
