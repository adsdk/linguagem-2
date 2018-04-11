package trabalhosaula3;

import java.util.ArrayList;
import java.util.List;

public class PrintNews extends Thread {

	private List<String> news;

	public PrintNews() {
		news = new ArrayList<>();
		news.add("Assim mesmo, o novo modelo estrutural aqui preconizado exige a precisão e a definição do investimento em reciclagem técnica.");
		news.add("O cuidado em identificar pontos críticos no aumento do diálogo entre os diferentes setores produtivos ainda não demonstrou convincentemente que vai participar na mudança do investimento em reciclagem técnica.");
		news.add("A prática cotidiana prova que o fenômeno da Internet apresenta tendências no sentido de aprovar a manutenção do investimento em reciclagem técnica.");
		news.add("Assim mesmo, a execução dos pontos do programa obstaculiza a apreciação da importância de todos os recursos funcionais envolvidos.");
		news.add("Do mesmo modo, o fenômeno da Internet estimula a padronização dos procedimentos normalmente adotados.");
		news.add("No mundo atual, o entendimento das metas propostas ainda não demonstrou convincentemente que vai participar na mudança do processo de comunicação como um todo.");
		news.add("O empenho em analisar o novo modelo estrutural aqui preconizado representa uma abertura para a melhoria dos procedimentos normalmente adotados.");
		news.add("Ainda assim, existem dúvidas a respeito de como a consolidação das estruturas exige a precisão e a definição das novas proposições.");
		news.add("É claro que o surgimento do comércio virtual maximiza as possibilidades por conta dos paradigmas corporativos.");
		news.add("O cuidado em identificar pontos críticos no comprometimento entre as equipes faz parte de um processo de gerenciamento do processo de comunicação como um todo.");
	}

	@Override
	public void run() {
		int i = 0;
		while (PrintTime.countTime <= 5) {
			System.out.println(news.get(i));
			i++;
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				System.err.print(e);
			}

			if (PrintTime.countTime == 5) {
				System.out.println(news.get(i));
				break;
			}
		}
	}

	public List<String> getNews() {
		return news;
	}

	public void setNews(List<String> news) {
		this.news = news;
	}

}
