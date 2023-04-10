CREATE DATABASE paulistao
GO
USE paulistao

GO
CREATE TABLE times(
CodigoTime					INT			NOT NULL,
NomeTime					VARCHAR(30) NOT NULL,
Cidade						VARCHAR(30)	NOT NULL,
Estadio						VARCHAR(30) NOT NULL,
MaterialEsportivo			VARCHAR(30) NOT NULL
PRIMARY KEY(CodigoTime)
)

GO
CREATE TABLE grupos(
Grupo		VARCHAR(1)	NOT NULL,
CodTime		INT			NOT NULL	UNIQUE
FOREIGN KEY(CodTime) REFERENCES times (CodigoTime)
)

GO
CREATE TABLE jogos(
CodTimeA	INT		NOT NULL,
CodTimeB	INT		NOT NULL,
GolsA		INT			NULL,
GolsB		INT			NULL,
DataJ		DATE		NULL
FOREIGN KEY(CodTimeA) REFERENCES times (CodigoTime),
FOREIGN KEY(CodTimeB) REFERENCES times (CodigoTime)
)

GO
INSERT INTO times VALUES
	(1, '�gua Santa', 'Diadema', 'Distrital do Inamar', 'Karilu'), 
	(2, 'Botafogo-SP', 'Riber�o Preto', 'Santa Cruz', 'Volt Sport'), 
	(3, 'Corinthians', 'S�o Paulo', 'Neo Qu�mica Arena', 'Nike'), 
	(4, 'Ferrovi�ria', 'Araraquara','Fonte Luminosa', 'Lupo'), 
	(5, 'Guarani', 'Campinas', 'Brinco de Ouro', 'Kappa'), 
	(6, 'Inter de Limeira', 'Limeira', 'Limer�o', 'Alluri Sports'), 
	(7, 'Ituano', 'Itu', 'Novelli J�nior', 'Kanxa'), 
	(8, 'Mirassol', 'Mirassol', 'Jos� Maria de Campos Maia', 'Super Bolla'), 
	(9, 'Novorizontino', 'Novo Horizonte', 'Jorge  Ismael de Biasi', 'Physicus'), 
	(10, 'Palmeiras', 'S�o Paulo', 'Allianz Parque', 'Puma'), 
	(11, 'Ponte Preta', 'Campinas', 'Mois�s Lucarelli', '1900 (Marca Pr�pria)'), 
	(12, 'Red Bull Bragantino', 'Bragan�a Paulista', 'Nabi Abi Chedid', 'Nike'), 
	(13, 'Santo Andr�', 'Santo Andr�', 'Bruno Jos� Daniel', 'Icone Sports'), 
	(14, 'Santos', 'Santos', 'Vila Belmiro', 'Umbro'), 
	(15, 'S�o Bernardo', 'S�o Bernardo do Campo', 'Primeiro de Maio', 'Magnum Group'), 
	(16, 'S�o Paulo', 'S�o Paulo','Morumbi', 'Adidas')


SELECT * FROM times
SELECT * FROM grupos

CREATE PROCEDURE timesGrandes
AS 
BEGIN 
INSERT INTO grupos 
SELECT TOP 4 SUBSTRING('ABCD', ROW_NUMBER()
		OVER (ORDER BY NEWID()), 1), times.CodigoTime
FROM times 
WHERE times.CodigoTime IN (3, 10, 14, 16)
AND times.CodigoTime NOT IN (SELECT CodigoTime FROM grupos) 
ORDER BY NEWID() 
END


CREATE PROCEDURE timesPequenos
AS
BEGIN
    WITH numeros_aleatorios AS (
        SELECT ROW_NUMBER() OVER (ORDER BY NEWID()) 
        AS numero_aleatorio, CodigoTime 
        FROM times
        WHERE CodigoTime NOT IN (3, 10, 14, 16)
    ),
    numeros_grupo AS ( SELECT CodigoTime, CASE 
                WHEN numero_aleatorio IN (1, 2, 3) THEN 'A' 
                WHEN numero_aleatorio IN (4, 5, 6) THEN 'B' 
                WHEN numero_aleatorio IN (7, 8, 9) THEN 'C' 
                ELSE 'D' 
            END AS grupo
        FROM numeros_aleatorios
    )
    INSERT INTO grupos (grupo, CodTime)
    SELECT grupo, CodigoTime FROM numeros_grupo
END
