create table entrega(
    id SERIAL CONSTRAINT pk_id_entrega PRIMARY KEY,
    cliente_id integer not null,
    taxa decimal(10,2) not null,
    status varchar(20) not null,
    data_pedido timestamp not null,
    data_finalizacao timestamp,
    
    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(255) not null,
    destinatario_numero varchar(30) not null,
    destinatario_complemento varchar(60) not null,
    destinatario_bairro varchar(30) not null
);

alter table entrega add constraint fk_entrega_cliente
foreign key (cliente_id) references cliente (id);