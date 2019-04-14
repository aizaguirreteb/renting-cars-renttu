REM *************** ALQUILER.SQL *****************

DROP TABLE IF EXISTS alquiler;

CREATE TABLE alquiler (
id NUMBER NOT NULL,
dniCliente VARCHAR2(9) NOT NULL,
matricula VARCHAR2(7) NOT NULL,
fechaInicio DATE NOT NULL,
fechaPrevistaEntrega DATE NOT NULL,
fechaEntrega DATE,
diasContratados NUMBER,
kmRecorridos NUMBER,
estadoDeposito VARCHAR2(10),
numRenovaciones NUMBER,
pagoEfectuado VARCHAR2(10),
precioDia NUMBER,
estadoAlquiler VARCHAR2(4),
CONSTRAINT pk_alquiler PRIMARY KEY(id,dniCliente,matricula,fechaInicio,fechaPrevistaEntrega),
CONSTRAINT fk_alquiler_cliente FOREIGN KEY(dniCliente) REFERENCES cliente,
CONSTRAINT fk_alquiler_vehiculo FOREIGN KEY(matricula) REFERENCES vehiculo
);

REM ***Falta diseñar una tabla con la contabilidad donde llevemos el id del alquiler y obtengamos 
REM *** todos los datos relativos al pago, descuentos, precio total.
