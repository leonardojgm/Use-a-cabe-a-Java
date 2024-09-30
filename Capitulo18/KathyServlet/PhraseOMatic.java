public class PhraseOMatic {

	public static String makePhrase () {

		//cria tr�s conjuntos de palavras onde ser� feita a sele��o
		String[] wordListOne = {"24/7", "v�rias camadas", "30.000 p�s", "B-to-B", "todos ganham", "front-end", "baseado na Web", "difundido", "inteligente", "seis sigma", "caminho cr�tico", "din�mico"};
		String[] wordListTwo = {"habilitado", "adesivo", "valor agregado", "orientado", "central", "distribuido", "agrupado", "solidificado", "independente da maquina", "posicionado", "em rede", "dedicado", "alavancado", "alinhado", "destinado", "compartilhado", "cooperativo", "acelerado"};
		String[] wordListThree = {"processo", "ponto m�ximo", "solu��o", "arquitetura", "habilita��o no n�cleo", "estrat�gia", "mindshare", "portal", "espa�o", "vis�o", "paradigma", "miss�o"};
		
		// verifica quantas palavras existem em cada lista
		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;

		// gere tr�s n�meros aleat�rios, para extrair palavras aleat�rias de cada lista
		int rand1 = (int) (Math.random() * oneLength);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);

		// agora constr�i uma frase
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

		// exiba a frase
		return ("Precisamos de " + phrase);

	}

}