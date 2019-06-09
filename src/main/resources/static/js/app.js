var appOrderSystem = angular.module("appOrderSystem",[]);

appOrderSystem.controller("produtoController", function($scope,$http){
	$scope.produtos = [];
	$scope.produto = {};
	$scope.error;
		
	carregarProdutos = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/produto'
			}).then(function successCallback(response) {
				$scope.produtos = response.data;
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.salvarProduto = function(){
		$scope.error = '';
		$http({
			  method: 'POST', url: 'http://localhost:8080/produto', data: $scope.produto
			}).then(function successCallback(response) {
				carregarProdutos();
			  }, function errorCallback(response) {
				  $scope.error = response.data.message;
			  });
	};
	
	$scope.removerProduto = function(id){
		$http({
			  method: 'DELETE', url: 'http://localhost:8080/produto/'+id, 
			}).then(function successCallback(response) {
				for(var i = 0; i < $scope.produtos.length; i++){
					if($scope.produtos[i].id == id){
						$scope.produtos.slice(i,1);
						break;
					}
				}
				carregarProdutos();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.alterarProduto = function(pro){
		$scope.produto = angular.copy(pro);
	};
	
	$scope.cancelar = function(){
		$scope.produto = {};
	}; 
	
	carregarProdutos();
});

appOrderSystem.controller("restauranteController", function($scope,$http){
	$scope.restaurantes = [];
	$scope.restaurante = {};
	$scope.error;
	
	carregarRestaurante = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/restaurante'
			}).then(function successCallback(response) {
				$scope.restaurantes = response.data;
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.salvarRestaurante = function(){
		$scope.error = '';
		$http({
			  method: 'POST', url: 'http://localhost:8080/restaurante', data: $scope.restaurante
			}).then(function successCallback(response) {
				carregarRestaurante();
			  }, function errorCallback(response) {
				  $scope.error = response.data.message;
			  });
	};
	
	$scope.removerRestaurante = function(id){
		$http({
			  method: 'DELETE', url: 'http://localhost:8080/restaurante/'+id, 
			}).then(function successCallback(response) {
				for(var i = 0; i < $scope.restaurantes.length; i++){
					if($scope.restaurantes[i].id == id){
						$scope.restaurantes.slice(i,1);
						break;
					}
				}
				carregarRestaurante();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.alterarRestaurante = function(res){
		$scope.restaurante = angular.copy(res);
	};
	
	$scope.cancelar = function(){
		$scope.restaurante = {};
	}; 
	
	carregarRestaurante();
});

appOrderSystem.controller("mesaController", function($scope,$http){
	
	$scope.mesas = [];
	$scope.mesa = {};
	$scope.erro;
		
	carregarMesas = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/mesa'
			}).then(function successCallback(response) {
				$scope.mesas = response.data;
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.salvarMesa = function(){
		$scope.erro = "";
		$http({
			  method: 'POST', url: 'http://localhost:8080/mesa', data: $scope.mesa
			}).then(function successCallback(response) {
				carregarMesas();
			  }, function errorCallback(response) {
				$scope.error = response.data.message;
			  });
	};
	
	$scope.removerMesa = function(id){
		$http({
			  method: 'DELETE', url: 'http://localhost:8080/mesa/'+id, 
			}).then(function successCallback(response) {
				for(var i = 0; i < $scope.mesas.length; i++){
					if($scope.mesas[i].id == id){
						$scope.mesas.slice(i,1);
						break;
					}
				}
				carregarMesas();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.alterarMesa = function(mes){
		$scope.mesa = angular.copy(mes);
	};
	
	$scope.cancelar = function(){
		$scope.mesa = {};
	}; 
	
	carregarMesas();
	
});

appOrderSystem.controller("funcionarioController", function($scope,$http){
	$scope.funcionarios = [];
	$scope.funcionario = {};
		
	carregarFuncionario = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/funcionario'
			}).then(function successCallback(response) {
				$scope.funcionarios = response.data;
				console.log($scope.funcionarios);
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.salvarFuncionario = function(){
		$http({
			  method: 'POST', url: 'http://localhost:8080/funcionario', data: $scope.funcionario
			}).then(function successCallback(response) {
				carregarFuncionario();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.removerFuncionario = function(id){
		$http({
			  method: 'DELETE', url: 'http://localhost:8080/funcionario/'+id, 
			}).then(function successCallback(response) {
				for(var i = 0; i < $scope.funcionarios.length; i++){
					if($scope.funcionarios[i].id == id){
						$scope.funcionarios.slice(i,1);
						break;
					}
				}
				carregarFuncionario();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.alterarFuncionario = function(fun){
		$scope.funcionario = angular.copy(fun);
	};
	
	$scope.cancelar = function(){
		$scope.funcionario = {};
	}; 
	
	carregarFuncionario();
});

appOrderSystem.controller("cardapioController", function($scope,$http){
	$scope.cardapios = [];
	$scope.cardapio = {};
	$scope.produtos = [];
	$scope.produto = {};
	
	init = function () {		
		var idCardapio = window.location.pathname.split('/')[2];
		
		if(idCardapio) { // buscar um cardapio específico
			carregarCardapio(idCardapio);
		} else if(window.location.pathname.includes('lista_cardapio')) { // buscar um cardapio ativo 
			carregarCardapioAtivo();
		} else {
			carregarProdutos();
			carregarCardapios();
		}
	};
	
	carregarProdutos = function(){
		$http({
		  method: 'GET',
		  url: 'http://localhost:8080/produto'
		}).then(function successCallback(response) {
		  $scope.produtos = response.data;
	    }, function errorCallback(response) {
		  console.log(response.status);
	    });
	};
	
	carregarCardapio = function(id) {
		$http({
			method: 'GET',
			url: 'http://localhost:8080/cardapio/'+id
		}).then(function successCallback(response) {
			$scope.cardapio = response.data;
			$scope.produtos = response.data.produtos;
			console.log($scope.cardapios);
	    }, function errorCallback(response) {
	    	console.log(response.status);
	    });
	};
	
	carregarCardapioAtivo = function() {
		$http({
			method: 'GET',
			url: 'http://localhost:8080/cardapio?ativo=true'
		}).then(function successCallback(response) {
			$scope.cardapio = response.data;
			$scope.produtos = response.data.produtos;
	    }, function errorCallback(response) {
	    	console.log(response.status);
	    });
	}
		
	carregarCardapios = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/cardapio'
			}).then(function successCallback(response) {
				$scope.cardapios = response.data;
				console.log($scope.cardapios);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
		
	$scope.salvarCardapio = function(){
		var produtos = [];
		
		for(var i = 0; i < $scope.produtos.length; i++) {
			if($scope.produtos[i].checked){
				produtos.push($scope.produtos[i]);
			} 
		}
		$scope.cardapio.produtos = produtos;
		$http({
			  method: 'POST', url: 'http://localhost:8080/cardapio', data: $scope.cardapio
			}).then(function successCallback(response) {
				init();
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.visualizarCardapio = function(id){
		if(id) {
			window.location.href = 'http://localhost:8080/lista_cardapio/'+id;
		} else {
			window.location.href = 'http://localhost:8080/lista_cardapio/';
		}
	};
	
	$scope.removerCardapio = function(id){
		$http({
			  method: 'DELETE', url: 'http://localhost:8080/cardapio/'+id, 
			}).then(function successCallback(response) {
				for(var i = 0; i < $scope.cardapios.length; i++){
					if($scope.cardapios[i].id == id){
						$scope.cardapios.slice(i,1);
						break;
					}
				}
				init();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.alterarCardapio = function(card){
		$scope.cardapio = angular.copy(card);
	};
	
	$scope.cancelar = function(){
		$scope.cardapio = {};
	};
	
	init();
});


appOrderSystem.controller("pedidoController", function($scope,$http){
	$scope.cardapios = [];
	$scope.pedidos = [];
	$scope.mesas = [];
	$scope.pedido = {};
	$scope.mesaPedido = null;
	$scope.success = false;
	$scope.cardapioAtivo = false;
	$scope.pedidosMesa = [];
	$scope.dadosPagamento = {};
		
	init = function () {
		carregarPedidos();
	};
	
	carregarPedidos = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/pedido'
			}).then(function successCallback(response) {
				$scope.pedidos = response.data;
				
				carregarMesas();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	carregarMesas = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/mesa'
			}).then(function successCallback(response) {
				$scope.mesas = response.data;
				getMesa();
				carregarCardapios();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	carregarCardapios = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/cardapio'
			}).then(function successCallback(response) {
				$scope.cardapios = response.data;
				carregarCardapioAtivo();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	getMesa = function(){
		var idMesa = parseInt(new URL(window.location.href).searchParams.get("idMesa"));
		procurarMesa(idMesa);
		getPedidosMesa(idMesa);
	};
	
	getPedidosMesa = function(idMesa){
		for(var i = 0; i < $scope.pedidos.length; i++){
			var estadoPedido = $scope.pedidos[i]['estadoPedido'];
			if ($scope.pedidos[i].mesa.id === $scope.mesaPedido.id && estadoPedido == "AGUARDANDO") {
				$scope.pedidosMesa.push($scope.pedidos[i]);
			}
		}
		getPrecoPromocao();
	};
		
	carregarCardapioAtivo = function(){
		for(var i = 0; i < $scope.cardapios.length; i++){
			if($scope.cardapios[i].ativo){
				$scope.cardapioAtivo = true;
				break;
			}
		}
	};		
		
	procurarMesa = function(idMesa){
		var mesasEncontradas = $scope.mesas;
		for(var i = 0; i < mesasEncontradas.length; i++){
			var mesa = mesasEncontradas[i];
			if(mesa.id == idMesa){
				$scope.mesaPedido = mesa;
				break;
			}
		}
	};
	
	$scope.pagarConta = function() {
		for(var i = 0; i < $scope.pedidosMesa.length; i++) {
			var pedidoFinalizado = $scope.pedidosMesa[i];
			pedidoFinalizado.estadoPedido = "PAGO";
						
			$http({
				method: 'POST',
				url: 'http://localhost:8080/mudarEstado',
				data: pedidoFinalizado
			}).then(function successCallback(response) {
				console.log(response.status);
			}, function errorCallback(response) {
				console.log(response.status);
			});			
		}
	};
	
	getPrecoPromocao = function(){
		$http({
			method: 'POST',
			url: 'http://localhost:8080/desconto',
			data: $scope.pedidosMesa
		}).then(function successCallback(response) {
			
			$scope.dadosPagamento = response.data;
			console.log($scope.dadosPagamento);
			/*console.log(dadosPagamento);
			var mensagemPagamento = "Compra finalizada!\n ";
			
			if("valorTotal" in dadosPagamento){
				mensagemPagamento += dadosPagamento["mensagem"] + " \n Valor Total do Pedido: " + dadosPagamento["valorTotal"] + "\n Total a pagar: " + dadosPagamento["valorFinal"];
			}
			else{
				mensagemPagamento = "Total a pagar: " + dadosPagamento["valorFinal"];
			}
			alert(mensagemPagamento);*/			
		}, function errorCallback(response) {
			console.log(response.status);
		});
	}
	
	$scope.fazerPedido = function(){
		getMesa();
		if($scope.mesaPedido != null){
			var produtosPedidos = [];
			var produtosSolicitados = document.getElementsByClassName("produtos");
			for(var i = 0; i < produtosSolicitados.length ;i++){
				var inputs = produtosSolicitados[i].getElementsByTagName("input");
				var produto  = JSON.parse(inputs[0].getAttribute("value"));
				var qtdProduto = inputs[1].value;
				while(qtdProduto != 0){
					produtosPedidos.push(produto);
					qtdProduto-=1;
				}
			}
			$scope.pedido.mesa = $scope.mesaPedido;
			$scope.pedido.produtos = produtosPedidos;
			$http({
				  method: 'POST', url: 'http://localhost:8080/pedido', data: $scope.pedido
				}).then(function successCallback(response) {
					 console.log(response.status);
					 $scope.success = true;
				  }, function errorCallback(response) {
					  console.log(response.status);
				  });
			$scope.pedido = {};
		}
		else{
			console.log("Erro: Informações da mesa indisponível");
		}
	};
	
	$scope.alterar = function(pedido){
		pedido.estadoPedido = parseInt(document.getElementById(pedido.id.toString()).value);
		//console.log(pedido);
		$http({
			  method: 'POST', url: 'http://localhost:8080/mudarEstado', data: pedido
			}).then(function successCallback(response) {
				 console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
		  });
	};
	
	$scope.cancelar = function(){
		$scope.pedido = {};
	};
	
	init();
});

appOrderSystem.controller("indexController", function(){
	
});
