
SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

-- Suppression des données existantes
DROP TABLE IF EXISTS `adresse_postale`, `agence_voyage`, `bagage`, `voyageur`;

-- Création de la table `adresse_postale`
CREATE TABLE `adresse_postale` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `postal_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insertion de données dans `adresse_postale`
INSERT INTO `adresse_postale` (`id`, `street`, `city`, `postal_code`) VALUES
(1, 'Avenue des Champions', 'Paris', '75001'),
(2, 'Rue du Panier', 'Marseille', '13001'),
(3, 'Chemin du Terrain', 'Lyon', '69001'),
(4, 'Avenue du Slam', 'Bordeaux', '33000'),
(5, 'Rue du Crossover', 'Lille', '59000'),
(6, 'Boulevard de la Passe', 'Toulouse', '31000');

-- Création de la table `agence_voyage`
CREATE TABLE `agence_voyage` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `adresse_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `adresse_id` (`adresse_id`),
  CONSTRAINT `agence_voyage_ibfk_1` FOREIGN KEY (`adresse_id`) REFERENCES `adresse_postale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Création de la table `bagage`
CREATE TABLE `bagage` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `color` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insertion de données dans `bagage`
INSERT INTO `bagage` (`id`, `number`, `weight`, `color`) VALUES
(11, '1', 10.00, 'bleu'),
(12, '2', 20.00, 'rouge'),
(13, '1', 10.00, 'vert'),
(14, '2', 20.00, 'jaune');

-- Création de la table `voyageur`
CREATE TABLE `voyageur` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `category` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `adresse_id` int unsigned DEFAULT NULL,
  `bagage_id` int unsigned DEFAULT NULL,
  `agence_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `adresse_id` (`adresse_id`),
  KEY `bagage_id` (`bagage_id`),
  KEY `agence_id` (`agence_id`),
  CONSTRAINT `voyageur_ibfk_1` FOREIGN KEY (`adresse_id`) REFERENCES `adresse_postale` (`id`),
  CONSTRAINT `voyageur_ibfk_2` FOREIGN KEY (`bagage_id`) REFERENCES `bagage` (`id`),
  CONSTRAINT `voyageur_ibfk_3` FOREIGN KEY (`agence_id`) REFERENCES `agence_voyage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insertion de données dans `voyageur`

INSERT INTO `voyageur` (`id`, `name`, `category`, `age`, `adresse_id`, `bagage_id`, `agence_id`) VALUES
(3,	'Michel Durant',	'Adulte',	35,	1,	13,	NULL),
(4,	'Pierre Leclerc',	'Adulte',	30,	2,	14,	NULL);

