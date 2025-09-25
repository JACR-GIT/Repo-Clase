/*Realiza un procedimiento que dado el id de un 
producto me devuelve su nompre y precio junto
a la cantidad de unidades que se han pedido de el*/
SET SERVEROUTPUT ON

Create or replace procedure procantidad(ngama producto.gama%type)as
  Cursor gproductos is   
    Select nombre, precio_venta 
    from producto
    where gama=ngama;
    
    pnombre producto.nombre%TYPE;
    pprecio producto.precio_venta%TYPE;
    cantidad NUMBER;
begin
    
    Select Count(gama)into cantidad
    from producto
    where gama = ngama;

   Open gproductos;
   DBMS_OUTPUT.PUT_LINE('Nombre y cantidad de la gama: ' || ngama);
   DBMS_OUTPUT.PUT_LINE('-----------------------------');
   LOOP
        FETCH gproductos INTO pnombre,pprecio;
        Exit When gproductos%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Nombre del producto: ' || pnombre);
        DBMS_OUTPUT.PUT_LINE('Precio del producto: ' || pprecio || ' euros.');
        DBMS_OUTPUT.PUT_LINE('-----------------------------');
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Unidades totales: ' || cantidad||'.');
    CLOSE gproductos;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontraron productos en la gama ' || ngama);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

Exec procantidad('Herramientas');