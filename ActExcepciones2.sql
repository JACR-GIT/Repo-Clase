SET SERVEROUTPUT on;
CREATE OR REPLACE PROCEDURE P3JACR1 (numero_centro centros.numce%type,nombre_centro centros.nomce%type)
IS
    Cursor lista_centros is
     Select * from Centros;
    nombre_centro_repetido Exception;
    numero_centro_repetido Exception;
    nomycod_centro_repetido Exception;

BEGIN
   
   For centros in lista_centros Loop
   
       IF (centros.numce = numero_centro and centros.nomce = nombre_centro) THEN
            Raise nomycod_centro_repetido;
        elsif (centros.nomce = nombre_centro) THEN
            Raise nombre_centro_repetido;
        elsif (centros.numce = numero_centro) THEN
         Raise numero_centro_repetido;
        end if;      
    
    END LOOP;
    Insert into Centros (NUMCE, NOMCE)
        Values (numero_centro, nombre_centro);
    DBMS_OUTPUT.PUT_LINE('Centro insertado correctamente');
    FOR centros_insert IN lista_centros LOOP
             DBMS_OUTPUT.PUT_LINE('Codigo centro: ' || centros_insert.numce);
             DBMS_OUTPUT.PUT_LINE('Nombre: ' || centros_insert.nomce);
    END LOOP;
    
EXCEPTION
    WHEN numero_centro_repetido THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Numero de centro duplicado:  El codigo ' || numero_centro || ' ya existe.');
    WHEN nombre_centro_repetido THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Nombre de centro duplicado:  El nombre ' || nombre_centro || ' ya existe.');
    WHEN nomycod_centro_repetido THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: El nombre y el codigo de centro duplicado:  El nombre ' || nombre_centro || ' y el codigo ' || numero_centro || ' ya existen.');  
END P3JACR1;
/
EXEC P3JACR1(100,'Nuevocentro');