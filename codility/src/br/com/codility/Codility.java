package br.com.codility;

public class Codility {	

	public static void main(String[] args) {
		
		/*System.out.println(solution1(32));
		
		
		int[] A = {11,11,1,1,8,2,3,3,4,4,8};		
		System.out.println(solution2_1(A));*/
		
		
		int[] B = {1,2,3,4,5,6,7};
		int K = 3;
		int[] solution2_2 = solution2_2(B, K);
		for (int i : solution2_2) {
			System.out.println("Valor: " + i);
		}
		
	}
	
	/**
	 * Lição 1 - Iterations 
	 * Cobertura = 100%
	 * 
	 * */
	public static int solution1(int N) {
		String sequence = "0";
		int tamanhoLacunaBinaria = 0;
		
		while(sequence.length()<=Integer.toBinaryString(N).length()) {
	        if(Integer.toBinaryString(N).contains(sequence+1)) {
	        	tamanhoLacunaBinaria = sequence.length();
	        }
			sequence+="0";
		}
        return tamanhoLacunaBinaria;
    }
	
	/**
	 * Lição 2.1 - Arrays
	 * Cobertura = 44%
	 * 
	 * */
	public static int solution2_1(int[] A) {
		
		int numeroUnico = 0;
		int contNumeroAtual = 0;
		int meio = 0+A.length / 2;
		
		for (int i : A) {
			contNumeroAtual = 0;
			
			for (int j=0; j<meio; j++) {
				if(i==A[j]) {
					contNumeroAtual ++;
				}
				
				if(contNumeroAtual > 1) {
					break;
				}

				if(A[j] == A[meio]) {
					break;
				}
			}
			
			if(contNumeroAtual == 1 || contNumeroAtual == 0) {
				for (int j=meio; j<A.length; j++) {
					if(i==A[j]) {
						contNumeroAtual ++;
					}
					
					if(contNumeroAtual > 1) {
						break;
					}
				}
			}
			
			if(contNumeroAtual == 1) {
				numeroUnico = i;
				break;
			}
		}
		
		return numeroUnico;
	}
	

	
	/**
	 * Lição 2.2 - Arrays
	 * Cobertura = 
	 * 
	 * */
	public static int[] solution2_2(int[] A, int K) {
		
		int cont=1;
		int tamanhoArray = 0;
		int[] B = new int[A.length];
		
		while(cont <= K) {
			
			tamanhoArray = A.length;
			
			for (int i=0; i<tamanhoArray; i++) {
				if(i == 0) {
					B[i] = A[tamanhoArray-1];
				} else if(i == tamanhoArray-1) {
					B[i] = A[i-1];
					break;
				} else {
					B[i] = A[i-1];
				}
			}
			
			A = B;
			B = new int[A.length];
			cont++;
		}
		
		return A;
	}

}
