Projeto realizado com tomcat 9

Importe o projeto no Eclipse: File -> Import -> Existing Maven Projects

Para popular o banco de dados e cadastrar um usuário com privilégio admim:

1. logue no mysql:
mysql -u root

2. crie o banco de dados casadocodigo, no terminal do mysql:
create database casadocodigo;

3. Tenha certeza de que o seu servidor mysql esteja rodando.

4. Execute o servidor tomcat.

5. Digite a urlmagica em um browser de sua preferência:
http://localhost:8080/casadocodigo/url-magica-jdfkkdpein894mkdk93k40d04jd89dnmfie920djdie9

Isso irá popular o banco de dados com alguns produtos e um usuário:
login: admin@casadocodigo.com.br
senha: 123456