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
				$scope.restaurantes.push.apply($scope.restaurantes,response.data);
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

appOrderSystem.controller("mesaController", function(){
	
});

appOrderSystem.controller("cardapioController", function(){
	
});

appOrderSystem.controller("indexController", function(){
	
});