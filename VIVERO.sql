-- 1
SELECT e.nombre,
    e.apellido1,
    e.apellido2,
    e.puesto,
    e.codigo_oficina,
    RPAD(UPPER(SUBSTR(e.nombre, 1, 2)),8,'?!45') AS "codigo_acceso"
FROM empleado e
WHERE e.puesto NOT LIKE '%Ventas%';

-- 2
SELECT 'Spain' AS pais,
    COUNT(*) AS cantidad_de_clientes
FROM cliente
WHERE pais = 'Spain';

-- 3
SELECT COUNT(*) AS "Cantidad de pedidos no entregados a tiempo"
FROM pedido
WHERE estado = 'Pendiente' OR (fecha_entrega IS NOT NULL AND fecha_entrega > fecha_esperada);

-- 4
SELECT c.nombre_cliente AS "Nombre del Cliente",
    e.puesto ,
    c.nombre_contacto,
    e.apellido1,
    e.apellido2
FROM cliente c
JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE e.puesto LIKE 'Representante Ventas%'
order by e.apellido2;