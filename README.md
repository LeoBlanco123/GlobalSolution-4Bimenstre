# EcoWater 🚢🌎
![LogoReadme.png](documentacao%2FLogo%2FLogoReadme.png)

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
Ficou responsavel por fazer Mobile, Devops

### Gustavo Moreira - rm97999
Ficou responsavel por fazer QA

### Paulo Henrique – rm98082
Ficou responsavel por Banco de Dados e IA

### Daniel Soares -rm552184
Ficou responsavel por C#, Devops

# Como rodar a aplicação
O programa está rodando em uma VM, entre no link abaixo e em seguida coloque o login e senha para consiguir acessar o sistema:   
Link: http://172.210.12.65:8081/  
Login: teste123@gmail.com  
Senha: senha123

# Diagramas

## Diagrama de Classes de Entidade
![entity.png](documentacao%2Fdiagramas-classes%2Fentity.png)

## Diagrama de Classes de Request (DTO's)
![request.png](documentacao%2Fdiagramas-classes%2Frequest.png)

## Diagrama de Classes de Response (DTO's)
![response.png](documentacao%2Fdiagramas-classes%2Fresponse.png)

## Diagrama de Arquitetura
![arquitetura.png](documentacao%2Fdiagramas-classes%2Farquitetura.png)

## MER
![mer.png](documentacao%2Fdiagramas-classes%2Fmer.png)

## DER
![der.png](documentacao%2Fdiagramas-classes%2Fder.png)

# Link dos Videos
Video Pitch: https://www.youtube.com/watch?v=aG6flSJQT6c   
Video Java: https://www.youtube.com/watch?v=4B-9R-tODME   

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
        
