var appOrderSystem = angular.module("appOrderSystem",[]);

appOrderSystem.controller("indexController", function($scope,$http){
	$scope.nome = "Vitor";
	$scope.produtos = []
	$scope.produto = {}
	
	$scope.carregarInicio = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080'
			}).then(function successCallback(response) {
				console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	$scope.carregarProdutos = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/produto'
			}).then(function successCallback(response) {
				$scope.produtos = response.data;
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
	
	$scope.carregarProdutos();
	
	$scope.salvarProduto = function(){
		$http({
			  method: 'POST', url: 'http://localhost:8080/produto', data: $scope.produto
			}).then(function successCallback(response) {
				console.log(response.status);
				$scope.carregarInicio();
			  }, function errorCallback(response) {
				  console.log(response.status);
			  });
	};
	
});

appOrderSystem.controller("pedidoController", function(){
	
});

appOrderSystem.controller("mesaController", function(){
	
});

appOrderSystem.controller("cardapioController", function(){
	
});

appOrderSystem.controller("produtoController", function(){
	
});