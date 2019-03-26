var appOrderSystem = angular.module("appOrderSystem",[]);

appOrderSystem.controller("produtoController", function($scope,$http){
	$scope.produtos = [];
	$scope.produto = {};
		
	carregarProdutos = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/produto'
			}).then(function successCallback(response) {
				$scope.produtos.push.apply($scope.produtos, response.data);
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.salvarProduto = function(){
		$http({
			  method: 'POST', url: 'http://localhost:8080/produto', data: $scope.produto
			}).then(function successCallback(response) {
				carregarProdutos();
			  }, function errorCallback(response) {
				  console.log(response.status);
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
		$http({
			  method: 'POST', url: 'http://localhost:8080/restaurante', data: $scope.restaurante
			}).then(function successCallback(response) {
				carregarRestaurante();
			  }, function errorCallback(response) {
				  console.log(response.status);
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
		
	carregarMesas = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/mesa'
			}).then(function successCallback(response) {
				$scope.mesas = response.data;
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.salvarMesa = function(){
		$http({
			  method: 'POST', url: 'http://localhost:8080/mesa', data: $scope.mesa
			}).then(function successCallback(response) {
				carregarMesas();
			  }, function errorCallback(response) {
				  console.log(response.status);
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

appOrderSystem.controller("cardapioController", function(){
	
});

appOrderSystem.controller("pedidoController", function($scope,$http){
	$scope.pedidos = [];
	$scope.produtos = [];
	$scope.pedido = {};
	$scope.produtosAdicionados = []
		
	carregarPedido = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/pedido'
			}).then(function successCallback(response) {
				$scope.pedidos = response.data;
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	
	
	$scope.salvarPedido = function(){
		$http({
			  method: 'POST', url: 'http://localhost:8080/pedido', data: $scope.pedido
			}).then(function successCallback(response) {
				console.log($scope.pedido);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.removerPedido = function(id){
		$http({
			  method: 'DELETE', url: 'http://localhost:8080/pedido/'+id, 
			}).then(function successCallback(response) {
				for(var i = 0; i < $scope.pedidos.length; i++){
					if($scope.funcionarios[i].id == id){
						$scope.pedidos.slice(i,1);
						break;
					}
				}
				carregarPedido();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.alterarFuncionario = function(ped){
		$scope.pedido = angular.copy(ped);
	};
	
	$scope.cancelar = function(){
		$scope.pedido = {};
	}; 
	
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
	
	$scope.adicionarAoPedido = function(){
		$scope.produtosAdicionados.push(JSON.parse(document.getElementById("produtos").value));
	};
	
	carregarProdutos();
});

appOrderSystem.controller("funcionarioController", function($scope,$http){
	$scope.funcionarios = [];
	$scope.funcionario = {};
		
	carregarFuncionario = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/funcionario'
			}).then(function successCallback(response) {
				$scope.funcionarios.push.apply($scope.funcionarios,response.data);
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

appOrderSystem.controller("indexController", function(){
	
});