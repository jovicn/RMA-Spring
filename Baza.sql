-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for android_ispit
DROP DATABASE IF EXISTS `android_ispit`;
CREATE DATABASE IF NOT EXISTS `android_ispit` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `android_ispit`;

-- Dumping structure for table android_ispit.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `forename` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `addres` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `uq_account_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.account: ~5 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
REPLACE INTO `account` (`account_id`, `forename`, `surname`, `email`, `phone_number`, `addres`, `city`, `postal_code`, `password_hash`) VALUES
	(1, 'Marko', 'Markovic', 'mmarkovic@mail.com', '061123456', 'Adresa 1', 'Grad 1', '11000', '12345'),
	(2, 'Uros', 'Urosevic', 'uurosevic@mail.com', '+381060123456', 'Adresa 2', 'Grad 2', '11000', '12345'),
	(3, 'Pera', 'Peric', 'pperic@mail.com', '+381062456789', 'Adresa 3', 'Grad 3', '12000', '12345'),
	(4, 'Miki', 'Mikic', 'miki@mail.com', '+3810657894561', 'Adresa 4', 'Grad 4', '11000', '12345'),
	(5, 'Nikola', 'Jovic', 'jovic@mail.com', '0611234567', 'Adresa 10', 'Grad 10', '11000', '12345');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table android_ispit.author
DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `author_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `forename` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`author_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.author: ~7 rows (approximately)
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
REPLACE INTO `author` (`author_id`, `forename`, `surname`) VALUES
	(1, 'Ivo', 'Andric'),
	(2, 'Mesa', 'Selimovic'),
	(3, 'Djura', 'Jaksic'),
	(4, 'Milos', 'Crnjanski'),
	(5, 'Lav', 'Tolstoj'),
	(6, 'Dragoslav', 'Mihajlovic'),
	(7, 'Petar', 'Petrovic Njegos');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

-- Dumping structure for table android_ispit.author_book
DROP TABLE IF EXISTS `author_book`;
CREATE TABLE IF NOT EXISTS `author_book` (
  `author_book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `author_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`author_book_id`),
  KEY `fk_author_book_author_id` (`author_id`),
  KEY `fk_author_book_book_id` (`book_id`),
  CONSTRAINT `fk_author_book_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_author_book_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.author_book: ~5 rows (approximately)
/*!40000 ALTER TABLE `author_book` DISABLE KEYS */;
REPLACE INTO `author_book` (`author_book_id`, `author_id`, `book_id`) VALUES
	(1, 4, 2),
	(2, 1, 1),
	(4, 7, 3),
	(5, 1, 4),
	(6, 6, 5),
	(7, 5, 6);
/*!40000 ALTER TABLE `author_book` ENABLE KEYS */;

