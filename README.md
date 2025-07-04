# DubboShop

DubboShop is a distributed e-commerce platform built with a microservices architecture using Apache Dubbo and Zookeeper. It demonstrates scalable, maintainable, and high-availability patterns for online shopping systems.

## Features
- **Product Management:** Inventory tracking and stock management
- **Order Processing:** Order creation, tracking, and management
- **Payment Integration:** Payment processing workflows
- **Real-time Inventory:** Stock updates and availability checks

## Architecture
- **Microservices:** Separate services for items and orders
- **Service Discovery:** Zookeeper-based service registry
- **RPC Communication:** Apache Dubbo for inter-service communication
- **Database Operations:** MyBatis ORM with MySQL
- **Transaction Management:** Distributed transaction handling

## System Components
- **Item Service:** Manages product inventory and stock operations
- **Order Service:** Handles order creation and management
- **Web Service:** Provides REST API endpoints and web interface (JSP + Spring MVC)

## Technologies Used
- **Backend:** Java, Spring Framework, MyBatis
- **RPC:** Apache Dubbo
- **Registry:** Apache Zookeeper
- **Database:** MySQL
- **Frontend:** JSP, Spring MVC
- **Build:** Maven

## Getting Started

### Prerequisites
- Java 8+
- Maven
- MySQL
- Zookeeper

### Build and Run
1. Clone the repository:
   ```bash
   git clone git@github.com:isabelccc/DubboShop-.git
   cd DubboShop-
   ```
2. Start Zookeeper and MySQL services.
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Start each service module (item, order, web) as needed.

### Directory Structure
- `imooc-dubbo/` - Main distributed Dubbo-based system
- `imooc-single-mvc/` - Single-module MVC version (for comparison)
- `imooc-zk-curator-maven/` - Zookeeper/Curator demos
- `imooc-zookeeper-starter/` - Zookeeper usage demos

## License
This project is for educational and demonstration purposes.

---

For more details, see the source code and module documentation.
