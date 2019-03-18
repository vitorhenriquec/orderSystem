var appOrderSystem = angular.module("appOrderSystem",[]);

appOrderSystem.controller("indexController", function($scope,$http){
	$scope.nome = "Vitor";
	$http({
		  method: 'GET',
		  url: 'http://localhost:8080/produto'
		}).then(function successCallback(response) {
		    	console.log(response.status);
		  }, function errorCallback(response) {
			  console.log(response.status);
		  });
});

appOrderSystem.controller("pedidoController", function(){
	
});

appOrderSystem.controller("mesaController", function(){
	
});

appOrderSystem.controller("cardapioController", function(){
	
});

appOrderSystem.controller("produtoController", function(){
	
});