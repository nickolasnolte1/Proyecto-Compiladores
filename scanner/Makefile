JAVAC = javac
JAVA = java
MAIN_CLASS = Scanner
SOURCE_DIR = .

# Regla para compilar el código Java
compile:
	$(JAVAC) $(SOURCE_DIR)/*.java

# Regla para ejecutar el programa
run:
	$(JAVA) $(MAIN_CLASS)

# Regla para limpiar los archivos compilados
clean:
	rm -f $(SOURCE_DIR)/*.class

# Regla por defecto: compilar y ejecutar el programa
all: compile run
