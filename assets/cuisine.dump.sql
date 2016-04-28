-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 27 Décembre 2014 à 15:51
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `cuisine1`
--

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

CREATE TABLE IF NOT EXISTS `ingredient` (
  `id_ingredient` int(6) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `quantite` int(6) DEFAULT NULL,
  `unite` enum('kg','g','L','cl','cuillère à soupe') DEFAULT NULL,
  `id_recette` int(6) NOT NULL,
  PRIMARY KEY (`id_ingredient`),
  KEY `id_recette` (`id_recette`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Contenu de la table `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `nom`, `quantite`, `unite`, `id_recette`) VALUES
(3, 'tagliatelles', 500, 'g', 1),
(4, 'saumon fûmé', 200, 'g', 1),
(5, 'crème fraîche épaisse', 250, 'g', 1),
(6, 'tomates', 2, NULL, 1),
(7, 'huile d''olive', 3, 'cuillère à soupe', 1),
(8, 'échalottes', 3, NULL, 1),
(9, 'ciboulette', 2, 'cuillère à soupe', 1),
(10, 'sel', NULL, NULL, 1),
(11, 'poivre', NULL, NULL, 1),
(12, 'vodka', 7, 'cl', 1),
(13, 'farine', 125, 'g', 3),
(14, 'beurre', 125, 'g', 3),
(15, 'sucre', 250, 'g', 3),
(16, 'chocolat', 200, 'g', 3),
(17, 'oeufs', 4, NULL, 3),
(18, 'sachet de levure', 1, NULL, 3),
(19, 'paquet de levure', 1, NULL, 4),
(20, 'pot de yaourt', 1, NULL, 4),
(21, 'huile', 10, 'cl', 4),
(22, 'pots de sucre', 2, NULL, 4),
(23, 'pots de farine', 3, NULL, 4),
(24, 'oeufs', 2, NULL, 4),
(25, 'oignons', 3, NULL, 5),
(26, 'purée de tomates', 800, 'g', 5),
(27, 'carotte', 1, NULL, 5);

-- --------------------------------------------------------

--
-- Structure de la table `photo_recette`
--


-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

CREATE TABLE IF NOT EXISTS `recette` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `nom` varchar(60) NOT NULL,
  `temps_preparation` smallint(3) NOT NULL,
  `temps_cuisson` smallint(3) NOT NULL,
  `preparation` text NOT NULL,
  `remarque` text NOT NULL,
  `difficulte` tinyint(1) NOT NULL,
  `mots_cles` varchar(200) NOT NULL,
  `auteur` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `auteur` (`auteur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `recette`
--

INSERT INTO `recette` (`id`, `nom`, `temps_preparation`, `temps_cuisson`, `preparation`, `remarque`, `difficulte`, `mots_cles`, `auteur`) VALUES
(1, 'Tagliatelles au saumon fumé et à la vodka', 15, 20, 'Faites chauffer 2,5 litres d''eau chaude salée dans une casserole.\r\n\r\nQuand l''eau se met à bouillir, y plonger les tagliatelles et les laisser cuire le temps indiqué sur le paquet.\r\n\r\nTaillez le saumon fumé en petits dés.\r\n\r\nPlongez la tomate dans l''eau bouillante quelques secondes puis pelez-la et coupez-la en dès.\r\n\r\nPelez et hachez les échalotes.\r\n\r\nLavez et cisaillez la ciboulette.\r\n\r\nFaites chauffer l''huile d''olive dans une poêle, ajoutez-y les échalotes émincées et laissez-les cuire 2 minutes pour qu''elles deviennent translucides.\r\n\r\nAjoutez la crème fraîche, le sel, et le poivre et laissez réduire.\r\n\r\nAjoutez les cubes de tomates et redonner un bouillon.\r\n\r\nEn dernier lieu, y ajouter la vodka.\r\n\r\nQuand les pâtes sont cuites, égouttez-les, et versez-les dans la poêle, en y rajoutant les dés de saumon fumé et la ciboulette ciselée.\r\n', 'Boisson conseillée :\r\nun chardonnay frais', 2, 'pates;tagilatelles;saumon;vodka', 'adurand'),
(2, 'Quiche légère aux poireaux', 20, 40, 'Émincer les blancs de poireaux. \r\n\r\nPréchauffer le four à 180°C (thermostat 6). \r\n\r\nRéaliser une fondue de poireaux (faire revenir les poireaux avec le beurre puis cuire à couvert et à feu moyen pendant 15 min). \r\n\r\nPendant ce temps, mettre dans un récipient les œufs, la crème, le lait, la maïzena.\r\n\r\nMélanger au fouet et assaisonner avec le sel, poivre et la muscade. \r\n\r\nÉtaler la pâte brisée dans un moule à tarte en laissant le papier sulfurisé (couper le papier qui dépasse).\r\n\r\nÉgoutter la fondue de poireaux et la répartir sur la pâte. \r\n\r\nVerser le mélange par-dessus. \r\n\r\nMettre au four 40 min à 180°C (thermostat 6) sur chaleur tournante.\r\n\r\nA déguster accompagné d''une salade verte.', '', 1, 'quiche;poireau;', 'adurand'),
(3, 'Véritable moelleux au chocolat', 10, 30, 'Préchauffer le four à 180°C (th 6).\r\n\r\nFaire fondre le chocolat dans une casserole, avec un peu d''eau.\r\n\r\nHors du feu, ajouter le beurre, la farine et la levure.\r\n\r\nPréparer une mousse avec le jaune d’œuf, le sucre et un peu d''eau; l''ajouter à la préparation chocolatée.\r\n\r\nBattre les blancs en neige, et les incorporer dans la casserole tout doucement.\r\n\r\nVerser le tout dans un moule beurré à bords hauts, et enfourner, pendant environ 35 min.\r\n\r\nOn peut rajouter du sucre glace ou du chocolat fondu, pour décorer le dessus du gâteau.', 'Une parfaite recette de Noel !', 1, 'chocolat;moelleux;gateau;patisserie', 'tdupont'),
(4, 'Gateau au yaourt', 15, 30, 'Mélanger tout simplement les ingrédients un à un, dans l''ordre ci-dessus.\r\n\r\nVerser la pâte dans un moule à gâteau. \r\n\r\nPuis, faire cuire à 180°C (thermostat 6) pendant 30 min environ.\r\n\r\nVérifier la cuisson avec la pointe d''un couteau, qui doit ressortir sèche.', 'Vous pouvez remplacer le citron par un paquet de sucre vanillé. Comme yaourt je vous conseille des Veloutés ou autres yaourts liquides (bulgares, etc.).', 1, 'gateau;yaourt;patisserie', 'tdupont'),
(5, 'Lasagne à la bolognaise', 45, 30, 'Emincez les oignons. Ecrasez l''ail. Hachez finement carotte et céleri. \r\n\r\nFaire revenir ail et oignons dans un peu d''huile d''olive. Ajouter carotte et céleri. Puis la viande. Faire revenir le tout. Puis ajouter le vin rouge. Laisser s''évaporer.\r\n\r\nAjouter la purée de tomates, le verre d''eau, et les herbes. Saler, poivrer, puis laisser mijoter à feu doux 45 min.\r\n\r\nPréparer la béchamel : faites fondre le beurre, puis, hors du feu, ajouter la farine d''un coup. Remettre sur le feu et remuer avec un fouet jusqu''à ce que cela devienne un mélange bien lisse.\r\n\r\nAjouter le lait peu à peu. Remuer sans cesse, jusqu''à ce que le mélange s''épaississe. Ensuite, parfumer avec la muscade, salez, poivrez. Laisser cuire environ 5 min, feu très doux, en remuant. \r\n\r\nHuilez le plat à lasagnes. Posez une fine couche de béchamel, puis : lasagnes, bolognaise, béchamel et parmesan, et cela 3 fois de suite. \r\n\r\nSur la dernière couche de lasagnes, ne mettre que de la béchamel et recouvrir de fromage râpé. Parsemer quelques noisettes de beurre.\r\n\r\nFaire cuire à 200°C pendant environ 25 min.', '', 3, 'lasagne;pates;bolognaise', 'adurand');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `pseudo` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `etat` enum('ATTENTE','VALIDE') NOT NULL,
  PRIMARY KEY (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`pseudo`, `password`, `mail`, `nom`, `prenom`, `isAdmin`, `etat`) VALUES
('adurand', 'adurand', 'adurand@orange.fr', 'Durand', 'Amandine', 0, 'VALIDE'),
('tdupont', 'tdupont', 'tdupont@yopmail.com', 'Dupont', 'Thomas', 0, 'VALIDE');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD CONSTRAINT `ingredient_ibfk_1` FOREIGN KEY (`id_recette`) REFERENCES `recette` (`id`);

--
-- Contraintes pour la table `photo_recette`
--


--
-- Contraintes pour la table `recette`
--
ALTER TABLE `recette`
  ADD CONSTRAINT `recette_ibfk_1` FOREIGN KEY (`auteur`) REFERENCES `utilisateur` (`pseudo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
