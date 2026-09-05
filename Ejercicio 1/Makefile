JAVAC = javac
JAVA  = java
BIN   = bin
SRC   = $(shell find src -type f -name '*.java')

.PHONY: all build run clean

all: build

build: $(SRC)
	mkdir -p $(BIN)
	$(JAVAC) -d $(BIN) $(SRC)

run: build
	$(JAVA) -cp $(BIN) ejercicio1.Main

clean:
	rm -rf $(BIN)
