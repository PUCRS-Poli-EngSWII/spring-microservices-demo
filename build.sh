#!/bin/bash
# Build script para compilar todos os microserviços

cd "$(dirname "$0")"

# Compilar commons
echo "=== Compilando commons ==="
cd commons && mvn clean install -DskipTests && cd ..

# Compilar microservico1
echo "=== Compilando microservico1 ==="
cd microservico1 && mvn clean install -DskipTests && cd ..

# Compilar microservico2
echo "=== Compilando microservico2 ==="
cd microservico2 && mvn clean install -DskipTests && cd ..

# Compilar microservico3
echo "=== Compilando microservico3 ==="
cd microservico3 && mvn clean install -DskipTests && cd ..

echo "=== Build Completo ==="
