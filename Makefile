JAVAC = docker run --rm -v "${PWD}":/usr/src/myapp -w /usr/src/myapp openjdk javac
RUN_COMMAND = docker run --rm -v "${PWD}":/usr/src/myapp -w /usr/src/myapp openjdk java
JAVA_SOURCES = $(wildcard *.java)
MAIN_CLASS = Main
OBJ = Main.class MyThread.class

all: Main.class

%.class: %.java
	$(JAVAC) $^

.PHONY: run clean

run: $(OBJ)
	$(RUN_COMMAND) $(MAIN_CLASS)

clean:
	rm -rf $(OBJ)
