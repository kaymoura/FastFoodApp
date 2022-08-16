# ---------------------------------
# Limpa database antigo
# ---------------------------------
drop database kcm_fastfood;
create database kcm_fastfood;
use kcm_fastfood;

# ---------------------------------
# Cria e popula tabela Cliente
# ---------------------------------

create table cliente (
	id bigint auto_increment,
    nome varchar(60) not null,
    endereco varchar(200),
    cidade varchar(60),
    uf varchar(2),
    cep varchar(8),
    primary key (id)
);

insert into Cliente (nome, endereco, cidade, UF, cep) values
("Kaylane Coelho","Rua Carlos Augusto Cornelsen","Vila Pavão","PR","12395468"),
("Leonardo Ribeiro","Avenida Governador José Malcher","Ji-Paraná","PA","12475468"),
("Kailaine Naiara","Rua Pereira Estéfano","São Paulo","SP","12334868"),
("Bruno Marques","Rua Arlindo Nogueira","Teresina","PI","12395468"),
("Monize Siel","Avenida Juscelino Kubcheck", "São Paulo", "SP","12395468"),
("Livia Andrade","Rua Tenente-Coronel Cardoso","Araçatuba","RJ","55285468"),
("Isadora Munoz","QE 11 Área Especial C","Guará I","DF","12395468"),
("Pedro Henrique","Rua Domingos Olímpio","Sobral","CE","12395468"),
("Thiago Amaral","Travessa da CDL","Ji-Paraná","RO","17539868"),
("Beatriz Vitoria","Rua Paracatu","São Paulo","SP","12998618"),
("Heloysa Slider","Avenida Afonso Pena","Belo Horizonte","MG","12336468"),
("Justin Bieber","Avenida Desembargador Moreira","Belém","PA","15875468");

# ---------------------------------
# Cria e popula tabela Produto
# ---------------------------------

create table produto(
	id bigint auto_increment,
    nomep varchar(60),
    descricao varchar(100),
    qtd decimal(10,2),
    valor_unitario decimal(10,2),
    primary key(id)
);

insert into Produto (nomep, descricao, valorUnitario) values
("Bolo Banana", "Bolo com banana caramelizada", 19.95),("Bolo Limão", "Bolo com cobertura de calda de limão", 22.3),("Bolo Chocolate","Delicioso e macio bolo de chocolate", 25.99),("Bolo Morango", "Bolo cremoso de Morango",15.99),("Bolo Laranja","Bolo de laranja tradicional.", 16.8),
("Bolo Mertilo","Bolo branco ocm Mertilo", 32),("Torta Maça", "Torta tradicional de maça", 9.99),("Torta Chocolate","Torta Chocolate com Açucar de confeiteiro", 10.99),("Torta Limão","Torta de limão com chantilly", 21.2),("Donuts","Donuts com cobertura de chocolate", 11.8),("Pudim","Pudim de leite", 11.8),("Cupcake","Cupcake de chocolate", 8.2);

# ---------------------------------
# Cria a tabela Pedido
# ---------------------------------

create table pedido(
	id bigint auto_increment,
    id_cliente bigint not null,
    aberto_em datetime,
    fechado_em datetime,
    status varchar(20),
    obs varchar(200),
    primary key(id),
    foreign key fk_cliente(id_cliente) references cliente(id)
);

# ---------------------------------
# Cria a tabela Item de Pedido
# ---------------------------------
    
create table item(
	id bigint auto_increment,
    id_pedido bigint,
    id_produto bigint,
    qtd decimal(10,2),
    valor_unitario decimal(10,2),
    obs varchar(60),
    primary key(id),
    foreign key fk_pedido(id_pedido) references pedido(id),
    foreign key fk_produto(id_produto) references produto(id)
);



# ---------------------------------
# Popula Pedido e Item
# ---------------------------------

insert into pedido(id_cliente, aberto_em, status, obs) values
(1, current_timestamp() - interval 2 hour, "CONFIRMADO", "Retira"),
(2, current_timestamp() - interval 1 hour, "CONFIRMADO", "Sem cobertura"),
(3, current_timestamp() - interval 30 minute , "CONFIRMADO", ""),
(4, current_timestamp(), "CONFIRMADO", "");

