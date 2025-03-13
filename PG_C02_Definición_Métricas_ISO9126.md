# PG_C02_Definición_Métricas_ISO9126.md

A continuación se presenta la definición de métricas para evaluar herramientas de análisis estático de calidad de código, utilizando el formato ISO/IEC 9126.

## Métrica 1: Lines of Code (LOC)
- **Nombre:** Lines of Code (LOC)
- **Propósito:** Medir la cantidad de código escrito para evaluar la magnitud y complejidad potencial del proyecto.
- **Método de aplicación:** Análisis automático del código fuente, excluyendo líneas en blanco y comentarios.
- **Medición Fórmula:** 
- **Interpretación:** Un mayor número de LOC puede indicar un proyecto de gran envergadura, aunque también puede sugerir complejidad excesiva o falta de refactorización.
- **Tipo de escala:** Escala de razón
- **Tipo de medida:** Cuantitativa continua
- **Fuente de medición:** Codacy

## Métrica 2: Bugs
- **Nombre:** Bugs
- **Propósito:** Identificar errores potenciales en el código que puedan causar fallos en tiempo de ejecución.
- **Método de aplicación:** Detección mediante análisis estático de código.
- **Medición Fórmula:** Número total de incidencias clasificadas como "Bug".
- **Interpretación:** Un alto número de bugs indica posibles deficiencias en la calidad del código, lo que requiere acciones de mejora.
- **Tipo de escala:** Escala de razón
- **Tipo de medida:** Cuantitativa discreta
- **Fuente de medición:** Codacy

## Métrica 3: Vulnerabilidades
- **Nombre:** Vulnerabilidades
- **Propósito:** Medir la cantidad de problemas de seguridad detectados en el código.
- **Método de aplicación:** Análisis estático enfocado en la seguridad del software.
- **Medición Fórmula:** Número total de vulnerabilidades identificadas.
- **Interpretación:** Un elevado número de vulnerabilidades puede representar riesgos de seguridad que deben ser mitigados.
- **Tipo de escala:** Escala de razón
- **Tipo de medida:** Cuantitativa discreta
- **Fuente de medición:** Codacy

## Métrica 4: Code Smells
- **Nombre:** Code Smells
- **Propósito:** Detectar patrones o prácticas en el código que puedan afectar la mantenibilidad.
- **Método de aplicación:** Evaluación mediante reglas predefinidas de análisis estático.
- **Medición Fórmula:** Número total de incidencias clasificadas como "Code Smell".
- **Interpretación:** La presencia de numerosos code smells puede sugerir la necesidad de refactorización.
- **Tipo de escala:** Escala de razón
- **Tipo de medida:** Cuantitativa discreta
- **Fuente de medición:** Codacy

## Métrica 5: Coverage (Cobertura de Pruebas)
- **Nombre:** Coverage
- **Propósito:** Medir el porcentaje de código ejecutado durante las pruebas automatizadas.
- **Método de aplicación:** Ejecución de pruebas unitarias y análisis del porcentaje de líneas cubiertas.
- **Medición Fórmula:** 
- **Interpretación:** Una alta cobertura sugiere un buen nivel de pruebas, lo que puede mejorar la confiabilidad del software.
- **Tipo de escala:** Porcentaje (razón)
- **Tipo de medida:** Cuantitativa continua
- **Fuente de medición:** Codacy

## Métrica 6: Duplications
- **Nombre:** Duplications
- **Propósito:** Detectar el porcentaje de código duplicado, lo que puede afectar la mantenibilidad y aumentar la deuda técnica.
- **Método de aplicación:** Análisis automático de similitud en el código.
- **Medición Fórmula:** 
- **Interpretación:** Un porcentaje elevado indica oportunidades para refactorización y reducción de redundancias.
- **Tipo de escala:** Porcentaje (razón)
- **Tipo de medida:** Cuantitativa continua
- **Fuente de medición:** Codacy
