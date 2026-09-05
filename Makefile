# ==============================================================================
# Makefile Principal - Práctica 03: Principios SOLID (LP3 - UCSM)
# ==============================================================================

MAKEFLAGS += --no-print-directory

.PHONY: all build-all clean run-hotel run-ej1 run-ej2 run-ej3 run-ej4 help

all: build-all

help:
	@echo "================================================================="
	@echo "     COMANDOS DISPONIBLES PARA LA PRÁCTICA 03 (SOLID - LP3)      "
	@echo "================================================================="
	@echo "  make all         : Compila todos los proyectos"
	@echo "  make run-hotel   : Ejecuta el Sistema de Hotel (Experiencias 1-5)"
	@echo "  make run-ej1     : Ejecuta el Ejercicio 1 (Principio SRP)"
	@echo "  make run-ej2     : Ejecuta el Ejercicio 2 (Principio OCP)"
	@echo "  make run-ej3     : Ejecuta el Ejercicio 3 (Principio LSP)"
	@echo "  make run-ej4     : Ejecuta el Ejercicio 4 (Principio ISP)"
	@echo "  make clean       : Elimina todos los archivos binarios (.class)"
	@echo "================================================================="

build-all:
	@echo "[+] Compilando Actividad Principal: Hotel_Code..."
	@$(MAKE) -C "Hotel_Code" build
	@echo "[+] Compilando Ejercicio 1 (SRP)..."
	@$(MAKE) -C "Ejercicio 1" build
	@echo "[+] Compilando Ejercicio 2 (OCP)..."
	@$(MAKE) -C "Ejercicio 2" build
	@echo "[+] Compilando Ejercicio 3 (LSP)..."
	@$(MAKE) -C "Ejercicio 3" build
	@echo "[+] Compilando Ejercicio 4 (ISP)..."
	@$(MAKE) -C "Ejercicio 4" build
	@echo "\n[✓] Todos los proyectos fueron compilados exitosamente."

run-hotel:
	@$(MAKE) -C "Hotel_Code" run

run-ej1:
	@$(MAKE) -C "Ejercicio 1" run

run-ej2:
	@$(MAKE) -C "Ejercicio 2" run

run-ej3:
	@$(MAKE) -C "Ejercicio 3" run

run-ej4:
	@$(MAKE) -C "Ejercicio 4" run

clean:
	@echo "[*] Limpiando binarios..."
	@$(MAKE) -C "Hotel_Code" clean 2>/dev/null || true
	@$(MAKE) -C "Ejercicio 1" clean 2>/dev/null || true
	@$(MAKE) -C "Ejercicio 2" clean 2>/dev/null || true
	@$(MAKE) -C "Ejercicio 3" clean 2>/dev/null || true
	@$(MAKE) -C "Ejercicio 4" clean 2>/dev/null || true
	@echo "[✓] Limpieza completada."
