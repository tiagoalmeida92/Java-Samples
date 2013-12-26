====================================================================================
Estrutura do repositório 
====================================================================================

http://code.deetc.e.ipl.pt/ls/.../svn/<IDENTIFICADOR_DO_GRUPO>/ 
   |    
   +-- trunk ......................... Ramo principal de desenvolvimento
   |   |
   |   +-- build.xml ................. Ficheiro de build do ApacheAnt
   |   |
   |   +-- src ....................... Directoria que inclui o código fonte 
   |   |   |                          (produzido pela equipa de desenvolvimento)
   |   |   |
   |   |   +-- main                    Ficheiros fonte com as funcionalidades implementadas
   |   |   |   |
   |   |   |   +-- java                Ficheiros Java, organizados por package
   |   |   |       +-- <package-root>
   |   |   |    
   |   |   +-- test                    Ficheiros fonte com os testes unitários
   |   |   |   |
   |   |   |   +-- <semelhante a /trunk/main/java/>
   |   |   |
   |   |   +-- docs .................. Ficheiros com documentação de projecto
   |   |
   |   +-- vendor .................... Ficheiros produzidos por entidades externas...
   |       +-- main                          ... necessários ao funcionamento das aplicações
   |       |   +-- lib  
   |       |       +-- sqljdbc4.jar    Exemplo de library do driver JDBC para SQLServer
   |       +-- test                          ... necessários à execução dos testes unitários
   |           +-- lib  
   |               +-- junit-4-8.1.jar Exemplo de library do jUnit 4.8.1 (apenas usada nos testes)
   |
   +-- tags .......................... "Fotografia" do estado do projecto num dado instante
   |   |
   |   +-- 0.1.0  Conteúdo de /trunk relativo à entrega da etapa 1
   |   +-- 0.2.0  Conteúdo de /trunk relativo à entrega da etapa 2
   |   +-- 0.3.0  Conteúdo de /trunk relativo à entrega da etapa 3
   |   +-- 1.0.0  Conteúdo de /trunk relativo à entrega da etapa 4
   |   
   +-- branches .....................  Ramos alternativos ao desenvolvimento
                                                   Devem ter a mesma estrutura que /trunk

    
Nota:    
A directoria /target apenas deve existir na máquina de desenvolvimento. 
Devem usar o comando SVN Ignore para evitar que esta directoria seja listada na interface gráfica do comando SVN Commit.