eseeeeeeeeeeeeeeeeee
insert into item(id_pedido, id_produto, qtd, valor_unitario, obs) values
(1, 1, 2, 20, "Sem Maionese"),
(1, 2, 1, 28.90, ""),
(1, 6, 2, 8, ""),
(1, 4, 2, 6.50, ""),

(2, 1, 1, 20, ""),
(2, 6, 1, 8, ""),
(2, 4, 1, 6.50, ""),

(3, 2, 2, 28.9, ""),
(3, 6, 2, 8, ""),
(3, 4, 2, 6.50, "");
eseeeeeeeeeeeeeeeeee

# ---------------------------------
# Select para analisar cadastro de pedidos
# ---------------------------------
eseeeeeeeeeeeeeeeeee
select 
	pedido.id, 
    pedido.aberto_em,
    pedido.fechado_em,
    pedido.status,
    pedido.id_cliente, 
    cliente.nome, 
    item.id, 
    item.id_pedido, 
    item.id_produto, 
    produto.descricao, 
    item.qtd, 
    item.valor_unitario, 
    item.qtd * item.valor_unitario as valor_total
from pedido, cliente, item, produto
where 
	cliente.id = pedido.id_cliente AND
	item.id_pedido = pedido.id AND
    produto.id = item.id_produto

order by
	pedido.aberto_em;
eseeeeeeeeeeeeeeeeee





use kcmfastfood;

-- create table Cliente (
-- 	id bigint auto_increment,
--     nome varchar(60) not null,
--     endereco varchar(200),
--     cidade varchar(60),
--     uf varchar(2),
--     cep varchar(8),
--     primary key (id)
-- );
-- 
-- CREATE TABLE Produto (
--  id bigint NOT NULL AUTO_INCREMENT,
--  nomep varchar(60),
--  descricao varchar(128) NOT NULL,
--  valorUnitario float NOT NULL,
--  PRIMARY KEY(ID)
-- );

-- insert into Cliente (nome, endereco, cidade, UF, cep) values
-- ("Kaylane Coelho","Rua Carlos Augusto Cornelsen","Vila Pavão","PR","12395468"),
-- ("Leonardo Ribeiro","Avenida Governador José Malcher","Ji-Paraná","PA","12475468"),
-- ("Kailaine Naiara","Rua Pereira Estéfano","São Paulo","SP","12334868"),
-- ("Bruno Marques","Rua Arlindo Nogueira","Teresina","PI","12395468"),
-- ("Monize Siel","Avenida Juscelino Kubcheck", "São Paulo", "SP","12395468"),
-- ("Livia Andrade","Rua Tenente-Coronel Cardoso","Araçatuba","RJ","55285468"),
-- ("Isadora Munoz","QE 11 Área Especial C","Guará I","DF","12395468"),
-- ("Pedro Henrique","Rua Domingos Olímpio","Sobral","CE","12395468"),
-- ("Thiago Amaral","Travessa da CDL","Ji-Paraná","RO","17539868"),
-- ("Beatriz Vitoria","Rua Paracatu","São Paulo","SP","12998618"),
-- ("Heloysa Slider","Avenida Afonso Pena","Belo Horizonte","MG","12336468"),
-- ("Justin Bieber","Avenida Desembargador Moreira","Belém","PA","15875468");

insert into Produto (nomep, descricao, valorUnitario) values
("Bolo Banana", "Bolo com banana caramelizada", 19.95),("Bolo Limão", "Bolo com cobertura de calda de limão", 22.3),("Bolo Chocolate","Delicioso e macio bolo de chocolate", 25.99),("Bolo Morango", "Bolo cremoso de Morango",15.99),("Bolo Laranja","Bolo de laranja tradicional.", 16.8),
("Bolo Mertilo","Bolo branco ocm Mertilo", 32),("Torta Maça", "Torta tradicional de maça", 9.99),("Torta Chocolate","Torta Chocolate com Açucar de confeiteiro", 10.99),("Torta Limão","Torta de limão com chantilly", 21.2),("Donuts","Donuts com cobertura de chocolate", 11.8),("Pudim","Pudim de leite", 11.8),("Cupcake","Cupcake de chocolate", 8.2);