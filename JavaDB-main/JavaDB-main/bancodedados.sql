create database vendedor;

create table vendedor(
cpf VARCHAR(14) primary key,
nome VARCHAR(100) not null,
email VARCHAR(100) not null,
total_vendas DECIMAL(10,2)
);

INSERT INTO vendedor (cpf, nome, email, total_vendas) VALUES
('12345678901', 'Joao', 'joao@gmail.com', 10000.00),
('23456789012', 'Maria', 'maria@gmail.com', 2000.00),
('34567890123', 'Pedro', 'pedro@gmail.com', 2500.00),
('45678901234', 'Ana', 'ana@gmail.com', 200.00),
('56789012345', 'Lucas', 'lucas@gmail.com', 2.00),
('67890123456', 'Julia', 'julia@gmail.com', 9000.00),
('78901234567', 'Carlos', 'carlos@gmail.com', 1000.00),
('89012345678', 'Fernanda', 'fernanda@gmail.com', 300.00),
('90123456789', 'Bruno', 'bruno@gmail.com', 200.00),
('01234567890', 'Camila', 'camila@gmail.com', 1200.00),
('11234567890', 'Camila', 'camila@gmail.com', 1200.00);


select * from vendedor where total_vendas > 1000.00;

select sum(total_vendas) as total_geral from vendedor;

select if (
exists (select * from vendedor where total_vendas > 1000.00),
'Existem vendas maiores que 1000',
'Nao existem vendas maiores que 1000'
) as mensagem;
