/* */
/* C1 Listado de alumnos junto con su edad, ordenado de mayor a menor edad. Indicad los 
alias que se muestran en la imagen indicando tus iniciales.*/

select apellido1 || ' '|| apellido2 ||', '|| nombre "Apellidos y nombre del alumno/a mjch",
        trunc((sysdate-fecha_nacimiento)/365.25,0)||' años' as "Edad"
from personas
where tipo='alumno'
order by 2 desc,1 ;

 /*C2 Tipos de asignaturas que tienen más de 10 asignaturas. No olvides asignar los alias adecuados*/
 select tipo, count(id)"Cantidad de asignaturas"
 from asignatura
 group by tipo
 having count(id)>=15
 order by tipo;
 
/* C3 Listado de alumnos que hay matrículados en el curso 2022-2023. No olvides indicar los
alias adecuados. El listado debe aparecer ordenado como se ve en la imagen y sin repetición de nombres */
select  DISTINCT p.id,p.nombre, p.apellido1, p.apellido2,c.año_inicio, c.año_fin
from curso_escolar c join alumno_se_matricula_asignatura a 
        on c.id=a.id_curso_escolar
    join personas p on a.id_alumno=p.id
where c.año_inicio=2022 and c.año_fin=2023
ORDER BY 2,3,1;

/* C4 Listado de profesores y alumnos cuyo NIF finaliza en G, ordenado según aparece en la imagen.
No olvides indicar los alias adecuado.*/
select Nombre, Apellido1, Apellido2, NIF, tipo
from personas
where nif like '%G'
order by tipo, apellido1, apellido2;
 
/*C5 Muestra, concatenados en una única columna, el nombre y apellidos de los alumnos y la dirección  
de los alumnos que han nacido en el primer trimestre de cualquier año.  */
SELECT NOMBRE||' '||APELLIDO1||' '||APELLIDO2 "Nombre del alumno",
DIRECCIÓN, FECHA_NACIMIENTO "Fecha nacimiento"
FROM PERSONAS 
WHERE TIPO = 'alumno' and TO_CHAR(FECHA_NACIMIENTO, 'mm') IN (1,2,3)
order by apellido1,apellido2;

/* Consulta nº 6 Listado con todas las asignaturas ofertadas en el 
Grado en Ingeniería Informática (Plan 2015)  */
SELECT a.NOMBRE "Asignaturas", GRADO.NOMBRE as "Grado"
FROM ASIGNATURA a JOIN GRADO ON GRADO.ID = a.ID_GRADO
WHERE GRADO.NOMBRE like '%Ingeniería Informática%(Plan 2015)%';

/* Consulta nº 7 Listado de las asignaturas que imparte el profesor Zoe, Ramírez Gea de tipo básica */
SELECT a.NOMBRE "Asignaturas", a.TIPO "Tipo"
FROM ASIGNATURA  a JOIN PROFESOR ON a.ID_PROFESOR = PROFESOR.ID_PROFESOR
                                    JOIN PERSONAS pe ON pe.ID = PROFESOR.ID_PROFESOR
WHERE pe.NOMBRE = 'Zoe' and pe.APELLIDO1 = 'Ramírez' and pe.APELLIDO2 = 'Gea'
            and a.TIPO = 'básica';          
                
/* Consulta nº 8 */
SELECT APELLIDO1 "Primer Apellido", APELLIDO2 "Segundo Apellido", pe.NOMBRE "Nombre Profesor", de.NOMBRE "Nombre Departamento"
FROM PERSONAS pe JOIN PROFESOR ON pe.ID = PROFESOR.ID_PROFESOR
                                    JOIN DEPARTAMENTO de ON de.ID = PROFESOR.ID_DEPARTAMENTO
ORDER BY 1,2,3,4;

/* Consulta nº 9*/
SELECT de.NOMBRE "Departamentos sin profesores"
FROM DEPARTAMENTO de LEFT JOIN PROFESOR ON de.ID = PROFESOR.ID_DEPARTAMENTO
WHERE ID_PROFESOR IS NULL
order by 1;

/* C10 Alumnos de mayor edad */
/* Consulta nº 10*/
SELECT NIF, NOMBRE, APELLIDO1, APELLIDO2, CIUDAD, DIRECCIÓN, TELÉFONO, FECHA_NACIMIENTO,TIPO, trunc((SYSDATE -FECHA_NACIMIENTO) / 365.25, 0)"Edad"
FROM PERSONAS
WHERE tipo = 'alumno' 
    and trunc((SYSDATE -FECHA_NACIMIENTO) / 365.25, 0) =(SELECT MAX(trunc((SYSDATE -FECHA_NACIMIENTO) / 365.25, 0)) 
                                                                                                 FROM PERSONAS WHERE tipo = 'alumno');
                                                                                    

/* Consulta nº 11 */

SELECT GRADO.NOMBRE "Nombre grado", TIPO "Tipo asignatura", CRÉDITOs "Total créditos"
FROM ASIGNATURA JOIN GRADO ON ASIGNATURA.ID_GRADO = GRADO.ID
order by GRADO.NOMBRE, tipo;

-- Para sumarlos hay que hacer la suma y para ello hay que aplicar un group by
SELECT GRADO.NOMBRE "Nombre grado", TIPO "Tipo asignatura", sum(CRÉDITOS) "Total créditos"
FROM ASIGNATURA JOIN GRADO ON ASIGNATURA.ID_GRADO = GRADO.ID
GROUP BY GRADO.NOMBRE, tipo
order by 3 desc;

