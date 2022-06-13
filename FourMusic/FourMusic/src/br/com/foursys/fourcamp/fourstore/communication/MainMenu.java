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
		
		String user = "admin";
		String password = "1234";
		int login = 1;
		
		while(login == 1) {		
		
		System.out.print("Usuário: ");
		user = sc.nextLine();
		System.out.print("Senha: ");
		password = sc.nextLine();
		
		 if (user.equals("admin") && password.equals("1234")){  		
		
		while(true) {
			
			System.out.println(
				                  "\n ___________________________________"
								+ "\n|     Bem Vindo ao FourMusic        |" 
								+ "\n|___________________________________|"
								+ "\n|1 - Cadastrar produto              |" 
								+ "\n|2 - Atualizar produto              |" 
								+ "\n|3 - Venda                          |"
								+ "\n|4 - Listar produtos                |" 
								+ "\n|5 - Pesquisar produto por sku      |" 
								+ "\n|6 - Relatório de venda             |" 
								+ "\n|--------------------------------   |" 
								+ "\n| 0 - S A I R                       |"
								+ "\n|___________________________________|" 
								+ "\n" 
								+ "\nInforme a operação desejada: ");
						
			int option = sc.nextInt();
			switch(option) {
			case 0:
				System.out.println("Volte sempre!");
				System.exit(0);
				break;
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
	} else {
		System.err.println("Usuário ou senha incorreta");
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
		Double totalPrice = 0.0;
		ProductController productCont = new ProductController();
		
		
		
		System.out.println("Digite o SKU do produto: ");
		String sku = sc2.nextLine();
		System.out.println("Digite a quantidade do item: ");
		Integer qtt = sc2.nextInt();
		Product product = productCont.getProduct(sku);	
		System.out.println("");

		System.out.println("Adicionar CPF na nota?");
		System.out.println("1 - Sim" + " " + "2 - Não");
		int cpf = sc.nextInt();
		if (cpf == 1) {
			boolean return2 = false;

			while(!return2) {
			System.out.println("Digite seu CPF: ");
			Utils util = new Utils();
			cpf2 = sc.next();
			return2 = util.validateCPF(cpf2);
			if (!return2) {
				System.err.println("CPF inválido");
			}
		}
	}

		System.out.println("Qual a forma de pagamento?");
		for (PaymentsEnum p : EnumSet.allOf(PaymentsEnum.class)) {
			System.out.println(p.getKey());
		}
		String paymentType = sc.next();

		switch (paymentType) {
		case "1":
			getDebit();
			totalPrice = product.getSalePrice() * qtt;
			System.out.println("O valor da compra é: " + totalPrice);
			break;
		case "2":
			getCredit();
			
			totalPrice = product.getSalePrice() * qtt;
			totalPrice = totalPrice + (totalPrice * 0.15);
			System.out.println("O valor da compra é: " + totalPrice);	
			break;
		case "3":
			getPix();
			totalPrice = product.getSalePrice() * qtt;
			totalPrice = totalPrice - (totalPrice * 0.15);
			System.out.println("O valor da compra é: " + totalPrice);
			break;
		case "4":
			getMoney();
			totalPrice = product.getSalePrice() * qtt;
			totalPrice = totalPrice - (totalPrice * 0.15);
			System.out.println("O valor da compra é: " + totalPrice);
			break;
		default:
			System.out.println("Escolheu outro");

		}

		Object return1 = productCont.saleProduct(sku, qtt, cpf2, paymentType);
		System.out.println(return1);
	

}
	private static void searchBySku() {
		Scanner sc2 = new Scanner(System.in);
		 
		ProductController productCont = new ProductController();
		System.out.println("Digite o SKU do produto: ");
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
		String return1 = productC.registerProduct(sku, originPrice, salePrice, qtt);
		System.out.println(return1);
	}
	
	private static void getPix() {		

		Scanner sc = new Scanner(System.in);
		Sale saleM = new Sale();
		System.out.println("Digite a chave pix 1- Celular 2- Cpf");
		Integer key = sc.nextInt();

		switch (key) {
		case 1:
			sc.nextLine();
			boolean return2 = false;
			while (!return2) {
				System.out.println("Digite o numero de telefone");
				Utils util = new Utils();
				String telephone = sc.nextLine();
				return2 = util.validateTelephone(telephone);
				if (!return2) {
					System.err.println("Telefone inválido");
				} else {
					System.out.println("Pix realizado com sucesso");

				}
			}
			break;
		case 2:
			sc.nextLine();
			boolean return3 = false;
			while (!return3) {
				System.out.println("Digite o cpf");
				Utils util = new Utils();
				String cpf = sc.next();
				return3 = util.validateCPF(cpf);
				System.out.println("Pix realizado com sucesso");
				if (!return3) {
					System.err.println("CPF inválido");
				} else {
					System.out.println("Pix realizado com sucesso");

				}
			}

			break;

		}
	}
	
	
	private static void getDebit() {
		
		Scanner sc = new Scanner(System.in);
		Utils util = new Utils();
		boolean return2 = false;
		while (!return2) {
			System.out.println("Digite o n° do cartão");
			String cardNumberDebit = sc.next();
			return2 = util.validateCard(cardNumberDebit);

			if (util.validateCard(cardNumberDebit) == false) {
				System.err.println("Número inválido");
			} else {
				System.out.println("Insira o cartão na maquineta 1- Senha 2- Aproximação ");
				Integer option = sc.nextInt();
				if (option == 1) {
					System.out.println("Digite a senha");
					Integer cardPassword = sc.nextInt();
					System.out.println("Compra concluida com sucesso");
				} else {
					System.out.println("Aproxime o cartão");
					System.out.println("Compra concluida com sucesso");
				}
			}
		}
	}
	private static void getCredit() {
	

		Scanner sc = new Scanner(System.in);
		Utils util = new Utils();
		boolean return2 = false;
		while (!return2) {
			System.out.println("Digite o n° do cartão");
			String cardNumberDebit = sc.next();
			return2 = util.validateCard(cardNumberDebit);

			if (util.validateCard(cardNumberDebit) == false) {
				System.err.println("Número inválido");
			} else {
				System.out.println("Insira o cartão na maquineta 1- Senha 2- Aproximação ");
				Integer option = sc.nextInt();
				if (option == 1) {
					System.out.println("Digite a senha");
					Integer cardPassword = sc.nextInt();
					System.out.println("Compra concluida com sucesso");
				} else {
					System.out.println("Aproxime o cartão");
					System.out.println("Compra concluida com sucesso");
				}
			}
		}
	}

	private static void getMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Irá precisar de troco? 1- SIM  2-NÃO ");
		Integer moneychange = sc.nextInt();
		if(moneychange == 1) {
			System.out.println("Quanto de troco?");
			moneychange = sc.nextInt();	
			System.out.println("Confira o troco!");
			
		}else {
			System.out.println("Obrigado!");
		}
	
		
	}
}

