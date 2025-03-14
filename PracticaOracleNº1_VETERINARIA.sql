--1
CREATE SEQUENCE SCLI
START WITH 28
INCREMENT BY 3;

INSERT INTO Clientes(id,nombre,apellido1,apellido2,ciudad,dirección,teléfono,fecha_nacimiento) 
    VALUES (SCLI.nextval,'julian','navas','nose','sevilla','C/sucalle','389123748','01/01/2006');
INSERT INTO Clientes(id,nombre,apellido1,apellido2,ciudad,dirección,teléfono,fecha_nacimiento) 
    VALUES (SCLI.nextval,'Juanka','navas','nose','sevilla','C/sucalle','389123748','01/01/2006');

--2
UPDATE Citas
Set veterinario_id= (Select id from veterinarios where nombre = 'Ana' and apellido1= 'Pérez' and apellido2='Gonzáles')
Where veterinario_id = (Select id from veterinarios where nombre = 'María' and apellido1= 'García' and apellido2='Martínez')
                        and to_char(fecha,'mm')=04;
                        
--3
UPDATE tratamientos
set precio=precio-(0.02*precio)
where precio = (Select max(Precio) from tratamientos);

--4
Insert into mascotas (id,nombre,fecha_nacimiento,Especie_id) values ((Select Max(id)+1 from mascotas),'Luna', '06/12/2023',(SELECT id FROM especies where nombre = 'Hamster'));

--5
Insert into Tratamientos (id, nombre, precio)
(Select id+100, nombre||' - Descuento',precio*0.8 
from tratamientos where precio>=50);






