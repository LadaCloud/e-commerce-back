package controller;

public class RecursividadeOcorrenciasController {

        public RecursividadeOcorrenciasController() {
            super();
        }

        public int ocorrencias(int numero, int comparador) {
            if (numero == 0) {
                return 0;
            } else {
                int divisao = numero / 10;
                int ocorrencia = 0;

                if (numero % 10 == comparador) {
                    ocorrencia = 1;
                }

                return ocorrencia + ocorrencias(divisao, comparador);
            }
        }

}