-- Dumping structure for table android_ispit.book
DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `number_of_pages` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `year_of_issue` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `price` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.book: ~5 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
REPLACE INTO `book` (`book_id`, `name`, `number_of_pages`, `year_of_issue`, `description`, `price`) VALUES
	(1, 'Na Drini cuprija', '352', '1945', 'Najpoznatiji roman Iva Andrića, Na Drini ćuprija, hronološki opisuje svakodnevni život višegradske kasabe, koja se nalazi na obali rijeke Drine, gdje su živjeli zajedno Turci i hrišćani. Glavni lik ovog romana je most koji kod Višegrada spaja dvije obale Drine, odnosno Bosnu sa Srbijom, Zapad sa Istokom. Radnja romana prati četiri vijeka zbivanja oko mosta, koji je izgradio veliki vezir Mehmed paša Sokolović. Mehmed je srpski dječak koji je na silu odveden u tursku vojsku i poturčen da bi se kasnije uzdigao ljestvicama vlasti i postao prvi do sultana.', '799'),
	(2, 'Seobe', '230', '1929', 'Seobe (1929) istovremeno predstavljaju porodični roman tri lika i nacionalni roman o Srbima u Habzburškoj monarhiji u vreme Marije Terezije. Poetičnim pripovedanjem bez premca u srpskoj prozi priča o sudbinama srpskog oficira Vuka Isakoviča, njegove žene i njegovog puka tokom vojnog pohoda 1744. godine razgranava se u povest o opštoj tragediji nepripadanja, o lutanju, potrazi za smislom i snovima o utočištu.', '900'),
	(3, 'Gorski vijenac', '139', '1847', 'Oko jednog događaja nevelikih razmera i neprivlačnog za pe-sničku obradu, kakva je bila istraga poturica, Njegoš (1813-1851) je u svom pesničkom vencu ispleo čitavu crnogorsku istoriju, opevao najvažnije događaje iz prošlosti, od vremena Nemanjića do početka XVIII veka, naslikao svakodnevni život Crnogoraca', '889'),
	(4, 'Prokleta avlija', '168', '1954', 'Kratki roman Prokleta avlija, čije pisanje je Andrić započeo između dva svetska rata, a dovršio ga i objavio 1954. godine smatra se piščevim remek-delom. Svi protagonisti Proklete avlije, ma koliko različiti, čuvaju u sebi iskustvo sužnja, pa i svet, makar i nesvesno osećaju kao ograničen, teskoban prostor. Kao da je samo postojanje tamnovanje. „Svi su sporedni i nevažni“, zapisuje Andrić, „Avlija živi sama za sebe, sa stotinu promena, i uvek ista.“', '432'),
	(5, 'Kad su cvetale tikve', '183', '1968', 'Najznačajniji roman jugoslovenskog „crnog talasa“.', '760'),
	(6, 'Rat i mir', '1223', '1869', 'Radnja romana „Rat i mir“ se dešava u Sankt Peterburgu 1805. godine, baš kada je Napoleonovo osvajanje zapadne Evrope usadilo strah Rusiji. Na zabavi Ane Pavlovne upoznajemo većinu porodica koje su ključne za nastavak radnje romana. Susrećemo se sa Pjerom Bezuhovim, vanbračnim sinom bogatog plemića i Andrejem Bolkonskim, ambicioznim sinom penzionisanog vojnog komandanta.', '2130');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping structure for table android_ispit.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.category: ~8 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
REPLACE INTO `category` (`category_id`, `name`) VALUES
	(1, 'Autobiografija'),
	(2, 'Domaci autori'),
	(3, 'Drama'),
	(4, 'Fantastika'),
	(5, 'Horor'),
	(6, 'Komedija'),
	(7, 'Naucna fantastika'),
	(8, 'Trileri');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table android_ispit.category_book
DROP TABLE IF EXISTS `category_book`;
CREATE TABLE IF NOT EXISTS `category_book` (
  `category_book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`category_book_id`),
  KEY `fk_category_book_category_id` (`category_id`),
  KEY `fk_category_book_book_id` (`book_id`),
  CONSTRAINT `fk_category_book_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_category_book_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.category_book: ~8 rows (approximately)
/*!40000 ALTER TABLE `category_book` DISABLE KEYS */;
REPLACE INTO `category_book` (`category_book_id`, `category_id`, `book_id`) VALUES
	(1, 2, 1),
	(2, 3, 1),
	(4, 2, 3),
	(5, 2, 5),
	(6, 2, 4),
	(7, 2, 2),
	(8, 3, 5),
	(10, 3, 6);
/*!40000 ALTER TABLE `category_book` ENABLE KEYS */;

-- Dumping structure for table android_ispit.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `account_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `fk_order_account_id` (`account_id`) USING BTREE,
  CONSTRAINT `fk_order_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.order: ~0 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Dumping structure for table android_ispit.order_book
DROP TABLE IF EXISTS `order_book`;
CREATE TABLE IF NOT EXISTS `order_book` (
  `order_book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_book_id`),
  KEY `fk_order_book_order_id` (`order_id`),
  KEY `fk_order_book_book_id` (`book_id`),
  CONSTRAINT `fk_order_book_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_order_book_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table android_ispit.order_book: ~0 rows (approximately)
/*!40000 ALTER TABLE `order_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_book` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
