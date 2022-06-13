package src.br.com.foursys.fourcamp.fourstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import src.br.com.foursys.fourcamp.fourstore.model.Product;
import src.br.com.foursys.fourcamp.fourstore.model.Sale;
import src.br.com.foursys.fourcamp.fourstore.service.ProductService;

@RestController
public class ProductController {
			ProductService service = new ProductService();

			@PostMapping("/register")
			public String registerProduct(@RequestBody Product product) {
				String msg = "";
				if (product.getSku().length() == 10) {
					product.seeSku(product.getSku());
					if (product.getOriginPrice() == null || product.getSalePrice() == null || product.getSku() == null
							|| product.getColor() == null || product.getCategory() == null
							|| product.getSize() == null) {
						msg = "Não foi possível cadastrar o produto";
					} else if (service.searchBySku(product) != null) {
						msg = "Produto já está registrado no sistema";
					} else {
						service.registerProduct(product);
						msg += "Produto cadastrado com sucesso";
						msg += "\nSKU: " + product.getSku();
						msg += "\nQTT: " + product.getQtt();
						msg += "\nCOR: " + product.getColor();
						msg += "\nDEPARTAMENTO: " + product.getDepartment();
						msg += "\nTAMANHO: " + product.getSize();
						msg += "\nTIPO: " + product.getType();
						msg += "\nCATEGORIA: " + product.getCategory();
					}
				} else {
					msg = "Não foi possível cadastrar o produto(SKU INVÁLIDO)";
				}
				return msg;
			}


			@GetMapping("/listAll")
			public String listAllProducts() {
				String return1 = "";
				List<Object> lista = service.listAllProducts();
				for (int x = 0; x < lista.size(); x++) {
					Product product = (Product) lista.get(x);
					
					return1 = return1 + ""
					  + "\nSKU: " + product.getSku()
					  + "\nQTT: " + product.getQtt()
					  + "\nCOR: " + product.getColor()
					  + "\nDEPARTAMENTO: " + product.getDepartment()
					  +	"\nTAMANHO: " + product.getSize()
					  + "\nTIPO: " + product.getType()
					  + "\nCATEGORIA: " + product.getCategory()
					  +"\nPREÇO: " +product.getSalePrice();

				}
				return return1;
			}

			@GetMapping("/{sku}")
			public Object searchBySku(@PathVariable(value = "sku") String sku) {
				Object return1 = "Produto não encontrado";
				Product product = new Product(sku);
				product = service.searchBySku(product);
				if (product == null) {
					return return1;

				}
				return return1 = "Produto encontrado" 
								+ "\nDESCRIÇÃO: " +product.getType() +" " +product.getDepartment() +" " +product.getColor() + " - "+product.getCategory()+"/"+product.getSize()
								+ "\nQUANTIDADE: "+ product.getQtt() 
								+ "\nPREÇO ORIGINAL: " + product.getOriginPrice()
								+ "\nPREÇO DE VENDA: "	+ product.getSalePrice();
								

			}

			@PostMapping ("/add/{sku}")
			public Object addProduct(@PathVariable(value = "sku") String sku, @RequestParam(value = "qtt") Integer qtt) {
				Object return1 = "Estoque atualizado";
				Product product = new Product(sku);
				product = service.searchBySku(product);
				if (product == null) {
					return "Produto não existe";

				}
				else {
					int qttAtual = product.getQtt();
					product.setQtt(qttAtual + qtt);
				}
				return return1;
	
			}

			@PutMapping("/modify/{sku}")
			public Object modifyPrice(@PathVariable(value = "sku") String sku, @RequestParam(value = "salePrice") Double salePrice) {
				Object return1 = "Novo preço cadastrado com sucesso";
				Product product = new Product(sku);
				product = service.searchBySku(product);
				if (product == null) {
					return "Produto não encontrado";
				}else {
					product.setSalePrice(salePrice);
				}	
				return return1;
					
				
			}

	@PostMapping("/sale/{sku}/{qtt}")
	public Object saleProduct(@PathVariable(value = "sku") String sku, @PathVariable(value = "qtt") Integer qtt, @RequestBody Sale sale) {
		String cpf = "";
		String paymentType = null;
		try {
			if (sku == null || qtt == 0 || sale.getCpf() == null || sale.getPaymentType() == null) {
				return "Não foi possível realizar a venda";
			}
		} catch (NullPointerException e) {
			return "Não foi possível realizar a venda";
		}
		;
		cpf = sale.getCpf();
		paymentType = sale.getPaymentType();
		Product product = new Product(sku, qtt);
		product = service.searchBySku(product);
		if (product == null) {
			return "Produto não encontrado";
		} else if (qtt > product.getQtt()) {
			return "Saldo insuficiente, Quantidade pedida não existe no estoque";
		} else {
			service.registerSale(product, qtt, cpf, paymentType);
			return "Venda realizada com sucesso!";
		}
	}
		@GetMapping("/report")
		public String report () {
			String return1 = "";
			List<Object> list = service.listAllSales();
			if (list.size() == 0) {
				return1 = "Não existem vendas";
			} else {
				for (int x = 0; x < list.size(); x++) {
					Sale sale = (Sale) list.get(x);
					return1 = return1 + ""
							+ "Produto Vendido com sucesso"
							+ "\nSKU: " + sale.getProduct().getSku()
							+ "\nProduto: " + sale.getProduct().getType() + " " + sale.getProduct().getDepartment() + " " + sale.getProduct().getColor() + " - " + sale.getProduct().getCategory() + "/" + sale.getProduct().getSize()
							+ "\nQuantidade: " + sale.getProduct().getQtt()
							+ "\nPreço Unitário: " + sale.getProduct().getSalePrice()
							+ "\nPreço Total: " + (sale.getProduct().getSalePrice() * sale.getProduct().getQtt())
							+ "\nMetódo de Pagamento: " + sale.getPaymentType();
				}
			}
			return return1;
		}


			
			}
