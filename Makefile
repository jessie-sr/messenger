KAFKA_HOME =/usr/local/kafka/kafka_2.13-3.8.0/bin

all: run-kafka
stop_all: stop-server stop-zookeeper

run-kafka:
	@echo "Running Kafka"
	@$(KAFKA_HOME)/zookeeper-server-start.sh $(KAFKA_HOME)/../config/zookeeper.properties & echo $$! > zookeeper.pid
	@$(KAFKA_HOME)/kafka-server-start.sh $(KAFKA_HOME)/../config/server.properties & echo $$! > server.pid
	@sleep 5

stop-server:
	@echo "Stopping Kafka server..."
	@kill -9 $$(cat server.pid)
	@rm -f server.pid

stop-zookeeper:
	@echo "Stopping Kafka zookeeper..."
	@kill -9 $$(cat zookeeper.pid)
	@rm -f zookeeper.pid