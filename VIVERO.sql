-- 1
SELECT e.nombre,
    e.apellido1,
    e.apellido2,
    e.puesto,
    e.codigo_oficina,
    RPAD(UPPER(SUBSTR(e.nombre, 1, 2)),8,'?!45') AS "codigo_acceso"
FROM empleado e
WHERE e.puesto NOT LIKE '%Ventas%'
Order by 1,2,3;

-- 2
SELECT pais, COUNT(*) AS cantidad_de_clientes
FROM cliente
WHERE pais = 'Spain'
Group by pais;

-- 3
SELECT COUNT(*) AS "Cantidad de pedidos no entregados a tiempo"
FROM pedido
WHERE estado = 'Pendiente' OR (fecha_entrega IS NOT NULL AND fecha_entrega > fecha_esperada);

--4
SELECT 
    c.NOMBRE_CLIENTE, 
    e.NOMBRE, 
    e.APELLIDO1, 
    e.APELLIDO2, 
    e.PUESTO
FROM C##VIVERO.CLIENTE c
JOIN C##VIVERO.EMPLEADO e 
    ON c.CODIGO_EMPLEADO_REP_VENTAS = e.CODIGO_EMPLEADO
JOIN C##VIVERO.PAGO p 
    ON c.CODIGO_CLIENTE = p.CODIGO_CLIENTE
WHERE e.PUESTO LIKE '%Representante Ventas%'
ORDER BY c.NOMBRE_CLIENTE;


-- 5
SELECT 
    c.NOMBRE_CLIENTE, 
    e.NOMBRE AS NOMBRE_REPRESENTANTE, 
    e.APELLIDO1, 
    e.APELLIDO2, 
    e.PUESTO, 
    o.CIUDAD AS CIUDAD_OFICINA
FROM C##VIVERO.CLIENTE c
JOIN C##VIVERO.EMPLEADO e 
    ON c.CODIGO_EMPLEADO_REP_VENTAS = e.CODIGO_EMPLEADO
JOIN C##VIVERO.OFICINA o 
    ON e.CODIGO_OFICINA = o.CODIGO_OFICINA
JOIN C##VIVERO.PAGO p 
    ON c.CODIGO_CLIENTE = p.CODIGO_CLIENTE
WHERE e.PUESTO LIKE '%Representante Ventas%'
ORDER BY c.NOMBRE_CLIENTE;

--6
select o.ciudad, o.pais, o.region, o.codigo_postal, o.linea_direccion1, o.linea_direccion2
from oficina o
join empleado e on o.codigo_oficina = e.codigo_oficina
join cliente c on c.codigo_empleado_rep_ventas = e.codigo_empleado
where c.ciudad like 'Fuenlabrada';

--7
Select nombre_cliente
from cliente natural join pedido
where pedido.fecha_entrega>pedido.fecha_esperada
order by 1;

--8
Select distinct p.gama
from producto p natural join detalle_pedido d
order by 1;

--9
SELECT c.nombre_cliente
from cliente c left join pago p on c.codigo_cliente = p.codigo_cliente
where p.codigo_cliente is null
order by 1;

--10
SELECT c.nombre_cliente
from cliente c left join producto p on c.codigo_producto = p.codigo_producto
where p.codigo_cliente is null
order by 1;

--11
select codigo_pedido, sum (cantidad)
from detalle_pedido
group by codigo_pedido
order by 1;

--12
Select nombre_cliente, limite_cliente_credito || '€' "Limite de credito", sum (total)||'€' "Cantidad pagada", limite_credito-sum(total)
from cliente NATURAL JOIN pago
GROUP by nombre_cliente, limite_credito
having(sum(total))<limite_credito
order by 1;

--13
SELECT ej.nombre, e.nombre
FROM empleado e 
JOIN empleado ej ON e.codigo_empleado = ej.codigo_jefe
order by 2,1 desc;