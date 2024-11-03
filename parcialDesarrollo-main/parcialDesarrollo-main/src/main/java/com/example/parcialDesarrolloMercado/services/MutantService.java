package com.example.parcialDesarrolloMercado.services;


import com.example.parcialDesarrolloMercado.entities.Mutant;
import com.example.parcialDesarrolloMercado.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class MutantService {

    @Autowired
    private MutantRepository mutantRepository;

    private Set<String> processedDnaSequences = new HashSet<>();

    public char[][] makeMatrix(String[] dna){
        int n = dna.length;
        char[][] matrix = new char[n][n];
        // convertirString a Matriz
        for(int i = 0; i < n; i++){
            matrix[i] = dna[i].toCharArray();
        }
        return matrix;
    }

    public boolean searchMutantSequence(char[][] matrix,int x,int y,int dx,int dy){
        int n = matrix.length;
        char letra = matrix[x][y];
        for (int i = 1; i < 4; i++) {
            // Calcular nuevas coordenadas circulares
            x = (x + dx + n) % n;
            y = (y + dy + n) % n;

            if (matrix[x][y] != letra) {
                return false;
            }
        }
        return true;
    }

    public boolean isMutant(String[] dna) {

        int n = dna.length;
        if(n== 0 || dna[0].isEmpty()){
            throw new IllegalArgumentException("La cadena es vacia. Ingrese una cadena con caracteres válidos");
        }

        for (String str : dna) {
            for (char c : str.toCharArray()) {
                if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                    throw new IllegalArgumentException("Secuencia no valida.Las letras permitidas son A T G C ");
                }
            }
        }

        char[][] matrix = makeMatrix(dna);

        int[][] direcciones = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        boolean isMutant = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : direcciones) {
                    if (searchMutantSequence(matrix, i, j, dir[0], dir[1])) {
                        isMutant = true;
                        break;
                    }
                }
                if (isMutant) {
                    break;
                }
            }
            if (isMutant) {
                break;
            }
        }
        String dnaSequence = String.join(",",dna);
        if (!processedDnaSequences.contains(dnaSequence)) {
            Optional<Mutant> existingMutant = mutantRepository.findByDna(dnaSequence);

            if (existingMutant.isEmpty()) {
                Mutant mutant = Mutant.builder().build();
                mutant.setDna(dnaSequence);
                mutant.setMutant(isMutant);
                mutantRepository.save(mutant);
            }

            processedDnaSequences.add(dnaSequence);
        }

        return isMutant;
    }

}
