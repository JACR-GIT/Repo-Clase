CREATE OR REPLACE PROCEDURE P2JACR1 (p_codigo_cliente IN NUMBER)
IS
    v_nombre_cliente    CLIENTE.NOMBRE_CLIENTE%TYPE;
    v_total_pedidos     NUMBER := 0;
    v_total_pagado      NUMBER := 0;
    v_diferencia        NUMBER := 0;
    ex_sin_pedidos       EXCEPTION;

BEGIN
   SELECT NOMBRE_CLIENTE INTO v_nombre_cliente
    FROM CLIENTE
    WHERE CODIGO_CLIENTE = p_codigo_cliente;
    
    SELECT COUNT(*) INTO v_diferencia
    FROM PEDIDO
    WHERE CODIGO_CLIENTE = p_codigo_cliente;

    IF v_diferencia = 0 THEN
        RAISE ex_sin_pedidos;
    END IF;
    
    SELECT SUM(dp.CANTIDAD * dp.PRECIO_UNIDAD)INTO v_total_pedidos
    FROM PEDIDO p
    JOIN DETALLE_PEDIDO dp ON p.CODIGO_PEDIDO = dp.CODIGO_PEDIDO
    WHERE p.CODIGO_CLIENTE = p_codigo_cliente;

    SELECT SUM(TOTAL) INTO v_total_pagado
    FROM PAGO
    WHERE CODIGO_CLIENTE = p_codigo_cliente;

    v_diferencia := v_total_pedidos - v_total_pagado;

    DBMS_OUTPUT.PUT_LINE('El importe total de los pedidos del cliente ' || v_nombre_cliente || ' es: ' || v_total_pedidos || ' €');
    DBMS_OUTPUT.PUT_LINE('Ha pagado:' || v_total_pagado || ' €');
    DBMS_OUTPUT.PUT_LINE('DEBE  ' || v_diferencia || ' €');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: El cliente con código ' || p_codigo_cliente || ' no existe.');

    WHEN ex_sin_pedidos THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: El cliente con código ' || p_codigo_cliente || ' no ha realizado ningún pedido.');
END P2JACR1;
/
EXEC P2JACR1(10);