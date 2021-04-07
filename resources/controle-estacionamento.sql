CREATE TABLE `estacionamento`.`veiculos` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

CREATE TABLE `estacionamento`.`modelos` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

CREATE TABLE `estacionamento`.`marcas` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

CREATE TABLE `estacionamento`.`estacionamento` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `placa_veiculo` VARCHAR(45) UNSIGNED NOT NULL,
  `motorista` VARCHAR(45) NOT NULL,
  `dt_entrada` DATETIME NOT NULL,
  `vaga` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

ALTER TABLE `estacionamento`.`estacionamento` CHANGE COLUMN `vaga` `codigo_vaga` VARCHAR(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
 ADD COLUMN `codigo_fileira` VARCHAR(45) NOT NULL AFTER `codigo_vaga`;

