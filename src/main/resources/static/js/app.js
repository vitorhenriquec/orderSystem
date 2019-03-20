var appOrderSystem = angular.module("appOrderSystem",[]);

appOrderSystem.controller("indexController", function($scope,$http){
	$scope.produtos = []
	$scope.produto = {}
		
	carregarProdutos = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/produto'
			}).then(function successCallback(response) {
				$scope.produtos.push.apply($scope.produtos,response.data);
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
					if($scope.produtos[i].id == parseFloat(id)){
						$scope.produtos.slice(i,1);
						carregarProdutos();
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

appOrderSystem.controller("pedidoController", function(){
	
});

appOrderSystem.controller("mesaController", function(){
	
});

appOrderSystem.controller("cardapioController", function(){
	
});

appOrderSystem.controller("produtoController", function(){
	
});