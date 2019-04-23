REM *************** tabla reservas ***************

DROP TABLE if exists reserva;

CREATE TABLE reserva (
dniCliente VARCHAR2(9) NOT NULL,
matricula VARCHAR2(7) NOT NULL,
fechaInicio DATE NOT NULL,
diasContratados NUMBER,
horaReserva TIME,
recogida VARCHAR2(5),
CONSTRAINT pk_reservar PRIMARY KEY(dniCliente,matricula,fechaInicio,horaReserva),
CONSTRAINT fk_reserva_cliente FOREIGN KEY(dniCliente) REFERENCES cliente,
CONSTRAINT fk_reserva_vehiculo FOREIGN KEY(matricula) REFERENCES vehiculo
);