/* Consulta nº 12 Cantidad de asignaturas que no tienen todavía asignado profesor.  */
SELECT count(*) as "Asignaturas sin profesor"
FROM ASIGNATURA a 
WHERE a.ID_PROFESOR IS NULL;

 /*Profesores que no tienen asignado todavía asignaturas*/
select p.nombre, a.id
from personas p left join profesor pro on p.id=pro.id_profesor left join asignatura a on pro.id_profesor=a.id_profesor
where p.tipo='profesor';

select count(p.nombre) "Profesores sin asignaturas"
from personas p left join profesor pro on p.id=pro.id_profesor left join asignatura a on pro.id_profesor=a.id_profesor
where p.tipo='profesor' and a.id is null;

select count(pro.id_profesor)
from profesor pro left join asignatura a on pro.id_profesor=a.id_profesor
where a.id is null;

/* Consulta nº 13 */
SELECT de.NOMBRE "Departamento", count(ID_PROFESOR)"Nº de profesores"
FROM DEPARTAMENTO de JOIN PROFESOR ON de.ID = PROFESOR.ID_DEPARTAMENTO 
group by de.NOMBRE
HAVING count(ID_PROFESOR) > 2;

/* Consulta nº 14 alumnos que no se han matrículado todavía en ninguna asignatura y asignaturas 
que todavía no tienen alumnos matriculados.*/
SELECT a.NOMBRE "Asignatura", p.nombre "Alumno", p.apellido1, p.apellido2
FROM asignatura a FULL JOIN alumno_se_matricula_asignatura m ON a.ID = m.id_asignatura
                  full join personas p on p.id=m.id_alumno
WHERE a.nombre IS NULL or p.nombre is null;


/* Consulta nº 15 */
CREATE VIEW vista_profesores AS
    SELECT PERSONAS.NOMBRE , APELLIDO1, APELLIDO2, CIUDAD, TELÉFONO, FECHA_NACIMIENTO, SEXO, TIPO, de.NOMBRE Departamento
    FROM PERSONAS JOIN PROFESOR ON PERSONAS.ID = PROFESOR.ID_PROFESOR
                                    JOIN DEPARTAMENTO de ON PROFESOR.ID_DEPARTAMENTO = de.ID;                          
 
 select * from vista_profesores; 
   
/* Consulta nº 16 */
Select departamento, sexo, count(*)"Cantidad profesores/as"
from v 
ista_profesores
group by departamento, sexo
order by 1;

/*INSERT, UPDATE, DELETE*/
/*UT5_EJ1 Crea la siguiente tabla. Escribe la instrucción insert necesaria para insertar en
ella los datos de los alumnos los cuales se encuentran en la tabla personas.*/

CREATE TABLE alumnos (
    id INTEGER PRIMARY KEY,
    nif VARCHAR2(9),
    nombre VARCHAR2(25) NOT NULL,
    apellido1 VARCHAR2(50) NOT NULL,
    apellido2 VARCHAR2(50),
    ciudad VARCHAR2(25) NOT NULL,
    dirección VARCHAR2(50) NOT NULL,
    teléfono VARCHAR2(9),
    fecha_nacimiento DATE NOT NULL,
    sexo CHAR(2) CHECK (sexo IN ('H', 'M')) NOT NULL,
    tipo CHAR(8) CHECK (tipo IN ('profesor', 'alumno')) NOT NULL
);

INSERT INTO alumnos
SELECT *
FROM personas
WHERE tipo='alumno';

/*UT5_Ej2 Escribe los insert necesarios para registrar que el alumno
José	Koss	Bayer se ha matrículado en el curso 2022-2023 en las siguientes asignaturas
de: Biología celular,Física,Matemáticas I,Química general*/
insert into alumno_se_matricula_asignatura(id_alumno,id_asignatura,id_curso_escolar)VALUES(6,52,5);
insert into alumno_se_matricula_asignatura(id_alumno,id_asignatura,id_curso_escolar)VALUES(6,53,5);
insert into alumno_se_matricula_asignatura(id_alumno,id_asignatura,id_curso_escolar)VALUES(6,54,5);
insert into alumno_se_matricula_asignatura(id_alumno,id_asignatura,id_curso_escolar)VALUES(6,55,5);

/*UT5_EJ3 Los créditos de las asignaturas optivas pasan de 6 a 8*/
update asignatura
set créditos=8
where tipo='optativa';

/*UT5_EJ4 Las asignaturas que imparte el profesor Zoe	Ramírez Gea queremos que las imparta ahora el 
profesor David	Schmidt	Fisher*/
-- Esta forma sería incorrecta
update asignatura
set id_profesor=5
where id_profesor=3;

-- Esta forma es correcta
update asignatura
set id_profesor=(select id from personas where nombre='David' and apellido1='Schmidt' and apellido2='Fisher')
where id_profesor=(select id from personas where nombre='Zoe' and apellido1='Ramírez' and apellido2='Gea');

/*UT5_EJ5 Escribe la sentencia sql para borrar de la tabla GRADO el grado de Grado en Biotecnología (Plan 2015) 
¿Qué tenemos que hacer para poder eliminarlo? Explícalo.*/
delete grado
where nombre like '%Biotecnología%';