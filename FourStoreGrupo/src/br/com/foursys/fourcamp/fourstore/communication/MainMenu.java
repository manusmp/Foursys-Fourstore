package br.com.foursys.fourcamp.fourstore.communication;

import java.util.EnumSet;
import java.util.Scanner;

import br.com.fourcamp.fourstore.utils.Utils;
import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentsEnum;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;

public class MainMenu {
	 static Scanner sc = new Scanner(System.in);
	 
	public void mainmenu() {
		
		
		while(true) {
			
			System.out.println("----------Menu principal-----------------"
							+  "\n|1 - CADASTRAR PRODUTO                 |"
							+  "\n|2 - ATUALIZAR PRODUTO                 |"
							+  "\n|3 - VENDA                             |"
							+  "\n|4 - LISTAR PRODUTOS                   |"
							+  "\n|5 - PESQUISAR PRODUTO POR SKU         |"
							+  "\n|6 - RELATÓRIO DE VENDAS               | ");


			int option = sc.nextInt();
			switch(option) {
			case 1: 
				registerProduct();
				break;
		case 2:
				Integer option2;
				System.out.println("    Digite a opção desejada:"
								+"\n1 - Atualizar quantidade no estoque"
								+"\n2 - Atualizar preço de venda do produto");
				option2 = sc.nextInt();
				if(option2 == 1) {
					addProduct();
				}else if(option2 ==2) {
					modifyPrice();
				}else {
					System.out.print("Opção Inválida");
				}
				
			break;
			case 3:
				saleProduct();
				break;
			case 4:
				listAllProducts();
				break;
			case 5:
				searchBySku();
				break;
			case 6:
				report();
			}
			
		}
	}
	
	

	private void report() {
		System.out.println("Relatório de Vendas");	
		
		ProductController productC = new ProductController();
		String return1 = productC.report();
		System.out.println(return1);
		
		
	}



	private void modifyPrice() {
		
		Scanner sc3 = new Scanner(System.in);
		ProductController productCont = new ProductController();
		System.out.println("Qual o sku do produto");
		String sku = sc3.next();
		System.out.println("Informe o novo preço de venda: ");
		Double salePrice = sc3.nextDouble();
		Object return1 = productCont.modifyPrice(sku, salePrice);
		System.out.println(return1);
		
		
	}


	private void addProduct() {
		Scanner sc3 = new Scanner(System.in);
		ProductController productCont = new ProductController();
		System.out.println("Qual o sku do produto");
		String sku = sc3.next();
		System.out.println("Quantidade de produtos adicionada ao estoque: ");
		Integer qtt = sc3.nextInt();
		Object return1 = productCont.addProduct(sku, qtt);
		System.out.println(return1);
	
	}

	private void saleProduct() {
		String cpf2 = null;
		Scanner sc2 = new Scanner(System.in);
		
		Product product = new Product();
		ProductController productCont = new ProductController();
		
		System.out.println("Digite o SKU do produto: ");
		String sku = sc2.nextLine();
		System.out.println("Digite a quantidade do item: ");
		Integer qtt = sc2.nextInt();
		
		
		System.out.println("Qual a forma de pagamento?");
		for (PaymentsEnum p : EnumSet.allOf(PaymentsEnum.class)) {
			System.out.println(p.getKey());
		}
		String paymentType = sc.next();
		
		switch (paymentType) {
		case "1":
			System.out.println("1 - Debito");
			getDebito();
			break;
		case "2":
			System.out.println("2 - Credito");
			getCredito();
			break;
		case "3":
			System.out.println("3 - Pix");
			getPix();
			break;
		case "4":
			System.out.println("4 - Dinheiro");
			getMoney();
			break;
		default:
			System.out.println("Escolheu outro");
			
		}
		
		System.out.println("Adicionar CPF na nota?");
		System.out.println("1 - Sim" + "    " + "2 - Não");
		int cpf = sc.nextInt();
		if(cpf == 1) {
			System.out.println("Digite seu CPF: ");
				cpf2 = sc.next();			
		}
		
		
		Object return1 = productCont.saleProduct(sku, qtt, cpf2, paymentType);
		System.out.println(return1);
	}

	private static void searchBySku() {
		Scanner sc2 = new Scanner(System.in);
		 
		ProductController productCont = new ProductController();
		System.out.println("Qual o sku do produto");
		String sku = sc2.nextLine();

		Object return1 = productCont.searchBySku(sku);
		System.out.println(return1);

	}

	private void listAllProducts() {
		ProductController productC = new ProductController();
		String return1 = productC.listAllProducts();
		System.out.println(return1);
	}


	private void registerProduct() {


		
		
		System.out.println("Insira O SKU do produto: ");
		String sku = sc.next();
		System.out.println("Insira A QUANTIDADE do produto: ");
		Integer qtt = sc.nextInt();
		System.out.println("Insira O PREÇO ORIGINAL do produto: ");
		Double originPrice = sc.nextDouble();
		System.out.println("Insira O PREÇO DE VENDA do produto: ");
		Double salePrice = sc.nextDouble();
		ProductController productC = new ProductController();
		String return1 = productC.registerProduct(sku, salePrice, originPrice, qtt);
		System.out.println(return1);
	}
	
	private static void getPix() {
		Scanner sc = new Scanner(System.in);
		Sale vendaM = new Sale();
		System.out.println("digite a chave pix 1- Celular 2- Cpf");
		Integer chave = sc.nextInt();
		if(chave == 1) {
			 sc.nextLine();
			System.out.println("Digite o numero de telefone");
			String telefone = sc.nextLine();
			System.out.println("Pix realizado com sucesso");
			
		}else {
			sc.nextLine();
			System.out.println("Digite o cpf");
			String cpf = sc.nextLine();
			System.out.println("Pix realizado com sucesso");
		}
	}
	
	private static void getDebito() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira o cartão na maquineta 1- Senha 2- Aproximação ");
		Integer option = sc.nextInt();
		if(option == 1) {
			System.out.println("Digite a senha");
			Integer senha = sc.nextInt();
			System.out.println("Compra concluida com sucesso");
		}else {
			System.out.println("Aproxime o cartão");
			System.out.println("Compra concluida com sucesso");
		}
		
	}
	
	private static void getCredito() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira o cartão na maquineta 1- Senha 2- Aproximação ");
		Integer option = sc.nextInt();
		if(option == 1) {
			System.out.println("Deseja parcelar a compra? 1- SIM  2-NÃO");
			Integer parcelar = sc.nextInt();
			if(parcelar == 1 ) {
				System.out.println("Parcelar em quantas vezes?");
				Integer time = sc.nextInt();
				System.out.println("Digite a senha");
				Integer senha = sc.nextInt();
				System.out.println("Compra concluida com sucesso");
				}		
		}else {
			System.out.println("Aproxime o cartão");
			System.out.println("Compra concluida com sucesso");
		}
		
		
	}
	
	private static void getMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Irá precisar de troco? 1- SIM  2-NÃO ");
		Integer troco = sc.nextInt();
		if(troco == 1) {
			System.out.println("Quanto de troco?");
			troco = sc.nextInt();	
			System.out.println("Confira o troco!");
			
		}else {
			System.out.println("Obrigado!");
		}
	
		
	}
}
